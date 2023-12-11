package com.restfull.example.rest.service;

import com.restfull.example.rest.entety.GeneratedTemplateEntity;
import com.restfull.example.rest.entety.LabelEntity;
import com.restfull.example.rest.model.request.GenerateLabelRequest;
import com.restfull.example.rest.model.request.GenerateLetterRequest;
import com.restfull.example.rest.model.request.GenerateMailDescriptionRequest;
import com.restfull.example.rest.model.request.MailConfigurationRequest;
import com.restfull.example.rest.repository.GeneratedTemplateRepository;
import com.restfull.example.rest.repository.LabelRepository;
import com.restfull.example.rest.response.GenerateTemplateResponse;
import com.restfull.example.rest.response.LabelAllResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LabelService {

    private final LabelRepository labelRepository;
    private final GeneratedTemplateRepository templateRepository;


    public boolean checkAvailableLabel(UUID uuid, String label) {
        return labelRepository.findByUserIdAndName(uuid, label).isEmpty();
    }

    public List<LabelAllResponse> getAllLabels(UUID userId) {
        final List<LabelEntity> labelList = labelRepository.findAllByUserId(userId);
        final List<LabelAllResponse> returnList = new ArrayList<>();
        for (int i = 0; i < labelList.size(); i++) {
            LabelAllResponse labelAllResponse = new LabelAllResponse();
            final LabelEntity labelEntity = labelList.get(i);
            labelAllResponse.setLabel(labelEntity.getName());
            final List<GeneratedTemplateEntity> generatedTemplateList = templateRepository.findAllById(labelEntity.getId());
            for (int j = 0; j < generatedTemplateList.size(); j++) {
                final GeneratedTemplateEntity templateEntity = generatedTemplateList.get(i);
                GenerateTemplateResponse template = new GenerateTemplateResponse();
                template.setTitle(templateEntity.getTitle());
                template.setTemplate(templateEntity.getTemplate());
                template.setUsingPlaceHolder(templateEntity.getUsingPlaceHolder());
                labelAllResponse.getTemplates().add(template);
            }
            returnList.add(labelAllResponse);
        }
        return returnList;
    }

    public UUID getLabelId(UUID userId, String label) {
        final Optional<LabelEntity> optional = labelRepository.findByUserIdAndName(userId, label);
        if (optional.isEmpty()) {
            throw new RuntimeException("not found");
        }
        final LabelEntity labelEntity = optional.get();
        return labelEntity.getLabelId();
    }

    public LabelAllResponse getLabelByName(UUID userId, String label) {
        final Optional<LabelEntity> optional = labelRepository.findByUserIdAndName(userId, label);
        if (optional.isEmpty()) {
            throw new RuntimeException("not found");
        }
        final LabelEntity labelEntity = optional.get();
        LabelAllResponse labelAllResponse = new LabelAllResponse();
        labelAllResponse.setLabel(labelEntity.getName());
        final List<GeneratedTemplateEntity> generatedTemplateList = templateRepository.findAllById(labelEntity.getId());
        for (int j = 0; j < generatedTemplateList.size(); j++) {
            final GeneratedTemplateEntity templateEntity = generatedTemplateList.get(j);
            GenerateTemplateResponse template = new GenerateTemplateResponse();
            template.setTitle(templateEntity.getTitle());
            template.setTemplate(templateEntity.getTemplate());
            template.setUsingPlaceHolder(templateEntity.getUsingPlaceHolder());
            labelAllResponse.getTemplates().add(template);
        }
        return labelAllResponse;
    }

    public void saveGeneratedTemplates(UUID id, GenerateLetterRequest request, List<String> content) {
        LabelEntity labelEntity = new LabelEntity();
        labelEntity.setUserId(id);
        final GenerateLabelRequest generateLabelRequest = request.getGenerateLabelRequest();
        labelEntity.setName(generateLabelRequest.getName());
        labelEntity.setDescription(generateLabelRequest.getDescription());
        labelEntity.setLabelId(UUID.randomUUID());
        labelEntity.setUserId(id);
        final LabelEntity savedLabel = labelRepository.save(labelEntity);
        final MailConfigurationRequest mailConfigurationRequest = request.getMailConfigurationRequest();
        final GenerateMailDescriptionRequest generateMailDescriptionRequest = request.getGenerateMailDescriptionRequest();
        for (int i = 0; i < content.size(); i++) {
            GeneratedTemplateEntity entity = new GeneratedTemplateEntity();
            entity.setLabelId(savedLabel.getId());
            entity.setTemplate(content.get(i));
            entity.setTitle(generateMailDescriptionRequest.getTitle());
            entity.setUsingPlaceHolder(mailConfigurationRequest.getUsingPlaceHolder());
            entity.setFrom(mailConfigurationRequest.getFrom());
            templateRepository.save(entity);
        }
    }
}

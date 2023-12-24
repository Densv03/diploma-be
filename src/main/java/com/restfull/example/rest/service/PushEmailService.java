package com.restfull.example.rest.service;

import com.restfull.example.rest.entety.PushEntity;
import com.restfull.example.rest.model.request.PushEmailRequest;
import com.restfull.example.rest.model.request.PushRequest;
import com.restfull.example.rest.repository.PushRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PushEmailService {

    private final PushRepository pushRepository;

    private final LabelService labelService;
    public void push(UUID id, PushRequest request) {
        final List<PushEmailRequest> pushEmailRequests = request.getPushEmailRequests();
//        final UUID labelId = labelService.getLabelId(id, request.getGroupName());
        for (int i = 0; i < pushEmailRequests.size(); i++) {
            PushEntity pushEntity = new PushEntity();
            pushEntity.setTemplate(request.getTemplate());
            pushEntity.setTitle(request.getTitle());
            pushEntity.setUsingPlaceHolder(request.getUsingPlaceHolder());
            pushEntity.setFrom(request.getFrom());
//            pushEntity.setGroupId(labelId);
            pushEntity.setEmail(pushEmailRequests.get(i).getEmail());
            pushEntity.setUserId(id);
            pushRepository.save(pushEntity);
        }

    }

    public List<PushEntity> getPushEntity(){
        return pushRepository.findAll();
    }
}

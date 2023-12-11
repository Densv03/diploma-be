package com.restfull.example.rest.service;

import com.restfull.example.rest.entety.ReceiverUserEntity;
import com.restfull.example.rest.repository.EmailRepository;
import com.restfull.example.rest.response.EmailReceiverResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ReceiverService {

    private final EmailRepository emailRepository;

    public void addEmailToGroup(String email, Integer groupId) {
        ReceiverUserEntity entity = new ReceiverUserEntity();
        entity.setEmail(email);
        entity.setGroupId(groupId);
        emailRepository.save(entity);

    }

    public void deleteEmailFromGroup(String email, Integer id) {
        emailRepository.deleteByEmailAndAndGroupId(email, id);
    }

    public List<EmailReceiverResponse> getEmailsFromGroup(Integer groupId) {
        final List<ReceiverUserEntity> all = emailRepository.findAllByGroupId(groupId);
        List<EmailReceiverResponse> responses = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            EmailReceiverResponse receiverResponse = new EmailReceiverResponse(all.get(i).getEmail());
            responses.add(receiverResponse);
        }
        return responses;
    }
}

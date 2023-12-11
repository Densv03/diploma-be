package com.restfull.example.rest.service;

import com.restfull.example.rest.entety.GroupNameEntity;
import com.restfull.example.rest.model.request.EmailGroupCreateRequest;
import com.restfull.example.rest.repository.GroupRepository;
import com.restfull.example.rest.response.AvailableGroupNameResponse;
import com.restfull.example.rest.response.GroupResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GroupService {

    private final ReceiverService receiverService;
    private final GroupRepository groupRepository;
    public void createGroup(UUID userId, String groupName) {
        GroupNameEntity entity = new GroupNameEntity();
        entity.setUserId(userId);
        entity.setGroupName(groupName);
        groupRepository.save(entity);
    }

    public List<GroupResponse> getAllGroups(UUID userId) {
        final List<GroupNameEntity> groupsList = groupRepository.findAllByUserId(userId);
        List<GroupResponse> response = new ArrayList<>();
        for (int i = 0; i < groupsList.size(); i++) {
            final GroupNameEntity entity = groupsList.get(i);
            GroupResponse groupResponse = new GroupResponse();
            groupResponse.setGroupName(entity.getGroupName());
            groupResponse.setEmailReceiverResponses(receiverService.getEmailsFromGroup(entity.getId()));
            response.add(groupResponse);
        }
        return response;
    }

    public void addEmailToGroup(UUID userId, EmailGroupCreateRequest request) {
        final Optional<GroupNameEntity> optional = groupRepository.findByGroupNameAndUserId(request.getGroupName(), userId);
        if (optional.isEmpty()){
            throw new RuntimeException();
        }

        receiverService.addEmailToGroup(request.getEmail(), optional.get().getId());
    }

    public void deleteEmailToGroup(UUID userId, EmailGroupCreateRequest request) {
        final Optional<GroupNameEntity> optional = groupRepository.findByGroupNameAndUserId(request.getGroupName(), userId);
        if (optional.isEmpty()){
            throw new RuntimeException();
        }
        final Integer groupId = optional.get().getId();
        receiverService.deleteEmailFromGroup(request.getEmail(), groupId);
    }

    public AvailableGroupNameResponse checkGroup(UUID userId, String groupName) {
        return new AvailableGroupNameResponse(groupRepository.findByGroupNameAndUserId(groupName, userId).isEmpty());
    }
}

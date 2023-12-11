package com.restfull.example.rest.controller;

import com.restfull.example.rest.model.request.EmailGroupCreateRequest;
import com.restfull.example.rest.response.GroupResponse;
import com.restfull.example.rest.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.Header;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("groups")
@CrossOrigin()
public class ReceiverController {

    private final GroupService groupService;

    /**
     * Create group
     * Post /group
     * {
     * groupName : String
     * }
     *
     * @return
     */

    @PostMapping("/{groupName}")
    public ResponseEntity<?> createGroup(@RequestHeader("UserId") UUID userId, @PathVariable("groupName")String groupName) {
        groupService.createGroup(userId, groupName);
        return ResponseEntity.ok().build();
    }

    /**
     * check group
     * Post /group
     * {
     * groupName : String
     * }
     *
     * @return
     */

    @GetMapping("/{groupName}/check")
    public ResponseEntity checkGroup(@RequestHeader("UserId") UUID userId, @PathVariable("groupName")String groupName) {
        return ResponseEntity.ok(groupService.checkGroup(userId, groupName));
    }



    /**
     * /receiver/group
     * get full list with groups and receivers
     * GET /receiver/group
     * [{groupName : string, emailList[{id :UUID },{}]},{},{}....]
     *
     * @return
     */

    @GetMapping("/all")
    public ResponseEntity<List<GroupResponse>> getAllGroups(@RequestHeader("UserId") UUID userId) {
        return ResponseEntity.ok(groupService.getAllGroups(userId));
    }

    /**
     * /
     * Add email to current group
     * post /group/{email}
     * {
     * groupName :String
     * email : String
     * }
     * <p>
     * <p>
     * }
     *
     * @return
     */

    @PostMapping
    public ResponseEntity<?> addEmailToGroup(@RequestHeader("userId") UUID userId, @RequestBody EmailGroupCreateRequest request) {
        groupService.addEmailToGroup(userId, request);
        return ResponseEntity.ok().build();
    }


    /**
     * /
     * delete email to current group
     * delete /receiver/group
     * {
     * groupName :String
     * email : String
     * }
     * <p>
     * <p>
     * }
     *
     * @return
     */

    @DeleteMapping
    public ResponseEntity<?> deleteEmailToGroup(@RequestHeader("userId") UUID userId, @RequestBody EmailGroupCreateRequest request) {
        groupService.deleteEmailToGroup(userId, request);
        return ResponseEntity.noContent().build();
    }


}

package com.restfull.example.rest.controller;

import com.restfull.example.rest.response.AvailableLabelNameResponse;
import com.restfull.example.rest.response.LabelAllResponse;
import com.restfull.example.rest.service.LabelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.Header;

import java.util.List;
import java.util.UUID;

@RestController // This means that this class is a Controller
@RequestMapping(path="/label")
@AllArgsConstructor
public class LabelController {

    private final LabelService labelService;

    @GetMapping("/{label}")
    ResponseEntity<AvailableLabelNameResponse> checkAvailableLabelName(@RequestHeader("UserId") UUID uuid, @PathVariable(name = "label") String label) {
        return ResponseEntity.ok(new AvailableLabelNameResponse(labelService.checkAvailableLabel(uuid, label)));
    }

    @GetMapping
    ResponseEntity<List<LabelAllResponse>> getAllLetterLog(@RequestHeader("UserId") UUID uuid) {
        return ResponseEntity.ok(labelService.getAllLabels(uuid));
    }


    @GetMapping("/letterLog/{label}")
    ResponseEntity<LabelAllResponse> getLabel(@RequestHeader("UserId") UUID uuid, @PathVariable(name = "label") String label) {
        return ResponseEntity.ok(labelService.getLabelByName(uuid, label));
    }
}

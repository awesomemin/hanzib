package com.hanzib.api.parent.controller;

import com.hanzib.api.parent.Parent;
import com.hanzib.api.parent.ParentService;
import com.hanzib.api.parent.controller.dto.request.CreateParentRequest;
import com.hanzib.api.parent.controller.dto.response.CreateParentResponse;
import com.hanzib.api.parent.controller.dto.response.ReadParentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("parents")
@RequiredArgsConstructor
public class ParentController {

    private final ParentService parentService;

    @PostMapping
    public ResponseEntity<CreateParentResponse> createParent(@Valid @RequestBody CreateParentRequest request) {
        Parent parent = parentService.create(request.email(), request.nickname(), request.role());

        return ResponseEntity
                .created(URI.create("/members/" + parent.getId()))
                .body(CreateParentResponse.from(parent));
    }

    @GetMapping("{id}")
    public ResponseEntity<ReadParentResponse> readParent(@PathVariable Long id) {
        Parent parent = parentService.findOneById(id);

        return ResponseEntity.ok(ReadParentResponse.from(parent));
    }

}
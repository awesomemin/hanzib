package com.hanzib.api.family.controller;

import com.hanzib.api.family.Family;
import com.hanzib.api.family.FamilyService;
import com.hanzib.api.family.controller.dto.request.CreateFamilyRequest;
import com.hanzib.api.family.controller.dto.response.CreateFamilyResponse;
import com.hanzib.api.family.controller.dto.response.ReadFamilyResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/families")
public class FamilyController {

    private final FamilyService familyService;

    @PostMapping
    public ResponseEntity<CreateFamilyResponse> createFamily(@Valid @RequestBody CreateFamilyRequest request) {
        Family family = familyService.create(request);
        return ResponseEntity
                .created(URI.create("/families/" + family.getId()))
                .body(CreateFamilyResponse.from(family));
    }

    @GetMapping("{id}")
    public ResponseEntity<ReadFamilyResponse> readFamily(@PathVariable Long id) {
        Family family = familyService.findOneById(id);
        return ResponseEntity.ok(ReadFamilyResponse.from(family));
    }

}

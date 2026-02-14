package com.hanzib.api.family;

import com.hanzib.api.family.dto.CreateFamilyRequest;
import com.hanzib.api.family.dto.response.CreateFamilyResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

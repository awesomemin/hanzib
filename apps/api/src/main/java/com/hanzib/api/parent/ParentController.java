package com.hanzib.api.parent;

import com.hanzib.api.parent.dto.request.CreateParentRequest;
import com.hanzib.api.parent.dto.response.CreateParentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("parents")
@RequiredArgsConstructor
public class ParentController {

    private final ParentService parentService;

    @PostMapping
    public ResponseEntity<CreateParentResponse> createParent(@RequestBody CreateParentRequest request) {
        Parent parent = parentService.create(request);

        return ResponseEntity
                .created(URI.create("/members/" + parent.getId()))
                .body(CreateParentResponse.from(parent));
    }

}
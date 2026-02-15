package com.hanzib.api.parent;

import com.hanzib.api.parent.controller.dto.request.CreateParentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ParentService {

    private final ParentRepository parentRepository;

    @Transactional
    public Parent create(String email) {
        Parent parent = Parent.of(email);
        parentRepository.save(parent);
        return parent;
    }

    public Parent findOneById(Long id) {
        return parentRepository.findOneById(id);
    }

}
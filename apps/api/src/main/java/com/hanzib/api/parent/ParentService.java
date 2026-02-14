package com.hanzib.api.parent;

import com.hanzib.api.parent.dto.request.CreateParentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ParentService {

    private final ParentRepository parentRepository;

    @Transactional
    public Parent create(CreateParentRequest request) {
        Parent parent = Parent.of(request.email());
        parentRepository.save(parent);
        return parent;
    }

    public Parent findOneById(Long id) {
        return parentRepository.findOneById(id);
    }

}
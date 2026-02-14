package com.hanzib.api.family;

import com.hanzib.api.family.dto.CreateFamilyRequest;
import com.hanzib.api.family.exception.CreatedByParentNotFoundException;
import com.hanzib.api.family.exception.FamilyAlreadyExistsException;
import com.hanzib.api.parent.Parent;
import com.hanzib.api.parent.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FamilyService {

    private final FamilyRepository familyRepository;
    private final ParentService parentService;

    @Transactional
    public Family create(CreateFamilyRequest request) {
        Parent createdBy = parentService.findOneById(request.createdBy());
        if (createdBy == null) {
            throw new CreatedByParentNotFoundException(request.createdBy());
        }
        if (familyRepository.existsByCreatedById(createdBy.getId())) {
            throw new FamilyAlreadyExistsException(createdBy.getId());
        }
        Family family = Family.of(createdBy);
        familyRepository.save(family);
        return family;
    }

}
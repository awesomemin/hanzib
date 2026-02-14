package com.hanzib.api.family;

import com.hanzib.api.family.dto.CreateFamilyRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FamilyServiceTest {

    @Autowired FamilyService familyService;

}
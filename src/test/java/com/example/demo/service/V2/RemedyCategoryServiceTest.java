package com.example.demo.service.V2;

import com.example.demo.dto.RemedyCategory.RequestRemedyCategoryDTO;
import com.example.demo.dto.RemedyCategory.ResponseRemedyCategoryDTO;
import com.example.demo.entity.RemedyCategory;
import com.example.demo.repository.IRemedyCategoryRepository;
import com.example.demo.service.V2.RemedyCategoryV2Service;
import com.example.demo.stabs.RemedyCategoryStab;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({MockitoExtension.class})
public class RemedyCategoryServiceTest {
    @MockBean
    private IRemedyCategoryRepository repository;

    @InjectMocks
    private RemedyCategoryV2Service service;

    @BeforeEach
    public void setup() {
        service = new RemedyCategoryV2Service(repository, new ModelMapper());
    }

    @Test
    public void testOnCreate() {
        var captor = ArgumentCaptor.forClass(RemedyCategory.class);
        RequestRemedyCategoryDTO RemedyCategoryDTO = RemedyCategoryStab.getRequestDto();

        Mockito.when(repository.save(Mockito.any())).thenReturn(RemedyCategoryStab.getUser());

        ResponseRemedyCategoryDTO result = RemedyCategoryV2Service.create(RemedyCategoryStab.getRequestDto());

        Mockito.verify(repository, Mockito.atLeastOnce()).save(captor.capture());

        assertAll(
                () -> assertEquals(RemedyCategoryDTO.getName(), result.getName()),
                () -> assertEquals(RemedyCategoryDTO.getDescription(), result.getDescription())
        );
    }
}

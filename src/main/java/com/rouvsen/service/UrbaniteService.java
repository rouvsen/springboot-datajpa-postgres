package com.rouvsen.service;

import com.rouvsen.dto.UrbaniteDto;
import com.rouvsen.entity.Urbanite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UrbaniteService {

    List<UrbaniteDto> getAllUrbanites();

    Page<UrbaniteDto> getAllUrbanites(Pageable pageable);

    UrbaniteDto saveUrbanite(UrbaniteDto urbaniteDto);

    void deleteUrbanite(Long id);

}

package com.rouvsen.controller;

import com.rouvsen.dto.UrbaniteDto;
import com.rouvsen.service.UrbaniteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/urbanites")
@RequiredArgsConstructor
public class UrbaniteController {

    private final UrbaniteService urbaniteService;

    @PostMapping("/add")
    public ResponseEntity<UrbaniteDto> saveUrbanite(@RequestBody UrbaniteDto urbaniteDto) {
        return ResponseEntity.ok(urbaniteService.saveUrbanite(urbaniteDto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UrbaniteDto>> getAllUrbanites() {
        return ResponseEntity.ok(urbaniteService.getAllUrbanites());
    }
}

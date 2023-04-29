package com.rouvsen.dto;

import com.rouvsen.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class UrbaniteDto {
    private Long id;
    private String name;
    private String surname;
    private List<String> addresses;
}

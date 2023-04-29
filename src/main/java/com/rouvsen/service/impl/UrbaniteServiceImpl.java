package com.rouvsen.service.impl;

import com.rouvsen.dto.UrbaniteDto;
import com.rouvsen.entity.Address;
import com.rouvsen.entity.Urbanite;
import com.rouvsen.repo.AddressRepository;
import com.rouvsen.repo.UrbaniteRepository;
import com.rouvsen.service.UrbaniteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UrbaniteServiceImpl implements UrbaniteService {

    private final UrbaniteRepository urbaniteRepository;
    private final AddressRepository addressRepository;

    @Override
    public List<UrbaniteDto> getAllUrbanites() {
        List<Urbanite> urbanites = urbaniteRepository.findAll();
        List<UrbaniteDto> urbaniteDtos = new ArrayList<>();

        urbanites.forEach(urbanite -> {
            UrbaniteDto urbaniteDto = new UrbaniteDto(
                urbanite.getId(),
                urbanite.getName(),
                urbanite.getSurname(),
                urbanite.getAddresses() != null ?
                urbanite.getAddresses().stream().map(
                    Address::getAddressName
                ).collect(Collectors.toList()) : null
            );
            urbaniteDtos.add(urbaniteDto);
        });
        return urbaniteDtos;
    }

    @Override
    public Page<UrbaniteDto> getAllUrbanites(Pageable pageable) {
        //
        return null;
    }

    @Override
    public UrbaniteDto saveUrbanite(UrbaniteDto urbaniteDto) {

        Urbanite urbanite = new Urbanite();
        urbanite.setName(urbaniteDto.getName());
        urbanite.setSurname(urbaniteDto.getSurname());
        Urbanite savedUrbanite = urbaniteRepository.save(urbanite);


        List<Address> addresses = new ArrayList<>();
        urbaniteDto.getAddresses().forEach((adrs) -> {
            Address address = new Address();
            address.setUrbanite(savedUrbanite);
            address.setAddressName(adrs);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActive(true);
            addresses.add(address);
        });
        addressRepository.saveAll(addresses);
        urbaniteDto.setId(savedUrbanite.getId());
        return urbaniteDto;
    }

    @Override
    public void deleteUrbanite(Long id) {
        //
    }
}

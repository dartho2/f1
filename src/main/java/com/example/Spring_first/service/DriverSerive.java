package com.example.Spring_first.service;

import com.example.Spring_first.model.Driver;
import com.example.Spring_first.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DriverSerive {
    private final DriverRepository driverRepository;

    public Driver getDriver(long id_driver) {
        return driverRepository.findById(id_driver)
                .orElseThrow();
    }

    public Object getDriverForTeam(String teamName, String driverName) {
        return driverRepository.findAllByStringName(teamName, driverName);
    }
}
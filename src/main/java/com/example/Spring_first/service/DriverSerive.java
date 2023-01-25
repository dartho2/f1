package com.example.Spring_first.service;

import com.example.Spring_first.model.Driver;
import com.example.Spring_first.repository.ChampionshipRepository;
import com.example.Spring_first.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DriverSerive {
    private final DriverRepository driverRepository;

    public Driver getDriver(long id_driver) {
        return driverRepository.findById(id_driver)
                .orElseThrow(); // TODO driver
    }

    public Driver getDrivers(long id) {
        return driverRepository.findById(id).orElseThrow();
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverWithTeams(long driverId, long teamId) {
        return driverRepository.findByIdAndTeamIdIs(driverId, teamId);
    }

}

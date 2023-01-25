package com.example.Spring_first.controller;

import com.example.Spring_first.controller.dto.DriverDto;
import com.example.Spring_first.model.Driver;
import com.example.Spring_first.service.DriverSerive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class DriverController {
    private final DriverSerive driverSerive;

    @GetMapping("/drivers")
    public List<Driver> getAllDriver() {
        return driverSerive.getAllDrivers();
    }

    @GetMapping("/drivers/{driverId}/team/{teamId}")
    public Driver getDriverWithTeam(@PathVariable long driverId,@PathVariable long teamId) {
        return driverSerive.getDriverWithTeams(driverId,teamId);
    }
    @GetMapping("/driver/{driverId}/team/{teamId}")
    public DriverDto getDriver(@PathVariable long driverId,@PathVariable long teamId ) {
        return DriverDtoMapper.mapToDriverDto(driverSerive.getDrivers(driverId), teamId);
    }

}

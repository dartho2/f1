package com.example.Spring_first.controller;

import com.example.Spring_first.service.DriverSerive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DriverController {
    private final DriverSerive driverSerive;
    @GetMapping("/team/{teamName}/driver/{driverName}/champions")
    public Object getDriverForTeamCountry(@PathVariable String teamName, @PathVariable String driverName) {
        return driverSerive.getDriverForTeam(
                teamName.toUpperCase(),
                driverName.toUpperCase()
        );
    }
}

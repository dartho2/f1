package com.example.Spring_first.controller;

import com.example.Spring_first.controller.dto.DriverDto;
import com.example.Spring_first.model.Championship;
import com.example.Spring_first.model.Driver;
import com.example.Spring_first.model.Team;
import com.example.Spring_first.service.DriverSerive;
import com.example.Spring_first.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class DriverController {
    private final DriverSerive driverSerive;
    private final TeamService teamService;

    @GetMapping("/driver/{id_driver}")
    public Driver getDriver(@PathVariable long id_driver) {
        return driverSerive.getDriver(id_driver);
    }

    @GetMapping("/driver/{id_driver}/team")
    public Driver getDriverTeam(@PathVariable long id_driver) {
        return driverSerive.getDriverTeams(id_driver);
    }

    @GetMapping("/driver/{id_driver}/team/{id_team}")
    public DriverDto getChampionDriverTeam(@PathVariable long id_driver, @PathVariable long id_team) {
        Driver driver = driverSerive.getDriver(id_driver);      //TODO nadprogramowe zapytania
        Team team = teamService.getTeam(id_team);               //TODO nadprogramowe zapytania
        List<Championship> championshipList = driverSerive.getChampionDriverTeams(id_driver, id_team);
        return mapToDriverDto(championshipList, driver.getFirstname(), team.getName());
    }

    private DriverDto mapToDriverDto(List<Championship> championshipList, String firstname, String name) {
        return DriverDto.builder()
                .nameTeam(name)
                .firstName(firstname)
                .wins(String.valueOf(championshipList.stream().count())).build();
    }

    @GetMapping("/drivers")
    public List<Driver> getDriver() {
        return driverSerive.getDrivers();
    }

}

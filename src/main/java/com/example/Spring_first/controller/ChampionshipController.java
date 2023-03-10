package com.example.Spring_first.controller;

import com.example.Spring_first.controller.dto.DriverDto;
import com.example.Spring_first.model.Championship;
import com.example.Spring_first.model.Driver;
import com.example.Spring_first.model.Team;
import com.example.Spring_first.service.ChampionshipService;
import com.example.Spring_first.service.DriverSerive;
import com.example.Spring_first.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class ChampionshipController {
    private final ChampionshipService championshipService;
    private final DriverSerive driverSerive;
    private final TeamService teamService;


    @GetMapping("/champions")
    public List<Championship> getAllChampionship() {
        return championshipService.getAllChampionships();
    }

    @GetMapping("/champions/driver/{driverId}/team/{teamId}")
    public List<Championship> getChampionshipWithDriverId(@PathVariable long driverId, @PathVariable long teamId) {
        return championshipService.getChampionshipWithDriverIds(driverId, teamId);
    }

    @GetMapping("/champions/{id}")
    public Championship getChampionship(@PathVariable long id) {
        return championshipService.getChampionships(id);
    }

    @GetMapping("/driver/{id_driver}/champions")
    public List<ChampionshipYearDto> getChampionsDriver(@PathVariable long id_driver) {
        return przer(championshipService.getChampionsDrivers(id_driver));
    }

    private List<ChampionshipYearDto> przer(List<Championship> championsDrivers) {
        return  ChampionshipDtoMapper.mapToDriverDtoYear(championsDrivers);

    }

    @GetMapping("/driver/{driverId}/team/{teamId}/champions")
    public DriverDto getChampionsDriverTeam(@PathVariable long driverId, @PathVariable long teamId) {
        Driver driver = driverSerive.getDriver(driverId);      //TODO nadprogramowe zapytania
        Team team = teamService.getTeam(teamId);               //TODO nadprogramowe zapytania
        return ChampionshipDtoMapper.mapToDriverDtoTeam(
                championshipService.getChampionsDriverTeams(driverId, teamId)
                , driver, team);
    }
}

package com.example.Spring_first.controller;

import com.example.Spring_first.controller.dto.ChampionshipDto;
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

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChampionshipController {
    private final ChampionshipService championshipService;
    private final DriverSerive driverSerive;
    private final TeamService teamService;


    //GET ALL Champions List
    @GetMapping("/champions")
    public List<Championship> getAllChampionship() {
        return championshipService.getAllChampionships();
    }
    //GET ALL Champions List where driverId = X and teamId = X
    @GetMapping("/champions/driver/{driverId}/team/{teamId}")
    public List<Championship> getChampionshipWithDriverId(@PathVariable long driverId, @PathVariable long teamId) {
        return championshipService.getChampionshipWithDriverIds(driverId, teamId);
    }
    //GET CHAMPIONSHIP FOR ID
    @GetMapping("/champions/{id}")
    public Championship getChampionship(@PathVariable long id) {
        return championshipService.getChampionships(id);
    }

    @GetMapping("/driver/{id_driver}/champions")
    public List<Championship> getChampionsDriver(@PathVariable long id_driver) {
        return championshipService.getChampionsDrivers(id_driver);
    }

    @GetMapping("/driver/{driverId}/team/{teamId}/champions")
    public DriverDto getChampionsDriverTeam(@PathVariable long driverId, @PathVariable long teamId) {
        Driver driver = driverSerive.getDriver(driverId);      //TODO nadprogramowe zapytania
        Team team = teamService.getTeam(teamId);               //TODO nadprogramowe zapytania
        return ChampionshipDtoMapper.mapToDriverDtoTeam(championshipService.getChampionsDriverTeams(driverId, teamId), driver, team);
    }
    @GetMapping("/team/{teamId}/country/{countryId}/champions")
    public ChampionshipDto getChampionsCountryTeam(@PathVariable long teamId, @PathVariable long countryId) {
        return ChampionshipDtoMapper.mapToChampionshipDto(championshipService.getChampionsCountryTeams(teamId), countryId);
    }


}

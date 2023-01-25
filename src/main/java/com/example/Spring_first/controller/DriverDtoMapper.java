package com.example.Spring_first.controller;

import com.example.Spring_first.controller.dto.DriverDto;
import com.example.Spring_first.model.Driver;
import com.example.Spring_first.model.Team;

import java.util.List;
import java.util.stream.Collectors;

public class DriverDtoMapper {
    private DriverDtoMapper(){}
    public static DriverDto mapToDriverDto(Driver driverWithTeams, long teamId) {
        List<Team> winTeam = driverWithTeams.getTeam()
                .stream()
                .filter(team -> team.getId() == teamId)
                .collect(Collectors.toList()); //TODO filter result with teamId

        String name = winTeam.stream()
                .map(team -> team.getName())
                .toString();

        return DriverDto.builder()
                .firstName(driverWithTeams.getFirstname() + " " + driverWithTeams.getLastname())
                .nameTeam(name.toString())
                .winsTeam(String.valueOf(winTeam.stream().count()))
                .build();
    }
}

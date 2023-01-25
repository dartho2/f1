package com.example.Spring_first.controller;

import com.example.Spring_first.controller.dto.ChampionshipDto;
import com.example.Spring_first.controller.dto.DriverDto;
import com.example.Spring_first.model.Championship;
import com.example.Spring_first.model.Driver;
import com.example.Spring_first.model.Team;

import java.util.List;

public class ChampionshipDtoMapper {
    private ChampionshipDtoMapper(){}
    public static ChampionshipDto mapToChampionshipDto(List<Championship> championsCountryTeams, long countryId) {
        //TODO filter by countryId
        return ChampionshipDto.builder().countWin((int) championsCountryTeams.stream().count()).build();
    }

    public static DriverDto mapToDriverDtoTeam(List<Championship> championsDriverTeams, Driver driver, Team team) {
        return DriverDto.builder()
                .nameTeam(team.getName())
                .firstName(driver.getFirstname())
                .desc(driver.getFirstname() + " wygrał dla " + team.getName() + " " + championsDriverTeams.stream().count() + " razy")
                .winsTeam(String.valueOf(championsDriverTeams.stream().count())).build();
    }
}

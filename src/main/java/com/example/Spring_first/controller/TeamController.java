package com.example.Spring_first.controller;

import com.example.Spring_first.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;
    @GetMapping("/team/{teamName}/country/champions")
    public Object getTeamCountry(@PathVariable String teamName) {
        return teamService.getChampionsDriverTeams(teamName.toUpperCase());
    }
}

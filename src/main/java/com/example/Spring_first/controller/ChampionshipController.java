package com.example.Spring_first.controller;

import com.example.Spring_first.model.Championship;
import com.example.Spring_first.model.Driver;
import com.example.Spring_first.service.ChampionshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ChampionshipController {
    private final ChampionshipService championshipService;

    @GetMapping("/champions") //all Champions team and driver win
    public List<Championship> getDriver() {
        return championshipService.getchampion();
    }
    @GetMapping("/champions/{id}") //all Champions team and driver win
    public Optional<Championship> getChampionship(@PathVariable long id) {
        return championshipService.getChampionships(id);
    }
    @GetMapping("/champions/{years}/years") //all Champions team and driver win
    public List<Championship> getChampionshipsByYear(@PathVariable long years) {
        return championshipService.getChampionshipsByYears(years);
    }
    @GetMapping("/driver/{id_driver}/champions") // all champions where driver X win
    public List<Championship> getChampionsDriver(@PathVariable long id_driver) {
        return championshipService.getChampionsDrivers(id_driver);
    }

    @GetMapping("/drivers/{id_driver}/champions") // all champions where driver X win
    public Driver getDriverChamp(@PathVariable long id_driver) {
        return championshipService.getDriverChamps(id_driver);
    }

}

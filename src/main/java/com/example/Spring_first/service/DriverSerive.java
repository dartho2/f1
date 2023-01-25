package com.example.Spring_first.service;

import com.example.Spring_first.model.Championship;
import com.example.Spring_first.model.Driver;
import com.example.Spring_first.model.Team;
import com.example.Spring_first.model.WinnerDriver;
import com.example.Spring_first.repository.ChampionshipRepository;
import com.example.Spring_first.repository.DriverRepository;
import com.example.Spring_first.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DriverSerive {
    private final DriverRepository driverRepository;
    private final ChampionshipRepository championshipRepository;

    public Driver getDriver(long id_driver) {
        Driver driver = driverRepository.findById(id_driver).orElseThrow(); // TODO driver
        return driver;
    }

    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }


    public Driver getDriverTeams(long id_driver) {
        List<Championship> championshipList = championshipRepository.findAllByDriverIdIn(Collections.singletonList(id_driver));
        Driver driver = driverRepository.findById(id_driver).orElseThrow();
    return driver;
    }

    public List<Championship> getChampionDriverTeams(long idDriver, long idTeam) {
        List<Championship> championshipList = championshipRepository.findAllByDriverIdIn(Collections.singletonList(idDriver));
       return championshipList.stream().filter(team -> team.getTeam().getId() == idTeam).collect(Collectors.toList());
    }



}

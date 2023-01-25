package com.example.Spring_first.service;

import com.example.Spring_first.model.Championship;
import com.example.Spring_first.model.Driver;
import com.example.Spring_first.repository.ChampionshipRepository;
import com.example.Spring_first.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChampionshipService {
    private final ChampionshipRepository championshipRepository;
    private final DriverRepository driverRepository;

    public List<Championship> getchampion() {
        return championshipRepository.findAll();
    }

    public List<Championship> getChampionsDrivers(long idDriver) {
        List<Long> ids = Collections.singletonList(idDriver);
        List<Championship> list = championshipRepository.findAllByDriverIdIn(ids);
    return list;
    }

    public List<Championship> getChampionsDriverTeams(long idDriver) {
        List<Long> ids = Collections.singletonList(idDriver);
        List<Championship> list = championshipRepository.findAllByDriverIdIn(ids);
        return  list;
    }

    public Optional<Championship> getChampionships(long id) {
        return championshipRepository.findById(id);
//        return null;
    }

    public Driver getDriverChamps(long idDriver) {
        return driverRepository.findById(idDriver).orElseThrow();
    }

    public List<Championship> getChampionshipsByYears(long year) {
        List<Championship> listChampionship = championshipRepository.findByYearsIs(year);
        return listChampionship;
    }

}

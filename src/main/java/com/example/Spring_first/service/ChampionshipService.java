package com.example.Spring_first.service;

import com.example.Spring_first.model.Championship;
import com.example.Spring_first.repository.ChampionshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChampionshipService {
    private final ChampionshipRepository championshipRepository;

    public List<Championship> getAllChampionships() {
        return championshipRepository.findAll();
    }

    public List<Championship> getChampionshipWithDriverIds(long driverId, long teamId) {
        return championshipRepository.findAllByDriversIdAndTeamIdIs(driverId, teamId);
    }

    public Championship getChampionships(long id) {
        return championshipRepository.findById(id).orElseThrow();
    }

    public List<Championship> getChampionsDrivers(long idDriver) {
        return championshipRepository.findAllByDriversIdIs(idDriver);
    }

    public List<Championship> getChampionsDriverTeams(long driverId, long teamId) {
        return championshipRepository.findAllByDriversIdAndTeamIdIs(driverId, teamId);
    }

    public List<Championship> getChampionsCountryTeams(long teamId) {
        return championshipRepository.findAllByTeamIdIs(teamId);
    }

}

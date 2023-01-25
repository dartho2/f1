package com.example.Spring_first.service;

import com.example.Spring_first.model.Team;
import com.example.Spring_first.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team getTeam(long idTeam) {
        return teamRepository.findById(idTeam).orElseThrow();
    }
}

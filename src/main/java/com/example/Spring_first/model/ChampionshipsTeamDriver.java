package com.example.Spring_first.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class ChampionshipsTeamDriver {
    @Id
    private Long id;
    private  Long driver_id;
    @OneToMany
    @JoinColumn(name = "team_id")
    List<Team> team;
    @OneToMany
    @JoinColumn(name = "driver_id")
    List<Driver> driver;

    @OneToOne
    @JoinColumn(name = "championship_id")
    Championship championship;
}

package com.example.Spring_first.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Championship {
    @Id
    private long id;
    private int years;

    @JsonIgnore
    @OneToMany
    @JoinTable(
            name = "championships_team_driver",
            joinColumns = @JoinColumn(name = "championship_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    Set<Team> team;

    @OneToMany
    @JoinTable(
            name = "championships_team_driver",
            joinColumns = @JoinColumn(name = "championship_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id"))
    Set<Driver> drivers;



}

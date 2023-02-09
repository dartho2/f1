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
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setYears(int years) {
        this.years = years;
    }

    public Set<Team> getTeam() {
        return team;
    }

    public void setTeam(Set<Team> team) {
        this.team = team;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

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

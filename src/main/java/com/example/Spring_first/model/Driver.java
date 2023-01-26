package com.example.Spring_first.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Driver {
    @Id
    public long id;
    private String firstname;
    private String lastname;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "championships_team_driver",
            joinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"))
    Set<Team> team;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    Country country;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "championships_team_driver",
            joinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "championship_id", referencedColumnName = "id"))
    Set<Championship> championships;





}

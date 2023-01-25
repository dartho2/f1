package com.example.Spring_first.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Embeddable
public class Championship {
    @Id
    public int id;
    private int years;
    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    Driver driver;


}

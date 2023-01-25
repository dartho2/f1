package com.example.Spring_first.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Team {
    @Id
    public long id;
    private String name;
    @ManyToMany(mappedBy = "team")
    Set<Driver> drivers;


}

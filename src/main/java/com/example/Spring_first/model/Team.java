package com.example.Spring_first.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Team {
    @Id
    public long id;
    private String name;
//    @OneToMany
//    @JoinColumn(name = "team_id")
//    private List<Championship> championships;
//    Set<Championship> championship;
//    @OneToMany(mappedBy = "team")
//    Set<Championship> years;
//    @OneToMany(mappedBy = "team")
//    private Set<Championship> years = new HashSet<>();

}

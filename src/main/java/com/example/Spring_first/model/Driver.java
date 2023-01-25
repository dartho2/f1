package com.example.Spring_first.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Driver {
    @Id
    public long id;
    private String firstname;
    private String lastname;
    private long nationality_id;
    @OneToMany(mappedBy = "driver")
    Set<Championship> championship;
//    @OneToMany
//    @JoinColumn(name = "driver_id")
//    private List<Championship> championships;


}

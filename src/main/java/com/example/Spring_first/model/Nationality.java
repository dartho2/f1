package com.example.Spring_first.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Nationality {
    @Id
    public int id;
    private String country;
}

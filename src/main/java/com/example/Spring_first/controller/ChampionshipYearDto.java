package com.example.Spring_first.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChampionshipYearDto {
    private String years;

    public String getYears() {
        return years;
    }




    public void setYears(String years) {
        this.years = years;
    }

    public ChampionshipYearDto(String years) {
        this.years = years;
    }
}

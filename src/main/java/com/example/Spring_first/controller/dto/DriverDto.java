package com.example.Spring_first.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DriverDto {
    private String firstName;
    private String nameTeam;
    private String wins;
}

package com.example.Spring_first.controller.dto;

import lombok.*;

@Getter
@Setter
@Builder
public class DriverDto {

    private String firstname;
    private String nameTeam;
    private String winsTeam;
    private String desc;
}

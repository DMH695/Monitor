package com.example.monitor.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Node {
    private int id;
    private String number;
    private double airWet;
    private double airTemperature;
    @JsonProperty("CO2")
    private double CO2;
    private double light;
    private double soilWet;
    private double soilTemperature;
    private boolean control;
    private String date;
}

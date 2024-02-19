package com.example.kas0601.dto;

import java.util.HashMap;

import lombok.Data;

@Data
public class CambioData {
    private Double amount;
    private String base;
    private String date;
    private HashMap<String, Double> rates;
}
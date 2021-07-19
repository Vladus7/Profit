package com.example.profit.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SuperSet {
    private long id;
    private double weight;
    private int resp;
    private Exercise exercise;

    public SuperSet() {
    }

    public SuperSet(double weight, int resp) {
        this.weight = weight;
        this.resp = resp;
    }

    public SuperSet(long id, double weight, int resp) {
        this.id = id;
        this.weight = weight;
        this.resp = resp;
    }
}

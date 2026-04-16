package com.ian_avila.crud_client.dto;

import java.time.LocalDate;

public class ClientUpdateRequest {
    private String name;
    private Double income;
    private LocalDate birthDate;
    private Integer children;

    public ClientUpdateRequest(String name, Double income, LocalDate birthDate, Integer children) {
        this.name = name;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirth_date() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}


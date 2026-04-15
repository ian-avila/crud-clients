package com.ian_avila.crud_client.dto;

import java.time.LocalDate;

public class ClientUpdateRequest {
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birth_date;
    private Integer children;

    public ClientUpdateRequest(String name, String cpf, Double income, LocalDate birth_date, Integer children) {
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birth_date = birth_date;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public Integer getChildren() {
        return children;
    }
}


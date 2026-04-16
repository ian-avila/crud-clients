package com.ian_avila.crud_client.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public class ClientCreateRequest {

    @NotBlank(message = "Required field")
    private String name;

    @NotBlank(message = "Required field")
    private String cpf;

    @Positive(message = "Non-positive amount")
    private Double income;

    @Past(message = "Invalid date")
    private LocalDate birthDate;

    @PositiveOrZero(message = "Non-positive number")
    private Integer children;

    public ClientCreateRequest(String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
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
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}

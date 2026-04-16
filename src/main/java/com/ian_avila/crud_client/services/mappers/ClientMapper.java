package com.ian_avila.crud_client.services.mappers;

import com.ian_avila.crud_client.dto.ClientCreateRequest;
import com.ian_avila.crud_client.dto.ClientResponse;
import com.ian_avila.crud_client.dto.ClientSummary;
import com.ian_avila.crud_client.dto.ClientUpdateRequest;
import com.ian_avila.crud_client.entities.Client;

public final class ClientMapper {

    public static Client toEntity(ClientCreateRequest request) {
        return new Client(null, request.getName(), request.getCpf(), request.getIncome(), request.getBirth_date(), request.getChildren());
    }

    public static void updateEntity(ClientUpdateRequest request, Client client) {
        if (request.getName() != null) {
            client.setName(request.getName());
        }

        if (request.getIncome() != null) {
            client.setIncome(request.getIncome());
        }

        if (request.getBirth_date() != null) {
            client.setBirth_date(request.getBirth_date());
        }

        if (request.getChildren() != null) {
            client.setChildren(request.getChildren());
        }
    }

    public static ClientResponse toResponse(Client client) {
        return new ClientResponse(client.getId(), client.getName(), client.getCpf(), client.getIncome(), client.getBirth_date(), client.getChildren());
    }

    public static ClientSummary toSummary(Client client) {
        return new ClientSummary(client.getId(), client.getName(), client.getCpf(), client.getIncome(), client.getBirth_date(), client.getChildren());
    }
}

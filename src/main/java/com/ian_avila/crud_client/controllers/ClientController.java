package com.ian_avila.crud_client.controllers;

import com.ian_avila.crud_client.dto.ClientResponse;
import com.ian_avila.crud_client.dto.ClientSummary;
import com.ian_avila.crud_client.services.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/clients")
public class ClientController {

    ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ClientSummary>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK.value()).body(service.findAll(pageable));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable Long id) {
        ClientResponse response = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

}

package com.ian_avila.crud_client.services;

import com.ian_avila.crud_client.dto.ClientCreateRequest;
import com.ian_avila.crud_client.dto.ClientResponse;
import com.ian_avila.crud_client.dto.ClientSummary;
import com.ian_avila.crud_client.dto.ClientUpdateRequest;
import com.ian_avila.crud_client.entities.Client;
import com.ian_avila.crud_client.repositories.ClientRepository;
import com.ian_avila.crud_client.services.exceptions.ResourceNotFoundException;
import com.ian_avila.crud_client.services.mappers.ClientMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientResponse findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        return ClientMapper.toResponse(client);
    }

    public Page<ClientSummary> findAll(Pageable pageable) {
        Page<ClientSummary> result = clientRepository.findAll(pageable).map(ClientMapper::toSummary);
        return result;
    }

    public ClientResponse insert(ClientCreateRequest request) {
        Client client = clientRepository.save(ClientMapper.toEntity(request));
        return ClientMapper.toResponse(client);
    }

    public ClientResponse update(ClientUpdateRequest request, Long id) {
        Client client = clientRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("Resource not found")));
        ClientMapper.updateEntity(request, client);
        return ClientMapper.toResponse(client);
    }

    public void delete(Long id) {
        if(!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found");
        }

        clientRepository.deleteById(id);
    }

}
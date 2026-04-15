package com.ian_avila.crud_client.repositories;

import com.ian_avila.crud_client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

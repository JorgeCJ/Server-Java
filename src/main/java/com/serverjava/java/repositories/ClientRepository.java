package com.serverjava.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serverjava.java.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}

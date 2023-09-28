package com.serverjava.java.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serverjava.java.entities.Client;
import com.serverjava.java.repositories.ClientRepository;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository repository;
	
	@GetMapping
	public List<Client> findAll(){
		List<Client> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Client findById(@PathVariable Long id){
		Client result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public Client insert(@RequestBody Client client){
		Client result = repository.save(client);
		return result;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable Long id) {
	    Optional<Client> client = repository.findById(id);
	    
	    if (client.isPresent()) {
	        repository.deleteById(id);
	        return new ResponseEntity<>("Client deleted successfully.", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Client not found.", HttpStatus.NOT_FOUND);
	    }
	}

}

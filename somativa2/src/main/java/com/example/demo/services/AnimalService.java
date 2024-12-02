package com.example.demo.services;
import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Animal;
import com.example.demo.entities.Cliente;
import com.example.demo.repository.AnimalRepository;
import com.example.demo.repository.ClienteRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
private final AnimalRepository animalRepository;
private final ClienteRepository clienteRepository;
	
@Autowired
public AnimalService(AnimalRepository animalRepository, ClienteRepository clienteRepository) {
this.animalRepository = animalRepository;
this.clienteRepository = clienteRepository;
}

public Animal saveAnimal(Animal animal) {
	if (animal.getCliente() != null && animal.getCliente().getId() != null) {
		Optional<Cliente> cliente = clienteRepository
				.findById(animal.getCliente().getId());
		if (cliente.isPresent()) {
			animal.setCliente(cliente.get());
			return animalRepository.save(animal);
		} else {
			throw new RuntimeException("Cliente não encontrado");
		}
	} else {
		throw new RuntimeException("ID do CLiente é Obrigatório");
	}
}


public List<Animal> getAllAnimais(){
	return animalRepository.findAll();
}			

public Animal getAnimalById(Long id) {
return animalRepository.findById(id).orElse(null);
}
	
}

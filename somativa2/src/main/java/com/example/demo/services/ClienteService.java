package com.example.demo.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entities.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
private final ClienteRepository clienteRepository;

@Autowired
public ClienteService(ClienteRepository clienteRepository) {
this.clienteRepository = clienteRepository;
}

public List<Cliente> getAllClientes(){
	return clienteRepository.findAll();
}

public Cliente saveCliente(Cliente cliente) {
return clienteRepository.save(cliente);
}

public Cliente getClienteById(Long id) {
return clienteRepository.findById(id).orElse(null);
}

}
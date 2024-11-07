package com.example.dam.spring01.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Remove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dam.spring01.entity.Cliente;
import com.example.dam.spring01.repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService{
	
	@Autowired
	IClienteRepository clienteRepository;
	
	
	@Override
	public Iterable<Cliente> todosLosClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente clientePorId(Long id) {		
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void borrarClientePorId(Long id) {
		clienteRepository.deleteById(id);
	}
	
	@Override
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	

}

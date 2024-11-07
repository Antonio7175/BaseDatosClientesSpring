package com.example.dam.spring01.service;

import java.util.List;

import com.example.dam.spring01.entity.Cliente;

public interface IClienteService {

	Iterable<Cliente> todosLosClientes();
	Cliente clientePorId(Long id);
	void borrarClientePorId(Long id);
	void save(Cliente cliente);
}

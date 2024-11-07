package com.example.dam.spring01.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dam.spring01.entity.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long>{

		Iterable<Cliente>findAllByApellido(String apellido);
}

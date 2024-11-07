package com.example.dam.spring01.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dam.spring01.entity.Cliente;
import com.example.dam.spring01.service.ClienteService;



@RestController // ya no hace falta anotar como @ResponseBody
@RequestMapping("/api/articulos")
public class ClienteRestController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/listar")
	public Iterable<Cliente> listaClientes(){
		return clienteService.todosLosClientes();
	}
}

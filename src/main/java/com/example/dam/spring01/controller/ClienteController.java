package com.example.dam.spring01.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dam.spring01.entity.Cliente;
import com.example.dam.spring01.service.ClienteService;
import com.example.dam.spring01.service.IClienteService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@ModelAttribute("titulo")
	public String dameTituloSuperior() {
		return "Los clientes";
	}
	
	@GetMapping("/all")
	public String monstrarTodosLosClientes(Model model) {
		model.addAttribute("titular", "Listado de clientes");
		model.addAttribute("text", "Mostrando el listado de clientes ");
		model.addAttribute("clientes", clienteService.todosLosClientes());
		return "cliente/lista";
	}
	
	
	
	@GetMapping("/id/{id}")
	public String monstrarUnCliente(Model model, @PathVariable Long id) {
		model.addAttribute("titular", "Información cliente");
		model.addAttribute("text", "Mostrando información cliente");
		model.addAttribute("cliente", clienteService.clientePorId(id));
		return "cliente/un-cliente";
	}
	
	
	
	@GetMapping("/delete/id/{id}")
	public String borrarUnCliente(@PathVariable Long id, RedirectAttributes flash) {
		clienteService.borrarClientePorId(id);
		flash.addFlashAttribute("warning", "Artículo borrado con éxito");
		return "redirect:/cliente/all";
	}
	
	@GetMapping("/form/{id}")
	public String unCLienteEnForm(Model model, @PathVariable Long id) {
		model.addAttribute("titular", "Modificacion de informacion de cliente");
		model.addAttribute("text", "Mostrando información cliente para su actualización");
		model.addAttribute("cliente", clienteService.clientePorId(id));
		return "cliente/form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Cliente cliente,
			BindingResult result,
			Map<String, Object> model, RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.put("titulo", "Formulario de Cliente");
			model.put("cliente", cliente);
			return "cliente/form";
		}
		clienteService.save(cliente);
		flash.addFlashAttribute("success", "Artículo guardado con éxito");
		return "redirect:/cliente/all";
	}
	
	@GetMapping("/form")
	public String unCLienteNuevo(Model model) {
		model.addAttribute("titular", "Modificacion de informacion de cliente");
		model.addAttribute("text", "Mostrando información cliente para su actualización");
		model.addAttribute("cliente", new Cliente());
		return "cliente/form";
	}
	
	


}

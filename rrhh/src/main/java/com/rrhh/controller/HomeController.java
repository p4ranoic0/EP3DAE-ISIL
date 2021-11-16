package com.rrhh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rrhh.entity.Colaborador;
import com.rrhh.entity.Tienda;


@Controller

public class HomeController {
	@GetMapping("/")
	public String mostrarHome(Model model) {
		return "principal";
	}
	
	@GetMapping("/mostrarGestionarTienda")
	public String mostrarGestionarTienda(HttpServletRequest request, Model model) {
		Tienda objTienda = new Tienda();
		model.addAttribute("objTienda", objTienda);
		return "gestionarTiendas";
	
	}
	@GetMapping("/mostrarGestionarColaborador")
	public String mostrarGestionarColaborador(HttpServletRequest request, Model model) {
		Colaborador objColaborador = new Colaborador();
		model.addAttribute("objColaborador", objColaborador);
		return "gestionarColaboradores";
	
	}
	
	@GetMapping("/mostrarAsignarTienda")
	public String mostrarAsignarTienda(HttpServletRequest request, Model model) {
		Tienda objTienda = new Tienda();
		model.addAttribute("objTienda", objTienda);
		return "asignarJefeTienda";
	
	}
}

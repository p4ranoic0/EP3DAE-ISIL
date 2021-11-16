package com.rrhh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rrhh.entity.Colaborador;
import com.rrhh.entity.Tienda;
import com.rrhh.repository.ColaboradorRepository;
import com.rrhh.repository.TiendaRepository;

@Controller
@RequestMapping("/tienda")
public class TiendaController {

	@Autowired
	TiendaRepository tiendaRepository;
	
	
	@Autowired
	ColaboradorRepository colaboradorRepository;
	
	@PostMapping("/buscarTienda")
	public String buscarTienda(HttpServletRequest request, Tienda objTienda, BindingResult result,
			RedirectAttributes attributes, Model model) {
		
		List<Tienda> listaTiendas = tiendaRepository.findByDistrito(objTienda.getDistrito());
		
		if (listaTiendas == null) {
			model.addAttribute("mensaje", "No hay tienda registrada en ese distrito");			
			model.addAttribute("objTienda", objTienda);
		} else {
			model.addAttribute("objTienda", objTienda);
			model.addAttribute("listaTiendas",listaTiendas);
		}
			
		return "gestionarTiendas";
	}
	
	@PostMapping("/buscarTiendaAsignar")
	public String buscarTiendaAsignar(HttpServletRequest request, Tienda objTienda, BindingResult result,
			RedirectAttributes attributes, Model model) {
		
		List<Tienda> listaTiendas = tiendaRepository.findByDistrito(objTienda.getDistrito());	
		
		if (listaTiendas == null) {
			model.addAttribute("mensaje", "No hay tienda registrada en ese distrito");			
			model.addAttribute("objTienda", objTienda);
		} else {
			model.addAttribute("objTienda", objTienda);
			model.addAttribute("listaTiendas",listaTiendas);
		}
			
		return "asignarJefeTienda";
	}
	
	@GetMapping("NuevaTienda")
	public String NuevaTienda(HttpServletRequest request, Model model) {
		Tienda objTienda = new Tienda();
		model.addAttribute("objTienda", objTienda);
		return "nuevaTienda";
	}
	
	@PostMapping("/registrarTienda")
	public String registrarTienda(HttpServletRequest request, Tienda objTienda, BindingResult result,
			RedirectAttributes attributes, Model model) {
		
			tiendaRepository.save(objTienda);
			model.addAttribute("mensaje", "La Tienda se registró con éxito");
			Tienda obj = new Tienda();
			model.addAttribute("objTienda", obj);		

		return "nuevaTienda";
	}
	
	@GetMapping("/cargarAsignacion/{id}")
	public String cargarAsignacion(@PathVariable("id") int id, 
			RedirectAttributes attributes, Model model) {
			
		Tienda objTienda = tiendaRepository.findById(id);
		model.addAttribute("objTienda", objTienda);		
		
		//Validar si la tienda cuenta con Colaborador Asignado
		List<Colaborador> listaColaboradores = colaboradorRepository.findAll();
		model.addAttribute("listaColaboradores", listaColaboradores);		
		return "asignarJefe";
				
	}
	
	
	@PostMapping("/grabarAsignacion")
	public String grabarAsignacion(HttpServletRequest request, 
			@RequestParam("idColaborador") int idColaborador, 
			Tienda objTienda, BindingResult result,
			RedirectAttributes attributes, Model model) {
		
		if (objTienda.getColaborador()!=null) {
		
		}
		
		Tienda tienda = objTienda;		
		Colaborador colaborador = colaboradorRepository.findById(idColaborador);
		tienda.setColaborador(colaborador);			
		tiendaRepository.save(tienda);				
		
		
		return "redirect:/";
				
	}


	
}

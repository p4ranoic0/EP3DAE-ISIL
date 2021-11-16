package com.rrhh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_COLABORADOR")
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	@Column(name="id")
	private Integer id;
	
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="apePaterno")
	private String apePaterno;
	
	@Column(name="apeMaterno")
	private String apeMaterno;
	
	@Column(name="dni")
	private String dni;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}

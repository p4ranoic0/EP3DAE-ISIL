package com.rrhh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.rrhh.entity.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador,Integer> {

	List<Colaborador> findAll();
	Colaborador findByDni(String dni);
	List<Colaborador> findByApePaterno(String apePaterno);
	Colaborador findById(int id);
	
}

package com.projetoExemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoExemplo.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository <Funcionario,Long>{
	
}

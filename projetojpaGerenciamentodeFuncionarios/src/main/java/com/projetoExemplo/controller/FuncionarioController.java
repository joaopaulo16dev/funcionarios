package com.projetoExemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoExemplo.entities.Funcionario;
import com.projetoExemploService.FuncionarioService;

import jakarta.validation.Valid;

@RestController@RequestMapping("/cliente") 
public class FuncionarioController {
	
	private final FuncionarioService  funcionarioService;
	
	@Autowired
	public  FuncionarioController( FuncionarioService  funcionarioService) {
		this.funcionarioService =  funcionarioService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscaFuncionarioControlId(@PathVariable Long id){
		 Funcionario  funcionario =  funcionarioService.buscaFuncionarioId(id);
		if(funcionario != null) {
			return ResponseEntity.ok(funcionario);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> buscaTodosFuncionariosControl(){
		List<Funcionario>  Funcionarios =  funcionarioService.buscaTodosFuncionario();
		return ResponseEntity.ok(Funcionarios);
	}		
	@PostMapping("/")
	public ResponseEntity<Funcionario> salvaFuncionarioControl(@RequestBody @Valid  Funcionario funcionario){
		 Funcionario salvaFuncionario = funcionarioService.salvaFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaFuncionario);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> alteraFuncionarioControl(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario){
		 Funcionario alteraFuncionario = funcionarioService.alterarFuncionario(id, funcionario);
		if(alteraFuncionario != null) {
			return ResponseEntity.ok(funcionario);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Funcionario> apagaFuncionarioControl(@PathVariable Long id){
		boolean apagar =  funcionarioService.apagarFuncionario(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
		

}

package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table


public class Farmacia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=3,message="minimo de 3 caracteres")
	private String nome;
	
	@NotNull
	@Size(min=8,message="a bula n pode ser vazia")
	private String bula;
	
	@Positive(message = "o atributo deve ser um valor positivo")
	private int attribute12;
	
	@NotBlank(message = "a data de validade não pode ser vazia")
	private String datavalidade;


	public String getNome() {
		return nome;

	}

	public void setNome(String nome) {
		this.nome = nome;

	}

	public Long getId() {
		return id;

	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBula() {
		return bula;

	}

	public void setBula(String bula) {
		this.bula = bula;
	}
	public int getAttribute12() {
		return attribute12;

	}

	public void setAttribute12(int attribute12) {
		this.attribute12 = attribute12;

	}
	public String getDatavalidade() {
		return datavalidade;

	}

	public void setDatavalidade(String datavalidade) {
		this.datavalidade = datavalidade;

	}
	
	
	
}

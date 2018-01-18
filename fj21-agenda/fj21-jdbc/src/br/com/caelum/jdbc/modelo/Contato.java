package br.com.caelum.jdbc.modelo;

import java.util.Calendar;

public class Contato {
	
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	
	public Contato() {}
	
	//Id - get/set
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	//nome - get/set
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//email - get/set
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//endereco - get/set
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	//dataNascimento - get/set
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


}

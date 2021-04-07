package br.com.delpadre.entities;

import org.springframework.util.ObjectUtils;

public class Parametro {
	private String nome;
	private String tipo;
	
	public Parametro(String nome, String tipo) 
    {
        if (ObjectUtils.isEmpty(nome) || ObjectUtils.isEmpty(tipo))
            throw new RuntimeException("Os parâmetros de um método devem possuir tipo e nome");

        this.nome = nome;
        this.tipo = tipo;
    }

	public String getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}
	
}

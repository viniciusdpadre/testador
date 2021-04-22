package com.delpadre.Testador.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anotacao {
	public String Nome;

	public static final String EXPRESSAO_REGULAR = "\\B\\@\\w+";

	public Anotacao(String nome) {
		this.setNome(nome);
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public static List<Anotacao> Criar(Codigo codigo) {
		List<Anotacao> anotacoes = new ArrayList<Anotacao>();

		Pattern pattern = Pattern.compile(Anotacao.EXPRESSAO_REGULAR);
		Matcher matcher = pattern.matcher(codigo.getCabecalho());
		
		System.out.println(codigo.getCabecalho());

		while(matcher.find()) {
			Anotacao anotacao = new Anotacao(matcher.group());
			anotacoes.add(anotacao);
		}

		return anotacoes;
	}
}

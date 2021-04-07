package br.com.delpadre.business;

import br.com.delpadre.entities.ClasseDTO;

public class ElaboradorClasseTesteApp {
	public void Criar(String nomeClasse, String conteudo) {
		ClasseDTO classeDTO = new ClasseDTO(nomeClasse, conteudo);
	}
}

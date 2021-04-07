package br.com.delpadre.entities;

import java.util.ArrayList;
import java.util.List;

public class ClasseDTO {
	private Codigo codigo;
	public String nome;
    public List<Anotacao> anotacoes;
    public List<Atributo> atributos;
    public List<Construtor> construtores;
    
    public ClasseDTO(String nome, String codigo)
    {
        this.anotacoes = new ArrayList<Anotacao>();
        this.atributos = new ArrayList<Atributo>();
        this.construtores = new ArrayList<Construtor>();

        this.nome = nome;
        this.codigo = new Codigo(codigo);
    }
    
	public Codigo getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Codigo codigo) {
		this.codigo = codigo;
		this.MontarClasse();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Anotacao> getAnotacoes() {
		return anotacoes;
	}
	
	public void setAnotacoes(List<Anotacao> anotacoes) {
		this.anotacoes = anotacoes;
	}
	
	public List<Atributo> getAtributos() {
		return atributos;
	}
	
	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}
	
	public List<Construtor> getConstrutores() {
		return construtores;
	}
	
	public void setConstrutores(List<Construtor> construtores) {
		this.construtores = construtores;
	}
	
	private void MontarClasse()
    {
        this.anotacoes = Anotacao.Criar(codigo);
        this.atributos = Atributo.Criar(codigo);
        this.construtores = Construtor.Criar(codigo);
    }
}

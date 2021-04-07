package br.com.delpadre.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.ObjectUtils;

public class Atributo {
	public static final String EXPRESSAO_REGULAR = "(?<=private)(.*?)(?=;)";
	
    public String nome;
    public String tipo;
    
    public Atributo(String codigo) 
    {
        String [] atributoTipoNome = codigo.trim().split(" ");

        if (atributoTipoNome.length != 2 || ObjectUtils.isEmpty(atributoTipoNome[0]) || ObjectUtils.isEmpty(atributoTipoNome[1]))
            throw new RuntimeException("Um atributo deve conter nome e tipo");

        this.tipo = atributoTipoNome[0].trim();
        this.nome = atributoTipoNome[1].trim();
    }
    
	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}
	
	public static List<Atributo> Criar(Codigo codigo)
    {
		List<Atributo> atributos = new ArrayList<Atributo>();

		Pattern pattern = Pattern.compile(Anotacao.EXPRESSAO_REGULAR);
		Matcher matcher = pattern.matcher(codigo.getCabecalho());
		
		for (int i = 0; i < matcher.groupCount(); i++) {
			String ocorrencia = matcher.group(i);
			
			if (ocorrencia.contains("("))
                continue;

			Atributo atributo = new Atributo(ocorrencia.trim());
            atributos.add(atributo);
		}
		
        return atributos;
    }
}

package br.com.delpadre.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.ObjectUtils;

public class Construtor {
	public static String EXPRESSAO_REGULAR = "(?<=public)(.*?)(?={)";

    private String nome;

	private List<Parametro> parametros;
    
    public Construtor(String nome, String codigo)
    {
        this.nome = nome;
        this.parametros = new ArrayList<Parametro>();
        this.CriarParametros(codigo);
    }
    
    public String getNome() {
		return nome;
	}
    
    public void CriarParametros(String codigo)
    {
        String expressaoRegular = "(?<=\\()(.*?)(?=\\))";

        Pattern pattern = Pattern.compile(expressaoRegular);
		Matcher matcher = pattern.matcher(codigo.trim());

		if(!matcher.find())
			return;
		
        String[] parametrosTexto = matcher.group().split(",");
        CriarParametros(parametrosTexto);
    }
    
    private void CriarParametros(String[] parametrosTexto)
    {
    	for (String parametroTexto : parametrosTexto)
        {
            if (ObjectUtils.isEmpty(parametroTexto))
                continue;

            String[] parametroNomeData = parametroTexto.trim().split(" ");

            Parametro parametro = new Parametro(parametroNomeData[0], parametroNomeData[1]);

            this.parametros.add(parametro);
        }
    }
    
    public  static List<Construtor> Criar(Codigo codigo)
    {
        List<Construtor> construtores = new ArrayList<Construtor>();
		Pattern pattern = Pattern.compile(Construtor.EXPRESSAO_REGULAR);
		Matcher matcher = pattern.matcher(codigo.getCorpo());

		for (int i = 0; i < matcher.groupCount(); i++) {
			Construtor construtor = new Construtor(codigo.getNomeClasse(), matcher.group(i));
			construtores.add(construtor);
		}

        return construtores;
    }
}

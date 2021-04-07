package br.com.delpadre.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.delpadre.util.Texto;

public class Codigo {
	private String nomeClasse;
	private String cabecalho;
	private String conteudo;
	private String corpo;

	public Codigo(String conteudo) {
		this.setConteudo(conteudo);
		this.setCabecalho(conteudo);
	}

	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}

	public String getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(String cabecalho) {
		this.cabecalho = Texto.RemoverQuebraLinha(cabecalho);
		String expressaoRegular = "(.*[p][u][b][l][i][c])";

		Pattern pattern = Pattern.compile(expressaoRegular);
		Matcher matcher = pattern.matcher(this.cabecalho);

		if (matcher.find()) {
			this.cabecalho = matcher.group(1);
			this.cabecalho = Texto.RemoverQuebraLinha(this.cabecalho);
		} else
			this.cabecalho = "";
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
		this.setCabecalho(conteudo);
		this.setCorpo(conteudo);
		this.definirNomeClasse();
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = Texto.RemoverQuebraLinha(corpo);

		String expressaoRegular = "^.*?(?={)";
		Pattern p = Pattern.compile(expressaoRegular, Pattern.CASE_INSENSITIVE);

		this.corpo = p.matcher(this.corpo).replaceAll("");
	}

	private void definirNomeClasse() {
		String expressaoRegular = "(?s)(?<=public class).+?(?={)";

		Pattern pattern = Pattern.compile(expressaoRegular);
		Matcher matcher = pattern.matcher(this.conteudo);

		if (matcher.find())
			this.setNomeClasse(matcher.group(1).trim());
		else
			this.setNomeClasse("");
	}
}

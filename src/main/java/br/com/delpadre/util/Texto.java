package br.com.delpadre.util;

import java.util.regex.Pattern;

public class Texto {
	public static String RemoverQuebraLinha(String conteudo) {
		Pattern p = Pattern.compile("\\r\\n", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
		return p.matcher(conteudo).replaceAll(" ");
	}
}

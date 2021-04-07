package br.com.delpadre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.delpadre.business.ElaboradorClasseTesteApp;

@SpringBootApplication
public class TestadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestadorApplication.class, args);
		
		
		String conteudo = "@Data\n"
				+ "                                @Getter\n"
				+ "                                @Setter\n"
				+ "                                public class NomeDTO {\n"
				+ "                                        private int teste;\n"
				+ "                                       public NomeDTO(){\n"
				+ "                                        }\n"
				+ "                                       public NomeDTO(string nome){\n"
				+ "                                            if (a = b){\n"
				+ "                                            }\n"
				+ "                                            return \"\"ok\"\"s;\n"
				+ "                                        }\n"
				+ "\n"
				+ "                                      public NomeDTO(string nome, string teste){\n"
				+ "                                            if (a = b){\n"
				+ "                                            }\n"
				+ "                                            return \"\"ok\"\"s;\n"
				+ "                                        }\n"
				+ "\n"
				+ "                                      private String teste;\n"
				+ "                                }";
		
		ElaboradorClasseTesteApp elaboradorClasseTesteApp = new ElaboradorClasseTesteApp();
		elaboradorClasseTesteApp.Criar("NomeDTO", conteudo);
	}

}

package br.ifsp.edu.similaridade;

import java.util.Map;

public abstract class Arquivo {
	String arquivo;
	
	public Arquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
	public abstract Map<String, Integer> lerArquivo();

}

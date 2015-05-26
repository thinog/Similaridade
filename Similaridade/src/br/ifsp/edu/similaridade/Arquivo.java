package br.ifsp.edu.similaridade;

public abstract class Arquivo {
	String arquivo;
	
	public Arquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
	public abstract void lerArquivo();

}

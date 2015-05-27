package br.ifsp.edu.similaridade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dados {
	private static String proxPasta = "y";
	private static int numPasta = 0;

	public String getProxPasta() {
		return proxPasta;
	}

	public Pasta lerEntrada() {
		Scanner ler = new Scanner(System.in);
			
		String caminho = null;
		String ext = null;
		String[] extensoes = null;
		
		System.out.println("Diretório: ");
		caminho = ler.nextLine();
		System.out.println("Extensões procuradas: ");
		ext = ler.nextLine();
		ext = ext.replaceAll(" |\\.", "").toLowerCase();
		extensoes = ext.split(",");
		numPasta++;	
		
		if(numPasta == 3){
			ler.close();
		}
		
		return new Pasta(caminho, extensoes);	
	}
	
	public void imprimirLista(List<String> arquivos){
		arquivos = new ArrayList<>(arquivos);
		while(arquivos.size() > 0){
			System.out.println(arquivos.get(0));
			arquivos.remove(0);
		}
	}
}

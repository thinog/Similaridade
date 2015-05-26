package br.ifsp.edu.similaridade;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ArquivoTxt extends Arquivo {
	
	public ArquivoTxt(String arquivo){
		super(arquivo);
	}
	
	Palavra palavra = new Palavra();
	private Map<String, Integer> mapa = new HashMap<>();
	
	@Override
	public void lerArquivo(){
		try { 
			BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "UTF-8")); 
			String linha = lerArq.readLine();
			System.out.println(arquivo);
			
			while (linha != null) { 
				mapa = palavra.mapearPalavras(linha, mapa);
				linha = lerArq.readLine();
			} 	
			
			lerArq.close();
			
			for (Entry<String, Integer> entry : mapa.entrySet()) {
				System.out.println(entry.getKey()); 
				System.out.println("--> freq=" + entry.getValue() + "\n");
			}			
			
		}catch (IOException e) { 
			System.err.println("Erro na abertura do arquivo: " + e.getMessage()); 
		}
	}

}

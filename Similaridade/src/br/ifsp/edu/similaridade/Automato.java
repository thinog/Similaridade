package br.ifsp.edu.similaridade;

import java.util.ArrayList;
import java.util.List;

public class Automato {
	/*
	 * Legendas: 
	 * ei = estado inicial 
	 * ddp = dentro de palavra 
	 * psc = palavra sem caracter 
	 * fdt = fim de texto
	 * 
	 * cPalavra = Palavra com caracter
	 * sPalavra = Palavra sem caracter
	 */

	public char[] l = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z', 'á', 'à', 'ã', 'â', 'é', 'ê', 'í', 'ó', 'ô', 'õ',
			'ú', 'ü', 'ç', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z', 'Á', 'À', 'Ã', 'Â', 'É', 'Ê', 'Í', 'Ó', 'Ô', 'Õ', 'Ú',
			'Ü', 'Ç'};
	public List<Character> letras;
	public char[] n = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'_' };
	public List<Character> numeros;
	public char carac = '\u0000';
	public String estado;
	public List<Character> cPalavra;
	public List<Character> sPalavra;
	public List<Character> linha;
	public char[] vazio;
	public List<String> palavra;
	public int i = 0;
	public Automato auto;
	public StringBuilder sb;

	public List<String> ei(String line) {
		char caracter = '\u0000';
		cPalavra = new ArrayList<>();
		sPalavra = new ArrayList<>();
		linha = new ArrayList<>();
		letras = new ArrayList<>();
		numeros = new ArrayList<>();
		palavra = new ArrayList<>();
		auto = new Automato();
		estado = "ei";
		sb = new StringBuilder();
		
		for(char c : line.toCharArray()){
			linha.add(c);			
		}
		
		for(char c : l){
			letras.add(c);
		}
		
		for(char c : n){
			numeros.add(c);
		}
		
		while(!estado.equals("fdt")){
			caracter = auto.ler(linha);
			if(letras.contains(caracter)){
				ddp(caracter);					
			}else if(numeros.contains(caracter)){
				if(cPalavra.size() > 0){
					ddp(caracter);
				}else{
					psc(caracter);
				}
			}else if(!numeros.contains(caracter) && !letras.contains(caracter)){
				if(!cPalavra.isEmpty()){
					for(char c : cPalavra){
						sb.append(c);
					}						
					palavra.add(sb.toString());
				}
				
				sb.setLength(0);
				cPalavra.clear();
				sPalavra.clear();
			}
			
			if(caracter == '\u0000'){
				break;
			}
			
			if(sPalavra.isEmpty() && cPalavra.isEmpty() && estado.equals("fdt")){
				estado = "ei";
			}
			
			caracter = '\u0000';
		}
		
		return palavra;
	}

	public void ddp(char carac) {
		estado = "ddp";
		
		if(sPalavra.size() > 0 && cPalavra.size() == 0){
			cPalavra.addAll(sPalavra);
		}
		
		sPalavra.clear();
		cPalavra.add(carac);		
	}

	public void psc(char num) {
		estado = "psc";
		sPalavra.add(num);		
	}
	
	public char ler(List<Character> line){
		if(i < line.size()){
			carac = (char) line.get(i);
			i++;
		}else{
			estado = "fdt";
			carac = '\u0000';
		}
		
		return carac;
	}
	
}

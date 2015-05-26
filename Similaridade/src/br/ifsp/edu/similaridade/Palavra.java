package br.ifsp.edu.similaridade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Palavra {

	
	public Map<String, Integer> mapearPalavras(String texto, Map<String, Integer> mapa){		
		Automato automato;
		List<String> palavras = new ArrayList<>();
		Integer freq;
		String p;
		
		automato = new Automato();
		
		palavras = automato.ei(texto);
		
		for(int i = 0; i < palavras.size(); i++){ 
			p = palavras.get(i);
			freq = mapa.get(p);
				
			if (freq != null) { 
				mapa.put(palavras.get(i), mapa.get(palavras.get(i))+1);
			} else { 
				mapa.put(palavras.get(i),1); 
			} 			
			
			//System.out.println("tamanho: " + mapa.size());
			p = "";
		}
		
		return mapa;
	}
}

package br.ifsp.edu.similaridade;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapaGeral {
	private Map<String, Integer> mapa = new HashMap<>();
	
	public Map<String, Integer> mapear(Map<String, Integer> m1, Map<String, Integer> m2, Map<String, Integer> m3){
		mapa = m1;
		
		for(Entry<String, Integer> entry : m2.entrySet()){
			if (mapa.get(entry.getKey()) != null) { 
				mapa.put(entry.getKey(), mapa.get(entry.getKey()) + entry.getValue());
			} else { 
				mapa.put(entry.getKey(),1); 
			}
		}
		
		for(Entry<String, Integer> entry : m3.entrySet()){
			if (mapa.get(entry.getKey()) != null) { 
				mapa.put(entry.getKey(), mapa.get(entry.getKey()) + entry.getValue());
			} else { 
				mapa.put(entry.getKey(),1); 
			} 		
		}
				
		return mapa;
	}
	
	public void imprimirMapa(Map<String, Integer> m){
		for (Entry<String, Integer> entry : m.entrySet()) {
			System.out.println(entry.getKey()); 
			System.out.println("--> freq=" + entry.getValue() + "\n");
		}		
	}
	
	public void Idf(int arquivos){
		//log(totalArquivos / arquivos com termo)
		// termo por arquivo * log...
		
		
	}
	
}

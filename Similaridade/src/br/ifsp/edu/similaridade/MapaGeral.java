package br.ifsp.edu.similaridade;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapaGeral {
	public Map<String, Integer> mapear(Map<String, Integer> m1, Map<String, Integer> m2, Map<String, Integer> m3){
		Map<String, Integer> mapa = new HashMap<>();
		
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
	
}

package br.ifsp.edu.similaridade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Principal {
	public static void main(String[] args) {
		Dados dados = new Dados();
		Pasta pasta1 = null;
		Pasta pasta2 = null;
		Pasta pasta3 = null;	
		List<String> arquivos1 = new ArrayList<>();
		List<String> arquivos2 = new ArrayList<>();
		List<String> arquivos3 = new ArrayList<>();
		List<Arquivo> arq1 = new ArrayList<>();
		List<Arquivo> arq2 = new ArrayList<>();
		List<Arquivo> arq3 = new ArrayList<>();
		Map<String, Integer> mapa1 = new HashMap<>();
		Map<String, Integer> mapa2 = new HashMap<>();
		Map<String, Integer> mapa3 = new HashMap<>();
		Map<String, Integer> mapaGlobal = new HashMap<>();
		MapaGeral mgeral = new MapaGeral();
	
		ArquivoFactory fabrica = new ArquivoFactory();
		int i = 0;
		
		pasta1 = dados.lerEntrada();		
		pasta2 = dados.lerEntrada();
		pasta3 = dados.lerEntrada();
		
		arquivos1 = pasta1.obterArquivos();
		arquivos2 = pasta2.obterArquivos();
		arquivos3 = pasta3.obterArquivos();
		
		while(Pasta.getNumThreads() > 0){
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
				
		//dados.imprimirLista(arquivos1);
		while(arquivos1.size() > 0){
			arq1.add(fabrica.tipoArq(arquivos1.get(i)));
			arquivos1.remove(0);

			mapa1.putAll(arq1.get(i).lerArquivo());
			if(arq1.get(i) != null){
				i++;
			}
		}
		
		//dados.imprimirLista(arquivos2);
		i = 0;
		while(arquivos2.size() > 0){
			arq2.add(fabrica.tipoArq(arquivos2.get(i)));
			arquivos2.remove(0);
			
			mapa2.putAll(arq2.get(i).lerArquivo());
			if(arq2.get(i) != null){
				i++;
			}
		}
		
		//dados.imprimirLista(arquivos3);
		i = 0;
		while(arquivos3.size() > 0){
			arq3.add(fabrica.tipoArq(arquivos3.get(i)));
			arquivos3.remove(0);
			
			mapa3.putAll(arq3.get(i).lerArquivo());
			if(arq3.get(i) != null){
				i++;
			}
		}
		
		mapaGlobal = mgeral.mapear(mapa1, mapa2, mapa3);
		mgeral.imprimirMapa(mapaGlobal);
		
		
	}
}

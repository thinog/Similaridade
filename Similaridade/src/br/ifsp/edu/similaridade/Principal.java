package br.ifsp.edu.similaridade;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main(String[] args) {
		Dados dados = new Dados();
		Pasta pasta1 = null;
		Pasta pasta2 = null;
		Pasta pasta3 = null;	
		List<String> arquivos1 = new ArrayList<>();
		List<String> arquivos2 = null;
		List<String> arquivos3 = null;
		List<Arquivo> arq1 = new ArrayList<>();
		List<Arquivo> arq2 = null;
		List<Arquivo> arq3 = null;
		ArquivoFactory fabrica = new ArquivoFactory();
		int i = 0;
		
		pasta1 = dados.lerEntrada();		
		if(dados.getProxPasta().equals("y")){
			pasta2 = dados.lerEntrada();
			if(dados.getProxPasta().equals("y")){
				pasta3 = dados.lerEntrada();
			}
		}
		
		arquivos1 = pasta1.obterArquivos();
		if(pasta2 != null){
			arquivos2 = new ArrayList<>();
			arquivos2 = pasta2.obterArquivos();
			
			if(pasta3 != null){
				arquivos3 = new ArrayList<>();
				arquivos3 = pasta3.obterArquivos();
			}
		}
		
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

			arq1.get(i).lerArquivo();
			if(arq1.get(i) != null){
				i++;
			}
		}
		
		if(pasta2 != null){
			//dados.imprimirLista(arquivos2);
			arq2 = new ArrayList<>();
			i = 0;
			while(arquivos2.size() > 0){
				arq2.add(fabrica.tipoArq(arquivos2.get(i)));
				arquivos2.remove(0);
				if(arq2.get(i) != null){
					i++;
				}
			}
			if(pasta3 != null){
				//dados.imprimirLista(arquivos3);
				arq3 = new ArrayList<>();
				i = 0;
				while(arquivos3.size() > 0){
					arq3.add(fabrica.tipoArq(arquivos3.get(i)));
					arquivos3.remove(0);
					if(arq3.get(i) != null){
						i++;
					}
				}
			}
		}
		
		

	}
}

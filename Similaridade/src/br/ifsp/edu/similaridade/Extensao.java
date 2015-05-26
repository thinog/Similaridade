package br.ifsp.edu.similaridade;

public class Extensao {
	private String[] extensoes;
	
	public Extensao (String[] ext){
		extensoes = ext;
	}
	
	public boolean checarExt(String caminho){
		
		/* A extensão do arquivo recebido será comparada com todas
		 * as extensões informadas. Caso seja igual a alguma das 
		 * informadas, imprime o caminho completo do arquivo e 
		 * encerra o laço e, respectivamente, o método
		 */
		for (String e : extensoes){
			
			if (caminho.endsWith(e.toLowerCase())){ 
				return true;
			}
		}
		return false;
	}
		
}

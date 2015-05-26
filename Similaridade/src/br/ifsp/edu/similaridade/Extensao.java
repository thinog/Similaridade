package br.ifsp.edu.similaridade;

public class Extensao {
	private String[] extensoes;
	
	public Extensao (String[] ext){
		extensoes = ext;
	}
	
	public boolean checarExt(String caminho){
		
		/* A extens�o do arquivo recebido ser� comparada com todas
		 * as extens�es informadas. Caso seja igual a alguma das 
		 * informadas, imprime o caminho completo do arquivo e 
		 * encerra o la�o e, respectivamente, o m�todo
		 */
		for (String e : extensoes){
			
			if (caminho.endsWith(e.toLowerCase())){ 
				return true;
			}
		}
		return false;
	}
		
}

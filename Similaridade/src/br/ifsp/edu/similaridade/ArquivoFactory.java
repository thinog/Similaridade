package br.ifsp.edu.similaridade;

public class ArquivoFactory {
	
	public Arquivo tipoArq(String arquivo){
		if(arquivo.endsWith("doc") || arquivo.endsWith("docx")){
			return new ArquivoDoc(arquivo);
		}else if(arquivo.endsWith("txt")){
			return new ArquivoTxt(arquivo);
		}else if(arquivo.endsWith("pdf")){
			return new ArquivoPdf(arquivo);
		}else{
			System.out.println("Imposs�vel ler arquivo " + arquivo);
			return null;
		}
		
		//throw new RuntimeException("Extens�o n�o listada");
	}
}

package br.ifsp.edu.similaridade;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class ArquivoPdf extends Arquivo {
	
	public ArquivoPdf(String arquivo){
		super(arquivo);
	}
	
	Palavra palavra = new Palavra();
	private Map<String, Integer> mapa = new HashMap<>();
	
	@Override
	public void lerArquivo(){
		try{
			PdfReader filePdf = new PdfReader(arquivo);
            int numPaginas = filePdf.getNumberOfPages() + 1;
            System.out.println(arquivo);
            
            for(int i=1; i < numPaginas; i++){
                String pagina = PdfTextExtractor.getTextFromPage(filePdf, i);
                mapa = palavra.mapearPalavras(pagina, mapa);
            }
            
			for (Entry<String, Integer> entry : mapa.entrySet()) {
				System.out.println(entry.getKey()); 
				System.out.println("--> freq=" + entry.getValue() + "\n");
			}
            


		}catch (IOException e) { 
			System.err.println("Erro na abertura do arquivo: " + e.getMessage()); 
		}
	}
}

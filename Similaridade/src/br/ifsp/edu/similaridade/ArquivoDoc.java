package br.ifsp.edu.similaridade;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class ArquivoDoc extends Arquivo {
 	
 	public ArquivoDoc(String arquivo){
 		super(arquivo);
 	}
 	
	Palavra palavra = new Palavra();
	private Map<String, Integer> mapa = new HashMap<>();

 	@Override
 	public Map<String, Integer> lerArquivo() {
 		try{
	 		if(arquivo.endsWith("docx")){
 				XWPFDocument fileDocx = new XWPFDocument(new FileInputStream(arquivo));  
		 		XWPFWordExtractor arqWordx = new XWPFWordExtractor(fileDocx);  
		 	    String wordxText = arqWordx.getText(); 
		 	    
		 	    mapa = palavra.mapearPalavras(wordxText, mapa);
		 	    		 	    
				for (Entry<String, Integer> entry : mapa.entrySet()) {
					System.out.println(entry.getKey()); 
					System.out.println("--> freq=" + entry.getValue() + "\n");
				}
		 	    
		 	    //System.out.println(wordxText);
		 	    
		 	    arqWordx.close();		 	    
	 		}else if(arquivo.endsWith("doc")){
	 			POIFSFileSystem fileDoc = new POIFSFileSystem(new FileInputStream(arquivo));  
	 		    WordExtractor arqWord = new WordExtractor(fileDoc);  
	 		    String wordText = arqWord.getText();  
	 		    
	 		    mapa = palavra.mapearPalavras(wordText, mapa);

	            System.out.println(arquivo);
		 	    
				/*for (Entry<String, Integer> entry : mapa.entrySet()) {
					System.out.println(entry.getKey()); 
					System.out.println("--> freq=" + entry.getValue() + "\n");
				}*/
	 		    
	 		   	//System.out.println(wordText);
	 		   
	 		   	arqWord.close();
	 	    }
	 	}catch (IOException e) { 
			System.err.println("Erro na abertura do arquivo: " + e.getMessage()); 
		}
		return mapa;
 	}
}

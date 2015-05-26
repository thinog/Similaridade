package br.ifsp.edu.similaridade;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Pasta implements Runnable {
	private String caminho;
	private String[] ext;
	private Extensao extensoes;
	private List<String> arquivos;
	private static int numThreads;
	private Thread threadPasta;

	public Pasta(String caminho, String[] ext) {
		this.caminho = caminho;
		this.ext = ext;
		this.arquivos = new ArrayList<>();
		this.threadPasta = new Thread(this);
		Pasta.numThreads++;
	}

	public static int getNumThreads() {
		return numThreads;
	}

	public List<String> obterArquivos() {
		this.threadPasta.start();
		return arquivos;
	}

	@Override
	public void run() {
		List<String> subpastas = new ArrayList<>();
		extensoes = new Extensao(ext);
		subpastas.add(caminho);
		boolean extOk;

		while (subpastas.size() > 0) {
			try {
				File f = new File(subpastas.get(0));
				File[] fAux = f.listFiles();

				for (File file : fAux) {
					if (file.isDirectory()) {
						subpastas.add(file.getAbsolutePath());
					} else if (file.isFile()) {
						extOk = extensoes.checarExt(file.getName());
						if (extOk == true) {
							arquivos.add(file.getAbsolutePath());
						}
					}
				}
			} catch (NullPointerException npe) {
				System.out.println("*** Impossível acessar " + subpastas.get(0)	+ " ***");
			}
			subpastas.remove(0);
		}
		
		Pasta.numThreads--;
	}
}

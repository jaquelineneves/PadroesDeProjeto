package composite;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public abstract class GeradorArquivo {
	//Ctrl + Shift + O retira imports desnecessarios
	
	private Processador processador;
	
	public GeradorArquivo(Processador processador) {
		this.processador = processador;
	}
	
	public final void gerarArquivo(String nome, Map<String, Object> propriedades) throws IOException {
		String conteudo = gerarConteudo(propriedades);
		byte[] bytes = processador.processaConteudo(conteudo.getBytes()); //o processador vai processar o conteudo sem saber se é compactado, criptografado ou default. 
		FileOutputStream fileout = new FileOutputStream(nome);
		fileout.write(bytes);
		fileout.close();		
	}
	
	//obriga os filhos implementar pq é abstract
	protected abstract String gerarConteudo(Map<String,Object> propriedades);


}

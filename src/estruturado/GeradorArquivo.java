package estruturado;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public abstract class GeradorArquivo {
	//Ctrl + Shift + O retira imports desnecessarios
	public final void gerarArquivo(String nome, Map<String, Object> propriedades) throws IOException {
		String conteudo = gerarConteudo(propriedades);
		byte[] bytes = processaConteudo(conteudo.getBytes());
		FileOutputStream fileout = new FileOutputStream(nome);
		fileout.write(bytes);
		fileout.close();		
	}
	
	//obriga os filhos implementar pq é abstract
	protected abstract String gerarConteudo(Map<String,Object> propriedades);
		
	protected byte[] processaConteudo(byte[] conteudo) throws IOException {
		return conteudo;
	}

}

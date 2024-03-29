package estruturado;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Principal {
	
	public static void main(String[] args) throws IOException {
		Map<String,Object> mapa = new HashMap<>();
		mapa.put("nome", "Carlos");
		mapa.put("idade", 32);
		
		GeradorArquivo gerador = new GeradorArquivoPropriedades(new ProcessaCriptografado());
		gerador.gerarArquivo("c:\\Gerador\\Cripto.txt", mapa);
		
		GeradorArquivo gerador1 = new GeradorArquivoXml(new ProcessaCompactado());
		gerador1.gerarArquivo("c:\\Gerador\\XML.zip", mapa);
		
		GeradorArquivo gerador2 = new GeradorArquivoPropriedades(new ProcessaDefault());
		gerador2.gerarArquivo("c:\\Gerador\\default.txt", mapa);
	}
	
	/*
	 * Bridge
	 * Faz uma pontezinha, ele tem heran�a s�lida e oque varia de implementacoes faz uma composi��o com a interface.
	 * 
	 * */
}

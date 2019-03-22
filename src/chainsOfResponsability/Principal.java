package chainsOfResponsability;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Principal {

	public static void main(String[] args)throws IOException {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("nome", "Carlos");
		mapa.put("idade",32);
		
		Processador processaCompactado = new ProcessaCompactado();
		Processador processaCriptografado = new ProcessaCriptografado(processaCompactado);

		
		GeradorArquivo gerador = new GeradorArquivoPropriedades(processaCriptografado);
		gerador.gerarArquivo("c:\\Gerador\\prop1.zip", mapa);//gera um arquivo criptografado e depois zipado

	}

}
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

		List<Processador> processadores = new ArrayList<Processador>();
		processadores.add(new ProcessaCriptografado());
		processadores.add(new ProcessaCompactado());

		List<Processador> processadores1 = new ArrayList<Processador>();
		processadores1.add(new ProcessaCompactado());
		processadores1.add(new ProcessaCriptografado());

		List<Processador> processadores2 = new ArrayList<Processador>();
		processadores2.add(new ProcessaDefault());
		processadores2.add(new ProcessaCompactado());
		
		GeradorArquivo gerador = new GeradorArquivoPropriedades(new ProcessadorComposto(processadores));
		gerador.gerarArquivo("c:\\Gerador\\prop1.zip", mapa);//gera um arquivo criptografado e depois zipado

		GeradorArquivo gerador1 = new GeradorArquivoXml(new ProcessadorComposto(processadores1));
		gerador1.gerarArquivo("c:\\Gerador\\xml1.txt", mapa );//primeiro zipado e depois criptografado

		GeradorArquivo gerador2 = new GeradorArquivoPropriedades(new ProcessaDefault());
		gerador2.gerarArquivo("c:\\Gerador\\default.zip", mapa );

	}

}
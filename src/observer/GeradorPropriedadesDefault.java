package observer;

import java.util.Map;

public class GeradorPropriedadesDefault extends GeradorArquivo {

	public GeradorPropriedadesDefault(Processador processador) {
		super(processador);
	}
	
	@Override
	protected String gerarConteudo(Map<String, Object> propriedades) {
		//gera properties
		StringBuilder propFileBuilder = new StringBuilder();
		for (String prop: propriedades.keySet()) {
			propFileBuilder.append(prop+"="+propriedades.get(prop)+"\n");
		}
		return propFileBuilder.toString();
	}

}

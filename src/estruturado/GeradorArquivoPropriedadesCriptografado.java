package estruturado;

import java.util.Map;

public class GeradorArquivoPropriedadesCriptografado extends GeradorArquivo{
	
	@Override
	protected String gerarConteudo(Map<String, Object> propriedades) {
		//gera properties
		StringBuilder propFileBuilder = new StringBuilder();
		for (String prop: propriedades.keySet()) {
			propFileBuilder.append(prop+"="+propriedades.get(prop)+"\n");
		}
		return propFileBuilder.toString();
	}
	
	@Override
	protected byte[] processaConteudo(byte[] bs) {
		//criptografia
		byte[] newBytes = new byte[bs.length];
		for (int i = 0; i<bs.length; i++) {
			newBytes[i] = (byte)((bs[i]+10) % Byte.MAX_VALUE);
		}
		return newBytes;
	}

}

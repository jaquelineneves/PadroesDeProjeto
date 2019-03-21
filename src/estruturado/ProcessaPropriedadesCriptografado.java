package estruturado;

import java.util.Map;

public class ProcessaPropriedadesCriptografado {
	
	public byte[] processaPropriedadesCriptografado(Map<String, Object> propriedades) {
		String conteudo = geraConteudoPropriedades(propriedades);
		return processaCriptografado(conteudo.getBytes());
	}
	
	private String geraConteudoPropriedades(Map<String, Object> propriedades) {
		//gera properties
		StringBuilder propFileBuilder = new StringBuilder();
		for (String prop: propriedades.keySet()) {
			propFileBuilder.append(prop+"="+propriedades.get(prop)+"\n");
		}
		return propFileBuilder.toString();
	}
	
	private byte[] processaCriptografado(byte[] bs) {
		//criptografia
		byte[] newBytes = new byte[bs.length];
		for (int i = 0; i<bs.length; i++) {
			newBytes[i] = (byte)((bs[i]+10) % Byte.MAX_VALUE);
		}
		return newBytes;
	}

}

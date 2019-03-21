package estruturado;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GeradorArquivo {

	public final void gerarArquivo(String nome, Map<String, Object> propriedades, String tipo) throws IOException {
		byte[] bytes = null;
		if (tipo.equals("PROPRIEDADES_CRIPTOGRAFADO")) {
			bytes = processaPropriedadesCriptografado(propriedades);
		} else if (tipo.equals("XML_COMPACTADO")) {
			bytes = processaXmlCompactado(propriedades);
		} else {
			System.out.println("Desconheço essa opção");
			return;
		}
		FileOutputStream fileout = new FileOutputStream(nome);
		fileout.write(bytes);
		fileout.close();		
	}
	
	private byte[] processaXmlCompactado(Map<String, Object> propriedades) throws IOException {
		String conteudo = geraConteudoXml(propriedades);
		return processaCompactacao(conteudo.getBytes());
	}
	
	private String geraConteudoXml(Map<String, Object> propriedades) {
		//gera xml
		StringBuilder propFileBuilder = new StringBuilder();
		propFileBuilder.append("<properties>");
		for (String prop: propriedades.keySet()) {
			propFileBuilder.append("<"+prop+">"+propriedades.get(prop)+"</"+prop+">");
		}
		propFileBuilder.append("</propriedades>");
		return propFileBuilder.toString();	
	}
	
	private byte[] processaCompactacao(byte[] bytes) throws IOException {
		//compacta
		ByteArrayOutputStream byteout = new ByteArrayOutputStream();
		ZipOutputStream out = new ZipOutputStream(byteout);
		out.putNextEntry(new ZipEntry("internal"));
		out.write(bytes);
		out.closeEntry();
		out.close();
		return byteout.toByteArray();	
	}

}

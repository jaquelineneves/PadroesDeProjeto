package observer;

import java.io.IOException;
import java.util.List;

public class ProcessadorComposto implements Processador {

	/*
	 * implementa a interface como tds os outros, mas tbm tem uma associação com essa interface.
	 * 
	 */
	
	private List<Processador> processadores;
	
	public ProcessadorComposto(List<Processador> processadores) {
		this.processadores = processadores;
	}
	
	@Override
	public byte[] processaConteudo(byte[] bytes) throws IOException {
		for (Processador processador: processadores) {
			processador.processaConteudo(bytes);
		}
		return bytes;
	}

}

package chainsOfResponsability;

import java.io.IOException;

public abstract class Processador {
	//esse chains � conhecido por uma cadeia de execu��o
	private Processador proximoProcessador;
	
	public Processador(Processador proximoProcessador) {
		this.proximoProcessador = proximoProcessador;
	}
	
	public Processador() {
		this.proximoProcessador = null;
	}
	
	public byte[] processarCadeia(byte[] bytes) throws IOException {
		bytes = processaConteudo(bytes);
		if(proximoProcessador != null) {
			bytes = proximoProcessador.processarCadeia(bytes);
		}
		return bytes;
	}
	
	protected abstract byte[] processaConteudo(byte[] bytes) throws IOException;
}

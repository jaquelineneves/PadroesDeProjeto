package chainsOfResponsability;

public class ProcessaCriptografado extends Processador {
	
	public ProcessaCriptografado(Processador proximo) {
		super(proximo);
	}
	
	public ProcessaCriptografado() {
		
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

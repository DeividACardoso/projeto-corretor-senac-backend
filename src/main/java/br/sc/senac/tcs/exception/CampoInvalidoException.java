package br.sc.senac.tcs.exception;

public class CampoInvalidoException extends Exception {
	
	public CampoInvalidoException(String mensagem, Throwable causa) {
		super(mensagem);
	}

	public CampoInvalidoException(String mensagem) {
		super(mensagem);
	}

}

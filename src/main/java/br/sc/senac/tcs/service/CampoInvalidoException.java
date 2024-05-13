package br.sc.senac.tcs.service;

public class CampoInvalidoException extends Exception {

    private static final long serialVersionUID = 3127415545307655634L;

    public CampoInvalidoException(String mensagem, Exception e) {
        super(mensagem, e);
    }

    public CampoInvalidoException(String mensagem) {
        super(mensagem);
    }

}

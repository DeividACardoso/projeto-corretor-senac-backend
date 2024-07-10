package br.sc.senac.tcs.exception;

import java.util.List;

public class CampoInvalidoException extends RuntimeException {

    private List<String> errorMessages;

    public CampoInvalidoException(List<String> errorMessages) {
        super(String.join(", ", errorMessages));
        this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public CampoInvalidoException(String mensagem, Throwable causa) {
        super(mensagem);
    }

    public CampoInvalidoException(String mensagem) {
        super(mensagem);
    }

    @Override
    public String getMessage() {
        return "Campo inválido: " + super.getMessage();
    }
}

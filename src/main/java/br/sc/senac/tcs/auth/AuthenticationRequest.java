package br.sc.senac.tcs.auth;

public class AuthenticationRequest {
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getUsername() {
        throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }
}

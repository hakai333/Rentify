package cl.MyMGroup.Rentify.dto;

import cl.MyMGroup.Rentify.model.Usuario;

public class AuthResponse {
    private String mensaje;
    private String token;
    private Usuario usuario;

    public AuthResponse(String mensaje, String token, Usuario usuario) {
        this.mensaje = mensaje;
        this.token = token;
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getToken() {
        return token;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

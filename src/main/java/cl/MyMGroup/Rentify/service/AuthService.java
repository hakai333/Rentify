package cl.MyMGroup.Rentify.service;

import cl.MyMGroup.Rentify.dto.AuthResponse;
import cl.MyMGroup.Rentify.dto.LoginRequest;
import cl.MyMGroup.Rentify.dto.RegisterRequest;
import cl.MyMGroup.Rentify.model.Usuario;
import cl.MyMGroup.Rentify.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public String register(RegisterRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            return "El email ya esta registrado";
        }

        Usuario usuario = new Usuario(request.getNombre(), request.getApellido() ,request.getEmail(), request.getPassword());
        usuarioRepository.save(usuario);
        return "Registrado correctamente";
    }

    public AuthResponse login(LoginRequest request) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(request.getEmail());

        if (usuarioOpt.isEmpty() || !usuarioOpt.get().getPassword().equals(request.getPassword())) {
            return new AuthResponse("Credenciales inválidas", null);
        }

        // Simulamos token (en producción usar JWT)
        String fakeToken = "token_" + usuarioOpt.get().getId();
        return new AuthResponse("Login exitoso", fakeToken);
    }




}

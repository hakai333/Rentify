package cl.MyMGroup.Rentify.controller;

import cl.MyMGroup.Rentify.dto.AuthResponse;
import cl.MyMGroup.Rentify.dto.LoginRequest;
import cl.MyMGroup.Rentify.dto.RegisterRequest;
import cl.MyMGroup.Rentify.model.Usuario;
import cl.MyMGroup.Rentify.repository.UsuarioRepository;
import cl.MyMGroup.Rentify.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequest request) {
        String message = authService.register(request);
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

    AuthResponse response = authService.login(request);

    if (response.getToken() == null) {
        return ResponseEntity.status(401).body(response);
    }

    return ResponseEntity.ok(response);
}

    @GetMapping("/test")
    public ResponseEntity<String> testConnection() {
        return ResponseEntity.ok("Backend conectado correctamente");
    }


}

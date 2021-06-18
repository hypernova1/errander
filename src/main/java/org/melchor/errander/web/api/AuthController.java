package org.melchor.errander.web.api;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.service.AuthService;
import org.melchor.errander.web.payload.JoinForm;
import org.melchor.errander.web.payload.LeaveForm;
import org.melchor.errander.web.payload.LoginForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm) {
        String token = authService.login(loginForm);

        return ResponseEntity.ok(token);
    }

}

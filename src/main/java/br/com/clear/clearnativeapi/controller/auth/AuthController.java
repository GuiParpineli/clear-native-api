package br.com.clear.clearnativeapi.controller.auth;

import br.com.clear.clearnativeapi.configuration.jwt.JwtUtil;
import br.com.clear.clearnativeapi.controller.dto.TokenDto;
import br.com.clear.clearnativeapi.data.entity.UserDto;
import br.com.clear.clearnativeapi.domain.service.user.UserUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.clear.clearnativeapi.configuration.jwt.JwtUtilImpl.EXPIRATION_TIME;

@RestController
@RequestMapping(value = "public/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Auth", description = "Auth operations")
public class AuthController {
    private final UserDetailsService service;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserDetailsService service, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userApp) {

        final UserDetails userDetails = service.loadUserByUsername(userApp.username());
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        userApp.username(),
                        userApp.password())
                );

        final String jwt = jwtUtil.generateToken(userDetails);
        TokenDto tokenDto = new TokenDto(jwt, EXPIRATION_TIME);

        return ResponseEntity.ok(tokenDto);
    }
}

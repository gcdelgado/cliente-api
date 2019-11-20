package br.com.surittec.clienteapi.controller;

import br.com.surittec.clienteapi.security.AccountCredentials;
import br.com.surittec.clienteapi.security.TokenAuthenticationService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Collections;

@RestController
@CrossOrigin("${origem-permitida}")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody @Valid AccountCredentials credentials) throws Exception{

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentials.getUsername(),
                        credentials.getPassword(),
                        Collections.emptyList()
                )
        );

        if (authentication != null) {
            final String token = TokenAuthenticationService.gerarToken(credentials.getUsername());
            return ResponseEntity.ok(token);
        } else{
            return ResponseEntity.badRequest().body("CREDENCIAIS INVALIDAS");
        }
    }

}

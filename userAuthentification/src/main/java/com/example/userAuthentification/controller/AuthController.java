package com.example.userAuthentification.controller;

import com.example.userAuthentification.client.LaboratoireDTO;
import com.example.userAuthentification.dto.JwtAuthenticationResponse;
import com.example.userAuthentification.dto.UtilisateurDto;
import com.example.userAuthentification.entity.User;
import com.example.userAuthentification.service.JwtTokenProvider;
import com.example.userAuthentification.service.UserService;
import com.example.userAuthentification.serviceClient.LaboratoireService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String addNewUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody JwtAuthenticationResponse authRequest) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authenticate.isAuthenticated()) {
            return userService.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        userService.validateToken(token);
        return "Token is valid";
    }

    @GetMapping("/getAllUtilisateurs")
    public ResponseEntity<List<UtilisateurDto>> getAllUtilisateurs() {
        List<UtilisateurDto> utilisateurs = userService.getAllUtilisateurs();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> getUtilisateurById(@PathVariable Long id) {
        UtilisateurDto utilisateur = userService.obtenirUtilisateurParId(id); // Using non-static method
        return utilisateur != null ?
                new ResponseEntity<>(utilisateur, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/email/{email}")
    public UtilisateurDto getUserByEmail(@PathVariable  String email) {
        UtilisateurDto user = new UtilisateurDto();
        user.setEmail(email);
        user.setNomComplet(user.getNomComplet());

        return user;
    }


    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDto> mettreAJourUtilisateur(@PathVariable Long id, @Valid @RequestBody UtilisateurDto utilisateurDto) {
        UtilisateurDto utilisateurMisAJour = userService.modifierUtilisateur(id, utilisateurDto);
        return utilisateurMisAJour != null ?
                new ResponseEntity<>(utilisateurMisAJour, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerUtilisateur(@PathVariable Long id) {
        userService.supprimerUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    private final LaboratoireService laboratoireService;

    @Autowired
    public AuthController(LaboratoireService laboratoireService) {
        this.laboratoireService = laboratoireService;
    }

    @GetMapping("/laboratoires/{id}")
    public LaboratoireDTO getLaboratoireById(@PathVariable Long id) {
        return laboratoireService.getLaboratoireDetails(id);
    }
}

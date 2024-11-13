package com.example.userAuthentification.dto;
public class JwtAuthenticationResponse {

    private String username;
    private String password;

    // Constructeur sans argument (équivalent à @NoArgsConstructor)
    public JwtAuthenticationResponse() {
    }

    // Constructeur avec arguments (équivalent à @AllArgsConstructor)
    public JwtAuthenticationResponse(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters et Setters (équivalent à @Data)

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



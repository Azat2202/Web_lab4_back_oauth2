package ru.web_lab4.authController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ApplicationUser {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotBlank
    private String login;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String salt;

    public ApplicationUser(String login, String password, String salt) {
        this.login = login;
        this.password = password;
        this.salt = salt;
    }
}

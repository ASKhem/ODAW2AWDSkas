package com.kas.kasproy.dto;

import com.kas.kasproy.errors.First;
import com.kas.kasproy.errors.Second;
import com.kas.kasproy.model.user.Rol;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioNewDto {
    @NotEmpty(message = "Name is empty", groups = First.class)
    @Size(min = 5, max = 20, message = "Name must be between 5 and 20 characters" , groups = Second.class)
    private String nombre;

    @NotEmpty(message = "Password is empty" , groups = First.class)
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters" , groups = Second.class)
    private String password;

    @NotEmpty(message = "Email is empty" , groups = First.class)
    @Email(message = "Email is not valid" , groups = Second.class)
    private String email;

    @NotNull
    private Rol rol;
}

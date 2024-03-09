package com.kas.kasproy.dto;

import com.kas.kasproy.model.user.Rol;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioNewDto {
    @NotEmpty
    private String nombre;

    @NotEmpty
    private String password;

    @NotEmpty
    private String email;

    @NotEmpty
    private Rol rol;
}

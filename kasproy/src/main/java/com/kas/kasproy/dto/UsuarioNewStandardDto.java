package com.kas.kasproy.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioNewStandardDto {
    @NotEmpty
    private String nombre;

    @NotEmpty
    private String password;

    @NotEmpty
    private String email;
}

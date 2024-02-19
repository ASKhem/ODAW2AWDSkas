package com.kas08.kas0810.domain;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ConsultaForm {
    @NotEmpty(message = "*Escribe el tu nombre")
    private String name;

    @NotEmpty(message = "*Escribe tu correo")
    private String correo;

    @NotEmpty(message = "*Obligatorio")
    private String tipo;

    @NotEmpty(message = "*El comentario no debe estar en blanco")
    private String comentario;

    @AssertTrue(message = "*Acepta los términos y condiciones")
    private boolean aceptaCondiciones;

    public void reset() {
        this.name = null;
        this.correo = null;
        this.comentario = null;
        this.tipo = "";
        this.aceptaCondiciones = false;
    }
}

package com.kas.kasproy.dto;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {

    private Long id;

    private Long usuarioId;

    private Long ordenadorInfoId;

    private Double precio;

    private LocalDate fechaPedido;
}

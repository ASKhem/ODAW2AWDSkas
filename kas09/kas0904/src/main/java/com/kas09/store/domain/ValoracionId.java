package com.kas09.store.domain;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValoracionId implements Serializable{
    private Long usuario;
    private Long producto;
}

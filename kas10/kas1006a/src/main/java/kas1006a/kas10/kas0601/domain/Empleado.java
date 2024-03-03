package kas1006a.kas10.kas0601.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Empleado {
    @NotNull
    @Min(1)
    private Long id;
    @NotNull
    @Size(min=3)
    private String nombre;
    @Email
    private String email;
    @NotNull
    private Double salario;
}

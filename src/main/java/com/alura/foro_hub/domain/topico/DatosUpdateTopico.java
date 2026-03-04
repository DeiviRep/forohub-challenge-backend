package com.alura.foro_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DatosUpdateTopico(
        @NotBlank @Size(max = 200) String titulo,
        @NotBlank String mensaje,
        String status,
        Long autorId,
        Long cursoId
) {

}

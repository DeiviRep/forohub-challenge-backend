package com.alura.foro_hub.domain.topico;

import java.time.LocalDateTime;

public record DatosListTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        String curso
) {
        public DatosListTopico(Topico topico) {
                this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus().name(), topico.getAutor().getNombre(), topico.getCurso().getNombre());
        }

}

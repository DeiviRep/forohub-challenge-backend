package com.alura.foro_hub.controller;

import java.net.URI;

// import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura.foro_hub.domain.topico.DatosDetalleTopico;
import com.alura.foro_hub.domain.topico.DatosListTopico;
import com.alura.foro_hub.domain.topico.DatosRegistroTopico;
import com.alura.foro_hub.domain.topico.DatosRespuestaTopico;
import com.alura.foro_hub.domain.topico.DatosUpdateTopico;
import com.alura.foro_hub.domain.topico.TopicoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/topicos")
// @SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> crear(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder) {
        var topico = topicoService.crearTopico(datos);
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus().name(),
                topico.getAutor().getId(),
                topico.getCurso().getId()
            );
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }
    
    @GetMapping
    public ResponseEntity<Page<DatosListTopico>> listar(
            @RequestParam(required = false) String curso,
            @RequestParam(required = false) Integer year,
            Pageable pageable
    ) {
        var result = topicoService.listadoPage(curso, year, pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detalle(@PathVariable Long id) {
        var result = topicoService.detalle(id);
        return ResponseEntity.ok(result);
    }
    
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosDetalleTopico> actualizar(@PathVariable Long id, @RequestBody @Valid DatosUpdateTopico datos) {
        var result = topicoService.actualizar(id, datos);
        return ResponseEntity.ok(result);
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        topicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}

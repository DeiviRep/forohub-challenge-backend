package com.alura.foro_hub.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.alura.foro_hub.domain.StatusTopico;
import com.alura.foro_hub.domain.ValidacionException;
import com.alura.foro_hub.domain.curso.CursoRepository;
import com.alura.foro_hub.domain.usuario.UsuarioRepository;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public Topico crearTopico(DatosRegistroTopico datos){
                if (!usuarioRepository.existsById(datos.autorId())) {
            throw new ValidacionException("Autor no encontrado");
        }
        if (!cursoRepository.existsById(datos.autorId())) {
            throw new ValidacionException("Curso no encontrado");
        }
        if (topicoRepository.existsByTituloIgnoreCaseAndMensajeIgnoreCase(datos.titulo(), datos.mensaje())) {
            throw new ValidacionException("Tópico duplicado (título + mensaje ya existen).");
        }
        var autor = usuarioRepository.findById(datos.autorId()).get();
        var curso = cursoRepository.findById(datos.cursoId()).get();
        Topico topicoDatos = new Topico();        
        topicoDatos.setTitulo(datos.titulo());
        topicoDatos.setMensaje(datos.mensaje());
        topicoDatos.setAutor(autor);
        topicoDatos.setCurso(curso);
        topicoDatos.setStatus(StatusTopico.ABIERTO);
        var topico = topicoRepository.save(topicoDatos);
        return topico;
    }

    public Page<DatosListTopico> listadoPage(String curso, Integer year, @PageableDefault(size = 10, sort = "fechaCreacion") Pageable pageable) {
        Page<DatosListTopico> page;
        if (curso != null && year != null) {
            page = topicoRepository.findByCursoNombreAndYear(curso, year, pageable).map(DatosListTopico::new);
        } else if (curso != null) {
            page = topicoRepository.findByCurso_NombreIgnoreCase(curso, pageable).map(DatosListTopico::new);
        } else if (year != null) {
            page = topicoRepository.findByYear(year, pageable).map(DatosListTopico::new);
        } else {
            page = topicoRepository.findAll(pageable).map(DatosListTopico::new);
        }
        return page;
    }
}

package com.alura.foro_hub.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
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
}

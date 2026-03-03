package com.alura.foro_hub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long>{
    boolean existsByTituloIgnoreCaseAndMensajeIgnoreCase(String titulo, String mensaje);

    
    Page<Topico> findByCurso_NombreIgnoreCase(String nombreCurso, Pageable pageable);

    @Query("""
           select t from Topico t
            where lower(t.curso.nombre) = lower(?1)
              and function('year', t.fechaCreacion) = ?2
           """)
    Page<Topico> findByCursoNombreAndYear(String nombreCurso, int year, Pageable pageable);

    @Query("""
           select t from Topico t
            where function('year', t.fechaCreacion) = ?1
           """)
    Page<Topico> findByYear(int year, Pageable pageable);

}

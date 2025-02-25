package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro,Long> {
    @Query("SELECT l from Libro l where l.titulo=:titulo")
    public Libro buscarLibroPorTitulo(@Param("titulo")String titulo);

    @Query("SELECT l from Libro l where l.autor=:autor")
    public List<Libro> buscarLibrosPorAutor(@Param("autor")Autor autor);

    @Query("SELECT l from Libro l where l.autor.nombre=:nombre")
    public List<Libro> buscarLibrosPorAutor(@Param("nombre")String nombre);
}

package br.com.fiap.cursos.cursos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "curso")
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String descricao;
    String instrutor;
    int duracao;
}


// http://localhost:8080/cursos
// http://localhost:8080/cursos/novo
// http://localhost:8080/cursos/editar/1
// http://localhost:8080/cursos/deletar/1

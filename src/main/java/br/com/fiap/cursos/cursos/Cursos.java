package br.com.fiap.cursos.cursos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String instrutor;
    private int duracao;
    public void setId(Long id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
    
}


// http://localhost:8080/cursos
// http://localhost:8080/cursos/novo
// http://localhost:8080/cursos/editar/1
// http://localhost:8080/cursos/deletar/1

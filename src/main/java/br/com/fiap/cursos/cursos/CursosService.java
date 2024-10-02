package br.com.fiap.cursos.cursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursosService {
    
    @Autowired
    private CursosRepository cursoRepository;

    public List<Cursos> listarCursos() {
        return cursoRepository.findAll();
    }

    public Cursos salvarCurso(Cursos curso) {
        return cursoRepository.save(curso);
    }

    public Cursos buscarCursoPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public void deletarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
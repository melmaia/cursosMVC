package br.com.fiap.cursos.cursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursosService {
    
    @Autowired
    private CursosRepository cursosRepository;

    public List<Cursos> listarCursos() {
        return cursosRepository.findAll();
    }

    public Cursos salvarCurso(Cursos cursos) {
        return cursosRepository.save(cursos);
    }

    public Cursos buscarCursoPorId(Long id) {
        return cursosRepository.findById(id).orElse(null);
    }

    public void deletarCurso(Long id) {
        cursosRepository.deleteById(id);
    }
    
}
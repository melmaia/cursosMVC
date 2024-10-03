package br.com.fiap.cursos.cursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursosService cursoService;

    @GetMapping
    public String listarCursos(Model model) {
        List<Cursos> cursos = cursoService.listarCursos();
        model.addAttribute("cursos", cursos);
        return "curso/lista"; // Ajustado para referenciar a lista.html na pasta curso
    }

    @GetMapping("/novo")
    public String mostrarFormularioDeNovoCurso(Model model) {
        model.addAttribute("curso", new Cursos());
        return "curso/formulario"; // Ajustado para referenciar formulario.html na pasta curso
    }

    @PostMapping
    public String salvarCurso(@ModelAttribute Cursos curso) {
        cursoService.salvarCurso(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarCurso(@PathVariable Long id, Model model) {
        Cursos curso = cursoService.buscarCursoPorId(id);
        model.addAttribute("curso", curso);
        return "curso/formulario"; // Mantido como está, referenciando formulario.html
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarCurso(@PathVariable Long id, @ModelAttribute Cursos curso) {
        curso.setId(id);
        cursoService.salvarCurso(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarCurso(@PathVariable Long id) {
        cursoService.deletarCurso(id);
        return "redirect:/cursos";
    }
}

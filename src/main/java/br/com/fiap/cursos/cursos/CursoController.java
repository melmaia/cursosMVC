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
    private CursosService cursosService;

    @GetMapping
    public String listarCursos(Model model) {
        List<Cursos> cursos = cursosService.listarCursos();
        model.addAttribute("cursos", cursos);
        return "curso/lista"; }

    @GetMapping("/novo")
    public String mostrarFormularioDeNovoCurso(Model model) {
        model.addAttribute("curso", new Cursos());
        return "curso/formulario"; 
    }

    @PostMapping
    public String salvarCurso(@ModelAttribute Cursos cursos) {
        cursosService.salvarCurso(cursos);
        return "redirect:/cursos";
    }


}

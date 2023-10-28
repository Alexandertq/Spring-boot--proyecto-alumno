package pe.tarea.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.tarea.entity.Curso;
import pe.tarea.service.CursoService;

@Controller
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	public CursoController() {
		// TODO Auto-generated constructor stub
	}
		
	@GetMapping("/curso")
	public String curso_GET(Map map) 
	{
		map.put("bcurso", cursoService.findAll());
		
		return "Curso/lisregistro";
	}
	
	@GetMapping("/cursos/registrar")
	public String registrar_GET(Model model)
	{
		Curso cursoNull=new Curso();
		model.addAttribute("curso",cursoNull);
		
		return "Curso/registrar";
	}
	
	@PostMapping("/cursos/registrar")
	public String registrar_POST(Curso curso)
	{
		//guardar en la BD
		cursoService.insert(curso);
		
		return "redirect:/curso";
	}
	@GetMapping("/cursos/editar/{cursoId}")
	public String editar_GET(Model model,@PathVariable Integer cursoId)
	{
		Curso cursoDb=cursoService.findById(cursoId);
		model.addAttribute("curso",cursoDb);
		
		return "Curso/editar";
	}
	
	@PostMapping("/cursos/editar/{cursoId}")
	public String editar_POST(Curso curso)
	{
		cursoService.update(curso);
		
		return "redirect:/curso";
	}
	
	@GetMapping("/cursos/borrar/{cursoId}")
	public String borrar_GET(Model model,@PathVariable Integer cursoId)
	{
		Curso cursoDb=cursoService.findById(cursoId);
		model.addAttribute("curso",cursoDb);
		
		return "Curso/borrar";
	}
	
	@RequestMapping(value="/cursos/borrar/{cursoId}",method=RequestMethod.POST)
	public String borrar_POST(Curso curso)
	{
		cursoService.delete(curso.getCursoId());
		return "redirect:/curso";
	}
	
	@GetMapping("/cursos/detalle/{cursoId}")
	public String detalle_GET(Model model,@PathVariable Integer cursoId)
	{
		Curso cursoDb=cursoService.findById(cursoId);
		model.addAttribute("curso",cursoDb);
		
		return "Curso/detalle";
	}
	@RequestMapping(value="/cursos/detalle/{cursoId}",method=RequestMethod.POST,params="btnInicio")
	public String detalle_POST1()
	{
		return "redirect:/inicio";
	}
	
	@RequestMapping(value="/cursos/detalle/{cursoId}",method=RequestMethod.POST,params="btnVolver")
	public String detalle_POST2()
	{
		return "redirect:/curso";
	}

}

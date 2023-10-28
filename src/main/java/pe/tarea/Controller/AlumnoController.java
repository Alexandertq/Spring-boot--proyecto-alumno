package pe.tarea.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import pe.tarea.entity.Alumno;
import pe.tarea.entity.Curso;
import pe.tarea.service.AlumnoService;
import pe.tarea.service.CursoService;
import pe.tarea.service.FotoService;
import pe.tarea.service.UniversidadService;
@Controller
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private UniversidadService universidadService;
	
	@Autowired
	private FotoService fotoService;
	
	@Autowired
	private CursoService cursoService;
	
	private Collection<Curso> complemento=null;
	
	public AlumnoController() {}
	
	@GetMapping("/inicio")
	public String inicio_GET() {
		return "inicio";
	}
	
	@GetMapping("/listaalumno")
	public String alumno_GET(Map map) 
	{
		map.put("balumno", alumnoService.findAll());
		
		return "Alumno/lisregistro";
	}
	
	@GetMapping("/listaalumno/registrar")
	public String registrar_GET(Model model,Map map)
	{
		Alumno alumnoNull=new Alumno();
		model.addAttribute("alumno",alumnoNull);
		
		map.put("buniversidad", universidadService.findAll());
		map.put("bfoto", fotoService.findAll());
		
		return "Alumno/registrar";
	}
	
	@PostMapping("/listaalumno/registrar")
	public String registrar_POST(Alumno alumno)
	{
		//guardar en la BD
		alumnoService.insert(alumno);
		
		return "redirect:/listaalumno";
	}
	@GetMapping("/listaalumno/editar/{alumnoId}")
	public String editar_GET(Model model,Map map,@PathVariable Integer alumnoId)
	{
		Alumno alumnoDb=alumnoService.findById(alumnoId);
		model.addAttribute("alumno",alumnoDb);
		
		map.put("buniversidad", universidadService.findAll());
		map.put("bfoto", fotoService.findAll());
		
		return "Alumno/editar";
	}
	
	@PostMapping("/listaalumno/editar/{alumnoId}")
	public String editar_POST(Alumno alumno)
	{
		alumnoService.update(alumno);
		
		return "redirect:/listaalumno";
	}
	
	@GetMapping("/listaalumno/borrar/{alumnoId}")
	public String borrar_GET(Model model,@PathVariable Integer alumnoId)
	{
		Alumno alumnoDb=alumnoService.findById(alumnoId);
		model.addAttribute("alumno",alumnoDb);
		
		return "Alumno/borrar";
	}
	
	@RequestMapping(value="/listaalumno/borrar/{alumnoId}",method=RequestMethod.POST)
	public String borrar_POST(Alumno alumno)
	{
		alumnoService.delete(alumno.getAlumnoId());
		return "redirect:/listaalumno";
	}
	
	@GetMapping("/listaalumno/detalle/{alumnoId}")
	public String detalle_GET(Model model,@PathVariable Integer alumnoId)
	{
		Alumno alumnoDb=alumnoService.findById(alumnoId);
		model.addAttribute("alumno",alumnoDb);
		
		return "Alumno/detalle";
	}
	@RequestMapping(value="/listaalumno/detalle/{alumnoId}",method=RequestMethod.POST,params="btnInicio")
	public String detalle_POST1()
	{
		return "redirect:/inicio";
	}
	
	@RequestMapping(value="/listaalumno/detalle/{alumnoId}",method=RequestMethod.POST,params="btnVolver")
	public String detalle_POST2()
	{
		return "redirect:/listaalumno";
	}
		
	//////////////////////////////
		
	@GetMapping("/listaalumno/curso_agregar/{alumnoId}")
    public String curso_agregar_GET(Model model,Map map,@PathVariable Integer alumnoId,
                                        @RequestParam(defaultValue="false") boolean flag)
    {
        Alumno alumnoDb=alumnoService.findById(alumnoId);

        if(flag==false) {
        	complemento=this.convert(alumnoService.alumnos_cursos(alumnoId));
        }

        model.addAttribute("alumno",alumnoDb);

        map.put("bcurso1",cursoService.findAll());
        map.put("bcurso2",complemento);

        return "Alumno/curso_agregar";
    }

    @GetMapping("/alumno_curso/agregar/{cursoId}/{alumnoId}")
    public String agregar_carrito_GET(@PathVariable Integer cursoId,@PathVariable Integer alumnoId)
    {
        Curso cursoDb=cursoService.findById(cursoId);
        complemento.add(cursoDb);

        return "redirect:/listaalumno/curso_agregar/"+alumnoId+"?flag=true";
    }

    @PostMapping("/listaalumno/curso_agregar/{alumnoId}")
    public String curso_agregar_POST(@PathVariable Integer alumnoId)
    {
        Alumno alumnoDb=alumnoService.findById(alumnoId);

        for(Curso curso:complemento) {
            alumnoDb.addCurso(curso);
        }

        alumnoService.update(alumnoDb);

        return "redirect:/listaalumno";
    }

    public Collection<Curso> convert(Collection<Object[]> objects)
    {
        Collection<Curso> cursos=new ArrayList<>();

        for(Object[] object:objects)
        {
            Integer cursoId=Integer.parseInt(object[0].toString());
            Curso cursoDb=cursoService.findById(cursoId);

            cursos.add(cursoDb);
        }

        return cursos;
    }
	

}



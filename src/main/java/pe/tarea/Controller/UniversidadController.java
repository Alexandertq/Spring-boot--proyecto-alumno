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

import pe.tarea.entity.Universidad;
import pe.tarea.service.UniversidadService;


@Controller
public class UniversidadController {

	@Autowired
	private UniversidadService universidadService;

	public UniversidadController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/universidades")
	public String universidad_GET(Map map) 
	{
		map.put("buniversidad", universidadService.findAll());
		
		return "Universidad/lisregistro";
	}
	
	@GetMapping("/universidad/registrar")
	public String registrar_GET(Model model)
	{
		Universidad universidadNull=new Universidad();
		model.addAttribute("universidad",universidadNull);
		
		
		
		return "Universidad/registrar";
	}
	
	@PostMapping("/universidad/registrar")
	public String registrar_POST(Universidad universidad)
	{
		//guardar en la BD
		universidadService.insert(universidad);
		
		return "redirect:/universidades";
	}
	@GetMapping("/universidad/editar/{universidadId}")
	public String editar_GET(Model model,@PathVariable Integer universidadId)
	{
		Universidad universidadDb=universidadService.findById(universidadId);
		model.addAttribute("universidad",universidadDb);
		
		return "Universidad/editar";
	}
	
	@PostMapping("/universidad/editar/{universidadId}")
	public String editar_POST(Universidad universidad)
	{
		universidadService.update(universidad);
		
		return "redirect:/universidades";
	}
	
	@GetMapping("/universidad/borrar/{universidadId}")
	public String borrar_GET(Model model,@PathVariable Integer universidadId)
	{
		Universidad universidadDb=universidadService.findById(universidadId);
		model.addAttribute("universidad",universidadDb);
		
		return "Universidad/borrar";
	}
	
	@RequestMapping(value="/universidad/borrar/{universidadId}",method=RequestMethod.POST)
	public String borrar_POST(Universidad universidad)
	{
		universidadService.delete(universidad.getUniversidadId());
		return "redirect:/universidades";
	}
	
	@GetMapping("/universidad/detalle/{universidadId}")
	public String detalle_GET(Model model,@PathVariable Integer universidadId)
	{
		Universidad universidadDb=universidadService.findById(universidadId);
		model.addAttribute("universidad",universidadDb);
		
		return "Universidad/detalle";
	}
	@RequestMapping(value="/universidad/detalle/{universidadId}",method=RequestMethod.POST,params="btnInicio")
	public String detalle_POST1()
	{
		return "redirect:/inicio";
	}
	
	@RequestMapping(value="/universidad/detalle/{universidadId}",method=RequestMethod.POST,params="btnVolver")
	public String detalle_POST2()
	{
		return "redirect:/universidades";
	}

}

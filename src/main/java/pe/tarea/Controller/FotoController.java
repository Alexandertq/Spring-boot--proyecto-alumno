package pe.tarea.Controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


import pe.tarea.entity.Foto;
import pe.tarea.service.FotoService;
@Controller
public class FotoController {
	
	@Autowired
	private FotoService fotoService;
	
	public FotoController() {
		// TODO Auto-generated constructor stub
	}

	
	@GetMapping("/fotos")
	public String foto_GET(Map map) 
	{
		map.put("bfoto", fotoService.findAll());
		
		return "Foto/lisregistro";
	}
	
	@GetMapping("/foto/registrar")
	public String registrar_GET(Model model)
	{
		return "Foto/registrar";
	}
	
	@PostMapping("/foto/registrar")
	public String registrar_POST(@RequestPart("picture") MultipartFile picture) throws IOException 
	{
		
		Foto foto=new Foto();
		
		foto.setNombre(picture.getOriginalFilename());
		foto.setArchivo(picture.getBytes());
		
		fotoService.insert(foto);
		
		return "redirect:/fotos";
	}
	@GetMapping("/foto/editar/{fotoId}")
	public String editar_GET(Model model,@PathVariable Integer fotoId)
	{
		Foto fotoDb=fotoService.findById(fotoId);
		model.addAttribute("foto",fotoDb);
		
		return "Foto/editar";
	}
	
	@PostMapping("/foto/editar/{fotoId}")
	public String editar_POST(@PathVariable Integer fotoId,@RequestPart("picture") MultipartFile picture) throws IOException 
	{
		Foto foto=new Foto();
		
		foto.setFotoId(fotoId);
		foto.setNombre(picture.getOriginalFilename());
		foto.setArchivo(picture.getBytes());
		
		fotoService.update(foto);
		
		return "redirect:/fotos";
	}
	
	@GetMapping("/foto/borrar/{fotoId}")
	public String borrar_GET(Model model,@PathVariable Integer fotoId)
	{
		Foto fotoDb=fotoService.findById(fotoId);
		model.addAttribute("foto",fotoDb);
		
		return "Foto/borrar";
	}
	
	@RequestMapping(value="/foto/borrar/{fotoId}",method=RequestMethod.POST)
	public String borrar_POST(@PathVariable Integer fotoId)
	{
		fotoService.delete(fotoId);
		return "redirect:/fotos";
	}

}


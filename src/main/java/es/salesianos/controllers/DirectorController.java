package es.salesianos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Director;
import es.salesianos.service.DirectorService;

@Controller
public class DirectorController {
	
	@Autowired
	DirectorService service;
	
	@GetMapping(path = "/director")
	public ModelAndView getDirectors() {
		ModelAndView model = new ModelAndView("director");
		model.addObject("listAllDirectors", service.selectAllDirectors());
		return model;
	}
	
	@PostMapping(path = "/insertDirector")
	public String insertDirectors(@RequestParam String name) {
		Director director = new Director();
		director.setName(name);
		service.insert(director);
		return "index";
	}

	@GetMapping(path = "/deleteDirector")
	public String deleteDirectors(@RequestParam String cod) {
		service.delete(cod);
		return "index";
	}

	

	@PostMapping(path = "/searchActor")
	public ModelAndView searchActors(@RequestParam String name) {
		ModelAndView model = new ModelAndView("searchActors");
		model.addObject("listFilterDirector", service.filterDirectors(name));
		return model;
	}

	@GetMapping(path = "/searchActor")
	public String getsearchActor() {
		return "searchActor";
	}

}

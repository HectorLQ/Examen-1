package es.salesianos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Actor;
import es.salesianos.service.ActorService;

@Controller
public class ActorController {

	@Autowired
	ActorService service;
	
	@GetMapping(path = "/actor")
	public ModelAndView getActors() {
		ModelAndView model = new ModelAndView("actor");
		model.addObject("listAllActors", service.selectAllActors());
		return model;
	}
	

	@PostMapping(path = "/insertActor")
	public String insertActors(@RequestParam String name, @RequestParam Integer year) {
		Actor actor = new Actor();
		actor.setName(name);
		actor.setYear(year);
		service.insert(actor);
		return "index";
	}

	@GetMapping(path = "/filterActor")
	public ModelAndView filterActors(@RequestParam Integer beginDt, @RequestParam Integer endDt) {
		ModelAndView model = new ModelAndView("actor");
		model.addObject("listAllActors", service.filterAllActors(beginDt, endDt));
		return model;
	}
	
	@GetMapping(path = "/deleteActor")
	public String deleteActors(@RequestParam String cod) {
		service.delete(cod);
		return "index";
	}

	@GetMapping(path = "/recoveryFilm")
	public ModelAndView recoveryFilm(@RequestParam Integer cod) {
		ModelAndView model = new ModelAndView("selectActors");
		model.addObject("codFilm", cod);
		model.addObject("listAllActors", service.selectAllActors());
		return model;
	}
}

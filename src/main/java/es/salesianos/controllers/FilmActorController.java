package es.salesianos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.FilmActor;
import es.salesianos.service.FilmActorService;

@Controller
public class FilmActorController {
	
	@Autowired
	FilmActorService service;

	@GetMapping(path = "/fillFilmActor")
	public ModelAndView getPageFillFilmActor(@RequestParam Integer codActor, @RequestParam Integer codFilm) {
		ModelAndView model = new ModelAndView("fillFilmActor");
		model.addObject("codFilm", codFilm);
		model.addObject("codActor", codActor);
		return model;
	}
	

	@PostMapping(path = "/insertFilmActor")
	public String insertActors(@RequestParam Integer codActor, @RequestParam Integer codFilm, @RequestParam String role,
			@RequestParam Integer cache) {
		FilmActor filmActor = new FilmActor();
		filmActor.setCodActor(codActor);
		filmActor.setCodFilm(codFilm);
		filmActor.setCache(cache);
		filmActor.setRole(role);
		service.insert(filmActor);
		return "index";
	}
	
	@PostMapping(path = "/filterCharacter")
	public ModelAndView insertActor(@RequestParam String role) {
		ModelAndView model = new ModelAndView("searchCharacters");
		model.addObject("selectFilmActor", service.filterFilmActors(role));
		return model;
	}


	@GetMapping(path = "/searchCharacters")
	public String getPagesearchCharacter() {
		return "searchCharacters";
	}



}

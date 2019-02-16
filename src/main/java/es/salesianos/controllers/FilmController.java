package es.salesianos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Film;
import es.salesianos.service.FilmService;

@Controller
public class FilmController {
	
	@Autowired
	FilmService service;
	
	@GetMapping(path = "/film")
	public ModelAndView getFilms() {
		ModelAndView model = new ModelAndView("film");
		model.addObject("listAllFilms", service.selectAllFilms());
		return model;
	}
	

	@PostMapping(path = "/insertFilm")
	public String insertFilms(@RequestParam String title) {
		Film film = new Film();
		film.setTitle(title);
		service.insert(film);
		return "index";
	}

	@GetMapping(path = "/deleteFilm")
	public String deleteFilms(@RequestParam String cod) {
		service.delete(cod);
		return "index";
	}


	@GetMapping(path = "/filmActor")
	public ModelAndView getfilmActor() {
		ModelAndView model = new ModelAndView("filmActor");
		model.addObject("listAllFilms", service.selectAllFilms());
		return model;
	}

}

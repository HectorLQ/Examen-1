package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Film;
import es.salesianos.repository.FilmRepository;

public class FilmService {

	private FilmRepository repositoryF = new FilmRepository();

	public List<Film> selectAllFilms() {
		return repositoryF.selectAllFilms();
	}

	public void insert(Film film) {
		repositoryF.insert(film);

	}

	public void delete(String codString) {
		Film film = new Film();
		int cod = Integer.parseInt(codString);
		film.setCod(cod);
		repositoryF.delete(film);
	}
}

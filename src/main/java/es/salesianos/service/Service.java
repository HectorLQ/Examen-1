package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Film;
import es.salesianos.repository.Repository;

public class Service {

	private Repository repository = new Repository();

	public List<Actor> selectAllActor() {
		return repository.selectAllActor();
	}

	public List<Director> selectAllDirector() {
		return repository.selectAllDirector();
	}

	public List<Film> selectAllPelicula() {
		return repository.selectAllPelicula();
	}

	public void insert(Actor actor) {
		repository.insert(actor);

	}

	public void insert(Film film) {
		repository.insert(film);

	}

	public void insert(Director director) {
		repository.insert(director);
	}

	public void delete(Actor actor) {
		repository.delete(actor);

	}

	public void delete(Film pelicula) {
		repository.delete(pelicula);

	}

	public void delete(Director director) {
		repository.delete(director);
	}

}

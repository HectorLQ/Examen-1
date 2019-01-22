package es.salesianos.service;

import es.salesianos.model.DtoActorFilm;
import es.salesianos.model.FilmActor;
import es.salesianos.repository.FilmActorRepository;

public class FilmActorService {

	FilmActorRepository repositoryFA = new FilmActorRepository();

	public DtoActorFilm filterAllFilmActor(String role) {
		return repositoryFA.filterAllFilmActors(role);
	}

	public void insert(FilmActor filmActor) {
		repositoryFA.insert(filmActor);
	}
}

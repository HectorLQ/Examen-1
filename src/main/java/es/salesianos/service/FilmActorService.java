package es.salesianos.service;

import es.salesianos.model.DtoActorFilm;
import es.salesianos.model.FilmActor;
import es.salesianos.repository.FilmActorRepository;

public class FilmActorService {

	FilmActorRepository repositoryFA = new FilmActorRepository();

	public DtoActorFilm filterFilmActors(String role) {
		return repositoryFA.filterFilmActors(role);
	}

	public void insert(FilmActor filmActor) {
		repositoryFA.insert(filmActor);
	}
}

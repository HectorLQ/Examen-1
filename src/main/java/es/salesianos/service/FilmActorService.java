package es.salesianos.service;

import es.salesianos.model.DtoActorFilm;
import es.salesianos.model.FilmActor;
import es.salesianos.repository.FilmActorRepository;

public class FilmActorService {

	FilmActorRepository filmactorRepository = new FilmActorRepository();

	public DtoActorFilm filterFilmActors(String role) {
		return filmactorRepository.filterFilmActors(role);
	}

	public void insert(FilmActor filmActor) {
		filmactorRepository.insert(filmActor);
	}
}

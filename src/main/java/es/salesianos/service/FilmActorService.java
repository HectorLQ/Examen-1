package es.salesianos.service;

import org.springframework.stereotype.Service;

import es.salesianos.model.DtoActorFilm;
import es.salesianos.model.FilmActor;
import es.salesianos.repository.FilmActorRepository;

@Service
public class FilmActorService {

	FilmActorRepository filmactorRepository = new FilmActorRepository();

	public DtoActorFilm filterFilmActors(String role) {
		return filmactorRepository.filterFilmActors(role);
	}

	public void insert(FilmActor filmActor) {
		filmactorRepository.insert(filmActor);
	}
}

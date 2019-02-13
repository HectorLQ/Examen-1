package es.salesianos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.salesianos.model.Actor;
import es.salesianos.repository.ActorRepository;

@Service
public class ActorService {
	
	private ActorRepository actorRepository = new ActorRepository();
	
	public List<Actor> selectAllActors() {
		return actorRepository.selectAllActors();
	}
	
	public void insert(Actor actor) {
		actorRepository.insert(actor);

	}
	
	public void delete(String codString) {
		Actor actor = new Actor();
		int cod = Integer.parseInt(codString);
		actor.setCod(cod);
		actorRepository.delete(actor);

	}

	public List<Actor> filterAllActors(int beginDt, int endDt) {
		return actorRepository.filterAllActors(beginDt, endDt);
	}

}

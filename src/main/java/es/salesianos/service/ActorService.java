package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Actor;
import es.salesianos.repository.ActorRepository;

public class ActorService {
	
	private ActorRepository repositoryA = new ActorRepository();
	
	public List<Actor> selectAllActors() {
		return repositoryA.selectAllActors();
	}
	
	public void insert(Actor actor) {
		repositoryA.insert(actor);

	}
	
	public void delete(String codString) {
		Actor actor = new Actor();
		int cod = Integer.parseInt(codString);
		actor.setCod(cod);
		repositoryA.delete(actor);

	}


}

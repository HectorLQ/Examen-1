package es.salesianos.service;

import java.util.List;

import es.salesianos.model.Director;
import es.salesianos.repository.DirectorRepository;

public class DirectorService {

	private DirectorRepository repositoryD = new DirectorRepository();
	
	public List<Director> selectAllDirectors() {
		return repositoryD.selectAllDirectors();
	}
	
	public void insert(Director director) {
		repositoryD.insert(director);
	}
	
	public void delete(Director director) {
		repositoryD.delete(director);
	}

}

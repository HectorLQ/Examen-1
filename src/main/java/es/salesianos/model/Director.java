package es.salesianos.model;

import java.util.List;

public class Director extends BaseEntity{
	
	private String nombre;
	private List<Film> films; 

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

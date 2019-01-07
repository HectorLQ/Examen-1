package es.salesianos.model;

import java.util.List;

public class Director extends BaseEntity{
	
	private String nombre;
	private List<Pelicula> films; 

	public List<Pelicula> getFilms() {
		return films;
	}

	public void setFilms(List<Pelicula> films) {
		this.films = films;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

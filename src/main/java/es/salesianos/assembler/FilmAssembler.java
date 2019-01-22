package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Film;

public class FilmAssembler {

	public static Film assembleFilmFromReq(HttpServletRequest req) {
		Film film = new Film();
		String title = req.getParameter("title");
		String codString = req.getParameter("cod");
		if (codString != null) {
			int cod = Integer.parseInt(codString);
			film.setCod(cod);
		}
		film.setTitle(title);
		return film;
	}

}

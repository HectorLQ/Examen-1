package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.assembler.FilmAssembler;
import es.salesianos.model.Film;
import es.salesianos.service.Service;

public class PeliculaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Film film = FilmAssembler.assembleFilmFrom(req);
		service.insert(film);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codString = req.getParameter("cod");

		if (null != codString) {
			Film pelicula = FilmAssembler.assembleFilmFrom(req);
			service.delete(pelicula);
		}
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		List<Film> selectAllPelicula = service.selectAllPelicula();
		req.setAttribute("listAllPeliculas", selectAllPelicula);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pelicula.jsp");
		dispatcher.forward(req, resp);
	}
}

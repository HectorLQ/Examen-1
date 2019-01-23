package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.assembler.FilmAssembler;
import es.salesianos.model.Actor;
import es.salesianos.model.Film;
import es.salesianos.service.ActorService;
import es.salesianos.service.FilmService;

public class LinkFilmServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	 private FilmService filmService = new FilmService();
	 private ActorService actorService = new ActorService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Film film = FilmAssembler.assembleFilmFromReq(req);
		filmService.insert(film);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cod = req.getParameter("cod");
		req.setAttribute("codFilm", cod);
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Actor> listAllActors = actorService.selectAllActors();
		req.setAttribute("listAllActors", listAllActors);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/selectActors.jsp");
		dispatcher.forward(req, resp);
	}
}

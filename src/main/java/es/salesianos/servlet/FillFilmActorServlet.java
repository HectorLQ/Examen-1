package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.assembler.FilmActorAssembler;
import es.salesianos.model.FilmActor;
import es.salesianos.service.FilmActorService;

public class FillFilmActorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private FilmActorService service = new FilmActorService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FilmActor filmActor = FilmActorAssembler.assembleFilmActorFromReq(req);
		service.insert(filmActor);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codActor = req.getParameter("codActor");
		String codFilm = req.getParameter("codFilm");
		req.setAttribute("codActor", codActor);
		req.setAttribute("codFilm", codFilm);
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/fillFilmActor.jsp");
		dispatcher.forward(req, resp);
	}
}

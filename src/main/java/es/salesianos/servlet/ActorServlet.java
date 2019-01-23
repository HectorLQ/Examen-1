package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.assembler.ActorAssembler;
import es.salesianos.model.Actor;
import es.salesianos.service.ActorService;

public class ActorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ActorService service = new ActorService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Actor actor = ActorAssembler.assembleActorFromReq(req);
		service.insert(actor);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cod = req.getParameter("cod");
		if (cod != null) {
			service.delete(cod);
		}
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String beginDateString = req.getParameter("beginDt");
		if (beginDateString != null) {
			int beginDt = Integer.parseInt(req.getParameter("beginDt"));
			int endDt = Integer.parseInt(req.getParameter("endDt"));
			List<Actor> listAllActors = service.filterAllActors(beginDt, endDt);
			req.setAttribute("listAllActors", listAllActors);
		}
		List<Actor> listAllActors = service.selectAllActors();
		req.setAttribute("listAllActors", listAllActors);
		redirect(req, resp);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/actor.jsp");
		dispatcher.forward(req, resp);
	}
}

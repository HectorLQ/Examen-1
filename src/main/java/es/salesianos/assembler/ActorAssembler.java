package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;

public class ActorAssembler {
	
	public static Actor assembleActorFromReq(HttpServletRequest req) {
		Actor actor = new Actor();
		String name = req.getParameter("name");
		actor.setName(name);
		String year = req.getParameter("year");
		if(null != year) {
			actor.setYear(Integer.parseInt(year));
		}
		return actor;
	}

}

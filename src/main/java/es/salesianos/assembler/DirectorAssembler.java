package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Director;

public class DirectorAssembler {
	
	public static Director assembleDirectorFromReq(HttpServletRequest req) {
		Director director = new Director();
		String name = req.getParameter("name");
		director.setName(name);
		String codDirector = req.getParameter("cod");
		if (null != codDirector) {
			director.setCod(Integer.parseInt(codDirector));
		}
		return director;
	}

}

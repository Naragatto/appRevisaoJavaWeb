package br.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.DAO.usuarioDAO;

public class alterarUsuario implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		String pagina = "/WEB-INF/jsp/principal.jsp";
		
		
		return pagina;
	}
}

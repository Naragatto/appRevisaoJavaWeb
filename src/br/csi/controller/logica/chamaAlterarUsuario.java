package br.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.DAO.usuarioDAO;

public class chamaAlterarUsuario implements Logica{
	
	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) throws Exception {

		String pagina = "/WEB-INF/jsp/alterarUsuario.jsp";
		
		usuarioDAO uD = new usuarioDAO();

		rq.getSession().setAttribute("usuario", uD.getUsuarioById(Integer.valueOf(rq.getParameter("id"))));
		
		return pagina;
		
	}

}

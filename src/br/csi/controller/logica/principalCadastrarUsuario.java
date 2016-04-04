package br.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.DAO.usuarioDAO;

public class principalCadastrarUsuario implements Logica{
	
	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		
		String pagina = "/WEB-INF/jsp/cadastraUsuario.jsp";
		
		usuarioDAO uD = new usuarioDAO();

		rq.getSession().setAttribute("usuarios", uD.getUsuarios());
		return pagina;
	}
}

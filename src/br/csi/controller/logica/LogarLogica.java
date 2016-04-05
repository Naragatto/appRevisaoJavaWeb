package br.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.usuario;
import br.csi.model.DAO.usuarioDAO;

public class LogarLogica implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		String pagina = "/index.jsp";
		
		String login = rq.getParameter("login");
		String senha = rq.getParameter("senha");		

		usuario u = new usuario();

		u.setUsuario(login);
		u.setSenha(senha);
		
		
		usuarioDAO uD = new usuarioDAO();
		
		boolean logado = uD.autenticado(u);
		
		if(logado){
			pagina = "/WEB-INF/jsp/principal.jsp";
			rq.getSession().setAttribute("usuarioLogado", u);
		}
		
		return pagina;
	}
	
}

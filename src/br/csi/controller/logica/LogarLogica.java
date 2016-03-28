package br.csi.controller.logica;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.usuario;
import br.csi.model.DAO.usuarioDAO;

public class LogarLogica implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		String pagina = "/WEB-INF/index.jsp";
		
		String login = rq.getParameter("login");
		String senha = rq.getParameter("senha");		

		usuario u = new usuario();
		
		u.setUsuario(login);
		u.setSenha(senha);
		
		usuarioDAO uD = new usuarioDAO();
		RequestDispatcher rd;
		
		boolean retorno = uD.autenticado(u);
		
		if(retorno){
			pagina = "/WEB-INF/jsp/principal.jsp";
			rq.getSession().setAttribute("user", u);
		}
		
		return pagina;
	}
	
}

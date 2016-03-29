package br.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class principalCadastrarUsuario implements Logica{
	
	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) throws Exception {
		
		String pagina = "/WEB-INF/jsp/cadastraUsuario.jsp";

		return pagina;
	}

}

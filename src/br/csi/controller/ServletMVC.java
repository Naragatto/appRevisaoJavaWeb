package br.csi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.controller.logica.Logica;

/**
 * Servlet implementation class ServletMVC
 */
@WebServlet(name = "mvc", urlPatterns = { "/mvc" })
public class ServletMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()


     */
    public ServletMVC() {
        super();
    }
    
    
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
    
    
    
    
    
    
	protected void service(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		String log = rq.getParameter("logica");
		String nomeDaclasse = "br.csi.controller.logica."+log;
		
		try{
			Class<?> classe = Class.forName(nomeDaclasse);
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(rq, rp);
			rq.getRequestDispatcher(pagina).forward(rq, rp);
		}catch(Exception e){
			throw new ServletException("Logica causou uma excecao", e);
		}
		
		
		
	}

	
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

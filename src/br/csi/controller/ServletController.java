package br.csi.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import br.csi.model.usuario;
import br.csi.model.DAO.usuarioDAO;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/servletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcao = request.getParameter("opcao");

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		usuario u = new usuario();
		
		u.setUsuario(login);
		u.setSenha(senha);
		
		usuarioDAO uD = new usuarioDAO();
		RequestDispatcher rd;
		if(opcao.equals("LOGAR")){
			try {
				boolean retorno = uD.autenticado(u);
				if(retorno){
					request.getSession().setAttribute("user", u);
					String pagina = "/WEB-INF/jsp/principal.jsp";
					rd = getServletContext().getRequestDispatcher(pagina);
					rd.forward(request, response);
				}else{
					String pagina = "/index.jsp";
					rd = getServletContext().getRequestDispatcher(pagina);
					rd.forward(request, response);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				String pagina = "/index.jsp";
				rd = getServletContext().getRequestDispatcher(pagina);
				rd.forward(request, response);
			}			
			
		}
		
		if(opcao.equals("cadastrarUsuario")){
			request.getSession().setAttribute("user", u);
			String pagina = "/WEB-INF/jsp/cadastraUsuario.jsp";
			rd = getServletContext().getRequestDispatcher(pagina);
			rd.forward(request, response);			
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

package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

/*	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String parametro = request.getParameter("logica");	
		String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro;
		String acao = request.getParameter("acao");	

		
		try {
			
			Class classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			
			String Pagina = "Ação não encontrada";
			
			switch (acao) {
			case "remove":
				Pagina = logica.Delete(request, response);
				break;

			default:
				Pagina = logica.Executa(request, response);
			}
			
			
			
			request.getRequestDispatcher(Pagina).forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException("A lógica de negócio causou uma exceção",e);
		}
	}
}

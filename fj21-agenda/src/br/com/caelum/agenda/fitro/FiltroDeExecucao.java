package br.com.caelum.agenda.fitro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.agenda.ConnectionFactory;

@WebFilter("/*")
public class FiltroDeExecucao implements Filter {


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		
		 		
		try {	
			long tempoInicial = System.currentTimeMillis();
		
			Connection connection = new ConnectionFactory().getConnection();
			
			request.setAttribute("connection", connection);
			
			chain.doFilter(request, response);
			
			long tempoFinal = System.currentTimeMillis();
			
			connection.close();
			
			String uri = ((HttpServletRequest)request).getRequestURI();
			String parametros = ((HttpServletRequest)request).getParameter("logica");
			
			System.out.println("Tempo da requisicao de " + uri + "logica=" + parametros + " demorou (ms) " + (tempoFinal - tempoInicial));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		finally {
			
		}
	}
}

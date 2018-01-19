package br.com.caelum.tarefas.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	private List<String> uriWhileList =  new ArrayList<String>(){{
	    add("loginForm");
	    add("efetuaLogin");
	    add("resources/");
	}};
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response
			, Object controller) throws Exception {
		
		
		String uri = request.getRequestURI();
		
		//Verifica na lista de urls liberadas
		if (whiteListVerify(uri))
			return true;
		
		//Verifica usuario logado
		if (request.getSession().getAttribute("usuarioLogado") != null)
			return true;
		
		
		response.sendRedirect("loginForm");
		return false;
	}
	
	private boolean whiteListVerify(String uri) {

		//Verifica se tem conteudo na uri
		if (uri == null || uri.trim()=="" )
			return false;
		
		for(String item : uriWhileList)
			if (uri.contains(item))
				return true;
		
		return false;
	}
}

package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class PrimeiraLogica implements Logica {

	@Override
	public String Executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Executando logica");	
		System.out.println("Retornando o nome da página JSP");
		
		return "primeira-logica.jsp";
	}

	@Override
	public String Find(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String id = request.getParameter("id");
		
		ContatoDao dao = new ContatoDao( (Connection) request.getAttribute("connection"));
		
		dao.exclui(Integer.parseInt(id));
		
		return "";
	}

	@Override
	public String Save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String endereco = request.getParameter("endereco");
			
			String datanascimento = request.getParameter("datanascimento");
			Date dtNascimento;
	
			dtNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(datanascimento);
			
			Calendar data = Calendar.getInstance();
			data.setTime(dtNascimento);

			Contato cto = new Contato();
			cto.setNome(nome);
			cto.setDataNascimento(data);
			cto.setEmail(email);
			cto.setEndereco(endereco);
			
			ContatoDao dao = new ContatoDao( (Connection) request.getAttribute("connection"));
			
			dao.adiciona(cto);
		
			return "";
	}

	@Override
	public String Delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		
		ContatoDao dao = new ContatoDao( (Connection) request.getAttribute("connection"));
		
		dao.exclui(Integer.parseInt(id));
		
		return "";
	}

	@Override
	public String List(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

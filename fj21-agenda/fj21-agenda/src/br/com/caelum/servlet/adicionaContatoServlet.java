package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;
import br.com.caelum.apoio.ResponseHeader;

@WebServlet(urlPatterns="/adicionacontato")
public class adicionaContatoServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = resp.getWriter();
		
		try {
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			String endereco = req.getParameter("endereco");
			
			String datanascimento = req.getParameter("datanascimento");
			Date dtNascimento;
	
			dtNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(datanascimento);
			
			Calendar data = Calendar.getInstance();
			data.setTime(dtNascimento);

			Contato cto = new Contato();
			cto.setNome(nome);
			cto.setDataNascimento(data);
			cto.setEmail(email);
			cto.setEndereco(endereco);
			
			ContatoDao dao = new ContatoDao();
			
			dao.adiciona(cto);
			

			out.println(ResponseHeader.htmlHeader());
			out.println("<div class='ui positive message'>Contato Cadastrado com Sucesso</div>");
			out.println("</br></body></html>");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			out.println(ResponseHeader.htmlHeader());
			out.println("<div class='ui negative message'>Erro: " + e.toString()  +  "</div>");
			out.println("</br></body></html>");
		}
		
	}

}

package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/HoraAtual2")
public class HoraAtual2 extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8246840522855066521L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		out.println("<html><body> Hora atual 2...:" + new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTimeInMillis()) + "</body></html>");
	
	}
	
}

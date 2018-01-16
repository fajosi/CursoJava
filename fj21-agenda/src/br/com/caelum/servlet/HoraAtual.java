package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HoraAtual extends HttpServlet {
	
	@Override 
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		PrintWriter out = resp.getWriter();
		out.println("<html><body>" + new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTimeInMillis()) + "</body></html>");
	}

}

package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	String Executa(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String Find(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String Save(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String Delete(HttpServletRequest request, HttpServletResponse response) throws Exception;
	String List(HttpServletRequest request, HttpServletResponse response) throws Exception;
}

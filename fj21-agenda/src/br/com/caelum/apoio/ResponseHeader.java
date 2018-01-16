package br.com.caelum.apoio;

public class ResponseHeader {
	
	public static String htmlHeader() {
		
		StringBuilder str = new StringBuilder();
		
		str.append("<!DOCTYPE html>");
		str.append("<html>");
		str.append("	<head>");
		str.append("		<meta charset='UTF-8'>");
		str.append("		<title>Projeto fj21-agenda</title>");
				
		str.append("		  <link rel='stylesheet' type='text/css' href='./CDN/dist/semantic.css'>");
		


		str.append("		  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.js'></script>");
		str.append("		  <script src='./CDN/dist/semantic.js'></script>");
		str.append("	</head>");
		str.append("	<body style=''>");

		//str.append("		<div class='ui inverted menu'>");
		//str.append("			<a class='active item' href='../index.html'>Home</a>");
		//str.append("			<a class='item'>Contatos</a>");
		//str.append("			<a class='item'>Telefones Públicos</a>");
		//str.append("		</div>");
		str.append("		<br/>");
		
		return str.toString();
		
	}

}

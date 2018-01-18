<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="br.com.caelum.agenda.dao.*" %>
<%@ page import="br.com.caelum.agenda.modelo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Projeto fj21-agenda</title>
		
		<link rel="stylesheet" type="text/css" href="../CDN/dist/semantic.css">
		<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.js"></script>
		<script src="../CDN/dist/semantic.js"></script>
		
		<script>
			  $( function() {
				  $( "#divMainMenu" ).load( "../apoio/menu.html" );
			  } );
  		</script>	
	</head>
	<body>

		<div id="divMainMenu"></div>


		<br/>

		<h1 style="margin: 0px 0px 0px 25px;">Lista de Contatos</h1>


		<table class="ui celled table" style="margin: 0px 0px 0px 25px; width:70%;">
			<thead>
		    	<tr>
				    <th>Nome</th>
				    <th>E-mail</th>
				    <th>Endereço</th>
				    <th>Data Nascimento</th>
				    <th></th>
				</tr>
			</thead>
			<tbody>
			<%
				ContatoDao dao = new ContatoDao();
				List<Contato> contatos = dao.getLista();
				
				for (Contato contato: contatos) {
			
			%>
			    <tr>
			    	<td><%= contato.getNome() %></td>
			    	<td><%= contato.getEmail() %></td>
			    	<td><%= contato.getEndereco() %></td>
			    	<td><%= contato.getDataNascimento().getTimeInMillis() %></td>
			    	<td>
			    		<a><i class="edit icon"></i></a>
			    		<a onclick=""><i class="remove icon"></i></a>
			    	</td>
			    </tr>
		    <% 
		    } 
		    %>
			</tbody>
		</table>
		<br/>
		<a class="ui secondary button" href="adiciona.html"  style="margin: 0px 0px 0px 25px;">Adicionar Contato</a>

		
	</body>
</html>
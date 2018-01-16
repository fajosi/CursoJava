<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.caelum.agenda.dao.FuncionarioDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>Projeto fj21-agenda</title>
		
		<link rel="stylesheet" type="text/css" href="../CDN/dist/semantic.css">
		<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.js"></script>
		<script src="../CDN/dist/semantic.js"></script>
	
		  
		<script>
			  $( function() {
				  $( "#divMainMenu" ).load( "/fj21-agenda/apoio/menu.html" );
			  } );
  		</script>		
	</head>
	<body>

		<div id="divMainMenu"></div>


		<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.FuncionarioDao"/>
		
		<table class="ui celled table" style="margin: 0px 0px 0px 25px; width:70%;">
			<thead>
		    	<tr>
				    <th>id</th>
				    <th>Nome</th>
				    <th>Usuário</th>
				    <th>Senha</th>
				    <th></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="funcionario" items="${dao.lista}">
			    <tr>
			    	<td>${funcionario.id }</td>
			    	<td>${funcionario.nome }</td>
			    	<td>${funcionario.usuario }</td>
			    	<td>${funcionario.senha }</td>

			    	<td>
			    		<a><i class="edit icon"></i></a>
			    		<a onclick=""><i class="remove icon"></i></a>
			    	</td>
			    </tr>				
				
				</c:forEach>
			</tbody>
		</table>
		<br/>
		<a class="ui secondary button" href="adiciona.html"  style="margin: 0px 0px 0px 25px;">Funcionario Contato</a>

		
</body>
</html>
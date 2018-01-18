<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
	<c:import url="/apoio/header.html"></c:import>
	<script>
		  $( function() {

		  } );
 		</script>	
</head>
<body>
		<c:import url="/apoio/menu.html" charEncoding="UTF-8"></c:import>

		<div id="divBody">
			<h1>Lista de Contatos</h1>
			<table class="ui celled table" style="width:70%;">
				<thead>
			    	<tr>
			    		<th>Id</th>
					    <th>Nome</th>
					    <th>E-mail</th>
					    <th>Endereço</th>
					    <th>Data Nascimento</th>
					    <th></th>
					</tr>
				</thead>
				<tbody>
					<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDaoEx1" />
					<c:forEach var="contato" items="${dao.lista}">
						<tr>
							<td>${contato.id }</td>
							<td>${contato.nome }</td>
							<td>
								<c:if test="${not empty contato.email }">
								 <a href="${contato.email }">	${contato.email }</a>
								</c:if>
								<c:if test="${empty contato.email }">
									e-mail não informado
								</c:if>
							</td>
							<td>${contato.endereco }</td>
							<td>
								<fmt:formatDate pattern="dd/MM/yyyy" value="${contato.dataNascimento.time }" />
							</td>
							<td>
								<a><i class="edit icon"></i></a>
				    			<a href="/fj21-agenda/mvc?logica=PrimeiraLogica&acao=remove&id=${contato.id}"><i class="remove icon"></i></a>
							</td>
						</tr>				
					</c:forEach>
					
	
				</tbody>
			</table>
			
			<br/>
			<a class="ui secondary button" href="adiciona.jsp">Adicionar Contato</a>	
	</div>
</body>
</html>
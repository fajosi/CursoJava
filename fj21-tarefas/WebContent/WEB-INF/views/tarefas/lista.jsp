<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tgl" tagdir="/WEB-INF/tags"  %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<tgl:html_header_config></tgl:html_header_config>
	
	<script type="text/javascript">
	
		$(function(){
			Inicializa();	    
		});
		
		function finalizarAgora(id) {
			
			
			var url = "finalizaTarefa?id=" + id;
			var objId = "#tarefa" + id;

			$.get(url, function() {
				$(objId).prop('checked', true);
			});

		}	
		
		function finalizarAgoraPost(id) {

			var objId = "#tarefa" + id;

			$.post("finalizaTarefa", {'id': id },  function() {
				$(objId).prop('checked',  true);
			}); 
		}
		
		function finalizarAgoraPostAndModel(id) {
			alert(3);
			var objId = "#tarefa" + id;

			$.post("finalizaTarefaModel", {'id': id },  function(resposta) {
				$(objId).prop('checked',  true);
				alert(resposta);
			}); 
		}
	</script>
	
	
</head>
<body>
	<tgl:html_mainMenu></tgl:html_mainMenu>
	
	<div id="divBody">
		
		<h1>Lista de Tarefas</h1>
		
		<table  class="ui celled striped table" style="width:70%">
			<thead>
				<th>Id</th>
				<th>Descrição</th>
				<th>Finalizada</th>
				<th>Data Criação</th>
				<th>Ação</th>
			</thead>
			<tbody>
				<c:forEach var="tarefa" items="${tarefas}">
					<tr>
					<td>${tarefa.id}</td>
					<td>${tarefa.descricao}</td>
					<td>
							<div class="ui readonly checkbox"> 
								<c:if test="${tarefa.finalizado eq false}">
	  								<input id="tarefa${tarefa.id}" type="checkbox">
	  							</c:if>
	  							<c:if test="${tarefa.finalizado eq true}">
	  								<input id="tarefa${tarefa.id}" type="checkbox" checked>
	  							</c:if>
	  							<label></label>
	  						</div>
  					
  					</td>
					<td id="tarefadata${tarefa.id }">
						<fmt:formatDate pattern="dd/MM/yyyy" value="${tarefa.dataFinalizacao.time }"/>
					 </td>
					<td>
						
						<a href="removeTarefa?id=${tarefa.id }"><i class="remove icon" ></i></a>
						<a href="#" onclick="finalizarAgoraPostAndModel(${tarefa.id });">
						<i class="checkmark box icon" ></i>
						</a>

					</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="tarefa" class="ui secondary button">Nova tarefa</a>
	</div>
	

	<script>

	</script>
</body>
</html>
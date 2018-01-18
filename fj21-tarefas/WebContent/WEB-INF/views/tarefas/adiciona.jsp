<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	</script>
</head>
<body>
	<tgl:html_mainMenu></tgl:html_mainMenu>
	
	<div id="divBody">
		
		<h1>Adiciona Tarefa</h1>
	
		<div class="ui form">
			
			<form action="adicionaTarefa" method="post">
	
				<div class="field">
					<label>Descrição</label>
					<textarea name="descricao" rows="5" cols="100"></textarea>

  						<p >
							<f:errors path="tarefa.descricao" class="ui message"></f:errors>
						</p>

				</div>
				<input class="ui button" type="submit" value="Adiciona">
			</form>
		</div>
	</div>
</body>
</html>


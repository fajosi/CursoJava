<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tgl" %>
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
		<h1>Bem vindos, ${usuarioLogado.login} a aplicação Tarefas</h1>
	</div>
</body>
</html>
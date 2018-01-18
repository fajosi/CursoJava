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
			O contato ${contato.nome } foi adicionado com sucesso.
		</div>

</body>
</html>
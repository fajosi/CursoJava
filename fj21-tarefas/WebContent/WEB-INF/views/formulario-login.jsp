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
	</script>
</head>
<body>
	<tgl:html_mainMenu></tgl:html_mainMenu>
	
	<div id="divBody">
	
		<div class="ui middle aligned center aligned grid">
			<div class="column">
			    <h2 class="ui teal image header">
			      <div class="content">Efeutue a Autenticação</div>
			    </h2>
			    <form class="ui large form" action="efetuaLogin" method="post">
			      <div class="ui stacked segment">
			        <div class="field">
			          <div class="ui left icon input">
			            <i class="user icon"></i>
			            <input type="text" name="login" placeholder="login">
			          </div>
			        </div>
			        <div class="field">
			          <div class="ui left icon input">
			            <i class="lock icon"></i>
			            <input type="password" name="senha" placeholder="Password">
			          </div>
			        </div>

						<input type="submit" value="Enviar" class="ui fluid large teal submit button">

			      </div>
			
			      <div class="ui error message"></div>
			
			    </form>
			
			    <div class="ui message">
			      New to us? <a href="#">Sign Up</a>
			    </div>
			  </div>
		</div>
		
		
	</div>
</body>
</html>
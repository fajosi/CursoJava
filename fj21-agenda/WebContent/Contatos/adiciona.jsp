<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tgl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:import url="/apoio/header.html"></c:import>
	
	<script type="text/javascript">
		$.validator.setDefaults( {
			submitHandler: function () {
				alert( "submitted!" );
			}
		} );

		$( document ).ready( function () {
			$( "#contatoForm" ).validate( {
				rules: {
					nome: "required",
					lastname: "required",
					username: {
						required: true,
						minlength: 2
					},
					password: {
						required: true,
						minlength: 5
					},
					confirm_password: {
						required: true,
						minlength: 5,
						equalTo: "#password"
					},
					email: {
						required: true,
						email: true
					},
					agree: "required"
				},
				messages: {
					firstname: "Please enter your firstname",
					lastname: "Please enter your lastname",
					username: {
						required: "Please enter a username",
						minlength: "Your username must consist of at least 2 characters"
					},
					password: {
						required: "Please provide a password",
						minlength: "Your password must be at least 5 characters long"
					},
					confirm_password: {
						required: "Please provide a password",
						minlength: "Your password must be at least 5 characters long",
						equalTo: "Please enter the same password as above"
					},
					email: "Please enter a valid email address",
					agree: "Please accept our policy"
				},
				errorPlacement: function ( error, element ) {
					error.addClass( "ui red pointing label transition" );
					error.insertAfter( element.parent() );
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".row" ).addClass( errorClass );
				},
				unhighlight: function (element, errorClass, validClass) {
					$( element ).parents( ".row" ).removeClass( errorClass );
				}
			} );
		} );
	</script>
</head>
<body>
	<c:import url="/apoio/menu.html" charEncoding="UTF-8"></c:import>
	<div id="divBody">
		<h1> Adiciona novo Contato</h1>
		<form id="contatoForm" action="../adicionacontato" class="ui form" style="width:70%;">
			<div class="field">
				<label>Nome Completo</label>
				<input type="text" name="nome" placeholder="nome">
			</div>
			<div class="field">
				<label>E-mail</label>
				<input type="text" name="email" placeholder="email@provedor.com">
			</div>
			<div class="field">
				<label>Endereço</label>
				<input type="text" name="endereco" placeholder="endereco">
			</div>
			<div class="field">
				<label>Data de Nascimento</label>
				<tgl:cpData id="datanascimento"></tgl:cpData>
				<!--  
					<input type="text" id="datepicker" name="datanascimento" placeholder="datanascimento">
				-->
			</div>			
			<button class="ui primary submit button" type="submit">Salvar</button>
			<a class="ui button" href="main.jsp">Voltar a Lista</a>
		</form>
		
	</div>
</body>
</html>
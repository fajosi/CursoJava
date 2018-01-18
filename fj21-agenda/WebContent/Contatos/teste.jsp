  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Validando formul�rios com JQuery Validation</title>
  <!-- Inclus�o do jQuery-->
  <script src="http://code.jquery.com/jquery-1.11.1.js"></script>
  <!-- Inclus�o do Plugin jQuery Validation-->
  <script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
  
  <script>
  $("#formComentario").validate();
  </script>
  </head>
  <body>
   
  <form id="formComentario" method="post" action="">
    <fieldset>
      <legend>Por favor preencha o nome, e-mail e coment�rio</legend>
      <p>
        <label for="cnome">Nome (obrigat�rio, pelo menos 2 caracteres)</label>
        <input type="text" id="cnome" name="nome" required minlength="2">
      </p>
      <p>
        <label for="cemail">E-mail (obrigat�rio)</label> 
        <input type="email" id="cemail" name="email" required >
      </p>
      <p>
        <label for="ccomentario">Seu coment�rio (obrigat�rio)</label>
        <textarea id="ccomentario" name="comentario" required ></textarea>
      </p>
      <p>
        <input type="submit" value="Enviar">
      </p>
    </fieldset>
  </form>
  <!-- Inclus�o das valida��es com o Plugin jQuery Validation-->

  </body>
  </html> 
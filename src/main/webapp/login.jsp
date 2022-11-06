<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login Page</title>
	<link rel="icon" href="./assets/images/chat.png" />
	<link rel="stylesheet" href="./assets/styles/login_page.css">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" defer></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" defer></script>
</head>
<body>
	<div class="container">
		<form class="bg-white rounded shadow-5-strong p-5" id="login-form" method="post" action="startServer">
			<h4 class="text-center mb-2">Escolha seu nome de usuário</h4>
			<!-- Email input -->
			<div class="form-outline mb-2 mt-4">
			  <label class="form-label" for="login_username">Nome de Usuário</label>
			  <input type="text" name="username" id="login_username" class="form-control" />
			</div>
			
			<!-- Password input -->
			<div class="form-outline mb-4">
			  <label class="form-label" for="login_pw">Senha</label>
			  <input type="password" id="login_pw" name="password" class="form-control" placeholder="Autenticação em construção" disabled/ >
			</div>
			
			<!-- Submit button -->
			<button type="submit" class="btn btn-success btn-block text-center">Entrar</button>
		</form>
	</div>
</body>
</html>


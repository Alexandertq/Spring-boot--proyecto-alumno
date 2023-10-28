<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
body {
    font-family: Arial, sans-serif;
    background-image: url(https://fondosmil.com/fondo/17553.jpg);
    
  }
div {
  text-align: center;
  margin-top: 50px;
}

/* Style the heading */
h3 {
  color: #FFFFFF;
}

/* Style the form container */
form {
  border: 1px solid #ddd;
  padding: 20px;
  max-width: 400px;
  margin: 0 auto;
}

/* Style the b tags */
b {
  font-weight: bold;
}

 .container {
    max-width: 450px;
    margin: 0 auto;
    padding: 20px;
    background-color: #FFFFFF80;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
  }



/* Style the buttons */
form button {
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-right: 10px;
}

/* Style the button to be different from the others */
form button[name="btnVolver"] {
  background-color: #dc3545;
}
</style>

<body>

	<div class="container">
		<form name="" method="post">
			<h3>¡Curso - Detalle!</h3>
		
			<b>Curso ID:</b> ${curso.cursoId} <br>
			<b>Curso:</b> ${curso.nombre} <br>
			<b>Fecha de Inicio:</b> ${curso.finicio} <br>
			<b>Finaliza:</b> ${curso.ffin} <br>



			
			<button type="submit" name="btnInicio">Inicio</button>
			<button type="submit" name="btnVolver">Volver</button> 
		</form>
	</div>


</body>
</html>
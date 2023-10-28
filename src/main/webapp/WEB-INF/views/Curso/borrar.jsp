<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

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

  .container {
    max-width: 450px;
    margin: 0 auto;
    padding: 20px;
    background-color: #FFFFFF80;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
  }
/* Style the heading */
h3 {
  color: #333;
}

/* Style the form container */
form {
  border: 1px solid #ddd;
  padding: 30px;
  max-width: 400px;
  margin: 0 auto;
}

/* Style the form inputs */
form input[type="text"]{
  width: 100%;
  padding: 5px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

/* Style the buttons */
form button {
  padding: 10px 20px;
  background-color: #008000;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-right: 10px;
}

/* Style the Cancel button */
form button[type="button"] {
  background-color: #FF0000;
}
</style>

<body>

	<div class="container">
		<h3>�Curso - Borrar!</h3>
		
		<!-- Formulario Spring -->
		<form:form name="" method="post" modelAttribute="curso">
			Curso ID:<form:input type="text" path="cursoId" readonly="true"/> <br>
			Curso: <form:input type="text" path="nombre" readonly="true" /> <br>


			
			<button type="submit">Si, borrar</button>
			<button type="button" onclick="location.href='/alex/curso'">Cancelar</button>
		</form:form>
	</div>

</body>
</html>
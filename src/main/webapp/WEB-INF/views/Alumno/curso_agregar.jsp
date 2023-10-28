<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<script type="text/javascript">
		function agregarJS(cursoId,alumnoId) {
			location.href="/alex/alumno_curso/agregar/"+cursoId+"/"+alumnoId;
		}
	</script>

</head>
<style>

 body {
  font-family: Arial, Helvetica, sans-serif;
  background-image: url(https://fondosmil.com/fondo/17553.jpg);
  margin: 0;
  padding: 0;
}

.container {
  width: 25%;
  margin: 0 auto;
  background-color: #FFFFFF80;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

h3 {
  color: #333;
  text-align: center;
}

img {
  display: block;
  margin: 0 auto;
  border: 1px solid #ccc;
  border-radius: 50%;
}

label {
  font-weight: bold;
}

select {
  padding: 8px;
  width: 100%;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin-top: 5px;
  margin-bottom: 15px;
}

button {
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}

button:hover {
  background-color: #0056b3;
}

table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  padding: 10px;
  text-align: center;
}

th {
  background-color: #f8f8f8;
}

tr:nth-child(even) {
  background-color: #f5f5f5;
}
</style>
<body>
<div class="container">
	<div align="center">
		<h3>¡Alumno - Curso!</h3>
		<img src="data:${alumno.foto.getTypeFot()};base64,${alumno.foto.getBase64Fot()}" 
                             width="75px" height="75px" border="1"/> br
		<form:form name="" method="post" modelAttribute="alumno">
			
			<!-- productoId oculto -->
			<input type="hidden" id="inputAlumnoId" value="${alumno.alumnoId}"/>
			
			<b>Alumno</b>: ${alumno.nombres} ${alumno.apellidos} <br><br>
			
			
			<b>Curso</b>: 
			<select name="" id="selectCursoId">
				<option value="">-- Seleccione --</option>
				<c:forEach var="curso" items="${bcurso1}">
					<option value="${curso.cursoId}">${curso.nombre}</option>
				</c:forEach>
			</select> 
			
			<button type="button" 
			        onclick="agregarJS(document.getElementById('selectCursoId').value,
			        		           document.getElementById('inputAlumnoId').value)">
				Agregar
			</button> 
			<br><br>
			
			<table>
				<tr>
					<td><b>ID</b></td>
					<td><b>Cursos</b></td>
					
				</tr>
				
				<c:forEach var="curso" items="${bcurso2}">
					<tr>
						<td>${curso.cursoId}</td>
						<td>${curso.nombre}</td>
						
					</tr>
				</c:forEach>
			</table> <br>
			
			<button type="submit">Guardar</button>
			<button type="button" onclick="location.href='/alex/listaalumno'">Cancelar</button>
		
		</form:form>
				
	</div>
</div>
</body>
</html>
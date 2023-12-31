<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
    background-color: #FFFFFF80;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
  }
  
    img {
    display: block;
    margin: 0 auto;
    border: 1px solid #ccc;
    border-radius: 50%;
  }
  
  h3 {
    color: #333;
  }
  
  a {
    text-decoration: none;
    color: #B22222;
    transition: color 0.3s;
  }
  
  a:hover {
    color: #2980b9;
    
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
    background-color: #F0FFFF80;
  }
  
  .action-buttons a {
    display: inline-block;
    margin-right: 5px;
    padding: 5px 10px;
    background-color: #3498db;
    color: #fff;
    text-align: center;
    border-radius: 5px;
    transition: background-color 0.3s;
  }
  
  .action-buttons a:hover {
    background-color: #FFFFFF;
  }
  
</style>

<body>


	<div class="container" >
		<h3>¡Alumno - Listar!</h3>
	
		 <a href="/alex/inicio">Inicio</a> |
		<a href="/alex/listaalumno/registrar">Registrar</a>
		<br><br>
		
		<table>
			<tr>
				<td align="center"><b>ID</b></td>
				<td align="center"><b>Foto</b></td>
				<td align="center"><b>Nombres</b></td>
				<td align="center"><b>Apellidos</b></td>
				<td align="center"><b>F-Nacimiento</b></td>
				<td align="center"><b>email</b></td>
				<td align="center"><b>Telefono</b></td>	
				<td align="center"><b>Universidad</b></td>
				<td align="center"><b>Accion</b></td>
			</tr>
			
			<c:forEach var="alumno" items="${balumno}">
				<tr>
					<td>${alumno.alumnoId}  </td>
					<td>
                        <img src="data:${alumno.foto.getTypeFot()};base64,${alumno.foto.getBase64Fot()}" 
                             width="75px" height="75px" border="1"/>
                    </td>
					<td>${alumno.nombres}     </td>
					<td>${alumno.apellidos}   </td>
					<td>${alumno.fnacimiento} </td>
					<td>${alumno.email}       </td>
					<td>${alumno.telefono}    </td>
					
					<td>${alumno.universidad.nombre}</td>

					<td>
						<a href="/alex/listaalumno/detalle/${alumno.alumnoId}">Detalle</a> |
						<a href="/alex/listaalumno/editar/${alumno.alumnoId}">Editar</a> |
						<a href="/alex/listaalumno/borrar/${alumno.alumnoId}">Borrar</a> |
						<a href="/alex/listaalumno/curso_agregar/${alumno.alumnoId}">Cursos</a> 						
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
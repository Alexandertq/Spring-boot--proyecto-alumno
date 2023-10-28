<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
    max-width: 950px;
    margin: 0 auto;
    padding: 20px;
    background-color: #FFFFFF80;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
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
		<h3>¡Universidad - Listar!</h3>
	
		 <a href="/alex/inicio">Inicio</a> |
		<a href="/alex/universidad/registrar">Registrar</a>
		<br><br>
		
		<table>
			<tr>
				<td align="center"><b>ID</b></td>
				<td align="center"><b>Nombres</b></td>
				<td align="center"><b>Telefono</b></td>
				<td align="center"><b>Ubicacion</b></td>
				<td align="center"><b>Website</b></td>
				<td align="center"><b>Accion</b></td>
				
			</tr>
			
			<c:forEach var="universidad" items="${buniversidad}">
				<tr>
					<td>${universidad.universidadId}  </td>
					<td>${universidad.nombre}     </td>
					<td>${universidad.telefono}   </td>
					<td>${universidad.ubicacion} </td>
					<td>${universidad.website} </td>

					<td>
						<a href="/alex/universidad/detalle/${universidad.universidadId}">Detalle</a> |
						<a href="/alex/universidad/editar/${universidad.universidadId}">Editar</a> |
						<a href="/alex/universidad/borrar/${universidad.universidadId}">Borrar</a> 
												
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
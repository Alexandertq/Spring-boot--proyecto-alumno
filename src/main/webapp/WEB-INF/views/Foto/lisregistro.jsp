<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

<style>
  body {
    font-family: Arial, sans-serif;
    background-image: url(https://fondosmil.com/fondo/17553.jpg);



  }
  
  .container {
    max-width: 1100px;
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

</head>
<body>
    <div class="container">
        <div align="center">
            <h3>¡Imagenes - Listar!</h3>
    
            <a href="/alex/inicio">Inicio</a> | 
            <a href="/alex/foto/registrar">Registrar</a>
            <br><br>
    
            <table>
                <!-- encabezado -->
                <tr>
                    <td><b>ID</b></td>
                    <td><b>Nombre</b></td>
                    <td><b>Foto</b></td>
                    <td><b>Acción</b></td>
                </tr>
    
                <!-- filas -->
                <c:forEach var="foto" items="${bfoto}">
                    <tr>
                        <td>${foto.fotoId}</td>
                        <td>${foto.nombre}</td>
                        <td>
                            <img src="data:${foto.getTypeFot()};base64,${foto.getBase64Fot()}" 
                                 width="75px" height="75px" border="1"/>
                        </td>
                        <td>
                            <a href="/alex/foto/editar/${foto.fotoId}">Editar</a> |
                            <a href="/alex/foto/borrar/${foto.fotoId}">Borrar</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
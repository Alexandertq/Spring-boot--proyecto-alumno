<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
/* Apply CSS styling to the centered div */
  .container {
    max-width: 450px;
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
form input[type="text"],
form input[type="date"],
form input[type="email"],
form input[type="number"] {
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

    <div align="center">
        <h3>¡Foto - Borrar!</h3>

        <form name="" method="post" action="/alex/foto/borrar/${foto.fotoId}" enctype="multipart/form-data">
            Foto ID: <input type="text" name="imagenId" value="${foto.fotoId}" readonly="readonly"/> <br><br>

            Foto <br>
            <img src="data:${foto.getTypeFot()};base64,${foto.getBase64Fot()}" width="150px" height="150px" border="1"/> 

            <p>¿Está seguro de borrar?</p>

            <button type="submit">Si, borrar</button>
            <button type="button" onclick="location.href='/alex/fotos'">Cancelar</button>
        </form>
    </div>

</body>
</html>
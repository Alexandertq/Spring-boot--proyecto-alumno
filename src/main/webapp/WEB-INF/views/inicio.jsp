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
  margin: 0;
  font-family: Arial, sans-serif;
  background-image: url(https://img.freepik.com/vector-gratis/fondo-monocromatico-blanco-estilo-papel_52683-66443.jpg?w=2000);
  color: #000000
}

.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

header {
  text-align: center;
  background-color: #f2f2f2;
  padding: 10px 0;
}

header h1 {
  margin: 0;
}

main {
  text-align: center;
  padding: 20px 0;
  
  opacity: .6;
}

img {
  max-width: 100%;
  height: auto;
  border: 1px solid #ddd;
  box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1);
  
}

p {
  margin-top: 20px;
}

footer {
  text-align: center;
  background-color: #f2f2f2;
  padding: 10px 0;
}
</style>

<body>
  <div class="container">
    <header>
      <h1>Bienvenido</h1>
    </header>
    
      <footer>
      <button type="button" onclick="location.href='/alex/listaalumno'">Alumno</button>
      <button type="button" onclick="location.href='/alex/curso'">Curso</button>
      <button type="button" onclick="location.href='/alex/fotos'">Foto</button>
      <button type="button" onclick="location.href='/alex/universidades'">universidad</button>
    </footer>
    <main>

      <img src="https://blog.uchceu.es/campus-life/wp-content/uploads/sites/37/2018/10/giphy-3-1.gif" >
      <p></p>
    </main>

  </div>

</body>
</html>
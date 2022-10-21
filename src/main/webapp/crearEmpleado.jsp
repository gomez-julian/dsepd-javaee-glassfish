<%@ page import="fabrica.organizacion.Organizacion" %>
<%@ page import="modelo.OrganizacionModelo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Java Enterprise Exercises</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="fav.ico"/>
</head>
<body>
<%
    Organizacion organizacion = OrganizacionModelo.organizacion;
    String[] actividades = organizacion.getActvidades();
%>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="ServletGenerar" autocomplete="off" method="post">
            <h1>Contratar varios</h1>
            <input type="number" placeholder="Total empleados" id="cantidad" name="cantidad"/>
            <button>Contratar varios</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="Empleado" autocomplete="off" method="post">
            <h1>Contratar</h1>
            <input type="text" placeholder="Nombre" id="nombre" name="nombre"/>
            <input type="number" placeholder="Salario por hora" id="salario" name="salario"/>
            <select name="actividad">
                <%for(String actividad: actividades) {%>
                <option value="<%=actividad%>"><%=actividad.toUpperCase()%></option>
                <%}%>
            </select>
            <button>Contratar</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Crear varios</h1>
                <p>Ingrese la cantidad de empleados a crear</p>
                <button class="ghost" id="signIn">Nuevo empleado</button>
                <a href="ServletOrganizacion" class="ghost">Crear empresa</a>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Contratar empleado</h1>
                <p>Ingrese los datos correspondientes</p>
                <button class="ghost" id="signUp">Crear varios</button>
                <a href="ServletEmpleado" class="ghost">Ver empleados</a>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    const signUpButton = document.getElementById('signUp');
    const signInButton = document.getElementById('signIn');
    const container = document.getElementById('container');

    signUpButton.addEventListener('click', () => {
        container.classList.add("right-panel-active");
    });

    signInButton.addEventListener('click', () => {
        container.classList.remove("right-panel-active");
    });
</script>
<style>
    <%@include file="styles/form.css" %>
</style>
</html>
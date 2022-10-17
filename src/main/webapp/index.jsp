<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Java Enterprise Exercises</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="fav.ico"/>
</head>
<body>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="#">
            <h1>Nueva empresa</h1>
            <span>Abra una nueva empresa para registrar empleados</span>
            <input type="text" placeholder="Nombre" id="nombreOrg" name="nombreOrg"/>
            <input type="number" placeholder="Límite de empleados" id="maxOrg" name="maxOrg"/>
            <select name="giroOrg">
                <option value="docente">Docencia</option>
                <option value="administrativo" selected>Administrativo</option>
                <option value="tecnico">Técnico</option>
            </select>
            <button>Sign Up</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="Empleado" autocomplete="off" method="post">
            <h1>Nuevo empleado</h1>
            <span>registre los datos del empleado</span>
            <input type="text" placeholder="Nombre" id="nombre" name="nombre"/>
            <input type="text" placeholder="Ocupación" id="ocupacion" name="ocupacion"/>
            <button>Contratar</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Abrir empresa</h1>
                <p>Administre los empleados correctamente</p>
                <button class="ghost" id="signIn">Nuevo empleado</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Contratar empleado</h1>
                <p>Ingrese los datos correspondientes</p>
                <button class="ghost" id="signUp">Abrir empresa</button>
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
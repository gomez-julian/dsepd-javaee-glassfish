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
        <form action="#">
            <h1><%= organizacion.getNombre()%></h1>
            <span>Datos de la empresa</span>
            <input type="text" placeholder="Limite" id="limite" name="limite"
                   value="<%="Límite: " + organizacion.getLimiteTrabajadores()%>" disabled/>
            <input type="text" placeholder="Actual" id="actual" name="actual"
                   value="<%="Actual: " + organizacion.getTrabajadores().size()%>" disabled/>
            <input type="text" placeholder="Minimo horas" id="minhrs" name="minhrs"
                    value="<%="Mínimo horas: " + organizacion.getHoraEntrada()%>" disabled/>
            <input type="text" placeholder="Maximo horas" id="maxhrs" name="maxhrs"
                   value="<%="Máximo horas: " + organizacion.getHoraSalida()%>" disabled/>
            <select name="giroOrg">
                <option value="docente">Docencia</option>
                <option value="administrativo" selected>Administrativo</option>
                <option value="tecnico">Técnico</option>
            </select>
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
                <h1>Datos de la empresa</h1>
                <p>Asegurese que se encuentre en la empresa correcta</p>
                <button class="ghost" id="signIn">Nuevo empleado</button>
                <a href="ServletOrganizacion" class="ghost">Crear empresa</a>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Contratar empleado</h1>
                <p>Ingrese los datos correspondientes</p>
                <button class="ghost" id="signUp">Verificar empresa</button>
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
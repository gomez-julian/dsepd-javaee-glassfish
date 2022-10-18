<%@ page import="java.util.Vector" %>
<%@ page import="fabrica.trabajador.Trabajador" %>
<%@ page import="modelo.OrganizacionModelo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Java Enterprise Exercises</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="fav.ico"/>
</head>
<%
    Vector<Trabajador> trabajadores = OrganizacionModelo.organizacion.getTrabajadores();
%>
<body>
<ul class="cards">
    <% for(Trabajador trabajador: trabajadores) { %>
    <li>
        <a href="<%="ServletSalario?id="+trabajador.getIdTrabajador()%>" class="card">
            <img src="https://i.imgur.com/oYiTqum.jpg" class="card__image" alt="" />
            <div class="card__overlay">
                <div class="card__header">
                    <svg class="card__arc" xmlns="http://www.w3.org/2000/svg"><path /></svg>
                    <img class="card__thumb" src="https://i.imgur.com/7D7I6dI.png" alt="" />
                    <div class="card__header-text">
                        <h3 class="card__title"><%= trabajador.getNombre()%> </h3>
                        <span class="card__tagline">Ocupación: <%= trabajador.getOcupacion()%> </span>
                        <span class="card__status">1 hour ago</span>
                    </div>
                </div>
                <p class="card__description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores, blanditiis?</p>
            </div>
        </a>
    </li>
    <% } %>
</ul>
</body>
<style>
    <%@include file="styles/empleados.css" %>
</style>
</html>
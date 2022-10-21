<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fabrica.organizacion.Organizacion" %>
<%@ page import="modelo.OrganizacionModelo" %>
<%@ page import="fabrica.trabajador.Trabajador" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Java Enterprise Exercises</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="fav.ico"/>
</head>
<body>
<div class="container">
    <h2>Lista de empleados de ${organizacion.getNombre()} <small>Actual: ${organizacion.getTrabajadores().size()}</small></h2>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">ID</div>
            <div class="col col-2">Nombre</div>
            <div class="col col-3">Salario</div>
            <div class="col col-4">Ocupacion</div>
            <div class="col col-4">Acciones</div>
        </li>
        <c:forEach var="trabajador" items="${organizacion.getTrabajadores()}">
        <li class="table-row">
            <div class="col col-1" data-label="Job Id">${trabajador.getIdTrabajador()}</div>
            <div class="col col-2" data-label="Customer Name">${trabajador.getNombre()}</div>
            <div class="col col-3" data-label="Amount">$${trabajador.getSalario()}</div>
            <div class="col col-4" data-label="Payment Status">${trabajador.getOcupacion()}</div>
            <div class="col col-4" data-label="Calcular">
                <a href="${"ServletSalario?id=".concat(String.valueOf(trabajador.getIdTrabajador()))}">Calcular</a></div>
        </li>
        </c:forEach>
    </ul>
</div>

</body>

<style>
    <%@include file="styles/lista.css" %>
</style>
</html>
<%@ page import="com.example.javaeehelloworld.decorator.polynomial.AbstractPolynomial" %>
<%@ page import="com.example.javaeehelloworld.decorator.polynomial.ConcretePolynomialEquation" %>
<%@ page import="com.example.javaeehelloworld.decorator.polynomial.ConcreteDecoratorResolution" %>
<%@ page import="com.example.javaeehelloworld.decorator.polynomial.Term" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Java Enterprise Exercises</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="fav.ico" />
</head>
<%
    AbstractPolynomial polynomial = new ConcretePolynomialEquation();
    polynomial.addTerm(new Term(1, 2));
    polynomial.addTerm(new Term(2, 1));
    polynomial.addTerm(new Term(-8, 0));
%>
<body>
<div class="container">
    <div>
        <a href="hello-servlet">Hello</a>
    </div>
    <div>
        <h1>1. Ejercicio de resolución de ecuación cuadrática</h1>
        <p>Ecuación base: <%=polynomial%>
        </p>
        <br>
        <%
            polynomial = new ConcreteDecoratorResolution(polynomial);
        %>
        <p>Solución por medio de la fórmula general: <%=polynomial%>
        </p>
    </div>
    <div>
        <h1>2. Ejercicio de interacción con formularios y HttpServlet</h1>
        <p>Por favor ingrese su nombre:</p>
        <form action="ServletForm" method="post">
            <h3> Dar el nombre </h3>
            <input type="text" name="name">
            <input type="submit" value="Aceptar">
        </form>
    </div>
</div>
</body>
<style>
    <%@include file="styles/base.css" %>
</style>
</html>
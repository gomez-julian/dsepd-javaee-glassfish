package com.example.javaeehelloworld.controller;


import com.example.javaeehelloworld.controller.strategy.*;
import com.example.javaeehelloworld.decorator.polynomial.Term;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletSolution", value = "/solution")
public class ServletSolution extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/solution.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/solution.jsp";
        String original = null, solution = null, message = null, error;
        AbstractPolynomial polynomial = new PolynomialBuilder();

        String polynomialForm =request.getParameter("polynomial");
        String [] stringTerms = polynomialForm.split(";");

        for(String string: stringTerms){
            String [] variable = string.split(",");
            polynomial.addTerm(new Term(Integer.parseInt(variable[0]),Integer.parseInt(variable[1])));
        }

        switch (polynomial.getMaxExponent()){
            case 1:
                polynomial = new PolynomialLinear(polynomial.getTerms());
                message = "Resolución por ecuación lineal";
                break;
            case 2:
                polynomial = new PolynomialQuadratic(polynomial.getTerms());
                message = "Resolución por ecuación cuadrática";
                break;
            case 3:
                polynomial = new PolynomialCubical(polynomial.getTerms());
                message = "Resolución por ecuación cúbica";
                break;
            default:
                polynomial = new PolynomialHigher(polynomial.getTerms());
                message = "Resolución polinómica general";
        }

        request.setAttribute("solution", polynomial.evaluate());
        request.setAttribute("original", polynomial.toString());
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}

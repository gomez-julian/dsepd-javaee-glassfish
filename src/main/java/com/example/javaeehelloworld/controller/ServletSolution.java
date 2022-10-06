package com.example.javaeehelloworld.controller;

import com.example.javaeehelloworld.decorator.polynomial.AbstractPolynomial;
import com.example.javaeehelloworld.decorator.polynomial.ConcreteDecoratorResolution;
import com.example.javaeehelloworld.decorator.polynomial.ConcretePolynomialEquation;
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
        AbstractPolynomial polynomial = new ConcretePolynomialEquation();

        try {
            polynomial.addTerm(new Term(Integer.parseInt(request.getParameter("avariable")), 2));
            polynomial.addTerm(new Term(Integer.parseInt(request.getParameter("bvariable")), 1));
            polynomial.addTerm(new Term(Integer.parseInt(request.getParameter("cvariable")), 0));

            original = polynomial.toString();
            System.out.println(polynomial);

            polynomial = new ConcreteDecoratorResolution(polynomial);
            solution = polynomial.toString();
            System.out.println(polynomial);

            message = "El polinomio tiene una respuesta real.";
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if(solution.length()>20){
                error = "Error";
                message = "Ha ocurrido un error o la respuesta es imaginaria";
                original = "";
                solution = "";
                request.setAttribute("error", error);
            }
            request.setAttribute("message", message);
            request.setAttribute("original", original);
            request.setAttribute("solution", solution);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
    }
}

package controller;

import controller.strategy.AbstractPolynomial;
import controller.strategy.PolynomialBuilder;
import controller.strategy.Term;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletShow", value = "/show")
public class ServletShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //AbstractPolynomial  polynomial = (PolynomialBuilder)request.getAttribute("current");

        //int exponent = Integer.parseInt((String) request.getAttribute("exponent"));
        int coefficient = Integer.parseInt(request.getParameter("coefficient"));
        int exponent = Integer.parseInt(request.getParameter("exponent"));

        AbstractPolynomial polynomial = PolynomialBuilder.getBuilder();
        polynomial.addTerm(new Term(coefficient, exponent));

        request.setAttribute("current", polynomial);
        request.setAttribute("exponent", String.valueOf((exponent + 1)));

        String url = "/show.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}

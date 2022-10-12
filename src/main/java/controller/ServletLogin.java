package controller;

import controller.strategy.AbstractPolynomial;
import controller.strategy.PolynomialBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletLogin", value = "/polynomial")
public class ServletLogin extends HttpServlet {

    private String loggedUser;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/polynomial.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email =request.getParameter("email");
        String password =request.getParameter("password");
        String url = "/polynomial.jsp";
        WebUser user = WebUser.getUser(email, password);
        if(user != null){
            HttpSession session = request.getSession(true);
            session.setAttribute("username", email);
            request.setAttribute("account", email);

            AbstractPolynomial polynomial = new PolynomialBuilder();

            request.setAttribute("current", polynomial);
            request.setAttribute("exponent", "0");

            loggedUser = email;
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

        url = "/index.jsp";
        request.setAttribute("error", "Error");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private Map<String, String> getCredentials(){
        Map<String, String> map = new HashMap<>();
        map.put("julian@gmail.com", "juliancito");
        return map;
    }
}

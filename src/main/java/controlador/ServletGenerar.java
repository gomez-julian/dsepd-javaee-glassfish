package controlador;

import modelo.OrganizacionModelo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletGenerar", value = "/ServletGenerar")
public class ServletGenerar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        OrganizacionModelo.organizacion.getTrabajadores(cantidad);

        HttpSession session = request.getSession(true);
        session.setAttribute("organizacion", OrganizacionModelo.organizacion);
        String vista = "/listaEmpleados.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
        dispatcher.forward(request, response);
    }
}

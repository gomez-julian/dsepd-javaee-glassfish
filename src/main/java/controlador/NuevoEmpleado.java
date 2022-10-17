package controlador;

import fabrica.trabajador.Trabajador;
import modelo.OrganizacionModelo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NuevoEmpleado", value = "/Empleado")
public class NuevoEmpleado extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vista = "/empleados.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String ocupacion = request.getParameter("ocupacion");

        Trabajador trabajador = OrganizacionModelo.organizacion.getTrabajador();
        trabajador.registrarDatos(ocupacion);
        trabajador.setNombre(nombre);

        String vista = "/empleados.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
        dispatcher.forward(request, response);
    }
}

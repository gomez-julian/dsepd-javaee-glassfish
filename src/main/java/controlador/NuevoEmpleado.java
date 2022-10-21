package controlador;

import fabrica.trabajador.Trabajador;
import modelo.OrganizacionModelo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NuevoEmpleado", value = "/Empleado")
public class NuevoEmpleado extends HttpServlet {
    //TODO: Redirigir a la vista de listaEmpleados con session
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("organizacion", OrganizacionModelo.organizacion);
        String vista = "/crearEmpleado.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String ocupacion = request.getParameter("actividad");
        double salario = Double.parseDouble(request.getParameter("salario"));

        Trabajador trabajador = OrganizacionModelo.organizacion.getTrabajador();
        trabajador.registrarDatos(ocupacion);
        trabajador.setNombre(nombre);
        trabajador.setSalario(salario);

        HttpSession session = request.getSession(true);
        session.setAttribute("organizacion", OrganizacionModelo.organizacion);
        String vista = "/listaEmpleados.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
        dispatcher.forward(request, response);
    }
}

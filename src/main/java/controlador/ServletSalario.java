package controlador;

import fabrica.trabajador.Trabajador;
import modelo.OrganizacionModelo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletSalario", value = "/ServletSalario")
public class ServletSalario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTrabajador = Integer.parseInt(request.getParameter("id"));
        Trabajador trabajador = OrganizacionModelo.organizacion.buscarTrabajador(idTrabajador);
        request.setAttribute("trabajador", trabajador);

        String vista = "/salario.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTrabajador = Integer.parseInt(request.getParameter("id"));
        int entrada = Integer.parseInt(request.getParameter("entrada"));
        int salida = Integer.parseInt(request.getParameter("salida"));
        Trabajador trabajador = OrganizacionModelo.organizacion.buscarTrabajador(idTrabajador);

        double salario = (salida - entrada) * trabajador.getSalario();
        request.setAttribute("trabajador", trabajador);
        request.setAttribute("salario", salario);

        String vista = "/calculo.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
        dispatcher.forward(request, response);
    }
}

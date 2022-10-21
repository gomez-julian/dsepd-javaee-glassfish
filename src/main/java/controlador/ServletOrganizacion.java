package controlador;

import fabrica.organizacion.Organizacion;
import fabrica.organizacion.OrganizacionAcademica;
import fabrica.organizacion.OrganizacionAdministrativa;
import fabrica.organizacion.OrganizacionServicio;
import modelo.OrganizacionModelo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletOrganizacion", value = "/ServletOrganizacion")
public class ServletOrganizacion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vista = "/organizacion.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        int maxEmple = Integer.parseInt(request.getParameter("maxEmple"));
        //int minHoras = Integer.parseInt(request.getParameter("minHoras"));
        //int maxHoras = Integer.parseInt(request.getParameter("maxHoras"));
        int minHoras = 4;
        int maxHoras = 8;
        String giroOrg = request.getParameter("giroOrg");

        switch (giroOrg){
            case "docente":
                OrganizacionModelo.organizacion = new OrganizacionAcademica(nombre,"",maxEmple,minHoras,maxHoras);
                break;
            case "administrativo":
                OrganizacionModelo.organizacion = new OrganizacionAdministrativa(nombre,"",maxEmple,minHoras,maxHoras);
                break;
            case "tecnico":
                OrganizacionModelo.organizacion = new OrganizacionServicio(nombre,"",maxEmple,minHoras,maxHoras);
                break;
            default:
                throw new RuntimeException("Error al cachar esa cosa");
        }
        //adaptando a EL
        Organizacion organizacion = OrganizacionModelo.organizacion;
        String[] actividades = organizacion.getActvidades();

        HttpSession session = request.getSession(true);
        session.setAttribute("organizacion", organizacion);
        session.setAttribute("actividades", actividades);
        //fin adapatación

        String vista = "/opcionesOrganizacion.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
        dispatcher.forward(request, response);
    }
}

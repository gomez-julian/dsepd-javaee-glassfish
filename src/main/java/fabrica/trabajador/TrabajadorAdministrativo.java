package fabrica.trabajador;

import fabrica.shared.Horario;
import fabrica.shared.TipoActividad;
import fabrica.shared.TipoHorario;

public class TrabajadorAdministrativo extends Trabajador{

    private String habilidad;

    public TrabajadorAdministrativo(int idTrabajador, String nombre) {
        super(idTrabajador, nombre, TipoActividad.ADMINISTRATIVO);
    }

    @Override
    public void registrarDatos(String ocupacion) {
        this.ocupacion = ocupacion;
        this.horario = new Horario(TipoHorario.HORARIO_FIJO);
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }
}

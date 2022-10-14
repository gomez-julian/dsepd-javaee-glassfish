package fabrica.trabajador;

import fabrica.shared.Horario;
import fabrica.shared.TipoActividad;

import java.time.LocalTime;

public abstract class Trabajador {
    protected int idTrabajador;
    protected String nombre;
    protected String ocupacion;
    protected Horario horario;
    protected TipoActividad actividad;

    private static int generadorIds = 0;

    public void registrarEntradaSalida(LocalTime hora){

    }

    public void registrarActividad(TipoActividad actividad){
        this.actividad = actividad;
    }

    public abstract void registrarDatos(String ocupacion);

    public Trabajador(int idTrabajador, String nombre, TipoActividad actividad) {
        this.idTrabajador = idTrabajador;
        this.nombre = nombre;
        this.actividad = actividad;
    }

    public static int generarId(){
        generadorIds ++;
        return generadorIds;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Horario getHorario() {
        return horario;
    }

    public TipoActividad getActividad() {
        return actividad;
    }

    public void setActividad(TipoActividad actividad) {
        this.actividad = actividad;
    }

    @Override
    public String toString(){
        return "REPORTE INFORMACIÓN TRABAJADOR: \n"
                + "ID: " + this.idTrabajador + " NOMBRE: " + this.nombre + "\n"
                + "OCUPACIÓN: " + this.ocupacion + " ACTIVIDAD: " + this.actividad;
    }
}

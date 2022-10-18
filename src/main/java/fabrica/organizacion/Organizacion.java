package fabrica.organizacion;

import fabrica.trabajador.Trabajador;

import java.util.Vector;

public abstract class Organizacion {
    protected String nombre;
    protected String nivel;
    protected int limiteTrabajadores;
    protected Vector<Trabajador> trabajadores;
    protected int horaEntrada, horaSalida;

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public abstract String[] getActvidades();

    public Vector<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public int getLimiteTrabajadores() {
        return limiteTrabajadores;
    }

    public Organizacion(String nombre, String nivel, int limiteTrabajadores, int horaEntrada, int horaSalida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.limiteTrabajadores = limiteTrabajadores;
        this.trabajadores = new Vector<>();
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public abstract Trabajador getTrabajador();

    public Trabajador buscarTrabajador(int idTrabajador){
        Trabajador trabajadorEncontrado = null;
        for(Trabajador trabajador: trabajadores)
            if(trabajador.getIdTrabajador() == idTrabajador)
                trabajadorEncontrado = trabajador;
        return trabajadorEncontrado;
    }

    public void registrarTiempoTrabajado(Trabajador trabajador, int horas){

    }

    public void asignarTrabajo(Trabajador trabajador, String trabajo){

    }

    public void evaluarDesempenioTrabajador(Trabajador trabajador){

    }
}

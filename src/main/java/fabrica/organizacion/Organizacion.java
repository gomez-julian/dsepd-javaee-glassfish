package fabrica.organizacion;

import fabrica.trabajador.Trabajador;

import java.util.Vector;

public abstract class Organizacion {
    protected String nombre;
    protected String nivel;
    protected int limiteTrabajadores;
    protected Vector<Trabajador> trabajadores;

    public Organizacion(String nombre, String nivel, int limiteTrabajadores) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.limiteTrabajadores = limiteTrabajadores;
        this.trabajadores = new Vector<>();
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

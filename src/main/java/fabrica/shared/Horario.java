package fabrica.shared;

import java.time.LocalTime;
import java.util.Vector;

public class Horario {
    private TipoHorario tipoHorario;
    private Vector<LocalTime> horasRegistradas;

    public Horario(TipoHorario tipoHorario) {
        this.horasRegistradas = new Vector<>();
        this.tipoHorario = tipoHorario;
    }

    public void registrarHora(LocalTime hora){
        this.horasRegistradas.add(hora);
    }
}

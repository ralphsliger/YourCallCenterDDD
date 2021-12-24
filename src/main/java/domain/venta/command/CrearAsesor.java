package domain.venta.command;

import co.com.sofka.domain.generic.Command;
import domain.venta.values.AsesorID;
import domain.venta.values.Nombre;

public class CrearAsesor extends Command {
    private final AsesorID id;
    private final Nombre nombre;

    public CrearAsesor(AsesorID id, Nombre nombre){
            this.id=id;
            this.nombre=nombre;
    }

    public AsesorID getId() {
        return id;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

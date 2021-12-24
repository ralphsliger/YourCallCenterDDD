package domain.venta.command;

import co.com.sofka.domain.generic.Command;
import domain.venta.values.AsesorID;
import domain.venta.values.Nombre;
import domain.venta.values.VentaID;

public class CrearAsesor extends Command {
    private final VentaID ventaID;
    private final AsesorID id;
    private final Nombre nombre;

    public CrearAsesor(VentaID ventaID, AsesorID id, Nombre nombre){
            this.ventaID=ventaID;
            this.id=id;
            this.nombre=nombre;
    }

    public AsesorID getId() {
        return id;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public VentaID getVentaID() {
        return ventaID;
    }
}

package domain.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.values.AsesorID;
import domain.venta.values.Nombre;
import domain.venta.values.VentaID;

public class NombreAsesorActualizado extends DomainEvent {
    private final AsesorID asesorID;
    private final VentaID ventaID;
    private final Nombre nombre;

    public NombreAsesorActualizado(AsesorID asesorID, VentaID ventaID, Nombre nombre) {
        super("YourCallCenterDDD.domain.venta.events.NombreAsesorActualizado");
        this.asesorID=asesorID;
        this.ventaID=ventaID;
        this.nombre=nombre;
    }

    public AsesorID getAsesorID() {
        return asesorID;
    }

    public VentaID getVentaID() {
        return ventaID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

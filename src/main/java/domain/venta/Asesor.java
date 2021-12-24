package domain.venta;

import co.com.sofka.domain.generic.Entity;
import domain.venta.values.AsesorID;
import domain.venta.values.Nombre;

import java.util.Objects;

public class Asesor extends Entity<AsesorID> {
    Nombre nombre;
    public Asesor(AsesorID entityId, Nombre nombre) {
        super(entityId);
        this.nombre=nombre;
    }

    public Nombre Nombre() {
        return nombre;
    }

    public void actualizarNombre(Nombre nombre){
        Objects.requireNonNull(nombre);
        this.nombre=nombre;
    }
}

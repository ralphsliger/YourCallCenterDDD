package domain.venta.command;

import co.com.sofka.domain.generic.Command;
import domain.venta.Asesor;
import domain.venta.Cliente;
import domain.venta.values.VentaID;

public class CrearVenta extends Command {
    private final VentaID ventaID;
    private final Asesor asesor;
    private final Cliente cliente;

    public CrearVenta(VentaID ventaID, Asesor asesor, Cliente cliente) {
        this.ventaID= ventaID;
        this.asesor = asesor;
        this.cliente = cliente;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public VentaID getVentaID() {
        return ventaID;
    }
}

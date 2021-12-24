package domain.venta.command;

import co.com.sofka.domain.generic.Command;
import domain.venta.Asesor;
import domain.venta.Cliente;

public class CrearVenta extends Command {
    private final Asesor asesor;
    private final Cliente cliente;

    public CrearVenta(Asesor asesor, Cliente cliente) {
        this.asesor = asesor;
        this.cliente = cliente;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public Cliente getCliente() {
        return cliente;
    }
}

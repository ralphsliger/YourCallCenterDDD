package domain.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.values.ClienteID;
import domain.venta.values.Comprobante;
import domain.venta.values.VentaID;

public class ComprobanteClienteActualizado extends DomainEvent {
    private final ClienteID clienteID;
    private final Comprobante comprobante;

    public ComprobanteClienteActualizado(ClienteID clienteID,  Comprobante comprobante) {
        super("YourCallCenterDDD.domain.venta.events.ComprobanteClienteActualizado");
        this.clienteID=clienteID;
        this.comprobante=comprobante;
    }

    public ClienteID ClienteID() {
        return clienteID;
    }


    public Comprobante Comprobante() {
        return comprobante;
    }
}

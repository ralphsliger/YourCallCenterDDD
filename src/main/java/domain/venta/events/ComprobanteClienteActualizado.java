package domain.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.values.ClienteID;
import domain.venta.values.Comprobante;
import domain.venta.values.VentaID;

public class ComprobanteClienteActualizado extends DomainEvent {
    private final ClienteID clienteID;
    private final VentaID idVenta;
    private final Comprobante comprobante;

    public ComprobanteClienteActualizado(ClienteID clienteID, VentaID idVenta, Comprobante comprobante) {
        super("YourCallCenterDDD.domain.venta.events.ComprobanteClienteActualizado");
        this.clienteID=clienteID;
        this.idVenta=idVenta;
        this.comprobante=comprobante;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public VentaID getIdVenta() {
        return idVenta;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }
}

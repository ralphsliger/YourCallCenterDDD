package domain.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.values.ClienteID;
import domain.venta.values.NumeroContacto;
import domain.venta.values.VentaID;

public class NumeroContactoClienteActualizado extends DomainEvent {

    private final ClienteID clienteID;
    private final VentaID idVenta;
    private final NumeroContacto numero;

    public NumeroContactoClienteActualizado(ClienteID clienteID, VentaID idVenta, NumeroContacto numero) {
        super("YourCallCenterDDD.domain.venta.events.NumeroContactoClienteActualizado");
        this.clienteID=clienteID;
        this.idVenta=idVenta;
        this.numero=numero;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public VentaID getIdVenta() {
        return idVenta;
    }

    public NumeroContacto getNumero() {
        return numero;
    }
}

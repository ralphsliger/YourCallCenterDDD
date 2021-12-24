package domain.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.values.*;

public class ClienteCreado extends DomainEvent {
    private final ClienteID id;
    private final Identificacion identificacion;
    private final Comprobante comprobante;
    private final NumeroContacto numero;
    private final Downpayment downpayment;

    public ClienteCreado(ClienteID id, Identificacion identificacion, Comprobante comprobante, NumeroContacto numero, Downpayment downpayment) {
        super("YourCallCenterDDD.domain.venta.events.ClienteCreado");
        this.id=id;
        this.identificacion=identificacion;
        this.comprobante=comprobante;
        this.numero=numero;
        this.downpayment=downpayment;
    }

    public ClienteID getId() {
        return id;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public NumeroContacto getNumero() {
        return numero;
    }

    public Downpayment getDownpayment() {
        return downpayment;
    }
}

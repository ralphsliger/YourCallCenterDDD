package domain.venta.command;

import co.com.sofka.domain.generic.Command;
import domain.venta.values.*;

public class CrearCliente extends Command {
    private final ClienteID id;
    private final Identificacion identificacion;
    private final Comprobante comprobante;
    private final NumeroContacto numero;
    private final Downpayment downpayment;

    public CrearCliente(ClienteID id, Identificacion identificacion, Comprobante comprobante, NumeroContacto numero, Downpayment downpayment) {
        this.id = id;
        this.identificacion = identificacion;
        this.comprobante = comprobante;
        this.numero = numero;
        this.downpayment = downpayment;
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


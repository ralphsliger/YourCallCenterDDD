package domain.venta.command;

import co.com.sofka.domain.generic.Command;
import domain.venta.values.*;

public class CrearCliente extends Command {
    private final VentaID idVenta;
    private final ClienteID id;
    private final Identificacion identificacion;
    private final Comprobante comprobante;
    private final NumeroContacto numero;
    private final Downpayment downpayment;

    public CrearCliente(VentaID idVenta, ClienteID id, Identificacion identificacion, Comprobante comprobante, NumeroContacto numero, Downpayment downpayment) {
        this.idVenta=idVenta;
        this.id = id;
        this.identificacion = identificacion;
        this.comprobante = comprobante;
        this.numero = numero;
        this.downpayment = downpayment;
    }

    public ClienteID Id() {
        return id;
    }

    public Identificacion Identificacion() {
        return identificacion;
    }

    public Comprobante Comprobante() {
        return comprobante;
    }

    public NumeroContacto Numero() {
        return numero;
    }

    public Downpayment Downpayment() {
        return downpayment;
    }

    public VentaID IdVenta() {
        return idVenta;
    }
}


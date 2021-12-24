package domain.venta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.events.*;
import domain.venta.values.*;

import java.util.List;
import java.util.Objects;

public class Venta extends AggregateEvent<VentaID> {

    protected Asesor asesor;
    protected Cliente cliente;

    public Venta(VentaID entityId, Asesor asesor, Cliente cliente) {
        super(entityId);
        Objects.requireNonNull(asesor);
        Objects.requireNonNull(cliente);
        subscribe(new VentaChange(this));
        appendChange(new VentaCreada(asesor, cliente)).apply();
    }

    public Venta(VentaID entityId) {
        super(entityId);
        subscribe(new VentaChange(this));
    }

    public static Venta from(VentaID ventaID, List<DomainEvent> events){
        var venta = new Venta(ventaID);
        events.forEach(venta::applyEvent);
        return venta;
    }

    public Asesor Asesor() {
        return asesor;
    }

    public Cliente Cliente() {
        return cliente;
    }

    public void actualizarNombreCliente(ClienteID id, Nombre nombre, VentaID idVenta){
        Objects.requireNonNull(id);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(idVenta);
    }

    public void actualizarComprobanteCliente(ClienteID clienteID, VentaID idVenta, Comprobante comprobante){
        Objects.requireNonNull(clienteID);
        Objects.requireNonNull(idVenta);
        Objects.requireNonNull(comprobante);
        appendChange(new ComprobanteClienteActualizado(clienteID, idVenta, comprobante));
    }

    public void actualizarNumeroContactoCliente(ClienteID clienteID, VentaID idVenta, NumeroContacto numero){
        Objects.requireNonNull(clienteID);
        Objects.requireNonNull(idVenta);
        Objects.requireNonNull(numero);
        appendChange(new NumeroContactoClienteActualizado(clienteID, idVenta, numero));
    }

    public void actualizarNombreAsesor(AsesorID asesorID, VentaID ventaID, Nombre nombre){
        Objects.requireNonNull(asesorID);
        Objects.requireNonNull(ventaID);
        Objects.requireNonNull(nombre);
        appendChange(new NombreAsesorActualizado(asesorID, ventaID, nombre));
    }

    public void generarAsesor(AsesorID id, Nombre nombre){
        Objects.requireNonNull(id);
        Objects.requireNonNull(nombre);
        appendChange(new AsesorCreado(id, nombre));
    }

    public void generarCliente(ClienteID id, Identificacion identificacion, Comprobante comprobante, NumeroContacto numero, Downpayment downpayment){
        Objects.requireNonNull(id);
        Objects.requireNonNull(identificacion);
        Objects.requireNonNull(comprobante);
        Objects.requireNonNull(numero);
        Objects.requireNonNull(downpayment);
        appendChange(new ClienteCreado(id, identificacion, comprobante, numero, downpayment));
    }


}
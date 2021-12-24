package domain.venta;

import co.com.sofka.domain.generic.EventChange;
import domain.venta.events.*;
import domain.venta.values.Comprobante;

public class VentaChange extends EventChange {

    public VentaChange(Venta venta) {
        apply((VentaCreada event)->{
            venta.asesor= event.getAsesor();
            venta.cliente= event.getCliente();
        });

        apply((ClienteCreado event)->{
            venta.generarCliente(event.getId(), event.getIdentificacion(), event.getComprobante(), event.getNumero(), event.getDownpayment());
        });

        apply((AsesorCreado event)->{
            venta.generarAsesor(event.getId(), event.getNombre());
        });

        apply((NumeroContactoClienteActualizado event)->{
            venta.actualizarNumeroContactoCliente(event.getClienteID(),event.getIdVenta(), event.getNumero());
        });

        apply((NombreAsesorActualizado event)->{
            venta.actualizarNombreAsesor(event.getAsesorID(), event.getVentaID(), event.getNombre());
        });

        apply((ComprobanteClienteActualizado event)->{
           venta.actualizarComprobanteCliente(event.getClienteID(), event.getIdVenta(), event.getComprobante());
        });
    }

}

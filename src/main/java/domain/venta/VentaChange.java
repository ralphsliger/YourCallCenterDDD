package domain.venta;

import co.com.sofka.domain.generic.EventChange;
import domain.venta.events.*;
import domain.venta.values.Comprobante;

public class VentaChange extends EventChange {

    public VentaChange(Venta venta) {
        apply((VentaCreada event)->{
            venta.asesor= event.Asesor();
            venta.cliente= event.Cliente();
        });

        apply((ClienteCreado event)->{
            venta.generarCliente(event.Id(), event.Identificacion(), event.Comprobante(), event.Numero(), event.Downpayment());
        });

        apply((AsesorCreado event)->{
            venta.generarAsesor(event.Id(), event.Nombre());
        });

        apply((NumeroContactoClienteActualizado event)->{
            venta.actualizarNumeroContactoCliente(event.ClienteID(), event.Numero());
        });

        apply((NombreAsesorActualizado event)->{
            venta.actualizarNombreAsesor(event.AsesorID(),  event.Nombre());
        });

        apply((ComprobanteClienteActualizado event)->{
           venta.actualizarComprobanteCliente(event.ClienteID(), event.Comprobante());
        });
    }

}

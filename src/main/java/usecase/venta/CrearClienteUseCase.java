package usecase.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.venta.Cliente;
import domain.venta.Venta;
import domain.venta.command.CrearCliente;

public class CrearClienteUseCase extends UseCase<RequestCommand<CrearCliente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCliente> crearClienteRequestCommand) {
        var command = crearClienteRequestCommand.getCommand();
        var cliente = Venta.from(command.getIdVenta(), retrieveEvents(command.getIdVenta().value()));
        cliente.generarCliente(command.getId(), command.getIdentificacion(), command.getComprobante(), command.getNumero(), command.getDownpayment());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}

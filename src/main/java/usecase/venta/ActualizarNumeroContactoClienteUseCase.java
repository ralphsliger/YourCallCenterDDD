package usecase.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.venta.Venta;
import domain.venta.command.ActualizarNumeroContactoCliente;

public class ActualizarNumeroContactoClienteUseCase extends UseCase<RequestCommand<ActualizarNumeroContactoCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNumeroContactoCliente> actualizarNumeroContactoClienteRequestCommand) {
        var command = actualizarNumeroContactoClienteRequestCommand.getCommand();
        var numeroContacto = Venta.from(command.getIdVenta(), retrieveEvents(command.getIdVenta().value()));
        numeroContacto.actualizarNumeroContactoCliente(command.getClienteID(), command.getNumero());
        emit().onResponse(new ResponseEvents(numeroContacto.getUncommittedChanges()));
    }
}

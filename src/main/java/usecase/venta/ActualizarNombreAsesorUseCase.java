package usecase.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.venta.Venta;
import domain.venta.command.ActualizarNombreAsesor;

public class ActualizarNombreAsesorUseCase extends UseCase<RequestCommand<ActualizarNombreAsesor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreAsesor> actualizarNombreAsesorRequestCommand) {
        var command = actualizarNombreAsesorRequestCommand.getCommand();
        var nombreAsesor = Venta.from(command.getVentaID(), retrieveEvents(command.getVentaID().value()));
        nombreAsesor.actualizarNombreAsesor(command.getAsesorID(), command.getNombre());
        emit().onResponse(new ResponseEvents(nombreAsesor.getUncommittedChanges()));
    }
}

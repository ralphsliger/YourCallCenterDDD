package usecase.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.venta.Venta;
import domain.venta.command.CrearAsesor;

public class CrearAsesorUseCase extends UseCase<RequestCommand<CrearAsesor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearAsesor> crearAsesorRequestCommand) {
        var command = crearAsesorRequestCommand.getCommand();
        var asesor = Venta.from(command.getVentaID(), retrieveEvents(command.getVentaID().value()));
        asesor.generarAsesor(command.getId(),command.getNombre());
        emit().onResponse(new ResponseEvents(asesor.getUncommittedChanges()));
    }
}

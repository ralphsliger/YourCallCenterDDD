package usecase.lead;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.lead.Campana;
import domain.lead.command.CrearCampana;
import domain.lead.command.CrearLead;
import domain.lead.events.LeadCreado;
import domain.lead.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

class CrearLeadUseCaseTest {
    private CrearLeadUseCase useCase;

    @BeforeEach
    public void config(){
        useCase = new CrearLeadUseCase();
    }
    @Test
    public void crearLead(){
        var command = new CrearLead(
                LeadID.of("DMLEAD"),
                new Campana(CampanaID.of("BUZON"), new NombreCampana("NoShow"), new FechaDeContacto("202112")),
                new Interes("busca terreno en el norte de houston para negocio"),
                new NumeroDeContacto("300123456"),
                new Ubicacion("New caney"));

        var response = UseCaseHandler.getInstance().syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow();
        var events = response.getDomainEvents();

        LeadCreado leadCreado = (LeadCreado) events.get(0);
        Assertions.assertEquals("New caney", leadCreado.Ubicacion().value());
    }



}
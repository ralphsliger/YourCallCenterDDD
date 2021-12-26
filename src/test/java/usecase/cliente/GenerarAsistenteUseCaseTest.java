package usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.Asistente;
import domain.cliente.Llamada;
import domain.cliente.Prospecto;
import domain.cliente.command.GenerarAsistente;
import domain.cliente.command.GenerarClienteLlamada;
import domain.cliente.event.ClienteLlamadaCreado;
import domain.cliente.event.asistenteGenerado;
import domain.cliente.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GenerarAsistenteUseCaseTest {
    private GenerarAsistenteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void config(){
        useCase = new GenerarAsistenteUseCase();
        repository = mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }

    @Test
    public void createAsistente(){
        var command = new GenerarAsistente(
                ClienteLlamadaID.of("Cliente01"),
                LlamadaID.of("Llamada01"),
                AsistenteID.of("Asistente01"),
                new Email("mb@.com"),
                new NombreAsistente("Maria")
        );
        when(repository.getEventsBy(any())).thenReturn(events());
        var response = UseCaseHandler.getInstance().setIdentifyExecutor("Cliente01").syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow();
        var events = response.getDomainEvents();
        asistenteGenerado asistenteGenerado = (domain.cliente.event.asistenteGenerado) events.get(0);
        Assertions.assertEquals("Maria", asistenteGenerado.NombreAsistente().value());

    }

    private List<DomainEvent> events() {
        return List.of(
                new ClienteLlamadaCreado(ClienteLlamadaID.of("Cliente01"),
                        new Llamada(
                               LlamadaID.of("Llamada01"),
                                    new Prospecto(
                                           ProspectoID.of("Prospecto01"),
                                            new DescripcionProspecto("Terreno construir", "norte de houston"),
                                            new Cita(true, "20211207", "1600"),
                                            new TipoFinaciamiento("Cuenta abierta"),
                                            new Renta(true, 2000.0),
                                            new Conyugue(true, "Josefa")
                                    ),
                                    new Asistente(
                                            AsistenteID.of("Asistente01"),
                                            new Email("r@r.com"),
                                            new NombreAsistente("Maria")
                                    )
                        ))
        );

    }

}
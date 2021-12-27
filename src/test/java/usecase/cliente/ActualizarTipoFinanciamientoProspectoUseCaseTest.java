package usecase.cliente;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.Asistente;
import domain.cliente.Llamada;
import domain.cliente.Prospecto;
import domain.cliente.command.ActualizarTipoFinanciamientoProspecto;
import domain.cliente.event.ClienteLlamadaCreado;
import domain.cliente.event.TipoFinanciamientoProspectoActualizado;
import domain.cliente.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
class ActualizarTipoFinanciamientoProspectoUseCaseTest {
private ActualizarTipoFinanciamientoProspectoUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @BeforeEach
    public void conf(){
        useCase= new ActualizarTipoFinanciamientoProspectoUseCase();
        repository= mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }

    @Test
    public void updateTipo(){
        var command = new ActualizarTipoFinanciamientoProspecto(
                ClienteLlamadaID.of("Cliente01"),
                LlamadaID.of("Llamada01"),
                ProspectoID.of("Prospecto01"),
                new TipoFinaciamiento("abierto")
        );
        when(repository.getEventsBy("Prospecto01")).thenReturn(events());
        var response = UseCaseHandler.getInstance().setIdentifyExecutor("Cliente01").syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow();
        var event = response.getDomainEvents();
        TipoFinanciamientoProspectoActualizado fin = (TipoFinanciamientoProspectoActualizado) event.get(0);
        Assertions.assertEquals("abierto", fin.TipoFinaciamiento().value());
        
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
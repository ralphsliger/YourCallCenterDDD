package domain.cliente.command;

import co.com.sofka.domain.generic.Command;
import domain.cliente.values.ClienteLlamadaID;
import domain.cliente.values.Conyugue;
import domain.cliente.values.LlamadaID;
import domain.cliente.values.ProspectoID;

public class ActualizarDescripcionProspecto extends Command {
    private final ClienteLlamadaID clienteLlamadaID;
    private final LlamadaID llamadaID;
    private final ProspectoID prospectoID;
    private final Conyugue conyugue;

    public ActualizarDescripcionProspecto(ClienteLlamadaID clienteLlamadaID, LlamadaID llamadaID, ProspectoID prospectoID, Conyugue conyugue) {
        this.clienteLlamadaID = clienteLlamadaID;
        this.llamadaID = llamadaID;
        this.prospectoID = prospectoID;
        this.conyugue = conyugue;
    }

    public ClienteLlamadaID ClienteLlamadaID() {
        return clienteLlamadaID;
    }

    public LlamadaID LlamadaID() {
        return llamadaID;
    }

    public ProspectoID ProspectoID() {
        return prospectoID;
    }

    public Conyugue Conyugue() {
        return conyugue;
    }
}

package domain.cliente.command;

import domain.cliente.values.*;

public class ActualizarRentaProspecto {
    private final ClienteLlamadaID clienteLlamadaID;
    private final LlamadaID llamadaID;
    private final ProspectoID prospectoID;
    private final Renta renta;

    public ActualizarRentaProspecto(ClienteLlamadaID clienteLlamadaID, LlamadaID llamadaID, ProspectoID prospectoID, Renta renta) {
        this.clienteLlamadaID = clienteLlamadaID;
        this.llamadaID = llamadaID;
        this.prospectoID = prospectoID;
        this.renta = renta;
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

    public Renta Renta() {
        return renta;
    }
}

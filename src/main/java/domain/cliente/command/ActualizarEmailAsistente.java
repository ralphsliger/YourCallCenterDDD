package domain.cliente.command;

import domain.cliente.values.*;

public class ActualizarEmailAsistente {
    private final ClienteLlamadaID clienteLlamadaID;
    private final LlamadaID llamadaID;
    private final AsistenteID asistenteID;
    private final Email email;

    public ActualizarEmailAsistente(ClienteLlamadaID clienteLlamadaID, LlamadaID llamadaID, AsistenteID asistenteID, Email email) {
        this.clienteLlamadaID = clienteLlamadaID;
        this.llamadaID = llamadaID;
        this.asistenteID = asistenteID;
        this.email = email;
    }

    public ClienteLlamadaID ClienteLlamadaID() {
        return clienteLlamadaID;
    }

    public LlamadaID LlamadaID() {
        return llamadaID;
    }

    public AsistenteID AsistenteID() {
        return asistenteID;
    }

    public Email Email() {
        return email;
    }

}

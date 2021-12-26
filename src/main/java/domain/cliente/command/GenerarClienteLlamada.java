package domain.cliente.command;

import co.com.sofka.domain.generic.Command;
import domain.cliente.Asistente;
import domain.cliente.Llamada;
import domain.cliente.Prospecto;
import domain.cliente.values.ClienteLlamadaID;
import domain.cliente.values.LlamadaID;

public class GenerarClienteLlamada extends Command {
    ClienteLlamadaID clienteLlamadaID;
    Llamada llamada;

    public GenerarClienteLlamada(ClienteLlamadaID clienteLlamadaID, Llamada llamada) {
        this.clienteLlamadaID = clienteLlamadaID;
        this.llamada = llamada;
    }

    public ClienteLlamadaID ClienteLlamadaID() {
        return clienteLlamadaID;
    }

    public Llamada Llamada() {
        return llamada;
    }
}

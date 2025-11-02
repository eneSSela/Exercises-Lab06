package it.unibo.exceptions.fakenetwork.api;

import java.io.IOException;

public class NetworkException extends IOException {

    /*Costruttore con Messaggio Default*/
    public NetworkException() {
        super("Network Error : No Response...");
    }


    /*Costruttore con Descrizione Errore*/
    public NetworkException(final String message) {
        super("Network Error while sending message : " + message);
    }
}
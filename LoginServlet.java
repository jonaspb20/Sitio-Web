package estructura;

import modelo.Ticket;

public class NodoDoble {
    public Ticket dato;
    public NodoDoble siguiente;
    public NodoDoble anterior;

    public NodoDoble(Ticket dato) {
        this.dato = dato;
    }
}

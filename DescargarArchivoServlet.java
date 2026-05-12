package estructura;

import modelo.Ticket;

/**
 * =========================================================
 * CLASE: ListaDoble
 * ---------------------------------------------------------
 * Implementación de una lista doblemente enlazada
 * para la gestión de tickets.
 *
 * FUNCIONALIDADES:
 * - Inserción al inicio
 * - Inserción al final
 * - Búsqueda por ID
 * - Eliminación por ID
 * - Recorrido bidireccional
 * - Conteo de nodos
 * =========================================================
 */
public class ListaDoble {

    // =====================================================
    // ATRIBUTOS
    // =====================================================

    /**
     * Referencia al primer nodo de la lista.
     */
    private NodoDoble cabeza;

    /**
     * Referencia al último nodo de la lista.
     */
    private NodoDoble cola;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    /**
     * Inicializa la lista vacía.
     */
    public ListaDoble() {

        cabeza = null;
        cola = null;
    }

    // =====================================================
    // INSERTAR AL INICIO
    // =====================================================

    /**
     * Inserta un ticket al inicio de la lista.
     *
     * @param ticket Ticket a insertar
     */
    public void insertarInicio(Ticket ticket) {

        // VALIDAR OBJETO
        if (ticket == null) {
            return;
        }

        // CREAR NUEVO NODO
        NodoDoble nuevo = new NodoDoble(ticket);

        // VALIDAR SI LA LISTA ESTÁ VACÍA
        if (estaVacia()) {

            cabeza = nuevo;
            cola = nuevo;

        } else {

            // ENLAZAR NUEVO CON CABEZA ACTUAL
            nuevo.siguiente = cabeza;

            // ENLAZAR CABEZA ACTUAL CON NUEVO
            cabeza.anterior = nuevo;

            // ACTUALIZAR CABEZA
            cabeza = nuevo;
        }
    }

    // =====================================================
    // INSERTAR AL FINAL
    // =====================================================

    /**
     * Inserta un ticket al final de la lista.
     *
     * @param ticket Ticket a insertar
     */
    public void insertarFinal(Ticket ticket) {

        // VALIDAR OBJETO
        if (ticket == null) {
            return;
        }

        // CREAR NUEVO NODO
        NodoDoble nuevo = new NodoDoble(ticket);

        // VALIDAR SI LA LISTA ESTÁ VACÍA
        if (estaVacia()) {

            cabeza = nuevo;
            cola = nuevo;

        } else {

            // ENLAZAR COLA ACTUAL CON NUEVO
            cola.siguiente = nuevo;

            // ENLAZAR NUEVO CON COLA ACTUAL
            nuevo.anterior = cola;

            // ACTUALIZAR COLA
            cola = nuevo;
        }
    }

    // =====================================================
    // BUSCAR TICKET POR ID
    // =====================================================

    /**
     * Busca un ticket mediante el ID.
     *
     * @param id Identificador del ticket
     * @return Ticket encontrado o null
     */
    public Ticket buscarPorId(String id) {

        // VALIDAR ID
        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        // INICIAR RECORRIDO
        NodoDoble actual = cabeza;

        // RECORRER LISTA
        while (actual != null) {

            // VALIDAR COINCIDENCIA
            if (actual.dato.getId().equalsIgnoreCase(id)) {

                return actual.dato;
            }

            // AVANZAR
            actual = actual.siguiente;
        }

        // NO ENCONTRADO
        return null;
    }

    // =====================================================
    // ELIMINAR TICKET POR ID
    // =====================================================

    /**
     * Elimina un ticket de la lista.
     *
     * @param id ID del ticket
     * @return true si fue eliminado
     */
    public boolean eliminarPorId(String id) {

        // VALIDAR ID
        if (id == null || id.trim().isEmpty()) {
            return false;
        }

        // INICIAR RECORRIDO
        NodoDoble actual = cabeza;

        // RECORRER LISTA
        while (actual != null) {

            // VALIDAR ID
            if (actual.dato.getId().equalsIgnoreCase(id)) {

                // =========================================
                // ELIMINAR CABEZA
                // =========================================
                if (actual == cabeza) {

                    cabeza = actual.siguiente;

                    // VALIDAR NUEVA CABEZA
                    if (cabeza != null) {

                        cabeza.anterior = null;

                    } else {

                        // LISTA VACÍA
                        cola = null;
                    }
                }

                // =========================================
                // ELIMINAR COLA
                // =========================================
                else if (actual == cola) {

                    cola = actual.anterior;

                    // VALIDAR NUEVA COLA
                    if (cola != null) {
                        cola.siguiente = null;
                    }
                }

                // =========================================
                // ELIMINAR NODO INTERMEDIO
                // =========================================
                else {

                    actual.anterior.siguiente =
                            actual.siguiente;

                    actual.siguiente.anterior =
                            actual.anterior;
                }

                // ELIMINACIÓN EXITOSA
                return true;
            }

            // AVANZAR
            actual = actual.siguiente;
        }

        // NO ENCONTRADO
        return false;
    }

    // =====================================================
    // CONTAR NODOS
    // =====================================================

    /**
     * Cuenta la cantidad total de tickets.
     *
     * @return Número total de nodos
     */
    public int contarNodos() {

        int contador = 0;

        NodoDoble actual = cabeza;

        while (actual != null) {

            contador++;

            actual = actual.siguiente;
        }

        return contador;
    }

    // =====================================================
    // OBTENER PRIMER TICKET
    // =====================================================

    /**
     * Retorna el primer ticket registrado.
     *
     * @return Primer ticket o null
     */
    public Ticket obtenerPrimerTicket() {

        if (cabeza != null) {
            return cabeza.dato;
        }

        return null;
    }

    // =====================================================
    // OBTENER ÚLTIMO TICKET
    // =====================================================

    /**
     * Retorna el último ticket registrado.
     *
     * @return Último ticket o null
     */
    public Ticket obtenerUltimoTicket() {

        if (cola != null) {
            return cola.dato;
        }

        return null;
    }

    // =====================================================
    // LIMPIAR LISTA
    // =====================================================

    /**
     * Elimina todos los nodos de la lista.
     */
    public void limpiar() {

        cabeza = null;
        cola = null;
    }

    // =====================================================
    // VALIDAR SI LA LISTA ESTÁ VACÍA
    // =====================================================

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si no existen nodos
     */
    public boolean estaVacia() {

        return cabeza == null;
    }

    // =====================================================
    // GETTERS Y SETTERS
    // =====================================================

    /**
     * Obtiene la cabeza de la lista.
     *
     * @return Nodo cabeza
     */
    public NodoDoble getCabeza() {
        return cabeza;
    }

    /**
     * Modifica la cabeza de la lista.
     *
     * @param cabeza Nuevo nodo cabeza
     */
    public void setCabeza(NodoDoble cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * Obtiene la cola de la lista.
     *
     * @return Nodo cola
     */
    public NodoDoble getCola() {
        return cola;
    }

    /**
     * Modifica la cola de la lista.
     *
     * @param cola Nuevo nodo cola
     */
    public void setCola(NodoDoble cola) {
        this.cola = cola;
    }
}
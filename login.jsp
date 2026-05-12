package persistencia;

import estructura.NodoDoble;
import estructura.ListaDoble;
import modelo.Ticket;
import java.io.*;

public class ArchivoManager {

    private final String RUTA = System.getProperty("user.home") + File.separator + "tickets.txt";

    // 🔥 GUARDAR
    public void guardar(ListaDoble lista) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA));
        NodoDoble actual = lista.getCabeza();

        while (actual != null) {

            Ticket t = actual.dato;

            // ✅ Formato controlado (NO usar toString)
            bw.write(t.getId() + "," +
                     t.getPasajero() + "," +
                     t.getOrigen() + "," +
                     t.getDestino());

            bw.newLine();
            actual = actual.siguiente;
        }

        bw.close();
    }

    // 🔥 CARGAR
    public void cargar(ListaDoble lista) throws IOException {

        File f = new File(RUTA);
        if (!f.exists()) return;

        BufferedReader br = new BufferedReader(new FileReader(RUTA));
        String linea;

        while ((linea = br.readLine()) != null) {

            String[] d = linea.split(",");

            // ✅ Validación de seguridad
            if (d.length == 4) {
                Ticket t = new Ticket(d[0], d[1], d[2], d[3]);
                lista.insertarFinal(t);
            }
        }

        br.close();
    }
}
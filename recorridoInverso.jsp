package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;

@WebServlet("/descargar")
public class DescargarArchivoServlet extends HttpServlet {

    // =====================================================
    // DESCARGAR ARCHIVO TXT
    // =====================================================
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // =================================================
        // RUTA DEL ARCHIVO
        // =================================================
        String ruta = System.getProperty("user.home")
                + File.separator
                + "tickets.txt";

        File archivo = new File(ruta);

        // =================================================
        // VALIDAR EXISTENCIA
        // =================================================
        if (!archivo.exists()) {

            response.setContentType("text/html;charset=UTF-8");

            response.getWriter().println(
                    "<h2>El archivo no existe.</h2>"
            );

            return;
        }

        // =================================================
        // CONFIGURAR DESCARGA
        // =================================================
        response.setContentType("text/plain");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=tickets.txt"
        );

        // =================================================
        // ENVIAR ARCHIVO
        // =================================================
        FileInputStream fis = new FileInputStream(archivo);

        OutputStream os = response.getOutputStream();

        byte[] buffer = new byte[1024];

        int bytesLeidos;

        while ((bytesLeidos = fis.read(buffer)) != -1) {

            os.write(buffer, 0, bytesLeidos);
        }

        fis.close();
        os.close();
    }
}
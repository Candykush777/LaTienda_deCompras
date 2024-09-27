import database.TiendaConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import repositories.ProductRepository;
import view.Tienda;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Entrada {

    public static void main(String[] args) {

        // Cargar productos en la base de datos
        cargarProductos();

        // Ejecutar la interfaz gráfica en el hilo de despacho de eventos
        SwingUtilities.invokeLater(() -> {
            Tienda tienda = new Tienda();
            tienda.setVisible(true);
        });
    }
private static void cargarProductos(){
        BufferedReader br = null;
        Connection connection = TiendaConnection.getConnection();
        ProductRepository productRepository = new ProductRepository(connection);  // Nuevo

        try {
            URL url = new URL("https://dummyjson.com/products");
            HttpURLConnection connectionHttp = (HttpURLConnection) url.openConnection();
            br = new BufferedReader(new InputStreamReader(connectionHttp.getInputStream()));
            String lectura = br.readLine();
            JSONObject respuesta = new JSONObject(lectura);
            JSONArray products = respuesta.getJSONArray("products");

            // Ahora insertamos cada producto usando el ProductRepository
            for (int i = 0; i < products.length(); i++) {
                JSONObject product = products.getJSONObject(i);
                productRepository.insertProduct(product);  // Llamada a método de inserción
            }

            System.out.println("Productos cargados con éxito en la bbdd");

        } catch (MalformedURLException e) {
            System.out.println("Error en la codificación de la URL");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de conexión a internet");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al insertar los datos en SQL");
            System.out.println(e.getMessage());
        } finally {
            if (connection != null) TiendaConnection.closeConnection();
        }
    }
}
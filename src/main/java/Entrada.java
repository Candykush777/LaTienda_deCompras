import database.TiendaConnection;
import org.json.JSONArray;
import org.json.JSONObject;

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

        BufferedReader br = null;
        Connection connection = TiendaConnection.getConnection();
        PreparedStatement preparedStatement = null;


//URL ---> https://dummyjson.com/products
        try {
            URL url = new URL("https://dummyjson.com/products");
            //HTTPConnection --> abrir la URL
            HttpURLConnection connectionHttp = (HttpURLConnection) url.openConnection();
            //BufferedReader --> leer la contestacion de la pagina -> TXT
            br = new BufferedReader(new InputStreamReader(connectionHttp.getInputStream()));
            String lectura = br.readLine();  //System.out.println(lectura);  lee el jason en consola
            JSONObject respuesta = new JSONObject(lectura);
            JSONArray products = respuesta.getJSONArray("products");
           /* for (int i = 0; i < products.length(); i++) {

                JSONObject product =products.getJSONObject(i);

                String title = product.getString("title");
                String price = String.valueOf(product.getDouble("price"));
                String id = String.valueOf(product.getInt("id"));
                System.out.println(title + " " + price + " " +id);
            System.out.println(respuesta);
            pero lo queremos pAsar de texto a jason   aqui sacamos la lista de lo pedido como ejemplo
            }*/

            //Preparamos la query, en este caso queremos insertar los datos a la bbdd desde jason

            String insertQuery = "INSERT INTO products " +
                    "(id, title, description, category, price, discountPercentage, rating, stock, sku, weight, dimensions_width," +
                    " dimensions_height, dimensions_depth, warrantyInformation, shippingInformation, availabilityStatus, images, thumbnail)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            for (int i = 0; i < products.length(); i++) {

                JSONObject product = products.getJSONObject(i);

                int id = product.getInt("id");
                String title = product.getString("title");
                String description = product.getString("description");
                String category = product.getString("category");
                double price = product.getDouble("price");
                double discountPercentage = product.getDouble("discountPercentage");
                double rating = product.getDouble("rating");
                int stock = product.getInt("stock");
                String sku = product.getString("sku");
                double weight = product.getDouble("weight");
                JSONObject dimensions = product.getJSONObject("dimensions");
                double dimensions_width = dimensions.getDouble("width");
                double dimensions_height = dimensions.getDouble("height");
                double dimensions_depth = dimensions.getDouble("depth");
                String warrantyInformation = product.getString("warrantyInformation");
                String shippingInformation = product.getString("shippingInformation");
                String availabilityStatus = product.getString("availabilityStatus");
                JSONArray imagesArray =product.getJSONArray("images");
                String images = imagesArray.toString();
                String thumbnail = product.getString("thumbnail");

                //Preparar y ejecutar el statement


                preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, title);
                preparedStatement.setString(3, description);
                preparedStatement.setString(4, category);
                preparedStatement.setDouble(5, price);
                preparedStatement.setDouble(6, discountPercentage);
                preparedStatement.setDouble(7, rating);
                preparedStatement.setInt(8, stock);
                preparedStatement.setString(9, sku);
                preparedStatement.setDouble(10, weight);
                preparedStatement.setDouble(11, dimensions_width);
                preparedStatement.setDouble(12, dimensions_height);
                preparedStatement.setDouble(13, dimensions_depth);
                preparedStatement.setString(14, warrantyInformation);
                preparedStatement.setString(15, shippingInformation);
                preparedStatement.setString(16, availabilityStatus);
                preparedStatement.setString(17, images);
                preparedStatement.setString(18, thumbnail);

                preparedStatement.executeUpdate(); //ejecutar la insercion


            }

            System.out.println(" Productos cargados con éxito en la bbdd ");


        } catch (MalformedURLException e) {

            System.out.println("Error en la codificacion de la URL");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de internet");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al insertar los datos en SQL");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) TiendaConnection.closeConnection();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos");
                System.out.println(e.getMessage());
            }

        }

    }
}

package repositories;

import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductRepository {

    private Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    public void insertProduct(JSONObject product) throws SQLException {

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
                "(title, description, category, price, discountPercentage, rating, stock, sku, weight, dimensions_width," +
                " dimensions_height, dimensions_depth, warrantyInformation, shippingInformation, availabilityStatus, images, thumbnail)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );";

        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);


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
        String images = product.getJSONArray("images").toString();
        String thumbnail = product.getString("thumbnail");

        // Configurar parámetros
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, description);
        preparedStatement.setString(3, category);
        preparedStatement.setDouble(4, price);
        preparedStatement.setDouble(5, discountPercentage);
        preparedStatement.setDouble(6, rating);
        preparedStatement.setInt(7, stock);
        preparedStatement.setString(8, sku);
        preparedStatement.setDouble(9, weight);
        preparedStatement.setDouble(10, dimensions_width);
        preparedStatement.setDouble(11, dimensions_height);
        preparedStatement.setDouble(12, dimensions_depth);
        preparedStatement.setString(13, warrantyInformation);
        preparedStatement.setString(14, shippingInformation);
        preparedStatement.setString(15, availabilityStatus);
        preparedStatement.setString(16, images);
        preparedStatement.setString(17, thumbnail);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}

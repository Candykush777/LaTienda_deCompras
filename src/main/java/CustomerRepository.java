import database.TiendaConnection;
import model.Customer;

import java.sql.*;

public class CustomerRepository {

    private Customer customer;

    //tener todas las acciones CRUD que necesito del modelo Customer

    // INSERT - SELECT - UPDATE - DELETE -> CONNECTION ¡¡¡¡

    //Statement -> C-U-D -- se codifica a "ciegas" y el motor se fia de la codificación
    //PrepareStatement -> C-U-D se codifica parçametros y el motor ya tiene la codificación terminada
    // execute (SQL) -> "Insert into alumnos () VALUES ()" -> bool devuelve si hay fallo o no hay fallo
    // executeUpadate(SQL) -> "Insert into alumnos () VALUES()" -> int, numero filas afectadas
    //ResultSet R

    public void insertarCustomer(Customer newCustomer) {

        Connection connection = TiendaConnection.getConnection();
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
//INSERT
            String query = "INSERT INTO customer(name,first_lastname,second_lastname,email,password,phone) VALUES (?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newCustomer.getName());
            preparedStatement.setString(2, newCustomer.getFirst_lastname());
            preparedStatement.setString(3, newCustomer.getSecond_lastname());
            preparedStatement.setString(4, newCustomer.getEmail());
            preparedStatement.setString(5, newCustomer.getPassword());
            preparedStatement.setInt(6, newCustomer.getPhone());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("Fallo en la sentencia SQL");
            System.out.println(e.getMessage());
        } finally {

            //Cerramos conexión
            TiendaConnection.closeConnection();
            connection = null;
        }
    }

    //DELETE

    public void eliminarCustomer(int id) {

        Connection connection = TiendaConnection.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            String query = "DELETE FROM customer WHERE id = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int filasafectadas = preparedStatement.executeUpdate();

            if (filasafectadas > 0) {
                System.out.println("Customer eliminado correctamente ");
            } else {
                System.out.println("No se encuentra el Customer con el id especificado");
            }

            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Se detecta error al eliminar el customer");
            System.out.println(e.getMessage());
        } finally {

            TiendaConnection.closeConnection();

            connection = null;
        }

    }

    //UPDATE

    public void actualizarCustomer(Customer customer) {

        Connection connection = TiendaConnection.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            String query = "UPDATE customer SET name = ?, first_lastname = ?, second_lastname = ?, email = ?,password = ?,phone = ? WHERE id = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getFirst_lastname());
            preparedStatement.setString(3, customer.getSecond_lastname());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getPassword());
            preparedStatement.setInt(6, customer.getPhone());
            preparedStatement.setInt(7, customer.getId());

            int filaafctadas = preparedStatement.executeUpdate();

            if (filaafctadas > 0) {
                System.out.println("Customer actualizado correctamente");
            } else {
                System.out.println("no se encontró ningun Customer con ese id");
            }
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar el Customer : " + e.getMessage());
            System.out.println(e.getMessage());
        } finally {
            TiendaConnection.closeConnection();
            connection = null;
        }

    }

    //READ

    public void obtenerCustomerPorId(int id) {

        Connection connection = TiendaConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resulset = null;


        try {


            String query = "SELECT * FROM customer WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resulset = preparedStatement.executeQuery();

            if (resulset.next()) {

                customer = new Customer(


                        resulset.getString("name"),
                        resulset.getString("first_lastname"),
                        resulset.getString("second_lastname"),
                        resulset.getString("email"),
                        resulset.getString("password"),
                        resulset.getInt("id"),
                        resulset.getInt("phone"));

                //Imprimimos los datos del Customer

                System.out.println("Name : " + customer.getName());
                System.out.println("First lastname : " + customer.getFirst_lastname());
                System.out.println("Second lastname : " + customer.getSecond_lastname());
                System.out.println("Email : " + customer.getEmail());
                System.out.println("Password : " + customer.getPassword());
                System.out.println("ID : " + customer.getId());
                System.out.println("Phone : " + customer.getPhone());

            } else {

                System.out.println("No se encontró el Customer con el ID : " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el Customer");
            System.out.println(e.getMessage());

            //Vamos a cerrar recursos en este método
        } finally {

            try {
                if (resulset != null) resulset.close();
                if (preparedStatement != null) preparedStatement.close();
                TiendaConnection.closeConnection();
                connection = null;
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos");
                System.out.println(e.getMessage());
            }
        }


    }

}


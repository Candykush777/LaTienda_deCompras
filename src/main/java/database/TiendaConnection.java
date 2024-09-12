package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TiendaConnection {

    static Connection connection = null;


    private static void createConnection() {

        //cargar el Driver de memoria


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //abrir conexion
            //uri jdbc:mysql://127.0.0.1/curso_ue
            String uri = "jdbc:mysql://127.0.0.1:3306/almacen";
            //3306 e sel puerto remotoq ue será mapeado
            //abrir la conexión desde una uri, con usuario que tiene una pass
            connection = DriverManager.getConnection(uri, "root", "");


        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el Driver");
            System.out.println(e.getMessage());

            //error en el jdbc

        } catch (SQLException e) {
            System.out.println("Error en la ejecución de SQL");
            System.out.println(e.getMessage());

            //error en SQL, puede una letra que falta etc

        }


    }

    public static Connection getConnection(){

        if(connection==null){
            //creamos la conexion

            createConnection();
        }
        return connection;

    }

    public static void closeConnection(){

        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            System.out.println("Error en el creado de la bbdd");
            System.out.println(e.getMessage());
        }

    }


}

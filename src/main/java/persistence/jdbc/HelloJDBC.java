package persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJDBC {
    public static void main(String[] args) {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet result = null;
        String url = "jdbc:mysql://localhost:3306/jee";
        String user = "root";
        String pass = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, pass);
            sentencia = conexion.createStatement();
            System.out.println("OK. Driver cargado");
        } catch (ClassNotFoundException e) {
            System.out.println("Imposible cargar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Imposible conectar: " + e.getMessage());
        }

        try {
            sentencia
                    .executeUpdate("CREATE TABLE IF NOT EXISTS tabla1 (id1 INT PRIMARY KEY,nombre CHAR(20) DEFAULT '-')");
            System.out.println("OK. Tabla creada");
        } catch (SQLException e) {
            System.out.println("Creación de tabla fallida: " + e.getMessage());
        }

        try {
            sentencia.executeUpdate("INSERT tabla1 (id1) VALUES (3)");
            sentencia.executeUpdate("INSERT tabla1 VALUES (4,'Jesús')");
            sentencia.executeUpdate("INSERT tabla1 VALUES (5,'Juan')");
            System.out.println("OK. Datos introducidos en la tabla");
        } catch (SQLException e) {
            System.out.println("Insercción de datos de tabla fallida: " + e.getMessage());
        }

        try {
            result = sentencia.executeQuery("SELECT * FROM tabla1");
            while (result.next())
                System.out.println("    id1: " + result.getLong("id1") + ", nombre: "
                        + result.getString("nombre"));
            System.out.println("OK. Datos consultados en la tabla");
        } catch (SQLException e) {
            System.out.println("Consulta Fallida: " + e.getMessage());
        }

        try {
            sentencia.executeUpdate("DELETE FROM tabla1  WHERE id1=3");
            sentencia.executeUpdate("DELETE FROM tabla1  WHERE id1=4");
            sentencia.executeUpdate("DELETE FROM tabla1  WHERE id1=5");
            System.out.println("OK. Datos borrados de la tabla");
        } catch (SQLException e) {
            System.out.println("Borrado de datos de tabla fallida: " + e.getMessage());
        }

    }
}

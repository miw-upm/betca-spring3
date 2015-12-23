package persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
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
        } catch (ClassNotFoundException e) {
            System.out.println("Imposible cargar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Imposible conectar: " + e.getMessage());
        }
        try {
            System.out.println("Transaction...");
            // begin
            conexion.setAutoCommit(false);

            // sentencias SQL
            sentencia = conexion.createStatement();
            sentencia.executeUpdate("INSERT tabla1 VALUES (8,'Trans1')");
            sentencia.executeUpdate("INSERT tabla1 VALUES (8,'Trans2')");

            // Si se llega a este punto, todo ha ido bien
            conexion.commit();
        } catch (SQLException e) {
            try {
                // Hay problemas, se deshace todo
                conexion.rollback();
                System.out.println("OK. Deshaciendo por rollback... " + e.getMessage());
            } catch (SQLException e1) {
                System.out.println("ERROR (rollback): " + e1.getMessage());
            }
        } finally {
            try {
                conexion.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        try {
            result = sentencia.executeQuery("SELECT * FROM tabla1");
            while (result.next())
                System.out.println("id1: " + result.getLong("id1") + ", nombre: "
                        + result.getString("nombre"));
        } catch (SQLException e) {
            System.out.println("Consulta Fallida: " + e.getMessage());
        }

    }
}

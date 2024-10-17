package com.example.apppicodeorousuario.Config;



import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {

    private static final String IP = "10.0.2.2"; // Cambia esto a la IP de tu servidor
    private static final String PORT = "3306";
    private static final String DB = "restaurante"; // Nombre de tu base de datos
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection CONN() {
        Connection conn = null;
        String ConnURL = null;
        try {Class.forName("com.mysql.jdbc.Driver");
            ConnURL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DB + "?user=" + USER + "&password=" + PASSWORD;
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERROR", "SQLException: " + se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERROR", "ClassNotFoundException: " + e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR", "Exception: " + e.getMessage());
        }
        return conn;
    }

    public ResultSet obtenerNombresMenu() {
        ResultSet resultSet = null;
        String consulta = "SELECT NombreMenu FROM Menu";
        try (Connection conn = CONN();
             PreparedStatement stmt = conn.prepareStatement(consulta)) {
            resultSet = stmt.executeQuery();
        } catch (SQLException e) {
            Log.e("ERROR", "SQLException: " + e.getMessage());
        }
        return resultSet;
    }
}
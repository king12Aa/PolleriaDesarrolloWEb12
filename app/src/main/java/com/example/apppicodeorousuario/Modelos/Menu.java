package com.example.apppicodeorousuario.Modelos;





import android.util.Log;
import com.example.apppicodeorousuario.Config.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Menu {
    private int idMenu;
    private int idDescPlatos;
    private double costoMenu;
    private String nombreMenu;
    private int stock;

    // Constructor
    public Menu(int idMenu, int idDescPlatos, double costoMenu, String nombreMenu, int stock) {
        this.idMenu = idMenu;
        this.idDescPlatos = idDescPlatos;
        this.costoMenu = costoMenu;
        this.nombreMenu = nombreMenu;
        this.stock = stock;
    }

    // Constructor vacío para uso interno en la consulta
    public Menu() {}

    // Getters y setters
    public int getIdMenu() {
        return idMenu;
    }

    public int getIdDescPlatos() {
        return idDescPlatos;
    }

    public double getCostoMenu() {
        return costoMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public int getStock() {
        return stock;
    }

    public static ArrayList<Menu> obtenerMenus() {
        ArrayList<Menu> menus = new ArrayList<>();
        ConexionBD conexion = new ConexionBD();
        String query = "SELECT IdMenu, idDescPlatos, CostoMenu, NombreMenu, stock FROM Menu";

        try (Connection conn = conexion.CONN();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Menu menu = new Menu();
                menu.idMenu = rs.getInt("IdMenu");
                menu.idDescPlatos = rs.getInt("idDescPlatos");
                menu.costoMenu = rs.getDouble("CostoMenu");
                menu.nombreMenu = rs.getString("NombreMenu");
                menu.stock = rs.getInt("stock");
                menus.add(menu);
            }
        } catch (SQLException e) {
            Log.e("Menu", "Error al obtener los menús: " + e.getMessage());
        }
        return menus;
    }
}

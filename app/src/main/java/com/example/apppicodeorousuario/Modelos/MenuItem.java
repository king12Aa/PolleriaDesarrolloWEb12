package com.example.apppicodeorousuario.Modelos;


import android.util.Log;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import android.os.Parcel;
import android.os.Parcelable;

public class MenuItem implements Parcelable {
    private int idMenu;
    private int idDescPlatos;
    private double costoMenu;
    private String nombreMenu;
    private int stock;
    private DescMenu descMenu;

    public MenuItem(int idMenu, int idDescPlatos, double costoMenu, String nombreMenu, int stock) {
        this.idMenu = idMenu;
        this.idDescPlatos = idDescPlatos;
        this.costoMenu = costoMenu;
        this.nombreMenu = nombreMenu;
        this.stock = stock;
    }
    public String getDescripcionMenu() {
        if (descMenu != null) {
            return descMenu.getDescripcion();  // Obtener la descripción desde DescMenu
        } else {
            return "";  // Manejar caso donde no hay DescMenu asociado
        }
    }

    protected MenuItem(Parcel in) {
        idMenu = in.readInt();
        idDescPlatos = in.readInt();
        costoMenu = in.readDouble();
        nombreMenu = in.readString();
        stock = in.readInt();
    }

    public static final Creator<MenuItem> CREATOR = new Creator<MenuItem>() {
        @Override
        public MenuItem createFromParcel(Parcel in) {
            return new MenuItem(in);
        }

        @Override
        public MenuItem[] newArray(int size) {
            return new MenuItem[size];
        }
    };

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdDescPlatos() {
        return idDescPlatos;
    }

    public void setIdDescPlatos(int idDescPlatos) {
        this.idDescPlatos = idDescPlatos;
    }

    public double getCostoMenu() {
        return costoMenu;
    }

    public void setCostoMenu(double costoMenu) {
        this.costoMenu = costoMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idMenu);
        dest.writeInt(idDescPlatos);
        dest.writeDouble(costoMenu);
        dest.writeString(nombreMenu);
        dest.writeInt(stock);
    }

    @Override
    public int describeContents() {
        return 0;
    }




    public static List<MenuItem> getAllMenuItems(Connection conn) {
        List<MenuItem> menuItems = new ArrayList<>();
        String query = "SELECT * FROM Menu";

        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idMenu = rs.getInt("IdMenu");
                int idDescPlatos = rs.getInt("idDescPlatos");
                double costoMenu = rs.getDouble("CostoMenu");
                String nombreMenu = rs.getString("NombreMenu");
                int stock = rs.getInt("stock");
                menuItems.add(new MenuItem(idMenu, idDescPlatos, costoMenu, nombreMenu, stock));
            }
        } catch (SQLException e) {
            Log.e("MenuItem", "Error fetching menu items: " + e.getMessage());
        }

        return menuItems;
    }
}

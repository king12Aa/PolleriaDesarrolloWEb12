package com.example.apppicodeorousuario.Modelos;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.example.apppicodeorousuario.Config.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Mesa {
    private int idMesa;
    private String descripcion;
    private int idEstadoMesa;

    // Constructor
    public Mesa(int idMesa, String descripcion, int idEstadoMesa) {
        this.idMesa = idMesa;
        this.descripcion = descripcion;
        this.idEstadoMesa = idEstadoMesa;
    }

    // Getters y setters
    public int getIdMesa() {
        return idMesa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdEstadoMesa() {
        return idEstadoMesa;
    }

    public static ArrayList<Mesa> getMesas() {
        ArrayList<Mesa> mesas = new ArrayList<>();
        try {
            ConexionBD conexion = new ConexionBD();
            Connection conn = conexion.CONN();
            if (conn != null) {
                String query = "SELECT * FROM Mesa";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    mesas.add(new Mesa(rs.getInt("idMesa"), rs.getString("Descripcion"), rs.getInt("idEstadoMesa")));
                }
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mesas;
    }
}

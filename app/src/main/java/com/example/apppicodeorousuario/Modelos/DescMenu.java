package com.example.apppicodeorousuario.Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;

import android.os.Parcel;
import android.os.Parcelable;



public class DescMenu {
    private int idDescMenu;
    private String descripcion;

    // Getters y Setters
    public int getIdDescMenu() {
        return idDescMenu;
    }

    public void setIdDescMenu(int idDescMenu) {
        this.idDescMenu = idDescMenu;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
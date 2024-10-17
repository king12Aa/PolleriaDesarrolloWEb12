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

public class DetallePedido implements Parcelable {
    private int idDetallePedido;
    private int idPedido;
    private int idMenu;
    private int cantidad;
    private double monto;

    public DetallePedido(int idDetallePedido, int idPedido, int idMenu, int cantidad, double monto) {
        this.idDetallePedido = idDetallePedido;
        this.idPedido = idPedido;
        this.idMenu = idMenu;
        this.cantidad = cantidad;
        this.monto = monto;
    }

    protected DetallePedido(Parcel in) {
        idDetallePedido = in.readInt();
        idPedido = in.readInt();
        idMenu = in.readInt();
        cantidad = in.readInt();
        monto = in.readDouble();
    }

    public static final Creator<DetallePedido> CREATOR = new Creator<DetallePedido>() {
        @Override
        public DetallePedido createFromParcel(Parcel in) {
            return new DetallePedido(in);
        }

        @Override
        public DetallePedido[] newArray(int size) {
            return new DetallePedido[size];
        }
    };

    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idDetallePedido);
        dest.writeInt(idPedido);
        dest.writeInt(idMenu);
        dest.writeInt(cantidad);
        dest.writeDouble(monto);
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public static List<DetallePedido> getAllDetallesPedido(Connection conn) {
        List<DetallePedido> detalles = new ArrayList<>();
        String query = "SELECT * FROM DetallePedido";

        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idDetallePedido = rs.getInt("idDetallePedido");
                int idPedido = rs.getInt("idPedido");
                int idMenu = rs.getInt("idMenu");
                int cantidad = rs.getInt("cantidad");
                double monto = rs.getDouble("monto");
                detalles.add(new DetallePedido(idDetallePedido, idPedido, idMenu, cantidad, monto));
            }
        } catch (SQLException e) {
            Log.e("DetallePedido", "Error fetching detalles pedido: " + e.getMessage());
        }

        return detalles;
    }

}
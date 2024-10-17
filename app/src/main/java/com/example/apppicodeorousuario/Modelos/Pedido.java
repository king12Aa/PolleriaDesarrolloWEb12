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

public class Pedido implements Parcelable {
    private int idPedido;
    private int idEstadoPedido;
    private String horaPedido;
    private int idMesa;

    public Pedido(int idPedido, int idEstadoPedido, String horaPedido, int idMesa) {
        this.idPedido = idPedido;
        this.idEstadoPedido = idEstadoPedido;
        this.horaPedido = horaPedido;
        this.idMesa = idMesa;
    }

    protected Pedido(Parcel in) {
        idPedido = in.readInt();
        idEstadoPedido = in.readInt();
        horaPedido = in.readString();
        idMesa = in.readInt();
    }

    public static final Creator<Pedido> CREATOR = new Creator<Pedido>() {
        @Override
        public Pedido createFromParcel(Parcel in) {
            return new Pedido(in);
        }

        @Override
        public Pedido[] newArray(int size) {
            return new Pedido[size];
        }
    };

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(int idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public String getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idPedido);
        dest.writeInt(idEstadoPedido);
        dest.writeString(horaPedido);
        dest.writeInt(idMesa);
    }

    @Override
    public int describeContents() {
        return 0;
    }



    public static List<Pedido> getAllPedidos(Connection conn) {
        List<Pedido> pedidos = new ArrayList<>();
        String query = "SELECT * FROM Pedido";

        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idPedido = rs.getInt("idPedido");
                int idEstadoPedido = rs.getInt("idEstadoPedido");
                String horaPedido = rs.getString("horaPedido");
                int idMesa = rs.getInt("idMesa");
                pedidos.add(new Pedido(idPedido, idEstadoPedido, horaPedido, idMesa));
            }
        } catch (SQLException e) {
            Log.e("Pedido", "Error fetching pedidos: " + e.getMessage());
        }

        return pedidos;
    }
}

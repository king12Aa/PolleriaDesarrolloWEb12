package com.example.apppicodeorousuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;

import com.example.apppicodeorousuario.Modelos.Pedido;

public class PedidoController {

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
            Log.e("PedidoController", "Error fetching pedidos: " + e.getMessage());
        }

        return pedidos;
    }
}

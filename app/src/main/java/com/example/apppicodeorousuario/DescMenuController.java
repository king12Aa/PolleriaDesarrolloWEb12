package com.example.apppicodeorousuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;

import com.example.apppicodeorousuario.Modelos.DescMenu;


import com.example.apppicodeorousuario.Config.ConexionBD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DescMenuController {

    private ConexionBD conexionBD;

    public DescMenuController() {
        this.conexionBD = new ConexionBD();
    }

    public List<DescMenu> obtenerDescripciones() {
        List<DescMenu> descripciones = new ArrayList<>();
        Connection connection = conexionBD.CONN();
        if (connection != null) {
            try {
                String query = "SELECT * FROM DescMenu";
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    DescMenu descMenu = new DescMenu();
                    descMenu.setIdDescMenu(rs.getInt("idDescMenu"));
                    descMenu.setDescripcion(rs.getString("Descripcion"));
                    descripciones.add(descMenu);
                }
                rs.close();
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return descripciones;
    }
}

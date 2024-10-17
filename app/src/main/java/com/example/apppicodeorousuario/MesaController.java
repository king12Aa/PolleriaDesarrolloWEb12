package com.example.apppicodeorousuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;

import com.example.apppicodeorousuario.Modelos.Mesa;






    public class MesaController {
        public ArrayList<Mesa> obtenerMesas() {
            return Mesa.getMesas();
        }
    }

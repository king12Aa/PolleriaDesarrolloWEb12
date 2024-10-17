package com.example.apppicodeorousuario;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.apppicodeorousuario.Modelos.AppData;
import com.example.apppicodeorousuario.Modelos.Menu;
import com.example.apppicodeorousuario.Modelos.MenuItem;





public class DetalleMenuActivity extends AppCompatActivity {
    TextView textViewNombre, textViewDescripcion, textViewPrecio, textViewCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_menu);

        textViewNombre = findViewById(R.id.textViewNombre);
        textViewDescripcion = findViewById(R.id.textViewDescripcion);
        textViewPrecio = findViewById(R.id.textViewPrecio);
        textViewCantidad = findViewById(R.id.textViewCantidad);

        Menu selectedMenu = AppData.getInstance().getSelectedMenu();
        textViewNombre.setText(selectedMenu.getNombreMenu());
        textViewDescripcion.setText("Descripcion del plato"); // Esta debería venir de otra consulta si tienes más detalles.
        textViewPrecio.setText(String.valueOf(selectedMenu.getCostoMenu()));
        // Configura el textViewCantidad según las necesidades
    }
}



package com.example.apppicodeorousuario;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.apppicodeorousuario.MenuController;
import com.example.apppicodeorousuario.Modelos.AppData;
import com.example.apppicodeorousuario.Modelos.Menu;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewMenu = findViewById(R.id.listViewMenu);
        MenuController menuController = new MenuController();

        ArrayList<String> menus = new ArrayList<>();
        ArrayList<Menu> menuList = menuController.obtenerMenus();

        for (Menu menu : menuList) {
            menus.add(menu.getNombreMenu() + " - " + (menu.getStock() > 0 ? "Disponible" : "Agotado"));
        }

        ArrayAdapter<String> adapterMenu = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menus) {
            @Override
            public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {
                android.view.View view = super.getView(position, convertView, parent);
                TextView textView = view.findViewById(android.R.id.text1);
                if (menuList.get(position).getStock() > 0) {
                    textView.setTextColor(Color.GREEN);
                } else {
                    textView.setTextColor(Color.RED);
                }
                return view;
            }
        };
        listViewMenu.setAdapter(adapterMenu);

        listViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                Menu selectedMenu = menuList.get(position);
                if (selectedMenu.getStock() > 0) {
                    AppData.getInstance().setSelectedMenu(selectedMenu);
                    Intent intent = new Intent(MainActivity.this, DetalleMenuActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}

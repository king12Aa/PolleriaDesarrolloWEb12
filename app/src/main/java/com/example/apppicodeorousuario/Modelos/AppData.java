package com.example.apppicodeorousuario.Modelos;



import com.example.apppicodeorousuario.Modelos.Menu;

public class AppData {
    private static AppData instance = null;
    private Menu selectedMenu;

    private AppData() {}

    public static synchronized AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }

    public Menu getSelectedMenu() {
        return selectedMenu;
    }

    public void setSelectedMenu(Menu selectedMenu) {
        this.selectedMenu = selectedMenu;
    }
}

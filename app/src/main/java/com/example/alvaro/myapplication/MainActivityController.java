package com.example.alvaro.myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.quickbloxlibreria.QBAdmin;
import com.example.quickbloxlibreria.QBAdminListener;
import com.quickblox.core.model.QBBaseCustomObject;
import com.quickblox.customobjects.model.QBCustomObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alvaro on 28/11/16.
 */

public class MainActivityController implements View.OnClickListener, QBAdminListener {
    MainActivity vista;

    public MainActivityController(MainActivity vista){
        this.vista = vista;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == vista.botonRegistrar.getId()){
            vista.cambiaFragment(3);
        } else if(v.getId() == vista.botonIniciaSesionRegistro.getId()){
            vista.cambiaFragment(2);
        } else if (v.getId() == vista.botonLogin.getId()){
            if (!vista.EditUsuario.getText().toString().equals("") && !vista.EditPassw.getText().toString().equals(""))
                vista.qbAdmin.iniciarSesion(vista.EditUsuario.getText().toString(), vista.EditPassw.getText().toString());
        } else if (v.getId() == vista.botonRegistrarse.getId()){
            if (!vista.usuarioReg.getText().toString().equals("") && !vista.passwReg.getText().toString().equals(""))
                vista.qbAdmin.registrarse(vista.usuarioReg.getText().toString(), vista.passwReg.getText().toString());
        }
    }


    @Override
    public void logeado(boolean blLogeado) {
        if (blLogeado) {
            Intent intent = new Intent(vista, Main2Activity.class);
            vista.startActivity(intent);
            vista.finish();
        }
    }

    @Override
    public void registrado(boolean blRegistrado) {
        if (blRegistrado) {
            Intent intent = new Intent(vista, Main2Activity.class);
            vista.startActivity(intent);
            vista.finish();
        }
    }

    @Override
    public void datosDescargados(HashMap<Integer, String> datos) {

    }

}

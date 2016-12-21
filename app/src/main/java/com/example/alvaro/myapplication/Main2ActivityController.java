package com.example.alvaro.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.quickbloxlibreria.QBAdminListener;
import com.quickblox.core.Consts;
import com.quickblox.core.QBEntityCallback;
import com.quickblox.core.exception.QBResponseException;
import com.quickblox.core.model.QBBaseCustomObject;
import com.quickblox.core.request.QBRequestGetBuilder;
import com.quickblox.customobjects.QBCustomObjects;
import com.quickblox.customobjects.model.QBCustomObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alvaro on 13/12/16.
 */

public class Main2ActivityController implements View.OnClickListener, QBAdminListener {

    Main2Activity vista;
    String id;

    public Main2ActivityController(Main2Activity vista){
        this.vista = vista;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == vista.btnEspanol.getId()){
            id = "esp";
            vista.qbAdmin.selectTabla(id);
        }else if (v.getId() == vista.btnIngles.getId()){
            id = "eng";
            vista.qbAdmin.selectTabla(id);
        }

    }

    @Override
    public void logeado(boolean blLogeado) {

    }

    @Override
    public void registrado(boolean blRegistrado) {

    }

    @Override
    public void datosDescargados(HashMap<Integer, String> datos) {

        vista.text1.setText(datos.get(1).toString());
        vista.text2.setText(datos.get(2).toString());
        if(id.equals("esp")) {
            vista.btnEspanol.setText("Espanol");
            vista.btnIngles.setText("Ingles");
        } else {
            vista.btnEspanol.setText("Spanish");
            vista.btnIngles.setText("English");
        }
    }

}

package com.example.quickbloxlibreria;

import java.util.HashMap;

/**
 * Created by Alvaro on 1/12/2016.
 */

public interface QBAdminListener {
    public void logeado (boolean blLogeado);
    public void registrado (boolean blRegistrado);
    public  void datosDescargados (HashMap<Integer, String> datos);
}

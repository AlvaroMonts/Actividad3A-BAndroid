package com.example.quickbloxlibreria;


import android.app.Activity;
import android.os.Bundle;

import com.quickblox.auth.QBAuth;
import com.quickblox.auth.model.QBSession;
import com.quickblox.core.Consts;
import com.quickblox.core.QBEntityCallback;
import com.quickblox.core.QBSettings;
import com.quickblox.core.exception.QBResponseException;
import com.quickblox.core.helper.StringifyArrayList;
import com.quickblox.core.request.QBRequestGetBuilder;
import com.quickblox.customobjects.QBCustomObjects;
import com.quickblox.customobjects.model.QBCustomObject;
import com.quickblox.users.QBUsers;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Alvaro on 1/12/2016.
 */

public class QBAdmin {
    QBAdminListener listener;

    public QBAdmin(QBAdminListener listener, Activity activity){
        this.listener = listener;
        String APP_ID = "50017";
        String AUTH_KEY = "Oe732e2AuUmOema";
        String AUTH_SECRET = "DDa5778gV3eBszm";
        String ACCOUNT_KEY = "RMmAJBwgNwZZ1ArnNfig";
//
        QBSettings.getInstance().init(activity, APP_ID, AUTH_KEY, AUTH_SECRET);
        QBSettings.getInstance().setAccountKey(ACCOUNT_KEY);
    }


    public void iniciarSesion(final String usuario, final String password){
        QBUser user = new QBUser(usuario, password);
        QBUsers.signIn(user, new QBEntityCallback<QBUser>() {
            @Override
            public void onSuccess(QBUser user, Bundle params) {
                listener.logeado(true);
            }

            @Override
            public void onError(QBResponseException errors) {
                listener.logeado(false);
            }
        });
    }



    public void registrarse(String usuario, String password, String email){
        QBUser user = new QBUser(usuario, email, password);
        QBUsers.signUp(user, new QBEntityCallback<QBUser>() {
            @Override
            public void onSuccess(QBUser user, Bundle args) {
                listener.registrado(true);
            }

            @Override
            public void onError(QBResponseException errors) {
                listener.registrado(false);
            }
        });

    }




    public void startSesion(){
        QBAuth.createSession(new QBEntityCallback<QBSession>() {
            @Override
            public void onSuccess(QBSession session, Bundle params) {

            }

            @Override
            public void onError(QBResponseException errors) {

            }
        });

    }

    public void selectTabla (int idIdioma){


        QBRequestGetBuilder requestBuilder = new QBRequestGetBuilder();
        requestBuilder.eq("idi", idIdioma);

        QBCustomObjects.getObjects("idiomas", requestBuilder, new QBEntityCallback<ArrayList<QBCustomObject>>() {
            @Override
            public void onSuccess(ArrayList<QBCustomObject> customObjects, Bundle params) {

                HashMap <Integer, String> palabras = new HashMap<Integer, String>();


                for (int i = 0; i < customObjects.size(); i++){

                    palabras.put((Integer)customObjects.get(i).getFields().get("idp"),customObjects.get(i).getFields().get("valor").toString());

                }

                listener.datosDescargados(palabras);

            }

            @Override
            public void onError(QBResponseException errors) {

            }
        });
    }


    public void selectTema (String tema){


        QBRequestGetBuilder requestBuilder = new QBRequestGetBuilder();
        requestBuilder.eq("tema", tema);

        QBCustomObjects.getObjects("noticias", requestBuilder, new QBEntityCallback<ArrayList<QBCustomObject>>() {
            @Override
            public void onSuccess(ArrayList<QBCustomObject> customObjects, Bundle params) {

                HashMap <Integer, String> palabras = new HashMap<Integer, String>();


                for (int i = 0; i < customObjects.size(); i++){

                    palabras.put(i, customObjects.get(i).getFields().get("texto").toString());

                }

                listener.datosDescargados(palabras);

            }

            @Override
            public void onError(QBResponseException errors) {

            }
        });
    }



    public void selectNoticia (String noticia){


        QBRequestGetBuilder requestBuilder = new QBRequestGetBuilder();
        requestBuilder.eq("texto", noticia);

        QBCustomObjects.getObjects("noticias", requestBuilder, new QBEntityCallback<ArrayList<QBCustomObject>>() {
            @Override
            public void onSuccess(ArrayList<QBCustomObject> customObjects, Bundle params) {

                HashMap <Integer, String> palabras = new HashMap<Integer, String>();


                for (int i = 0; i < customObjects.size(); i++){

                    palabras.put(i, customObjects.get(i).getFields().get("noticia").toString());

                }

                listener.datosDescargados(palabras);

            }

            @Override
            public void onError(QBResponseException errors) {

            }
        });
}

package com.example.alvaro.myapplication;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.quickbloxlibreria.QBAdmin;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    LoginFragment loginFragment;
    RegistroFragment registroFragment;
    CreditoFragment creditoFragment;
    MainActivityController controlador;
    FragmentTransaction transaction;
    FragmentManager fm;
    Button botonRegistrar;
    Button botonLogin;
    Button botonIniciaSesionRegistro;
    Button botonRegistrarse;
    EditText EditUsuario;
    EditText EditPassw;
    EditText usuarioReg;
    EditText emailReg;
    EditText passwReg;

    QBAdmin qbAdmin;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();


        controlador = new MainActivityController(this);
        loginFragment = (LoginFragment) fm.findFragmentById(R.id.miFragmento);
        registroFragment = (RegistroFragment) fm.findFragmentById(R.id.fragmentRegistro);
        creditoFragment = (CreditoFragment) fm.findFragmentById(R.id.fragmentCredito);

        botonLogin = (Button) loginFragment.getView().findViewById(R.id.btnLogin);
        botonRegistrar = (Button) loginFragment.getView().findViewById(R.id.btnRegistro);
        botonIniciaSesionRegistro = (Button) registroFragment.getView().findViewById(R.id.btnIniciaSesionRegistro);
        botonRegistrarse = (Button) registroFragment.getView().findViewById(R.id.btnRegistrarse);

        botonLogin.setOnClickListener(controlador);
        botonRegistrar.setOnClickListener(controlador);
        botonIniciaSesionRegistro.setOnClickListener(controlador);
        botonRegistrarse.setOnClickListener(controlador);


        EditUsuario = (EditText) loginFragment.getView().findViewById(R.id.editTextUsername);
        EditPassw = (EditText) loginFragment.getView().findViewById(R.id.editTextPassword);

        usuarioReg = (EditText) registroFragment.getView().findViewById(R.id.editTextUsuarioR);
        emailReg = (EditText) registroFragment.getView().findViewById(R.id.editTextEmailR);
        passwReg = (EditText) registroFragment.getView().findViewById(R.id.editTextPasswR);


        qbAdmin = new QBAdmin(controlador, this);
        qbAdmin.startSesion();

        cambiaFragment(1);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void cambiaFragment(int fragment) {
        transaction = fm.beginTransaction();
        transaction.hide(creditoFragment);
        transaction.hide(loginFragment);
        transaction.hide(registroFragment);
        if (fragment == 1) {
            transaction.show(creditoFragment);
        } else if (fragment == 2) {
            transaction.show(loginFragment);
        } else if (fragment == 3) {
            transaction.show(registroFragment);
        }
        transaction.commitNow();
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
package com.example.kechaval.mysaveinstance;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    //CLASS STATIC
    public static class Datos implements Serializable{ String dt1,dt2,dt3,dt4,dt5; }


    EditText etDato1,etDato2,etDato3,etDato4,etDato5;
    TextView tvSave,tvTexto;
    final static String KEY_DATOS_CLASS ="DATOS";
    Datos mDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //haces esto o el onRestoreInstanceState
       // if (savedInstanceState != null) {
         //   mDatos =(Datos) savedInstanceState.getSerializable(KEY_DATOS_CLASS);
        //}

        ms("onCreate");
    }

    private void initView(){
        tvSave = findViewById(R.id.tvSave);
        etDato1 = findViewById(R.id.etDato1);
        etDato2 = findViewById(R.id.etDato2);
        etDato3 = findViewById(R.id.etDato3);
        etDato4 = findViewById(R.id.etDato4);
        etDato5 = findViewById(R.id.etDato5);
        tvTexto = findViewById(R.id.tvTexto);

    }

    private void ms(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        ms("onDestroy");
        super.onDestroy();
    }

    /**
     *
     * Este metodo es llamado antes de que la orientacion de la pantalla cambie
     * podemos guardar los valores cuando la pantalla se a redibujado
     *
     */

    @Override
    public void onSaveInstanceState(Bundle outState) {

        mDatos= new Datos();
        mDatos.dt1 = etDato1.getText().toString();
        mDatos.dt2 = etDato2.getText().toString();
        mDatos.dt3 = etDato3.getText().toString();
        mDatos.dt4 = etDato4.getText().toString();
        mDatos.dt5 = etDato5.getText().toString();

        outState.putSerializable(KEY_DATOS_CLASS,mDatos);
        super.onSaveInstanceState(outState);
    }

    /**
     * muestra los valores en la UI que fueron guardados antes de que la orientacion de la pantalla cambiara.
     *
     */

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        ms("onRestoreInstance");
        super.onRestoreInstanceState(savedInstanceState);
        Datos datos = (Datos) savedInstanceState.getSerializable(KEY_DATOS_CLASS);
        etDato1.setText(datos.dt1);
        etDato2.setText(datos.dt2);
        etDato3.setText(datos.dt3);
        etDato4.setText(datos.dt4);
        etDato5.setText(datos.dt5);

        tvTexto.setText(datos.dt1+datos.dt2+datos.dt3+datos.dt4+datos.dt5);
    }
}

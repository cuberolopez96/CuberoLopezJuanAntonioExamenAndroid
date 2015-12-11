package com.example.juanantonio.calculadoradivisasjuanantoniocubero;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Objects;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public RadioButton usd;
    public RadioButton jpy;
    public RadioButton bgn;
    public RadioButton czk;
    public TextView resultado;
    public EditText euros;
    private final double cusd = 1.0943;
    private final double cjpy = 132.97;
    private final double cczk = 27.021;
    private final double cbgn = 1.9558;
    public Button convertir;




    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usd = (RadioButton) findViewById(R.id.USD);
        jpy = (RadioButton) findViewById(R.id.JPY);
        bgn = (RadioButton) findViewById(R.id.BGN);
        czk = (RadioButton) findViewById(R.id.CZK);
        resultado = (TextView) findViewById(R.id.resultado);
        euros = (EditText) findViewById(R.id.editText);
        convertir = (Button) findViewById(R.id.convertir);


            convertir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(usd.isChecked()){

                        resultado.setText(euros.toString());

                    }
                    if(jpy.isChecked()){

                        try {
                            resultado.setText(multiplicar(cjpy));
                        } catch (Exception e) {
                            resultado.setText("Sintax Errors");
                        }

                    }
                    if(czk.isChecked()){

                        try {
                            resultado.setText(multiplicar(cczk));
                        } catch (Exception e) {
                            resultado.setText("Sintax Errors");
                        }

                    }
                    if(bgn.isChecked()){

                        try {
                            resultado.setText(multiplicar(cbgn));
                        } catch (Exception e) {
                            resultado.setText("Sintax Errors");
                        }

                    }
                    if(usd.isChecked()){

                        try {
                            resultado.setText(multiplicar(cusd));
                        } catch (Exception e) {
                            resultado.setText("Sintax Errors");
                        }

                    }
                }
            });


    }

    private double recogerValor() throws Exception {
        Pattern patron = Pattern.compile("^\\d+(\\.\\d+)?$");
        if(String.valueOf(euros.getText()).matches(patron.pattern())==false){
            throw new Exception();
        }


        return Double.parseDouble(String.valueOf(euros.getText()));
    }
    private  String multiplicar(double coeficiente) throws Exception {
        double resultado;
        resultado = recogerValor()*coeficiente;
        return ""+resultado;
    }


}

package com.globalscout;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;


public class TraduccionActivity extends AppCompatActivity {
    EditText textoATraducir;
    String traduccion, anterior;
    TextView textoTraducido, caracolizado;
    HorizontalScrollView contenedorCaracol;
    boolean codificacion = true;
    int clave;
    String textoDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traduccion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        clave = getIntent().getIntExtra(MainActivity.CLAVE,0);
        textoDato = getIntent().getStringExtra(MainActivity.TEXTO);
        textoATraducir = (EditText) findViewById(R.id.textoATraducir);
        textoTraducido = (TextView) findViewById(R.id.traduccion);
        switch (clave){
            case MainActivity.MURCIELAGO:
                getSupportActionBar().setTitle("Murcielago");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.DAME_TU_PICO:
                getSupportActionBar().setTitle("Dame tu pico");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.NUMERICA:
                getSupportActionBar().setTitle("Numerica");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.INVERTIDA:
                getSupportActionBar().setTitle("Invertida");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.BADEN_POWELL:
                getSupportActionBar().setTitle("Baden Powell");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.MORSE:
                getSupportActionBar().setTitle("Morse");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.MAS1:
                getSupportActionBar().setTitle("+1");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.MENOS1:
                getSupportActionBar().setTitle("-1");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.AGUJERITO:
                getSupportActionBar().setTitle("Agujerito");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.CENIT_POLAR:
                getSupportActionBar().setTitle("Cenit Polar");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.ROMANA:
                getSupportActionBar().setTitle("Romana");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.NEUMATICO:
                getSupportActionBar().setTitle("Neumatico");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.SUFAMELICO:
                getSupportActionBar().setTitle("Sufamelico");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.LAPIZ_NEGRO:
                getSupportActionBar().setTitle("Lapiz Negro");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.HUERFANITO:
                getSupportActionBar().setTitle("Huerfanito");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.ORQUIDEA:
                getSupportActionBar().setTitle("Orquidea");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.JULIO_CESAR:
                getSupportActionBar().setTitle("Julio Cesar");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.ABUELITO:
                getSupportActionBar().setTitle("Abuelito");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.EUCALIPTO:
                getSupportActionBar().setTitle("Eucalipto");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.HOMBRE:
                getSupportActionBar().setTitle("Hombre");
                textoATraducir.setHint("Texto a codificar");
                textoTraducido.setHint("codificacion");
                break;
            case MainActivity.AL_REVES:
                getSupportActionBar().setTitle("Al Reves");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.REINADO:
                getSupportActionBar().setTitle("Reinado");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.DON_MATIAS:
                getSupportActionBar().setTitle("Don Matias");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.CALENDARIO:
                getSupportActionBar().setTitle("Calendario");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.SIETE_CRUCES:
                getSupportActionBar().setTitle("Siete Cruces");
                textoATraducir.setHint("Texto a codificar");
                textoTraducido.setHint("codificacion");
                break;
            case MainActivity.PARRILLA_SIMPLE:
                getSupportActionBar().setTitle("Parrilla Simple");
                textoATraducir.setHint("Texto a codificar");
                textoTraducido.setHint("codificacion");
                break;
            case MainActivity.PARRILLA_COMPUESTA:
                getSupportActionBar().setTitle("Parrilla Compuesta");
                textoATraducir.setHint("Texto a codificar");
                textoTraducido.setHint("codificacion");
                break;
            case MainActivity.VOCAL:
                getSupportActionBar().setTitle("Vocal");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.ANGULO:
                getSupportActionBar().setTitle("Angulo");
                textoATraducir.setHint("Texto a codificar");
                textoTraducido.setHint("codificacion");
                break;
            case MainActivity.PZ:
                getSupportActionBar().setTitle("PZ");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.PARELINOFU:
                getSupportActionBar().setTitle("Parelinofu");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case MainActivity.CARACOL:
                getSupportActionBar().setTitle("Caracol");
                textoATraducir.setHint("Texto a codificar");
                textoTraducido.setHint("codificacion");
                break;
        }
        textoATraducir.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                traducir();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        traduccion = "";
        contenedorCaracol = (HorizontalScrollView) findViewById(R.id.contenedorCaracol);
        caracolizado = (TextView) findViewById(R.id.caracolizado);
        if(textoDato != null && textoDato.length() > 0){
            textoATraducir.setText(textoDato);
        }
    }

    public String aODeHombre(String texto){
        if(codificacion){
            textoATraducir.setHint("Texto a codificar");
            textoTraducido.setHint("codificacion");
            return Claves.aHombre(texto);
        }else{
            textoATraducir.setHint("Texto a traducir");
            textoTraducido.setHint("traduccion");
            return Claves.deHombre(texto);
        }
    }

    public void traducir() {
        contenedorCaracol.setVisibility(View.GONE);
        String texto = textoATraducir.getText().toString().toUpperCase() + "  ";
        switch(clave){
            case(MainActivity.MURCIELAGO):
                traduccion = Claves.murcielago(texto);
                Log.v("probando", "traduccion:" + traduccion);
                break;
            case(MainActivity.DAME_TU_PICO):
                traduccion = Claves.dameTuPico(texto);
                break;
            case(MainActivity.NUMERICA):
                traduccion = Claves.numerica(texto);
                break;
            case(MainActivity.INVERTIDA):
                traduccion = Claves.invertida(texto);
                break;
            case(MainActivity.BADEN_POWELL):
                traduccion = Claves.badenPowell(texto);
                break;
            case(MainActivity.MORSE):
                traduccion = Claves.aODeMorse(texto);
                break;
            case(MainActivity.MAS1):
                traduccion = Claves.M1(texto);
                break;
            case(MainActivity.MENOS1):
                traduccion = Claves.m1(texto);
                break;
            case(MainActivity.AGUJERITO):
                traduccion = Claves.agujerito(texto);
                break;
            case(MainActivity.CENIT_POLAR):
                traduccion = Claves.cenitPolar(texto);
                break;
            case(MainActivity.NEUMATICO):
                traduccion = Claves.neumatico(texto);
                break;
            case(MainActivity.ROMANA):
                traduccion = Claves.aODeRomana(texto);
                break;
            case(MainActivity.SUFAMELICO):
                traduccion = Claves.sufamelico(texto);
                break;
            case(MainActivity.LAPIZ_NEGRO):
                traduccion = Claves.lapizNegro(texto);
                break;
            case(MainActivity.HUERFANITO):
                traduccion = Claves.huerfanito(texto);
                break;
            case(MainActivity.ORQUIDEA):
                traduccion = Claves.orquidea(texto);
                break;
            case(MainActivity.JULIO_CESAR):
                traduccion = Claves.julioCesar(texto);
                break;
            case(MainActivity.ABUELITO):
                traduccion = Claves.abuelito(texto);
                break;
            case(MainActivity.EUCALIPTO):
                traduccion = Claves.eucalipto(texto);
                break;
            case(MainActivity.HOMBRE):
                traduccion = aODeHombre(texto);
                break;
            case(MainActivity.AL_REVES):
                traduccion = Claves.alReves(texto);
                break;
            case(MainActivity.REINADO):
                traduccion = Claves.reinado(texto);
                break;
            case(MainActivity.DON_MATIAS):
                traduccion = Claves.donMatias(texto);
                break;
            case(MainActivity.CALENDARIO):
                traduccion = Claves.aODeCalendario(texto);
                break;
            case(MainActivity.SIETE_CRUCES):
                traduccion = Claves.a7Cruces(texto);
                break;
            case(MainActivity.PARRILLA_SIMPLE):
                traduccion = Claves.aParrillaSimple(texto);
                break;
            case(MainActivity.PARRILLA_COMPUESTA):
                traduccion = Claves.aParrillaCompuesta(texto);
                break;
            case(MainActivity.VOCAL):
                traduccion = Claves.vocal(texto);
                break;
            case(MainActivity.ANGULO):
                traduccion = Claves.aAngulo(texto);
                break;
            case(MainActivity.PZ):
                traduccion = Claves.aODePZ(texto);
                break;
            case(MainActivity.PARELINOFU):
                traduccion = Claves.parelinofu(texto);
                break;
            case (MainActivity.CARACOL):
                contenedorCaracol.setVisibility(View.VISIBLE);
                caracolizado.setText(Claves.caracolizar(texto));
                traduccion = "";
                break;
        }
        textoTraducido.setText(getSmiledText(traduccion));
    }

    public Spannable getSmiledText(String text) {
        SpannableStringBuilder builder = new SpannableStringBuilder(text);
        if (Claves.getEmoticons().size() > 0) {
            int index;
            for (index = 0; index < builder.length(); index++) {
                if (Character.isLetter(builder.charAt(index)) && Character.toString(builder.charAt(index)).equals(Character.toString(builder.charAt(index)).toLowerCase())) {
                    for (Map.Entry<String, Integer> entry : Claves.getEmoticons().entrySet()) {
                        int length = entry.getKey().length();
                        if (index + length > builder.length())
                            continue;
                        if (builder.subSequence(index, index + length).toString().equals(entry.getKey())) {
                            builder.setSpan(new ImageSpan(this, entry.getValue()), index, index + length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            index += length - 1;
                            break;
                        }
                    }
                }
            }
        }
        return builder;
    }

    public void borrarTodo(View v){
        textoATraducir.setText("");
        textoTraducido.setText("");
        Toast.makeText(TraduccionActivity.this, "Los campos de texto y traduccion han sido limpiados", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.traduccion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuLimpiar:
                textoATraducir.setText("");
                textoTraducido.setText("");
                return true;
            case R.id.menuCambiar:
                codificacion = !codificacion;
                textoTraducido.setText(aODeHombre(textoATraducir.getText().toString()));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Intent resultIntent = new Intent();
        Log.v("probando", "Texto: " + textoATraducir.getText().toString());
        resultIntent.putExtra(MainActivity.TEXTO, textoATraducir.getText().toString());
        resultIntent.putExtra(MainActivity.TRADUCCION, textoTraducido.getText().toString());
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
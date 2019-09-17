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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;


public class TraduccionActivity extends AppCompatActivity {
    EditText textoATraducir;
    String traduccion, anterior;
    TextView textoTraducido, caracolizado, historial1, historialCodigo1, historial2, historialCodigo2, historial3, historialCodigo3, historial4, historialCodigo4, historial5, historialCodigo5, historial6, historialCodigo6, historial7, historialCodigo7, historial8, historialCodigo8, historial9, historialCodigo9, historial10, historialCodigo10;
    HorizontalScrollView contenedorCaracol;
    boolean codificacion = true;
    int clave;
    String textoDato;
    LinearLayout contenerHistorial1, contenerHistorial2, contenerHistorial3, contenerHistorial4, contenerHistorial5, contenerHistorial6, contenerHistorial7, contenerHistorial8, contenerHistorial9, contenerHistorial10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traduccion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        clave = getIntent().getIntExtra(Constantes.CLAVE,0);
        textoDato = getIntent().getStringExtra(Constantes.TEXTO);
        textoATraducir = (EditText) findViewById(R.id.textoATraducir);
        textoTraducido = (TextView) findViewById(R.id.traduccion);
        historial1 = (TextView) findViewById(R.id.historial1);
        historial2 = (TextView) findViewById(R.id.historial2);
        historial3 = (TextView) findViewById(R.id.historial3);
        historial4 = (TextView) findViewById(R.id.historial4);
        historial5 = (TextView) findViewById(R.id.historial5);
        historial6 = (TextView) findViewById(R.id.historial6);
        historial7 = (TextView) findViewById(R.id.historial7);
        historial8 = (TextView) findViewById(R.id.historial8);
        historial9 = (TextView) findViewById(R.id.historial9);
        historial10 = (TextView) findViewById(R.id.historial10);
        historialCodigo1 = (TextView) findViewById(R.id.historialcodigo1);
        historialCodigo2 = (TextView) findViewById(R.id.historialcodigo2);
        historialCodigo3 = (TextView) findViewById(R.id.historialcodigo3);
        historialCodigo4 = (TextView) findViewById(R.id.historialcodigo4);
        historialCodigo5 = (TextView) findViewById(R.id.historialcodigo5);
        historialCodigo6 = (TextView) findViewById(R.id.historialcodigo6);
        historialCodigo7 = (TextView) findViewById(R.id.historialcodigo7);
        historialCodigo8 = (TextView) findViewById(R.id.historialcodigo8);
        historialCodigo9 = (TextView) findViewById(R.id.historialcodigo9);
        historialCodigo10 = (TextView) findViewById(R.id.historialcodigo10);
        contenerHistorial1 = (LinearLayout) findViewById(R.id.contenedorHistorial1);
        contenerHistorial2 = (LinearLayout) findViewById(R.id.contenedorHistorial2);
        contenerHistorial3 = (LinearLayout) findViewById(R.id.contenedorHistorial3);
        contenerHistorial4 = (LinearLayout) findViewById(R.id.contenedorHistorial4);
        contenerHistorial5 = (LinearLayout) findViewById(R.id.contenedorHistorial5);
        contenerHistorial6 = (LinearLayout) findViewById(R.id.contenedorHistorial6);
        contenerHistorial7 = (LinearLayout) findViewById(R.id.contenedorHistorial7);
        contenerHistorial8 = (LinearLayout) findViewById(R.id.contenedorHistorial8);
        contenerHistorial9 = (LinearLayout) findViewById(R.id.contenedorHistorial9);
        contenerHistorial10 = (LinearLayout) findViewById(R.id.contenedorHistorial10);
        switch (clave){
            case Constantes.MURCIELAGO:
                getSupportActionBar().setTitle("Murcielago");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.DAME_TU_PICO:
                getSupportActionBar().setTitle("Dame tu pico");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.NUMERICA:
                getSupportActionBar().setTitle("Numerica");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.INVERTIDA:
                getSupportActionBar().setTitle("Invertida");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.BADEN_POWELL:
                getSupportActionBar().setTitle("Baden Powell");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.MORSE:
                getSupportActionBar().setTitle("Morse");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.MAS1:
                getSupportActionBar().setTitle("+1");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.MENOS1:
                getSupportActionBar().setTitle("-1");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.AGUJERITO:
                getSupportActionBar().setTitle("Agujerito");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.CENIT_POLAR:
                getSupportActionBar().setTitle("Cenit Polar");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.ROMANA:
                getSupportActionBar().setTitle("Romana");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.NEUMATICO:
                getSupportActionBar().setTitle("Neumatico");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.SUFAMELICO:
                getSupportActionBar().setTitle("Sufamelico");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.LAPIZ_NEGRO:
                getSupportActionBar().setTitle("Lapiz Negro");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.HUERFANITO:
                getSupportActionBar().setTitle("Huerfanito");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.ORQUIDEA:
                getSupportActionBar().setTitle("Orquidea");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.JULIO_CESAR:
                getSupportActionBar().setTitle("Julio Cesar");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.ABUELITO:
                getSupportActionBar().setTitle("Abuelito");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.EUCALIPTO:
                getSupportActionBar().setTitle("Eucalipto");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.HOMBRE:
                getSupportActionBar().setTitle("Hombre");
                textoATraducir.setHint("Texto a codificar");
                textoTraducido.setHint("codificacion");
                break;
            case Constantes.AL_REVES:
                getSupportActionBar().setTitle("Al Reves");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.REINADO:
                getSupportActionBar().setTitle("Reinado");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.DON_MATIAS:
                getSupportActionBar().setTitle("Don Matias");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.CALENDARIO:
                getSupportActionBar().setTitle("Calendario");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.SIETE_CRUCES:
                getSupportActionBar().setTitle("Siete Cruces");
                textoATraducir.setHint("Texto a codificar");
                textoTraducido.setHint("codificacion");
                break;
            case Constantes.PARRILLA_SIMPLE:
                getSupportActionBar().setTitle("Parrilla Simple");
                textoATraducir.setHint("Texto a codificar");
                textoTraducido.setHint("codificacion");
                break;
            case Constantes.PARRILLA_COMPUESTA:
                getSupportActionBar().setTitle("Parrilla Compuesta");
                textoATraducir.setHint("Texto a codificar");
                textoTraducido.setHint("codificacion");
                break;
            case Constantes.VOCAL:
                getSupportActionBar().setTitle("Vocal");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.ANGULO:
                getSupportActionBar().setTitle("Angulo");
                textoATraducir.setHint("Texto a codificar");
                textoTraducido.setHint("codificacion");
                break;
            case Constantes.PZ:
                getSupportActionBar().setTitle("PZ");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.PARELINOFU:
                getSupportActionBar().setTitle("Parelinofu");
                textoATraducir.setHint("Texto a traducir/codificar");
                textoTraducido.setHint("codificacion/traduccion");
                break;
            case Constantes.CARACOL:
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
                traducir(textoATraducir.getText().toString(),textoTraducido);
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
        armarHistorial(contenerHistorial1,Constantes.obtenerHistorial(1,this),historial1,historialCodigo1,1);
        armarHistorial(contenerHistorial2,Constantes.obtenerHistorial(2,this),historial2,historialCodigo2,2);
        armarHistorial(contenerHistorial3,Constantes.obtenerHistorial(3,this),historial3,historialCodigo3,3);
        armarHistorial(contenerHistorial4,Constantes.obtenerHistorial(4,this),historial4,historialCodigo4,4);
        armarHistorial(contenerHistorial5,Constantes.obtenerHistorial(5,this),historial5,historialCodigo5,5);
        armarHistorial(contenerHistorial6,Constantes.obtenerHistorial(6,this),historial6,historialCodigo6,6);
        armarHistorial(contenerHistorial7,Constantes.obtenerHistorial(7,this),historial7,historialCodigo7,7);
        armarHistorial(contenerHistorial8,Constantes.obtenerHistorial(8,this),historial8,historialCodigo8,8);
        armarHistorial(contenerHistorial9,Constantes.obtenerHistorial(9,this),historial9,historialCodigo9,9);
        armarHistorial(contenerHistorial10,Constantes.obtenerHistorial(10,this),historial10,historialCodigo10,10);
        contenerHistorial1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoATraducir.setText(Constantes.obtenerHistorial(1,TraduccionActivity.this));
            }
        });
        contenerHistorial2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoATraducir.setText(Constantes.obtenerHistorial(2,TraduccionActivity.this));
            }
        });
        contenerHistorial3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoATraducir.setText(Constantes.obtenerHistorial(3,TraduccionActivity.this));
            }
        });
        contenerHistorial4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoATraducir.setText(Constantes.obtenerHistorial(4,TraduccionActivity.this));
            }
        });
        contenerHistorial5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoATraducir.setText(Constantes.obtenerHistorial(5,TraduccionActivity.this));
            }
        });
        contenerHistorial6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoATraducir.setText(Constantes.obtenerHistorial(6,TraduccionActivity.this));
            }
        });
        contenerHistorial7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoATraducir.setText(Constantes.obtenerHistorial(7,TraduccionActivity.this));
            }
        });
        contenerHistorial8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoATraducir.setText(Constantes.obtenerHistorial(8,TraduccionActivity.this));
            }
        });
        contenerHistorial9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoATraducir.setText(Constantes.obtenerHistorial(9,TraduccionActivity.this));
            }
        });
        contenerHistorial10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoATraducir.setText(Constantes.obtenerHistorial(10,TraduccionActivity.this));
            }
        });
    }

    public void armarHistorial(LinearLayout contenedor, String texto, TextView textView1, TextView textView2, int codigo) {
        if(texto != null && texto.length() > 0){
            contenedor.setVisibility(View.VISIBLE);
            textView1.setText(Constantes.obtenerHistorial(codigo,this));
            traducir(textView1.getText().toString(),textView2);
        }else{
            contenedor.setVisibility(View.GONE);
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

    public void traducir(String textoAux, TextView traducido) {
        String texto = textoAux.toUpperCase() + "   ";
        contenedorCaracol.setVisibility(View.GONE);
        switch(clave){
            case(Constantes.MURCIELAGO):
                traduccion = Claves.murcielago(texto);
                Log.v("probando", "traduccion:" + traduccion);
                break;
            case(Constantes.DAME_TU_PICO):
                traduccion = Claves.dameTuPico(texto);
                break;
            case(Constantes.NUMERICA):
                traduccion = Claves.numerica(texto);
                break;
            case(Constantes.INVERTIDA):
                traduccion = Claves.invertida(texto);
                break;
            case(Constantes.BADEN_POWELL):
                traduccion = Claves.badenPowell(texto);
                break;
            case(Constantes.MORSE):
                traduccion = Claves.aODeMorse(texto);
                break;
            case(Constantes.MAS1):
                traduccion = Claves.M1(texto);
                break;
            case(Constantes.MENOS1):
                traduccion = Claves.m1(texto);
                break;
            case(Constantes.AGUJERITO):
                traduccion = Claves.agujerito(texto);
                break;
            case(Constantes.CENIT_POLAR):
                traduccion = Claves.cenitPolar(texto);
                break;
            case(Constantes.NEUMATICO):
                traduccion = Claves.neumatico(texto);
                break;
            case(Constantes.ROMANA):
                traduccion = Claves.aODeRomana(texto);
                break;
            case(Constantes.SUFAMELICO):
                traduccion = Claves.sufamelico(texto);
                break;
            case(Constantes.LAPIZ_NEGRO):
                traduccion = Claves.lapizNegro(texto);
                break;
            case(Constantes.HUERFANITO):
                traduccion = Claves.huerfanito(texto);
                break;
            case(Constantes.ORQUIDEA):
                traduccion = Claves.orquidea(texto);
                break;
            case(Constantes.JULIO_CESAR):
                traduccion = Claves.julioCesar(texto);
                break;
            case(Constantes.ABUELITO):
                traduccion = Claves.abuelito(texto);
                break;
            case(Constantes.EUCALIPTO):
                traduccion = Claves.eucalipto(texto);
                break;
            case(Constantes.HOMBRE):
                traduccion = aODeHombre(texto);
                break;
            case(Constantes.AL_REVES):
                traduccion = Claves.alReves(texto);
                break;
            case(Constantes.REINADO):
                traduccion = Claves.reinado(texto);
                break;
            case(Constantes.DON_MATIAS):
                traduccion = Claves.donMatias(texto);
                break;
            case(Constantes.CALENDARIO):
                traduccion = Claves.aODeCalendario(texto);
                break;
            case(Constantes.SIETE_CRUCES):
                traduccion = Claves.a7Cruces(texto);
                break;
            case(Constantes.PARRILLA_SIMPLE):
                traduccion = Claves.aParrillaSimple(texto);
                break;
            case(Constantes.PARRILLA_COMPUESTA):
                traduccion = Claves.aParrillaCompuesta(texto);
                break;
            case(Constantes.VOCAL):
                traduccion = Claves.vocal(texto);
                break;
            case(Constantes.ANGULO):
                traduccion = Claves.aAngulo(texto);
                break;
            case(Constantes.PZ):
                traduccion = Claves.aODePZ(texto);
                break;
            case(Constantes.PARELINOFU):
                traduccion = Claves.parelinofu(texto);
                break;
            case (Constantes.CARACOL):
                contenedorCaracol.setVisibility(View.VISIBLE);
                caracolizado.setText(Claves.caracolizar(texto));
                traduccion = "";
                break;
        }
        traducido.setText(getSmiledText(traduccion));
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
        resultIntent.putExtra(Constantes.TEXTO, textoATraducir.getText().toString());
        resultIntent.putExtra(Constantes.TRADUCCION, textoTraducido.getText().toString());
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
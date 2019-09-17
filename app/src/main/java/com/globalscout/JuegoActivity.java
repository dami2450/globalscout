package com.globalscout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;
import java.util.Random;

public class JuegoActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    String[] frases = {"hola vengo a flotar", "como te llamas", "carlitox jojojo", "siempre listo", "siempre mejor", "servir", "nunca te quedes a la deriva", "rema tu propia canoa hermano", "siempre adelante la meta alcanzaras", "el scout es leal y digno de toda confianza", "sono sono sono", "me llaman del bar de moe", "dejar el mundo mejor", "globalscout", "murcielago", "dame tu pico", "numerica", "invertida", "agujerito", "el lider es bueno, el lider es bello, no hay voluntad olvidate de ello", "conoce usted a don matias el señor q pisa un tren?", "garra blanca", "hermano gris", "pluma negra", "colmillo rojo", "todo por amor, nada por la fuerza, siempre lo mejor, siempre lo mejor"};
    int cantFrases = frases.length;
    int pos = -1;
    int puntos;
    int puntosClave;
    TextView puntaje, retoAleatorio;
    EditText respuesta;
    SharedPreferences puntosAGuardar;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        drawer.setDrawerListener(new DrawerLayout.DrawerListener() {

            private float last = 0;

            @Override
            public void onDrawerSlide(View arg0, float arg1) {

                View view = JuegoActivity.this.getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }

            @Override public void onDrawerStateChanged(int arg0) {}
            @Override public void onDrawerOpened(View arg0) {}
            @Override public void onDrawerClosed(View arg0) {}

        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        respuesta = (EditText) findViewById(R.id.respuesta);
        puntaje = (TextView) findViewById(R.id.puntaje);
        retoAleatorio = (TextView) findViewById(R.id.retoAleatorio);
        puntosAGuardar = getSharedPreferences("juegoGlobalScout", Context.MODE_PRIVATE);
        editor = puntosAGuardar.edit();
        puntos = puntosAGuardar.getInt("puntos", 0);
        puntaje.setText("puntaje: " + String.valueOf(puntos));
        nuevaPalabra(true);
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

    public void nuevaPalabra(boolean iniciando){
        Random rnd = new Random();
        int random;
        int random2;
        if(puntosAGuardar.getInt("posicion", -1) == -1 || !iniciando){
            random = (int) ((rnd.nextDouble() * cantFrases));
        } else{
            random = puntosAGuardar.getInt("posicion", -1);
        }
        if(puntosAGuardar.getInt("clave", -1) == -1 || !iniciando){
            random2 = (int) ((rnd.nextDouble() * 21) + 1);
        } else{
            random2 = puntosAGuardar.getInt("clave", -1);
        }
        pos = random;
        editor.putInt("posicion", random);
        editor.putInt("clave", random2);
        switch (random2){
            case(1):
                retoAleatorio.setText(Claves.murcielago(frases[random]) + "\n\n texto en murcielago");
                puntosClave = 2;
                break;
            case(2):
                retoAleatorio.setText(Claves.dameTuPico(frases[random]) + "\n\n dame tu pico");
                puntosClave = 2;
                break;
            case(3):
                retoAleatorio.setText(Claves.numerica(frases[random]) + "\n\n numerica");
                puntosClave = 4;
                break;
            case(4):
                retoAleatorio.setText(Claves.invertida(frases[random]) + "\n\n texto en invertida");
                puntosClave = 4;
                break;
            case(5):
                retoAleatorio.setText(Claves.badenPowell(frases[random]) + "\n\n texto en baden powell");
                puntosClave = 2;
                break;
            case(6):
                retoAleatorio.setText(Claves.aMorse(frases[random]) + "\n\n texto en morse");
                puntosClave = 4;
                break;
            case(7):
                retoAleatorio.setText(Claves.m1(frases[random]) + "\n\n texto en -1");
                puntosClave = 4;
                break;
            case(8):
                retoAleatorio.setText(Claves.M1(frases[random]) + "\n\n texto en +1");
                puntosClave = 4;
                break;
            case (9):
                retoAleatorio.setText(Claves.agujerito(frases[random]) + "\n\n texto en agujerito");
                puntosClave = 2;
                break;
            case (10):
                retoAleatorio.setText(Claves.cenitPolar(frases[random]) + "\n\n texto en cenit polar");
                puntosClave = 2;
                break;
            case (11):
                retoAleatorio.setText(Claves.aRomana(frases[random]) + "\n\n texto en romana");
                puntosClave = 4;
                break;
            case (12):
                retoAleatorio.setText(Claves.neumatico(frases[random]) + "\n\n texto en neumatico");
                puntosClave = 2;
                break;
            case (13):
                retoAleatorio.setText(Claves.sufamelico(frases[random]) + "\n\n texto en sufamelico");
                puntosClave = 2;
                break;
            case (14):
                retoAleatorio.setText(Claves.lapizNegro(frases[random]) + "\n\n texto en lapiz negro");
                puntosClave = 2;
                break;
            case (15):
                retoAleatorio.setText(Claves.huerfanito(frases[random]) + "\n\n texto en huerfanito");
                puntosClave = 2;
                break;
            case (16):
                retoAleatorio.setText(Claves.orquidea(frases[random]) + "\n\n texto en orquidea");
                puntosClave = 2;
                break;
            case (17):
                retoAleatorio.setText(Claves.julioCesar(frases[random]) + "\n\n texto en julio cesar");
                puntosClave = 2;
                break;
            case (18):
                retoAleatorio.setText(Claves.abuelito(frases[random]) + "\n\n texto en abuelito");
                puntosClave = 2;
                break;
            case (19):
                retoAleatorio.setText(Claves.eucalipto(frases[random]) + "\n\n texto en eucalipto");
                puntosClave = 2;
                break;
            case (20):
                retoAleatorio.setText(Claves.alReves(frases[random]) + "\n\n texto al reves");
                puntosClave = 1;
                break;
            case (21):
                retoAleatorio.setText(Claves.aHombre(frases[random]) + "\n\n texto en hombre");
                puntosClave = 10;
                break;
            case (22):
                retoAleatorio.setText(Claves.donMatias(frases[random]) + "\n\n texto en don matias");
                puntosClave = 10;
                break;
            case (23):
                retoAleatorio.setText(getSmiledText(Claves.a7Cruces(frases[random]) + "\n\n texto en 7 cruces"));
                puntosClave = 8;
                break;
            case (24):
                retoAleatorio.setText(getSmiledText(Claves.aParrillaSimple(frases[random]) + "\n\n texto en parrilla simple"));
                puntosClave = 8;
                break;
            case (25):
                retoAleatorio.setText(getSmiledText(Claves.aParrillaCompuesta(frases[random]) + "\n\n texto en parrilla compuesta"));
                puntosClave = 8;
                break;
        }
    }

    public void responder(View view){
        Log.v("comparando1", frases[pos]);
        Log.v("comparando2", respuesta.getText().toString());
        if(comparabilizar(frases[pos]).equals(comparabilizar(respuesta.getText().toString()))){
            int cantPalabras = frases[pos].split(" ").length;
            puntos = puntos + (cantPalabras*puntosClave);
        } else{
            puntos = puntos - 5;
        }
        puntaje.setText("puntaje: " + String.valueOf(puntos));
        respuesta.setText("");
        editor.putInt("puntos", puntos);
        editor.commit();
        nuevaPalabra(false);
    }

    public String comparabilizar(String texto){
        String resultado;
        resultado = texto.toLowerCase();
        resultado = resultado.replaceAll("á","a");
        resultado = resultado.replaceAll("é","e");
        resultado = resultado.replaceAll("í","i");
        resultado = resultado.replaceAll("ó","o");
        resultado = resultado.replaceAll("ú","u");
        String resultadoFinal = "";
        for(int i = 0; i<resultado.length(); i++){
            if(Character.isLetter(resultado.charAt(i))){
                resultadoFinal = resultadoFinal + resultado.charAt(i);
            }
        }
        return resultadoFinal;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        finish();
        switch (id) {
            case R.id.menuSemaforo:
                Constantes.semaforo(this);
                return true;
            case R.id.menuLinterna:
                Constantes.linternaMorse(this);
                return true;
            case R.id.menuTeclado:
                Constantes.tecladoEspecial(this);
                return true;
            case R.id.menuGuia:
                Constantes.guiaClaves(this);
                return true;
            case R.id.menuDoble:
                Constantes.clavesDobles(this);
                return true;
            case R.id.menuTriple:
                Constantes.clavesTriple(this);
                return true;
            case R.id.menuPreferencias:
                Constantes.preferencias(this);
                return true;
            default:
                return true;
        }
    }
}

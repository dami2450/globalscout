package com.globalscout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

public class codificacionSemaforaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    EditText textoASemaforear;
    ImageView animacionSemafora;
    int w;
    final int DURACION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codificacion_semafora);
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

                View view = codificacionSemaforaActivity.this.getCurrentFocus();
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

        textoASemaforear =  (EditText) findViewById(R.id.textoASemaforear);
        animacionSemafora = (ImageView) findViewById(R.id.animacionSemafora);
        Point size = new Point();
        Display display = getWindowManager().getDefaultDisplay();
        display.getSize(size);
        w = size.x;
        animacionSemafora.setMaxWidth(w);
        animacionSemafora.setMinimumWidth(w);
        animacionSemafora.setMaxHeight(w);
        animacionSemafora.setMinimumHeight(w);
    }

    public void semaforear(View view){
        View tecladoView = this.getCurrentFocus();
        if (tecladoView != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        String paraSemaforear = textoASemaforear.getText().toString().toUpperCase();
        int limite = paraSemaforear.length();
        boolean banderasNumeros = false;
        String anterior = "";
        int posicion = 0;
        AnimationDrawable animation = new AnimationDrawable();
        while (posicion < limite){
            String actual = "" + paraSemaforear.charAt(posicion);
            if(actual.equals(anterior)){
                animation.addFrame(obtenerDrawable(R.drawable.repeticion), 30);
            }
            anterior = actual;
            if((Character.isDigit(paraSemaforear.charAt(posicion)) && !banderasNumeros) || (Character.isLetter(paraSemaforear.charAt(posicion)) && banderasNumeros)){
                banderasNumeros = !banderasNumeros;
                animation.addFrame(obtenerDrawable(R.drawable.iniciofinnumerossemafora), DURACION);
            }
            switch (paraSemaforear.charAt(posicion)){
                case('1'):
                    animation.addFrame(obtenerDrawable(R.drawable.a1semafora), DURACION);
                    break;
                case('2'):
                    animation.addFrame(obtenerDrawable(R.drawable.b2semafora), DURACION);
                    break;
                case('3'):
                    animation.addFrame(obtenerDrawable(R.drawable.c3semafora), DURACION);
                    break;
                case('4'):
                    animation.addFrame(obtenerDrawable(R.drawable.d4semafora), DURACION);
                    break;
                case('5'):
                    animation.addFrame(obtenerDrawable(R.drawable.e5semafora), DURACION);
                    break;
                case('6'):
                    animation.addFrame(obtenerDrawable(R.drawable.f6semafora), DURACION);
                    break;
                case('7'):
                    animation.addFrame(obtenerDrawable(R.drawable.g7semafora), DURACION);
                    break;
                case('8'):
                    animation.addFrame(obtenerDrawable(R.drawable.h8semafora), DURACION);
                    break;
                case('9'):
                    animation.addFrame(obtenerDrawable(R.drawable.i9semafora), DURACION);
                    break;
                case('0'):
                    animation.addFrame(obtenerDrawable(R.drawable.k0semafora), DURACION);
                    break;
                case('A'):
                    animation.addFrame(obtenerDrawable(R.drawable.a1semafora), DURACION);
                    break;
                case('B'):
                    animation.addFrame(obtenerDrawable(R.drawable.b2semafora), DURACION);
                    break;
                case('C'):
                    animation.addFrame(obtenerDrawable(R.drawable.c3semafora), DURACION);
                    break;
                case('D'):
                    animation.addFrame(obtenerDrawable(R.drawable.d4semafora), DURACION);
                    break;
                case('E'):
                    animation.addFrame(obtenerDrawable(R.drawable.e5semafora), DURACION);
                    break;
                case('F'):
                    animation.addFrame(obtenerDrawable(R.drawable.f6semafora), DURACION);
                    break;
                case('G'):
                    animation.addFrame(obtenerDrawable(R.drawable.g7semafora), DURACION);
                    break;
                case('H'):
                    animation.addFrame(obtenerDrawable(R.drawable.h8semafora), DURACION);
                    break;
                case('I'):
                    animation.addFrame(obtenerDrawable(R.drawable.i9semafora), DURACION);
                    break;
                case('J'):
                    animation.addFrame(obtenerDrawable(R.drawable.jsemafora), DURACION);
                    break;
                case('K'):
                    animation.addFrame(obtenerDrawable(R.drawable.k0semafora), DURACION);
                    break;
                case('L'):
                    animation.addFrame(obtenerDrawable(R.drawable.lsemafora), DURACION);
                    break;
                case('M'):
                    animation.addFrame(obtenerDrawable(R.drawable.msemafora), DURACION);
                    break;
                case('N'):
                    animation.addFrame(obtenerDrawable(R.drawable.nsemafora), DURACION);
                    break;
                case('Ñ'):
                    animation.addFrame(obtenerDrawable(R.drawable.nsemafora), DURACION);
                    break;
                case('O'):
                    animation.addFrame(obtenerDrawable(R.drawable.osemafora), DURACION);
                    break;
                case('P'):
                    animation.addFrame(obtenerDrawable(R.drawable.psemafora), DURACION);
                    break;
                case('Q'):
                    animation.addFrame(obtenerDrawable(R.drawable.qsemafora), DURACION);
                    break;
                case('R'):
                    animation.addFrame(obtenerDrawable(R.drawable.rsemafora), DURACION);
                    break;
                case('S'):
                    animation.addFrame(obtenerDrawable(R.drawable.ssemafora), DURACION);
                    break;
                case('T'):
                    animation.addFrame(obtenerDrawable(R.drawable.tsemafora), DURACION);
                    break;
                case('U'):
                    animation.addFrame(obtenerDrawable(R.drawable.usemafora), DURACION);
                    break;
                case('V'):
                    animation.addFrame(obtenerDrawable(R.drawable.vsemafora), DURACION);
                    break;
                case('W'):
                    animation.addFrame(obtenerDrawable(R.drawable.wsemafora), DURACION);
                    break;
                case('X'):
                    animation.addFrame(obtenerDrawable(R.drawable.xsemafora), DURACION);
                    break;
                case('Y'):
                    animation.addFrame(obtenerDrawable(R.drawable.ysemafora), DURACION);
                    break;
                case('Z'):
                    animation.addFrame(obtenerDrawable(R.drawable.zsemafora), DURACION);
                    break;
                case(' '):
                    animation.addFrame(obtenerDrawable(R.drawable.espaciosemafora), DURACION);
                    break;
            }
            posicion = posicion + 1;
        }
        animation.addFrame(obtenerDrawable(R.drawable.findepista), DURACION);
        animacionSemafora.setBackground(animation);
        animation.start();
    }

    public void borrarTodoSemafora(View view){
        textoASemaforear.setText("");
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        finish();
        int id = item.getItemId();
        switch (id){
            case R.id.menuLinterna:
                MainActivity.linternaMorse(this);
                return true;
            case R.id.menuTeclado:
                MainActivity.tecladoEspecial(this);
                return true;
            case R.id.menuJuego:
                MainActivity.iniciarJuego(this);
                return true;
            case R.id.menuGuia:
                MainActivity.guiaClaves(this);
                return true;
            case R.id.menuDoble:
                MainActivity.clavesDobles(this);
                return true;
            case R.id.menuTriple:
                MainActivity.clavesTriple(this);
                return true;
            case R.id.menuPreferencias:
                MainActivity.preferencias(this);
                return true;
            default:
                return true;
        }
    }

    public Drawable obtenerDrawable(int id){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return getDrawable(id);
        }else{
            return getResources().getDrawable(id);
        }
    }
}

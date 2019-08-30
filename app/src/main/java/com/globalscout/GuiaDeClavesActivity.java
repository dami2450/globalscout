package com.globalscout;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class GuiaDeClavesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    final String DEFINICIONMURCIELAGO = "Esta clave consiste en escribir 'murcielago' en un renglon y abajo escribir '0123456789' para asignarle los numeros a las letras de 'murcielago' (como en la imagen guia), la clave consiste en reemplazar cada numero por la letra que tiene arriba y cada letra de 'murcielago' por el numero que tiene abajo, las letras y caracteres que no forman parte de 'murcielago' se escriben sin reemplazar";
    final String DEFINICIONDAMETUPICO = "Esta clave consiste en escribir  cada silaba de 'dame tu pico' en vertical una al lado de la otra de izquierda a derecha (como en la imagen guia), la clave consiste en reemplazar cada letra por la letra que tiene arriba o abajo, las letras y caracteres que no forman parte de 'dame tu pico' se escriben sin reemplazar";
    final String DEFINICIONNUMERICA = "Esta clave consiste en escribir en asignarle a cada letra su lugar en el abecedario ('a' es 1, 'b' es 2 ...) y los numeros se reemplazan por las letras que reemplazan ('1' es 'a', '2' es 'b' ...), los demas caracteres se escriben sin reemplazar";
    final String DEFINICIONINVERTIDA = "Esta clave consiste en escribir en asignarle a cada letra la letra que tiene el mismo lugar en el abecedario de atras para adelante ('a' es 'z', 'b' es 'y' ...), los demas caracteres se escriben sin reemplazar";
    final String DEFINICIONBADENPOWELL = "Esta clave consiste en escribir 'baden' en un renglon y abajo escribir 'powel', la clave consiste en reemplazar cada letra por la letra que tiene arriba o abajo, las letras y caracteres que no forman parte de 'baden powell' se escriben sin reemplazar";
    final String DEFINICIONMAS1 = "Esta clave consiste en escribir en asignarle a cada letra la letra le sigue en el abecedario ('a' es 'b', 'b' es 'c' ... en el caso de la z, 'z' es 'a'), los demas caracteres se escriben sin reemplazar";
    final String DEFINICIONMENOS1 = "Esta clave consiste en escribir en asignarle a cada letra la letra anterior en el abecedario ('z' es 'y', 'y' es 'x' ... en el caso de la a, 'a' es 'z'), los demas caracteres se escriben sin reemplazar";
    final String DEFINICIONAGUJERITO = "Esta clave consiste en escribir 'agujerito' en un renglon y abajo escribir '123456789' para asignarle los numeros a las letras de 'agujerito' (como en la imagen guia), la clave consiste en reemplazar cada numero por la letra que tiene arriba y cada letra de 'agujerito' por el numero que tiene abajo, las letras, el '0' y los caracteres que no forman parte de 'agujerito' se escriben sin reemplazar";
    final String DEFINICIONCENITPOLAR = "Esta clave consiste en escribir 'cenit' en un renglon y abajo escribir 'polar', la clave consiste en reemplazar cada letra por la letra que tiene arriba o abajo, las letras y caracteres que no forman parte de 'cenit polar' se escriben sin reemplazar";
    final String DEFINICIONNEUMATICO = "Esta clave consiste en escribir 'neumatico' en un renglon y abajo escribir '123456789' para asignarle los numeros a las letras de 'neumatico' (como en la imagen guia), la clave consiste en reemplazar cada numero por la letra que tiene arriba y cada letra de 'neumatico' por el numero que tiene abajo, las letras, el '0' y los caracteres que no forman parte de 'neumatico' se escriben sin reemplazar";
    final String DEFINICIONSUFAMELICO = "Esta clave consiste en escribir  cada silaba de 'sufamelico' en vertical una al lado de la otra de izquierda a derecha (como en la imagen guia), la clave consiste en reemplazar cada letra por la letra que tiene arriba o abajo, las letras y caracteres que no forman parte de 'sufamelico' se escriben sin reemplazar";
    final String DEFINICIONLAPIZNEGRO = "Esta clave consiste en escribir 'lapiz' en un renglon y abajo escribir 'negro', la clave consiste en reemplazar cada letra por la letra que tiene arriba o abajo, las letras y caracteres que no forman parte de 'lapiz negro' se escriben sin reemplazar";
    final String DEFINICIONHUERFANITO = "Esta clave consiste en escribir 'huerfanito' en un renglon y abajo escribir '0123456789' para asignarle los numeros a las letras de 'huerfanito' (como en la imagen guia), la clave consiste en reemplazar cada numero por la letra que tiene arriba y cada letra de 'huerfanito' por el numero que tiene abajo, las letras y caracteres que no forman parte de 'huerfanito' se escriben sin reemplazar";
    final String DEFINICIONORQUIDEA = "Esta clave consiste en escribir 'orquidea' en un renglon y abajo escribir '12345678' para asignarle los numeros a las letras de 'orquidea' (como en la imagen guia), la clave consiste en reemplazar cada numero por la letra que tiene arriba y cada letra de 'orquidea' por el numero que tiene abajo, las letras, numeros y caracteres que no forman parte de 'orquidea' se escriben sin reemplazar";
    final String DEFINICIONJULIOCESAR = "Esta clave consiste en escribir 'julio' en un renglon y abajo escribir 'cesar', la clave consiste en reemplazar cada letra por la letra que tiene arriba o abajo, las letras y caracteres que no forman parte de 'julio cesar' se escriben sin reemplazar";
    final String DEFINICIONABUELITO = "Esta clave consiste en escribir 'abuelito' en un renglon y abajo escribir '12345678' para asignarle los numeros a las letras de 'abuelito' (como en la imagen guia), la clave consiste en reemplazar cada numero por la letra que tiene arriba y cada letra de 'abuelito' por el numero que tiene abajo, las letras, el '0' y los caracteres que no forman parte de 'agujerito' se escriben sin reemplazar";
    final String DEFINICIONEUCALIPTO = "Esta clave consiste en escribir 'eucalipto' en un renglon y abajo escribir '123456789' para asignarle los numeros a las letras de 'eucalipto' (como en la imagen guia), la clave consiste en reemplazar cada numero por la letra que tiene arriba y cada letra de 'eucalipto' por el numero que tiene abajo, las letras, el '0' y los caracteres que no forman parte de 'agujerito' se escriben sin reemplazar";
    final String DEFINICIONDONMATIAS = "Esta clave fue inventada por el creador de globalscout y consiste en escribir 'don matias' en un renglon y abajo escribir 'nod saitam (don y matias al reves)', la clave consiste en reemplazar cada letra por la letra que tiene arriba o abajo, las letras y caracteres que no forman parte de 'don' se escriben sin reemplazar";
    final String DEFINICIONCALENDARIO = "Esta clave fue inventada por el creador de globalscout y consiste en elegir un mes y un año cualquiera, ya que la clave se basa en el calendario de ese mes y año, cada letra se reemplaza por un dia de la semana y la repeticion de ese dia en el mes (por ejemple, si quiero hacer la clave eligiendo junio del 2018, para codificar la g, que es la 7ma letra del alfabeto, tenes que buscar el 7 de junio de 2018 en el calendario y como es el 1er jueves del mes la g se reemplaza por jue1, y para la ñ que es la 15va letra del alfabeto hay que buscar el 15 de junio del 2018 y como es el 3er viernes del mes se reemplaza por vie3, y al final en un renglon a parte se escribe una fecha que incluya el mes y el año sobre el que esta hecha la clave (con este formato 3/6/2018), eso permite que el lector sepa que calendario tenga que consultar para traducir el texto";
    final String DEFINICION7CRUCES = "Esta clave consiste en dibujar 7 cruces y numerarlas de izquierda a derecha, en el sector de arriba de la primer cruz se escribe 1 a y se sigue el alfabeto en sentido horario por los 4 sectores de la cruz, cuando se llena se continua el abecedario en el sector de arriba de la siguiente cruz y se siguen poniendo las letras en sentido horario, la clave consiste en dibuja el fragmento de cruz donde esta la letra, y en el mismo se pone el numero de cruz";
    final String DEFINICIONPARRILLASIMPLE = "Esta clave consiste en dibujar el tateti con letras de la imagen, la clave consiste en dibuja el fragmento del tateti donde esta la letra y un punto en la ubicacion de la letra en ese fragmento, para representar el lugar de la letra en el mismo tateti";
    final String DEFINICIONPARRILLACOMPUESTA = "Esta clave consiste en dibujar 3 tatetis y numerarlos de izquierda a derecha, escribir 1 a arriba a la izquierda en el 1er tateti y se sigue el alfabeto de izquierda a derecha y cuando se llena la linea continuar con el alfabeto en la siguiente linea, y cuando se llena el primer tateti repetir el procedimiento en el 2do y tercer tateti, la clave consiste en dibuja el fragmento de tateti donde esta la letra, y en el mismo se pone el numero de tateti";
    String DEFINICIONCASERA="";
    ImageView imagenGuia, prev, sig;
    TextView textoGuia;
    int w;
    int MAX_OPCIONES = 21;
    SharedPreferences claveGuardada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guia_de_claves);

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

                View view = GuiaDeClavesActivity.this.getCurrentFocus();
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
        claveGuardada = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if(claveGuardada.getString("DESCRIPCIONCASERA","") != null && claveGuardada.getString("DESCRIPCIONCASERA","").trim().length() > 0){
            MAX_OPCIONES++;
            DEFINICIONCASERA = claveGuardada.getString("DESCRIPCIONCASERA","");
        }
        prev = (ImageView) findViewById(R.id.prev);
        sig = (ImageView) findViewById(R.id.sig);
        imagenGuia = (ImageView) findViewById(R.id.imagenGuia);
        textoGuia = (TextView) findViewById(R.id.definicionClave);
        Display display = getWindowManager().getDefaultDisplay();
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.HONEYCOMB_MR2){
            Point size = new Point();
            display.getSize(size);
            w = size.x;
        } else{
            w = display.getWidth();
        }
        double h = w/2.9;
        imagenGuia.setMaxWidth(w);
        imagenGuia.setMinimumWidth(w);
        imagenGuia.setMaxHeight((int) h);
        imagenGuia.setMinimumHeight((int) h);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int claveGuardada = obtenerGuiaClaveSeleccionada();
                if(claveGuardada == 0){
                    claveGuardada = MAX_OPCIONES;
                }else{
                    claveGuardada--;
                }
                Log.v("probando", "prev: " + claveGuardada);
                guardarGuiaClaveSeleccionada(claveGuardada);
                mostrarDefinicion();
            }
        });
        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int claveGuardada = obtenerGuiaClaveSeleccionada();
                if(claveGuardada == MAX_OPCIONES){
                    claveGuardada = 0;
                }else{
                    claveGuardada++;
                }
                Log.v("probando", "sig: " + claveGuardada);
                guardarGuiaClaveSeleccionada(claveGuardada);
                mostrarDefinicion();
            }
        });
        mostrarDefinicion();
    }

    public void guardarGuiaClaveSeleccionada(int clave){
        SharedPreferences claveSeleccionada = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = claveSeleccionada.edit();
        editor.putInt("GUIACLAVESELECCIONADA",clave);
        editor.commit();
    }

    public int obtenerGuiaClaveSeleccionada(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return prefs.getInt("GUIACLAVESELECCIONADA",0);
    }

    public void mostrarDefinicion() {
        //String seleccion = lista.getSelectedItem().toString();
        switch(obtenerGuiaClaveSeleccionada()){
            case(0):
                textoGuia.setText(DEFINICIONMURCIELAGO);
                imagenGuia.setImageResource(R.drawable.guiamurcielago);
                break;
            case(1):
                textoGuia.setText(DEFINICIONDAMETUPICO);
                imagenGuia.setImageResource(R.drawable.guiadametupico);
                break;
            case(2):
                textoGuia.setText(DEFINICIONNUMERICA);
                imagenGuia.setImageResource(R.drawable.guianumerica);
                break;
            case(3):
                textoGuia.setText(DEFINICIONINVERTIDA);
                imagenGuia.setImageResource(R.drawable.guiainvertida);
                break;
            case(4):
                textoGuia.setText(DEFINICIONBADENPOWELL);
                imagenGuia.setImageResource(R.drawable.guiabadenpowell);
                break;
            case(5):
                textoGuia.setText(DEFINICIONMAS1);
                imagenGuia.setImageResource(R.drawable.guiamasuno);
                break;
            case(6):
                textoGuia.setText(DEFINICIONMENOS1);
                imagenGuia.setImageResource(R.drawable.guiamenosuno);
                break;
            case(7):
                textoGuia.setText(DEFINICIONAGUJERITO);
                imagenGuia.setImageResource(R.drawable.guiaagujerito);
                break;
            case(8):
                textoGuia.setText(DEFINICIONCENITPOLAR);
                imagenGuia.setImageResource(R.drawable.guiacenitpolar);
                break;
            case(9):
                textoGuia.setText(DEFINICIONNEUMATICO);
                imagenGuia.setImageResource(R.drawable.guianeumatico);
                break;
            case(10):
                textoGuia.setText(DEFINICIONSUFAMELICO);
                imagenGuia.setImageResource(R.drawable.guiasufamelico);
                break;
            case(11):
                textoGuia.setText(DEFINICIONLAPIZNEGRO);
                imagenGuia.setImageResource(R.drawable.guialapiznegro);
                break;
            case(12):
                textoGuia.setText(DEFINICIONHUERFANITO);
                imagenGuia.setImageResource(R.drawable.guiahuerfanito);
                break;
            case(13):
                textoGuia.setText(DEFINICIONORQUIDEA);
                imagenGuia.setImageResource(R.drawable.guiaorquidea);
                break;
            case(14):
                textoGuia.setText(DEFINICIONJULIOCESAR);
                imagenGuia.setImageResource(R.drawable.guiajuliocesar);
                break;
            case(15):
                textoGuia.setText(DEFINICIONABUELITO);
                imagenGuia.setImageResource(R.drawable.guiaabuelito);
                break;
            case(16):
                textoGuia.setText(DEFINICIONEUCALIPTO);
                imagenGuia.setImageResource(R.drawable.guiaeucalipto);
                break;
            case(17):
                textoGuia.setText(DEFINICIONDONMATIAS);
                imagenGuia.setImageResource(R.drawable.guiadonmatias);
                break;
            case(18):
                textoGuia.setText(DEFINICIONCALENDARIO);
                imagenGuia.setImageResource(R.drawable.guiacalendario);
                break;
            case(19):
                textoGuia.setText(DEFINICION7CRUCES);
                imagenGuia.setImageResource(R.drawable.guiasietecruces);
                break;
            case(20):
                textoGuia.setText(DEFINICIONPARRILLASIMPLE);
                imagenGuia.setImageResource(R.drawable.guiaparrillasimple);
                break;
            case(21):
                textoGuia.setText(DEFINICIONPARRILLACOMPUESTA);
                imagenGuia.setImageResource(R.drawable.guiaparrillacompuesta);
                break;
            default:
                textoGuia.setText(DEFINICIONCASERA);
                imagenGuia.setImageResource(R.drawable.guiaclavecasera);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        finish();
        switch (id){
            case R.id.menuSemaforo:
                MainActivity.semaforo(this);
                return true;
            case R.id.menuLinterna:
                MainActivity.linternaMorse(this);
                return true;
            case R.id.menuTeclado:
                MainActivity.tecladoEspecial(this);
                return true;
            case R.id.menuJuego:
                MainActivity.iniciarJuego(this);
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
}

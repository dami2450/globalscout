package com.globalscout;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;


public class ClavesDobles extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Spinner listaDoble;
    String[] datos = {"morse de murcielago", "morse de dame tu pico", "morse de numerica", "morse de invertida", "morse de baden powell", "morse de sufamelico", "morse de -1", "morse de +1", "morse de hombre", "morse de al reves", "morse de agujerito", "morse de abuelito", "morse de eucalipto", "morse de cenit polar", "morse de neumatico", "romana de dame tu pico", "romana de invertida", "romana de baden powell", "romana de sufamelico", "romana de -1", "romana de +1", "romana de hombre", "romana de al reves", "romana de cenit polar", "numerica de dame tu pico", "numerica de invertida", "numeroica de baden powell", "numerica de sufamelico", "numerica de -1", "numerica de +1", "numerica de homre", "numerica de al reves", "numerica de cenit polar"};
    EditText textoATraducirDoble;
    String traduccion;
    TextView textoTraducidoDoble;
    ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claves_dobles);

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

                View view = ClavesDobles.this.getCurrentFocus();
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


        listaDoble = (Spinner) findViewById(R.id.spinnerDoble);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
        listaDoble.setAdapter(adaptador);
        textoATraducirDoble = (EditText) findViewById(R.id.textoATraducirDoble);
        traduccion = "";
        textoTraducidoDoble = (TextView) findViewById(R.id.traduccionDoble);
    }

    public void traducirDoble(View view) {
        String texto = textoATraducirDoble.getText().toString().toUpperCase() + "  ";
        switch(listaDoble.getSelectedItemPosition()){
            case(0):
                traduccion = Claves.aMorse(Claves.murcielago(texto));
                break;
            case(1):
                traduccion = Claves.aMorse(Claves.dameTuPico(texto));
                break;
            case(2):
                traduccion = Claves.aMorse(Claves.numerica(texto));
                break;
            case(3):
                traduccion = Claves.aMorse(Claves.invertida(texto));
                break;
            case(4):
                traduccion = Claves.aMorse(Claves.badenPowell(texto));
                break;
            case(5):
                traduccion = Claves.aMorse(Claves.sufamelico(texto));
                break;
            case(6):
                traduccion = Claves.aMorse(Claves.m1(texto));
                break;
            case(7):
                traduccion = Claves.aMorse(Claves.M1(texto));
                break;
            case(8):
                traduccion = Claves.aMorse(Claves.aHombre(texto));
                break;
            case(9):
                traduccion = Claves.aMorse(Claves.alReves(texto));
                break;
            case(10):
                traduccion = Claves.aMorse(Claves.agujerito(texto));
                break;
            case(11):
                traduccion = Claves.aMorse(Claves.abuelito(texto));
                break;
            case(12):
                traduccion = Claves.aMorse(Claves.eucalipto(texto));
                break;
            case(13):
                traduccion = Claves.aMorse(Claves.cenitPolar(texto));
                break;
            case(14):
                traduccion = Claves.aMorse(Claves.neumatico(texto));
                break;
            case(15):
                traduccion = Claves.aRomana(Claves.dameTuPico(texto));
                break;
            case(16):
                traduccion = Claves.aRomana(Claves.invertida(texto));
                break;
            case(17):
                traduccion = Claves.aRomana(Claves.badenPowell(texto));
                break;
            case(18):
                traduccion = Claves.aRomana(Claves.sufamelico(texto));
                break;
            case(19):
                traduccion = Claves.aRomana(Claves.m1(texto));
                break;
            case(20):
                traduccion = Claves.aRomana(Claves.M1(texto));
                break;
            case(21):
                traduccion = Claves.aRomana(Claves.aHombre(texto));
                break;
            case(22):
                traduccion = Claves.aRomana(Claves.aHombre(texto));
                break;
            case(23):
                traduccion = Claves.aRomana(Claves.cenitPolar(texto));
                break;
            case(24):
                traduccion = Claves.numerica(Claves.dameTuPico(texto));
                break;
            case(25):
                traduccion = Claves.numerica(Claves.invertida(texto));
                break;
            case(26):
                traduccion = Claves.numerica(Claves.badenPowell(texto));
                break;
            case(27):
                traduccion = Claves.numerica(Claves.sufamelico(texto));
                break;
            case(28):
                traduccion = Claves.numerica(Claves.m1(texto));
                break;
            case(29):
                traduccion = Claves.numerica(Claves.M1(texto));
                break;
            case(30):
                traduccion = Claves.numerica(Claves.aHombre(texto));
                break;
            case(31):
                traduccion = Claves.numerica(Claves.alReves(texto));
                break;
            default:
                traduccion = Claves.numerica(Claves.cenitPolar(texto));
                break;
        }
        textoTraducidoDoble.setText(traduccion);
        mShareActionProvider.setShareIntent(createShareForecastIntentActualizado(traduccion));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_claves_dobles, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share_doble);
        // Get the provider and hold onto it to set/change the share intent.
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        mShareActionProvider.setShareIntent(createShareForecastIntentActualizado(""));
        return true;
    }

    private Intent createShareForecastIntentActualizado(String traducido) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, traducido);
        return shareIntent;
    }

    public void borrarTodoDoble (View view){
        textoATraducirDoble.setText("");
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        finish();
        int id = item.getItemId();
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
            case R.id.menuGuia:
                MainActivity.guiaClaves(this);
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

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


public class ClavesTriples extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Spinner listaTriple;
    String[] datos = {"morse de numerica de dame tu pico", "morse de numerica de invertida", "morse de numerica de baden powell", "morse de numerica de sufamelico", "morse de numerica de -1", "morse de numerica de +1", "morse de numerica de hombre", "morse de numerica de al reves", "morse de numerica de cenit polar"};
    EditText textoATraducirTriple;
    String traduccion;
    TextView textoTraducidoTriple;
    ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claves_triples);

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

                View view = ClavesTriples.this.getCurrentFocus();
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

        listaTriple = (Spinner) findViewById(R.id.spinnerTriple);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
        listaTriple.setAdapter(adaptador);
        textoATraducirTriple = (EditText) findViewById(R.id.textoATraducirTriple);
        traduccion = "";
        textoTraducidoTriple = (TextView) findViewById(R.id.traduccionTriple);
    }

    public void traducirTriple(View view) {
        //String seleccion = lista.getSelectedItem().toString();
        String texto = textoATraducirTriple.getText().toString().toUpperCase() + "  ";
        switch(listaTriple.getSelectedItemPosition()){
            case(0):
                traduccion = Claves.aMorse(Claves.numerica(Claves.dameTuPico(texto)));
                break;
            case(1):
                traduccion = Claves.aMorse(Claves.numerica(Claves.invertida(texto)));
                break;
            case(2):
                traduccion = Claves.aMorse(Claves.numerica(Claves.badenPowell(texto)));
                break;
            case(3):
                traduccion = Claves.aMorse(Claves.numerica(Claves.sufamelico(texto)));
                break;
            case(4):
                traduccion = Claves.aMorse(Claves.numerica(Claves.m1(texto)));
                break;
            case(5):
                traduccion = Claves.aMorse(Claves.numerica(Claves.M1(texto)));
                break;
            case(6):
                traduccion = Claves.aMorse(Claves.numerica(Claves.aHombre(texto)));
                break;
            case(7):
                traduccion = Claves.aMorse(Claves.numerica(Claves.alReves(texto)));
                break;
            default:
                traduccion = Claves.aMorse(Claves.numerica(Claves.cenitPolar(texto)));
                break;
        }
        textoTraducidoTriple.setText(traduccion);
        mShareActionProvider.setShareIntent(createShareForecastIntentActualizado(traduccion));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_claves_triples, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share_triple);
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

    public void borrarTodoTriple (View view){
        textoATraducirTriple.setText("");
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        finish();
        int id = item.getItemId();
        switch (id) {
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
            case R.id.menuDoble:
                MainActivity.clavesDobles(this);
                return true;
            default:
                return true;
        }
    }
}
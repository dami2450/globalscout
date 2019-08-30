package com.globalscout;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class TecladoEspecialActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView traducido7c;
    TextView traducidops;
    TextView traducidopc;
    RelativeLayout layout7c;
    RelativeLayout layoutpc;
    RelativeLayout layoutps;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.teclado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu7c:
                layout7c.setVisibility(View.VISIBLE);
                layoutpc.setVisibility(View.GONE);
                layoutps.setVisibility(View.GONE);
                traducido7c.setText("");
                return true;
            case R.id.menups:
                layout7c.setVisibility(View.GONE);
                layoutpc.setVisibility(View.GONE);
                layoutps.setVisibility(View.VISIBLE);
                traducidops.setText("");
                return true;
            case R.id.menupc:
                layout7c.setVisibility(View.GONE);
                layoutpc.setVisibility(View.VISIBLE);
                layoutps.setVisibility(View.GONE);
                traducidopc.setText("");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teclado_especial);
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

                View view = TecladoEspecialActivity.this.getCurrentFocus();
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
        traducido7c = (TextView) findViewById(R.id.textoTraducidoSieteCruces);
        traducido7c.setText("");
        traducidops = (TextView) findViewById(R.id.textoTraducidoParrillaSimple);
        traducidops.setText("");
        traducidopc = (TextView) findViewById(R.id.textoTraducidoParrillaCompuesta);
        traducidopc.setText("");
        layout7c = (RelativeLayout) findViewById(R.id.layoutSieteCruces);
        layoutpc = (RelativeLayout) findViewById(R.id.layoutParrillaCompuesta);
        layoutps = (RelativeLayout) findViewById(R.id.layoutParrillaSimple);
    }

    public void masA7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "A");
    }

    public void masB7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "B");
    }

    public void masC7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "C");
    }

    public void masD7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "D");
    }

    public void masE7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "E");
    }

    public void masF7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "F");
    }

    public void masG7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "G");
    }

    public void masH7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "H");
    }

    public void masI7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "I");
    }

    public void masJ7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "J");
    }

    public void masK7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "K");
    }

    public void masL7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "L");
    }

    public void masM7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "M");
    }

    public void masN7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "N");
    }

    public void masÑ7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "Ñ");
    }

    public void masO7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "O");
    }

    public void masP7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "P");
    }

    public void masQ7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "Q");
    }

    public void masR7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "R");
    }

    public void masS7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "S");
    }

    public void masT7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "T");
    }

    public void masU7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "U");
    }

    public void masV7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "V");
    }

    public void masW7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "W");
    }

    public void masX7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "X");
    }

    public void masY7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "Y");
    }

    public void masZ7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + "Z");
    }

    public void masComa7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + ",");
    }

    public void masPunto7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + ".");
    }

    public void menosUno7c (View view){
        if(traducido7c.getText().toString().length() > 0){
            traducido7c.setText(traducido7c.getText().toString().substring(0,traducido7c.getText().toString().length()-1));
        }
    }

    public void masEspacio7c (View view){
        traducido7c.setText(traducido7c.getText().toString() + " ");
    }


    public void masAps (View view){
        traducidops.setText(traducidops.getText().toString() + "A");
    }

    public void masBps (View view){
        traducidops.setText(traducidops.getText().toString() + "B");
    }

    public void masCps (View view){
        traducidops.setText(traducidops.getText().toString() + "C");
    }

    public void masDps (View view){
        traducidops.setText(traducidops.getText().toString() + "D");
    }

    public void masEps (View view){
        traducidops.setText(traducidops.getText().toString() + "E");
    }

    public void masFps (View view){
        traducidops.setText(traducidops.getText().toString() + "F");
    }

    public void masGps (View view){
        traducidops.setText(traducidops.getText().toString() + "G");
    }

    public void masHps (View view){
        traducidops.setText(traducidops.getText().toString() + "H");
    }

    public void masIps (View view){
        traducidops.setText(traducidops.getText().toString() + "I");
    }

    public void masJps (View view){
        traducidops.setText(traducidops.getText().toString() + "J");
    }

    public void masKps (View view){
        traducidops.setText(traducidops.getText().toString() + "K");
    }

    public void masLps (View view){
        traducidops.setText(traducidops.getText().toString() + "L");
    }

    public void masMps (View view){
        traducidops.setText(traducidops.getText().toString() + "M");
    }

    public void masNps (View view){
        traducidops.setText(traducidops.getText().toString() + "N");
    }

    public void masÑps (View view){
        traducidops.setText(traducidops.getText().toString() + "Ñ");
    }

    public void masOps (View view){
        traducidops.setText(traducidops.getText().toString() + "O");
    }

    public void masPps (View view){
        traducidops.setText(traducidops.getText().toString() + "P");
    }

    public void masQps (View view){
        traducidops.setText(traducidops.getText().toString() + "Q");
    }

    public void masRps (View view){
        traducidops.setText(traducidops.getText().toString() + "R");
    }

    public void masSps (View view){
        traducidops.setText(traducidops.getText().toString() + "S");
    }

    public void masTps (View view){
        traducidops.setText(traducidops.getText().toString() + "T");
    }

    public void masUps (View view){
        traducidops.setText(traducidops.getText().toString() + "U");
    }

    public void masVps (View view){
        traducidops.setText(traducidops.getText().toString() + "V");
    }

    public void masWps (View view){
        traducidops.setText(traducidops.getText().toString() + "W");
    }

    public void masXps (View view){
        traducidops.setText(traducidops.getText().toString() + "X");
    }

    public void masYps (View view){
        traducidops.setText(traducidops.getText().toString() + "Y");
    }

    public void masZps (View view){
        traducidops.setText(traducidops.getText().toString() + "Z");
    }

    public void masComaps (View view){
        traducidops.setText(traducidops.getText().toString() + ",");
    }

    public void masPuntops (View view){
        traducidops.setText(traducidops.getText().toString() + ".");
    }

    public void menosUnops (View view){
        if(traducidops.getText().toString().length() > 0){
            traducidops.setText(traducidops.getText().toString().substring(0,traducidops.getText().toString().length()-1));
        }
    }

    public void masEspaciops (View view){
        traducidops.setText(traducidops.getText().toString() + " ");
    }




    public void masApc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "A");
    }

    public void masBpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "B");
    }

    public void masCpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "C");
    }

    public void masDpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "D");
    }

    public void masEpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "E");
    }

    public void masFpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "F");
    }

    public void masGpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "G");
    }

    public void masHpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "H");
    }

    public void masIpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "I");
    }

    public void masJpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "J");
    }

    public void masKpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "K");
    }

    public void masLpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "L");
    }

    public void masMpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "M");
    }

    public void masNpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "N");
    }

    public void masÑpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "Ñ");
    }

    public void masOpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "O");
    }

    public void masPpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "P");
    }

    public void masQpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "Q");
    }

    public void masRpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "R");
    }

    public void masSpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "S");
    }

    public void masTpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "T");
    }

    public void masUpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "U");
    }

    public void masVpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "V");
    }

    public void masWpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "W");
    }

    public void masXpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "X");
    }

    public void masYpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "Y");
    }

    public void masZpc (View view){
        traducidopc.setText(traducidopc.getText().toString() + "Z");
    }

    public void masComapc (View view){
        traducidopc.setText(traducidopc.getText().toString() + ",");
    }

    public void masPuntopc (View view){
        traducidopc.setText(traducidopc.getText().toString() + ".");
    }

    public void menosUnopc (View view){
        if(traducidopc.getText().toString().length() > 0){
            traducidopc.setText(traducidopc.getText().toString().substring(0,traducidopc.getText().toString().length()-1));
        }
    }

    public void masEspaciopc (View view){
        traducidopc.setText(traducidopc.getText().toString() + " ");
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
}
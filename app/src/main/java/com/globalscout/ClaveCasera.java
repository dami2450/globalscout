package com.globalscout;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ClaveCasera extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView prev, sig, logoClave;
    SharedPreferences palabrasGuardadas;
    EditText textoATraducir;
    String traduccion;
    TextView textoTraducido;
    LinearLayout palabrasCasera, datosCorrediza;
    EditText renglon1, renglon2, numero;
    CheckBox adelante, atras;
    ShareActionProvider mShareActionProvider;
    DrawerLayout drawer;
    final int REEMPLAZO = 1;
    final int CORREDIZA = 2;
    String P1 = "PALABRA1";
    String P2 = "PALABRA2";
    String NUMERO = "NUMERO_CORREDIZO";
    String ATRAS = "ATRAS";

    ArrayList<Integer> clavesValidas = new ArrayList<Integer>();
    int posSel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clave_casera);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        clavesValidas.add(REEMPLAZO);
        clavesValidas.add(CORREDIZA);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        drawer.setDrawerListener(new DrawerLayout.DrawerListener() {

            private float last = 0;

            @Override
            public void onDrawerSlide(View arg0, float arg1) {

                View view = ClaveCasera.this.getCurrentFocus();
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
        getSupportActionBar().setTitle("Globalscout");
        palabrasGuardadas = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        prev = (ImageView) findViewById(R.id.prev);
        sig = (ImageView) findViewById(R.id.sig);
        logoClave = (ImageView) findViewById(R.id.logoClave);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(posSel == 0){
                    posSel = (clavesValidas.size()-1);
                }else{
                    posSel--;
                }
                String s1 = palabrasGuardadas.getString(P1,"MURCIELAGO");
                String s2 = palabrasGuardadas.getString(P2,"0123456789");
                String num = palabrasGuardadas.getString(NUMERO,"0");
                renglon1.setText(s1);
                renglon2.setText(s2);
                numero.setText(num);
                armarImagenes();
            }
        });
        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(posSel == (clavesValidas.size()-1)){
                    posSel = 0;
                }else{
                    posSel++;
                }
                String s1 = palabrasGuardadas.getString(P1,"MURCIELAGO");
                String s2 = palabrasGuardadas.getString(P2,"0123456789");
                String num = palabrasGuardadas.getString(NUMERO,"0");
                renglon1.setText(s1);
                renglon2.setText(s2);
                numero.setText(num);
                armarImagenes();
            }
        });
        textoATraducir = (EditText) findViewById(R.id.textoATraducir);
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
        textoTraducido = (TextView) findViewById(R.id.traduccion);
        palabrasCasera = (LinearLayout) findViewById(R.id.palabrasCasera);
        renglon1 = (EditText) findViewById(R.id.palabra1);
        renglon2 = (EditText) findViewById(R.id.palabra2);
        datosCorrediza = (LinearLayout) findViewById(R.id.datosCorrediza);
        numero = (EditText) findViewById(R.id.numero);
        adelante = (CheckBox) findViewById(R.id.adelante);
        atras = (CheckBox) findViewById(R.id.atras);
        renglon1.setText(renglon1());
        renglon2.setText(renglon2());
        numero.setText(numeroCaracteres());
        renglon1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SharedPreferences claveIncluida = PreferenceManager.getDefaultSharedPreferences(ClaveCasera.this);
                SharedPreferences.Editor editor = claveIncluida.edit();
                editor.putString(P1,s.toString());
                editor.commit();
                if(renglon1 != null && renglon2 != null && renglon1.getText().toString().length() > 0 && renglon2.getText().toString().length() > 0 && renglon1.getText().toString().length() == renglon2.getText().toString().length()){
                    textoTraducido.setText(casera(textoATraducir.getText().toString()));
                }else{
                    if(renglon1 != null && renglon1.getText().toString().length() > 0 && renglon2 != null && renglon2.getText().toString().length() > 0){
                        Toast.makeText(ClaveCasera.this,"Para que la clave casera sea valida, ambas palabras deben tener la misma cantidad de caracteres",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(ClaveCasera.this,"Para que la clave casera sea valida debes ingresar una palabra en ambos campos de texto",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        renglon2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SharedPreferences claveIncluida = PreferenceManager.getDefaultSharedPreferences(ClaveCasera.this);
                SharedPreferences.Editor editor = claveIncluida.edit();
                editor.putString(P2,s.toString());
                editor.commit();
                if(renglon1 != null && renglon2 != null && renglon1.getText().toString().length() > 0 && renglon2.getText().toString().length() > 0 && renglon1.getText().toString().length() == renglon2.getText().toString().length()){
                    textoTraducido.setText(casera(textoATraducir.getText().toString()));
                }else{
                    if(renglon1 != null && renglon1.getText().toString().length() > 0 && renglon2 != null && renglon2.getText().toString().length() > 0){
                        Toast.makeText(ClaveCasera.this,"Para que la clave casera sea valida, ambas palabras deben tener la misma cantidad de caracteres",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(ClaveCasera.this,"Para que la clave casera sea valida debes ingresar una palabra en ambos campos de texto",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        numero.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SharedPreferences claveIncluida = PreferenceManager.getDefaultSharedPreferences(ClaveCasera.this);
                SharedPreferences.Editor editor = claveIncluida.edit();
                editor.putString(NUMERO,s.toString());
                editor.commit();
                if(numero != null && numero.getText().toString().length() > 0){
                    Integer original = Integer.valueOf(s.toString());
                    Integer valorFinal;
                    valorFinal = original%27;
                    if(atras()){
                        valorFinal = 27 - valorFinal;
                    }
                    textoTraducido.setText(Claves.corrediza(textoATraducir.getText().toString(),valorFinal));
                }else{
                    Toast.makeText(ClaveCasera.this,"Para que la clave casera sea valida debes ingresar un en el campo de numero",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        adelante.setChecked(!atras());
        atras.setChecked(atras());
        adelante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences claveIncluida = PreferenceManager.getDefaultSharedPreferences(ClaveCasera.this);
                SharedPreferences.Editor editor = claveIncluida.edit();
                editor.putBoolean(ATRAS,!isChecked);
                editor.commit();
                atras.setChecked(!isChecked);
                traducir();
            }
        });
        atras.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences claveIncluida = PreferenceManager.getDefaultSharedPreferences(ClaveCasera.this);
                SharedPreferences.Editor editor = claveIncluida.edit();
                editor.putBoolean(ATRAS,isChecked);
                editor.commit();
                adelante.setChecked(!isChecked);
                traducir();
            }
        });
    }

    public boolean atras(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        return prefs.getBoolean(ATRAS,false);
    }

    public String renglon1(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        return prefs.getString(P1,"MURCIELAGO");
    }

    public String renglon2(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        return prefs.getString(P2,"0123456789");
    }

    public String numeroCaracteres(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        return prefs.getString(NUMERO,"0");
    }

    public void traducir() {
        palabrasCasera.setVisibility(View.GONE);
        datosCorrediza.setVisibility(View.GONE);
        String texto = textoATraducir.getText().toString().toUpperCase() + "  ";
        switch(clavesValidas.get(posSel)){
            case(REEMPLAZO):
                palabrasCasera.setVisibility(View.VISIBLE);
                traduccion = casera(texto);
                break;
            case(CORREDIZA):
                datosCorrediza.setVisibility(View.VISIBLE);
                Integer original;
                if(numero.getText().toString().length() > 0){
                    original = Integer.valueOf(numero.getText().toString());
                }else{
                    original = 0;
                }
                Integer valorFinal;
                valorFinal = original%27;
                if(atras()){
                    valorFinal = 27 - valorFinal;
                }
                traduccion = Claves.corrediza(texto,valorFinal);
                break;
        }
        textoTraducido.setText(traduccion);
        if(mShareActionProvider != null){
            mShareActionProvider.setShareIntent(createShareForecastIntentActualizado(traduccion));
        }
    }

    public String casera (String texto){
        String resultado = "";
        String textopalabra1 = renglon1.getText().toString().toUpperCase();
        String textopalabra2 = renglon2.getText().toString().toUpperCase();
        if(textopalabra1 !=null && textopalabra1.length() > 0 && textopalabra2 !=null && textopalabra2.length() > 0 && textopalabra1.length() == textopalabra2.length()){
            HashMap<Character, Character> casera = new HashMap<>();
            for(int i = 0; i < textopalabra1.length(); i++){
                casera.put(textopalabra1.charAt(i),textopalabra2.charAt(i));
            }
            for(int i = 0; i < textopalabra2.length(); i++){
                casera.put(textopalabra2.charAt(i),textopalabra1.charAt(i));
            }
            for (int i = 0; i < texto.length(); i++) {
                Character nuevoCaracter = texto.toUpperCase().charAt(i);
                for (Map.Entry<Character, Character> entry : casera.entrySet()) {
                    if (texto.toUpperCase().charAt(i) == entry.getKey()) {
                        nuevoCaracter = entry.getValue();
                        break;
                    }
                }
                resultado = resultado + nuevoCaracter;
            }
        }else{
            if(textopalabra1 != null && textopalabra1.length() > 0 && textopalabra2 != null && textopalabra2.length() > 0){
                Toast.makeText(this,"Para que la clave casera sea valida, ambas palabras deben tener la misma cantidad de caracteres",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Para que la clave casera sea valida debes ingresar una palabra en ambos campos de texto",Toast.LENGTH_LONG).show();
            }
        }
        return resultado;
    }

    public void borrarTodo(){
        textoATraducir.setText("");
        textoTraducido.setText("");
        Toast.makeText(ClaveCasera.this, "Los campos de texto y traduccion han sido limpiados", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.casera, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        // Get the provider and hold onto it to set/change the share intent.
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        mShareActionProvider.setShareIntent(createShareForecastIntentActualizado(""));
        armarImagenes();
        return true;
    }

    private Intent createShareForecastIntentActualizado(String traducido) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, traducido);
        return shareIntent;
    }

    public void armarImagenes(){
        switch (clavesValidas.get(posSel)){
            case REEMPLAZO:
                logoClave.setImageResource(R.drawable.guiareemplazo);
                break;
            case CORREDIZA:
                logoClave.setImageResource(R.drawable.guiacorrediza);
                break;
        }
        traducir();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuLimpiar:
                borrarTodo();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onResume() {
        super.onResume();
        armarImagenes();
        final TextServicesManager tsm = (TextServicesManager) getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
    }

    public void onPause() {
        super.onPause();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawer.closeDrawer(Gravity.LEFT);
        int id = item.getItemId();
        switch (id){
            case R.id.menuSemaforo:
                Constantes.semaforo(this);
                return true;
            case R.id.menuLinterna:
                Constantes.linternaMorse(this);
                return true;
            case R.id.menuTeclado:
                Constantes.tecladoEspecial(this);
                return true;
            case R.id.menuJuego:
                Constantes.iniciarJuego(this);
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
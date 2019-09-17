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
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView logoClave;
    RelativeLayout contenedorClaveImagen;
    SharedPreferences palabrasGuardadas;
    EditText textoATraducir;
    String traduccion, anterior;
    TextView textoTraducido, caracolizado, textoCambiar;
    HorizontalScrollView contenedorCaracol;
    LinearLayout botonesHombre, contenedorOpciones;
    ShareActionProvider mShareActionProvider;
    boolean aHombre = false;
    DrawerLayout drawer;
    Button volverAIntentarHombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        drawer.setDrawerListener(new DrawerLayout.DrawerListener() {

            private float last = 0;

            @Override
            public void onDrawerSlide(View arg0, float arg1) {

                View view = MainActivity.this.getCurrentFocus();
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
        textoCambiar = (TextView) findViewById(R.id.textoCambiar);
        volverAIntentarHombre = (Button) findViewById(R.id.volverAIntentarHombre);
        logoClave = (ImageView) findViewById(R.id.logoClave);
        contenedorOpciones = (LinearLayout) findViewById(R.id.contenedorOpciones);
        contenedorClaveImagen = (RelativeLayout) findViewById(R.id.contenedorClaveImagen);
        contenedorClaveImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGrilla = new Intent(MainActivity.this,GrillaClavesActivity.class);
                startActivityForResult(intentGrilla,Constantes.GENERICO);
            }
        });
        textoCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGrilla = new Intent(MainActivity.this,GrillaClavesActivity.class);
                startActivityForResult(intentGrilla,Constantes.GENERICO);
            }
        });
        textoATraducir = (EditText) findViewById(R.id.textoATraducir);
        textoATraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTraducir = new Intent(MainActivity.this,TraduccionActivity.class);
                intentTraducir.putExtra(Constantes.TEXTO, textoATraducir.getText().toString());
                intentTraducir.putExtra(Constantes.CLAVE, Constantes.clavesValidas.get(Constantes.posSel));
                startActivityForResult(intentTraducir,Constantes.TRADUCCION_VENTANA);
            }
        });
        textoATraducir.setTextIsSelectable(false);
        /*textoATraducir.addTextChangedListener(new TextWatcher() {
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
        });*/
        traduccion = "";
        textoTraducido = (TextView) findViewById(R.id.traduccion);
        contenedorCaracol = (HorizontalScrollView) findViewById(R.id.contenedorCaracol);
        caracolizado = (TextView) findViewById(R.id.caracolizado);
        botonesHombre = (LinearLayout) findViewById(R.id.botonesHombre);
        anterior = "";
        Constantes.actualizarIncluidos(this);
    }

    public String aODeHombre(String texto){
        anterior = texto;
        if(aHombre){
            volverAIntentarHombre.setText("obtener traduccion");
            return Claves.aHombre(texto);
        }else{
            volverAIntentarHombre.setText("obtener codificacion");
            return Claves.deHombre(texto);
        }
    }

    public void volverAIntentarHombre (View view){
        aHombre = !aHombre;
        traduccion = aODeHombre(anterior);
        textoTraducido.setText(traduccion);
    }

    public void aceptarHombre (View view){
        aHombre = false;
        botonesHombre.setVisibility(View.GONE);
    }

    public void traducir() {
        contenedorCaracol.setVisibility(View.GONE);
        botonesHombre.setVisibility(View.GONE);
        String texto = textoATraducir.getText().toString().toUpperCase() + "  ";
        if(texto.trim().length() == 0){
            contenedorOpciones.setVisibility(View.GONE);
        }else{
            contenedorOpciones.setVisibility(View.VISIBLE);
        }
        switch(Constantes.clavesValidas.get(Constantes.posSel)){
            case(Constantes.MURCIELAGO):
                traduccion = Claves.murcielago(texto);
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
                botonesHombre.setVisibility(View.VISIBLE);
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
            case Constantes.CARACOL:
                contenedorCaracol.setVisibility(View.VISIBLE);
                caracolizado.setText(Claves.caracolizar(texto));
                traduccion = "";
                break;
        }
        textoTraducido.setText(getSmiledText(traduccion));
        if(mShareActionProvider != null){
            mShareActionProvider.setShareIntent(createShareForecastIntentActualizado(traduccion));
        }
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
        Toast.makeText(MainActivity.this, "Los campos de texto y traduccion han sido limpiados", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        // Get the provider and hold onto it to set/change the share intent.
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        mShareActionProvider.setShareIntent(createShareForecastIntentActualizado(""));
        armarImagenes(false);
        return true;
    }

    private Intent createShareForecastIntentActualizado(String traducido) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, traducido);
        return shareIntent;
    }






    public void armarImagenes(boolean traducir){
        switch (Constantes.clavesValidas.get(Constantes.posSel)){
            case Constantes.MURCIELAGO:
                logoClave.setImageResource(R.drawable.guiamurcielago);
                break;
            case Constantes.DAME_TU_PICO:
                logoClave.setImageResource(R.drawable.guiadametupico);
                break;
            case Constantes.NUMERICA:
                logoClave.setImageResource(R.drawable.guianumerica);
                break;
            case Constantes.INVERTIDA:
                logoClave.setImageResource(R.drawable.guiainvertida);
                break;
            case Constantes.BADEN_POWELL:
                logoClave.setImageResource(R.drawable.guiabadenpowell);
                break;
            case Constantes.MORSE:
                logoClave.setImageResource(R.drawable.guiamorse);
                break;
            case Constantes.MAS1:
                logoClave.setImageResource(R.drawable.guiamasuno);
                break;
            case Constantes.MENOS1:
                logoClave.setImageResource(R.drawable.guiamenosuno);
                break;
            case Constantes.AGUJERITO:
                logoClave.setImageResource(R.drawable.guiaagujerito);
                break;
            case Constantes.CENIT_POLAR:
                logoClave.setImageResource(R.drawable.guiacenitpolar);
                break;
            case Constantes.NEUMATICO:
                logoClave.setImageResource(R.drawable.guianeumatico);
                break;
            case Constantes.ROMANA:
                logoClave.setImageResource(R.drawable.guiaromana);
                break;
            case Constantes.SUFAMELICO:
                logoClave.setImageResource(R.drawable.guiasufamelico);
                break;
            case Constantes.LAPIZ_NEGRO:
                logoClave.setImageResource(R.drawable.guialapiznegro);
                break;
            case Constantes.HUERFANITO:
                logoClave.setImageResource(R.drawable.guiahuerfanito);
                break;
            case Constantes.ORQUIDEA:
                logoClave.setImageResource(R.drawable.guiaorquidea);
                break;
            case Constantes.JULIO_CESAR:
                logoClave.setImageResource(R.drawable.guiajuliocesar);
                break;
            case Constantes.ABUELITO:
                logoClave.setImageResource(R.drawable.guiaabuelito);
                break;
            case Constantes.EUCALIPTO:
                logoClave.setImageResource(R.drawable.guiaeucalipto);
                break;
            case Constantes.HOMBRE:
                logoClave.setImageResource(R.drawable.guiahombre);
                break;
            case Constantes.AL_REVES:
                logoClave.setImageResource(R.drawable.guiaalreves);
                break;
            case Constantes.REINADO:
                logoClave.setImageResource(R.drawable.guiareinado);
                break;
            case Constantes.DON_MATIAS:
                logoClave.setImageResource(R.drawable.guiadonmatias);
                break;
            case Constantes.CALENDARIO:
                logoClave.setImageResource(R.drawable.guiacalendario);
                break;
            case Constantes.SIETE_CRUCES:
                logoClave.setImageResource(R.drawable.guiasietecruces);
                break;
            case Constantes.PARRILLA_SIMPLE:
                logoClave.setImageResource(R.drawable.guiaparrillasimple);
                break;
            case Constantes.PARRILLA_COMPUESTA:
                logoClave.setImageResource(R.drawable.guiaparrillacompuesta);
                break;
            case Constantes.VOCAL:
                logoClave.setImageResource(R.drawable.guiavocal);
                break;
            case Constantes.ANGULO:
                logoClave.setImageResource(R.drawable.guiaangulo);
                break;
            case Constantes.PZ:
                logoClave.setImageResource(R.drawable.guiapz);
                break;
            case Constantes.PARELINOFU:
                logoClave.setImageResource(R.drawable.guiaparelinofu);
                break;
            case Constantes.CARACOL:
                logoClave.setImageResource(R.drawable.guiacaracol);
                break;
        }
        if(traducir){
            traducir();
        }
    }

    public void aleatorio(View view){
        if(Constantes.clavesValidas.size() > 1){
            Random rnd = new Random();
            Constantes.posSel = (int) (rnd.nextDouble() * (Constantes.clavesValidas.size()-1));
            armarImagenes(true);
        }else{
            Toast.makeText(this, "No se puede elegir una clave al azar si no se tiene ninguna clave aprobada", Toast.LENGTH_LONG).show();
        }
    }

    public void multiclave (View view){
        int total;
        if(Constantes.esClaveIncluida(Constantes.CARACOL,this)){
            total = 2;
        }else{
            total = 1;
        }
        if(Constantes.clavesValidas.size() > total){
            traduccion = Claves.multiclaveAleatoria(textoATraducir.getText().toString().toUpperCase(), this);
            textoTraducido.setText(getSmiledText(traduccion));
        }else{
            Toast.makeText(this, "No se puede elegir una clave al azar si no se tiene al menos 2 claves aprobadas, a parte de la clave caracol", Toast.LENGTH_LONG).show();
        }
    }

    public void traduccionInteligente(View view){
        Constantes.clavesPosibles = new ArrayList<Integer>();
        String texto = textoATraducir.getText().toString().toUpperCase();
        int a = 0;
        int b = texto.length();
        int numeros = 0;
        int letras = 0;
        int puntoRaya = 0;
        int CI = 0;
        int CP = 0;
        int CZ = 0;
        int barra = 0;

        while (a < b) {
            if (Character.isLetter(texto.charAt(a))){
                letras = letras + 1;
                if(texto.charAt(a) == 'I'){
                    CI = CI + 1;
                }
                if(texto.charAt(a) == 'P'){
                    CP = CP + 1;
                }
                if(texto.charAt(a) == 'Z'){
                    CZ = CZ + 1;
                }
            } else{
                if (Character.isDigit(texto.charAt(a))){
                    numeros = numeros + 1;
                } else{
                    if (texto.charAt(a) == '.' || texto.charAt(a) == '-'){
                        puntoRaya = puntoRaya + 1;
                    } else{
                        if (texto.charAt(a) == '/'){
                            barra = barra + 1;
                        }
                    }
                }
            }
            a = a + 1;
        }

        if ((CI > 0) && (CI == letras)) {
            if(Constantes.clavesValidas.contains(Constantes.ROMANA)){
                Constantes.clavesPosibles.add(Constantes.ROMANA);
            }
        } else {
            if((CP > 0) && (CZ > 0) && (CP * 3) >= letras && (CZ * 3) >= letras){
                if(Constantes.clavesValidas.contains(Constantes.PZ)){
                    Constantes.clavesPosibles.add(Constantes.PZ);
                }
            } else {
                if (numeros > (letras / 2)) {
                    if (barra > letras) {
                        if(Constantes.clavesValidas.contains(Constantes.NUMERICA)){
                            Constantes.clavesPosibles.add(Constantes.NUMERICA);
                        }
                    } else {
                        if(Constantes.clavesValidas.contains(Constantes.MURCIELAGO)){
                            Constantes.clavesPosibles.add(Constantes.MURCIELAGO);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.NEUMATICO)){
                            Constantes.clavesPosibles.add(Constantes.NEUMATICO);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.AGUJERITO)){
                            Constantes.clavesPosibles.add(Constantes.AGUJERITO);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.HUERFANITO)){
                            Constantes.clavesPosibles.add(Constantes.HUERFANITO);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.ORQUIDEA)){
                            Constantes.clavesPosibles.add(Constantes.ORQUIDEA);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.ABUELITO)){
                            Constantes.clavesPosibles.add(Constantes.ABUELITO);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.EUCALIPTO)){
                            Constantes.clavesPosibles.add(Constantes.EUCALIPTO);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.REINADO)){
                            Constantes.clavesPosibles.add(Constantes.REINADO);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.VOCAL)){
                            Constantes.clavesPosibles.add(Constantes.VOCAL);
                        }
                    }
                } else {
                    if (puntoRaya > letras) {
                        if(Constantes.clavesValidas.contains(Constantes.MORSE)){
                            Constantes.clavesPosibles.add(Constantes.MORSE);
                        }
                    } else {
                        if(Constantes.clavesValidas.contains(Constantes.DAME_TU_PICO)){
                            Constantes.clavesPosibles.add(Constantes.DAME_TU_PICO);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.INVERTIDA)){
                            Constantes.clavesPosibles.add(Constantes.INVERTIDA);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.BADEN_POWELL)){
                            Constantes.clavesPosibles.add(Constantes.BADEN_POWELL);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.CENIT_POLAR)){
                            Constantes.clavesPosibles.add(Constantes.CENIT_POLAR);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.SUFAMELICO)){
                            Constantes.clavesPosibles.add(Constantes.SUFAMELICO);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.MAS1)){
                            Constantes.clavesPosibles.add(Constantes.MAS1);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.MENOS1)){
                            Constantes.clavesPosibles.add(Constantes.MENOS1);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.LAPIZ_NEGRO)){
                            Constantes.clavesPosibles.add(Constantes.LAPIZ_NEGRO);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.JULIO_CESAR)){
                            Constantes.clavesPosibles.add(Constantes.JULIO_CESAR);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.AL_REVES)){
                            Constantes.clavesPosibles.add(Constantes.AL_REVES);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.HOMBRE)){
                            Constantes.clavesPosibles.add(Constantes.HOMBRE);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.DON_MATIAS)){
                            Constantes.clavesPosibles.add(Constantes.DON_MATIAS);
                        }
                        if(Constantes.clavesValidas.contains(Constantes.PARELINOFU)){
                            Constantes.clavesPosibles.add(Constantes.PARELINOFU);
                        }
                    }
                }
            }
        }
        Intent intentLista = new Intent(MainActivity.this,GrillaTraduccionesActivity.class);
        intentLista.putExtra(Constantes.TEXTO, (texto + "  "));
        startActivityForResult(intentLista,Constantes.GENERICO);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuCasero:
                Constantes.claveCasera(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onResume() {
        super.onResume();
        armarImagenes(false);
        final TextServicesManager tsm = (TextServicesManager) getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        SharedPreferences caracteresGuardados = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = caracteresGuardados.edit();
        editor.remove("A");
        editor.remove("Á");
        editor.remove("B");
        editor.remove("C");
        editor.remove("D");
        editor.remove("E");
        editor.remove("É");
        editor.remove("F");
        editor.remove("G");
        editor.remove("H");
        editor.remove("I");
        editor.remove("Í");
        editor.remove("J");
        editor.remove("K");
        editor.remove("L");
        editor.remove("M");
        editor.remove("N");
        editor.remove("Ñ");
        editor.remove("O");
        editor.remove("Ó");
        editor.remove("P");
        editor.remove("Q");
        editor.remove("R");
        editor.remove("S");
        editor.remove("T");
        editor.remove("U");
        editor.remove("Ú");
        editor.remove("V");
        editor.remove("W");
        editor.remove("X");
        editor.remove("Y");
        editor.remove("Z");
        editor.remove("0");
        editor.remove("1");
        editor.remove("2");
        editor.remove("3");
        editor.remove("4");
        editor.remove("5");
        editor.remove("6");
        editor.remove("7");
        editor.remove("8");
        editor.remove("9");
        editor.commit();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constantes.TRADUCCION_VENTANA){
            String original = data.getStringExtra(Constantes.TEXTO);
            String cambiado = data.getStringExtra(Constantes.TRADUCCION);
            textoATraducir.setText(original);
            textoTraducido.setText(cambiado);
            if(original != null && original.length() > 0){
                for(int i = 10; i > 1; i--){
                    int posterior = i - 1;
                    String historialPosterior = Constantes.obtenerHistorial(posterior,this);
                    Constantes.guardarHistorial(i,historialPosterior,this);
                }
                Constantes.guardarHistorial(1,original,this);
            }
        }else{
            armarImagenes(true);
        }
    }
}
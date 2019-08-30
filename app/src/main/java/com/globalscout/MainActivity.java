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
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.Log;
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
    final static int MURCIELAGO = 1;
    final static int DAME_TU_PICO = 2;
    final static int NUMERICA = 3;
    final static int INVERTIDA = 4;
    final static int BADEN_POWELL = 5;
    final static int MORSE = 6;
    final static int MAS1 = 7;
    final static int MENOS1 = 8;
    final static int AGUJERITO = 9;
    final static int CENIT_POLAR = 10;
    final static int ROMANA = 11;
    final static int NEUMATICO = 12;
    final static int SUFAMELICO = 13;
    final static int LAPIZ_NEGRO = 14;
    final static int HUERFANITO = 15;
    final static int ORQUIDEA = 16;
    final static int JULIO_CESAR = 17;
    final static int ABUELITO = 18;
    final static int EUCALIPTO = 19;
    final static int HOMBRE = 20;
    final static int AL_REVES = 21;
    final static int REINADO = 22;
    final static int DON_MATIAS = 23;
    final static int CALENDARIO = 24;
    final static int SIETE_CRUCES = 25;
    final static int PARRILLA_SIMPLE = 26;
    final static int PARRILLA_COMPUESTA = 27;
    final static int VOCAL = 28;
    final static int ANGULO = 29;
    final static int PZ = 30;
    final static int PARELINOFU = 31;
    final static int MAXIMO = 32;
    final static int CARACOL = 1000;
    final static String TEXTO = "TEXTO";
    final static String TRADUCCION = "TRADUCCION";
    final static String CLAVE = "CLAVE";
    static ArrayList<Integer> clavesValidas = new ArrayList<Integer>();
    static ArrayList<Integer> clavesPosibles = new ArrayList<Integer>();
    static int posSel = 0;
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
                startActivityForResult(intentGrilla,2450);
            }
        });
        textoCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGrilla = new Intent(MainActivity.this,GrillaClavesActivity.class);
                startActivityForResult(intentGrilla,2450);
            }
        });
        textoATraducir = (EditText) findViewById(R.id.textoATraducir);
        textoATraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTraducir = new Intent(MainActivity.this,TraduccionActivity.class);
                intentTraducir.putExtra(TEXTO, textoATraducir.getText().toString());
                intentTraducir.putExtra(CLAVE, clavesValidas.get(posSel));
                startActivityForResult(intentTraducir,1700);
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
        actualizarIncluidos(this);
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
        switch(clavesValidas.get(posSel)){
            case(MURCIELAGO):
                traduccion = Claves.murcielago(texto);
                break;
            case(DAME_TU_PICO):
                traduccion = Claves.dameTuPico(texto);
                break;
            case(NUMERICA):
                traduccion = Claves.numerica(texto);
                break;
            case(INVERTIDA):
                traduccion = Claves.invertida(texto);
                break;
            case(BADEN_POWELL):
                traduccion = Claves.badenPowell(texto);
                break;
            case(MORSE):
                traduccion = Claves.aODeMorse(texto);
                break;
            case(MAS1):
                traduccion = Claves.M1(texto);
                break;
            case(MENOS1):
                traduccion = Claves.m1(texto);
                break;
            case(AGUJERITO):
                traduccion = Claves.agujerito(texto);
                break;
            case(CENIT_POLAR):
                traduccion = Claves.cenitPolar(texto);
                break;
            case(NEUMATICO):
                traduccion = Claves.neumatico(texto);
                break;
            case(ROMANA):
                traduccion = Claves.aODeRomana(texto);
                break;
            case(SUFAMELICO):
                traduccion = Claves.sufamelico(texto);
                break;
            case(LAPIZ_NEGRO):
                traduccion = Claves.lapizNegro(texto);
                break;
            case(HUERFANITO):
                traduccion = Claves.huerfanito(texto);
                break;
            case(ORQUIDEA):
                traduccion = Claves.orquidea(texto);
                break;
            case(JULIO_CESAR):
                traduccion = Claves.julioCesar(texto);
                break;
            case(ABUELITO):
                traduccion = Claves.abuelito(texto);
                break;
            case(EUCALIPTO):
                traduccion = Claves.eucalipto(texto);
                break;
            case(HOMBRE):
                traduccion = aODeHombre(texto);
                botonesHombre.setVisibility(View.VISIBLE);
                break;
            case(AL_REVES):
                traduccion = Claves.alReves(texto);
                break;
            case(REINADO):
                traduccion = Claves.reinado(texto);
                break;
            case(DON_MATIAS):
                traduccion = Claves.donMatias(texto);
                break;
            case(CALENDARIO):
                traduccion = Claves.aODeCalendario(texto);
                break;
            case(SIETE_CRUCES):
                traduccion = Claves.a7Cruces(texto);
                break;
            case(PARRILLA_SIMPLE):
                traduccion = Claves.aParrillaSimple(texto);
                break;
            case(PARRILLA_COMPUESTA):
                traduccion = Claves.aParrillaCompuesta(texto);
                break;
            case(VOCAL):
                traduccion = Claves.vocal(texto);
                break;
            case(ANGULO):
                traduccion = Claves.aAngulo(texto);
                break;
            case(PZ):
                traduccion = Claves.aODePZ(texto);
                break;
            case(PARELINOFU):
                traduccion = Claves.parelinofu(texto);
                break;
            case CARACOL:
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

    public static void linternaMorse(Context context){
        Intent intent = new Intent(context, LinternaMorseActivity.class);
        context.startActivity(intent);
    }

    public static void semaforo(Context context){
        Intent intent = new Intent(context, codificacionSemaforaActivity.class);
        context.startActivity(intent);
    }

    public static void guiaClaves(Context context){
        Intent intent = new Intent(context, GuiaDeClavesActivity.class);
        context.startActivity(intent);
    }

    public static void clavesDobles(Context context){
        Intent intent = new Intent(context, ClavesDobles.class);
        context.startActivity(intent);
    }

    public static void clavesTriple(Context context){
        Intent intent = new Intent(context, ClavesTriples.class);
        context.startActivity(intent);
    }

    public static void preferencias(Context context){
        Intent intent = new Intent(context, PreferenciasActivity.class);
        context.startActivity(intent);
    }

    public static void iniciarJuego(Context context){
        Intent intent = new Intent(context, JuegoActivity.class);
        context.startActivity(intent);
    }

    public static void claveCasera(Context context){
        Intent intent = new Intent(context, ClaveCasera.class);
        context.startActivity(intent);
    }

    public static void tecladoEspecial(Context context){
        Intent intent = new Intent(context, TecladoEspecialActivity.class);
        context.startActivity(intent);
    }

    public static void incluirClave(int clave, boolean incluida, Context context){
        SharedPreferences claveIncluida = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = claveIncluida.edit();
        editor.putBoolean(("CLAVE_"+clave),incluida);
        editor.commit();
        actualizarIncluidos(context);
    }

    public static boolean esClaveIncluida(int clave, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean(("CLAVE_"+clave),true);
    }

    public static void actualizarIncluidos(Context context){
        clavesValidas.clear();
        posSel = 0;
        for (int i = 1; i < MAXIMO; i++){
            if(esClaveIncluida(i,context)){
                clavesValidas.add(i);
            }
        }
        if(esClaveIncluida(CARACOL,context)){
            clavesValidas.add(CARACOL);
        }
    }

    public void armarImagenes(boolean traducir){
        switch (clavesValidas.get(posSel)){
            case MURCIELAGO:
                logoClave.setImageResource(R.drawable.guiamurcielago);
                break;
            case DAME_TU_PICO:
                logoClave.setImageResource(R.drawable.guiadametupico);
                break;
            case NUMERICA:
                logoClave.setImageResource(R.drawable.guianumerica);
                break;
            case INVERTIDA:
                logoClave.setImageResource(R.drawable.guiainvertida);
                break;
            case BADEN_POWELL:
                logoClave.setImageResource(R.drawable.guiabadenpowell);
                break;
            case MORSE:
                logoClave.setImageResource(R.drawable.guiamorse);
                break;
            case MAS1:
                logoClave.setImageResource(R.drawable.guiamasuno);
                break;
            case MENOS1:
                logoClave.setImageResource(R.drawable.guiamenosuno);
                break;
            case AGUJERITO:
                logoClave.setImageResource(R.drawable.guiaagujerito);
                break;
            case CENIT_POLAR:
                logoClave.setImageResource(R.drawable.guiacenitpolar);
                break;
            case NEUMATICO:
                logoClave.setImageResource(R.drawable.guianeumatico);
                break;
            case ROMANA:
                logoClave.setImageResource(R.drawable.guiaromana);
                break;
            case SUFAMELICO:
                logoClave.setImageResource(R.drawable.guiasufamelico);
                break;
            case LAPIZ_NEGRO:
                logoClave.setImageResource(R.drawable.guialapiznegro);
                break;
            case HUERFANITO:
                logoClave.setImageResource(R.drawable.guiahuerfanito);
                break;
            case ORQUIDEA:
                logoClave.setImageResource(R.drawable.guiaorquidea);
                break;
            case JULIO_CESAR:
                logoClave.setImageResource(R.drawable.guiajuliocesar);
                break;
            case ABUELITO:
                logoClave.setImageResource(R.drawable.guiaabuelito);
                break;
            case EUCALIPTO:
                logoClave.setImageResource(R.drawable.guiaeucalipto);
                break;
            case HOMBRE:
                logoClave.setImageResource(R.drawable.guiahombre);
                break;
            case AL_REVES:
                logoClave.setImageResource(R.drawable.guiaalreves);
                break;
            case REINADO:
                logoClave.setImageResource(R.drawable.guiareinado);
                break;
            case DON_MATIAS:
                logoClave.setImageResource(R.drawable.guiadonmatias);
                break;
            case CALENDARIO:
                logoClave.setImageResource(R.drawable.guiacalendario);
                break;
            case SIETE_CRUCES:
                logoClave.setImageResource(R.drawable.guiasietecruces);
                break;
            case PARRILLA_SIMPLE:
                logoClave.setImageResource(R.drawable.guiaparrillasimple);
                break;
            case PARRILLA_COMPUESTA:
                logoClave.setImageResource(R.drawable.guiaparrillacompuesta);
                break;
            case VOCAL:
                logoClave.setImageResource(R.drawable.guiavocal);
                break;
            case ANGULO:
                logoClave.setImageResource(R.drawable.guiaangulo);
                break;
            case PZ:
                logoClave.setImageResource(R.drawable.guiapz);
                break;
            case PARELINOFU:
                logoClave.setImageResource(R.drawable.guiaparelinofu);
                break;
            case CARACOL:
                logoClave.setImageResource(R.drawable.guiacaracol);
                break;
        }
        if(traducir){
            traducir();
        }
    }

    public void aleatorio(View view){
        if(clavesValidas.size() > 1){
            Random rnd = new Random();
            posSel = (int) (rnd.nextDouble() * (clavesValidas.size()-1));
            armarImagenes(true);
        }else{
            Toast.makeText(this, "No se puede elegir una clave al azar si no se tiene ninguna clave aprobada", Toast.LENGTH_LONG).show();
        }
    }

    public void multiclave (View view){
        int total;
        if(esClaveIncluida(CARACOL,this)){
            total = 2;
        }else{
            total = 1;
        }
        if(clavesValidas.size() > total){
            traduccion = Claves.multiclaveAleatoria(textoATraducir.getText().toString().toUpperCase(), this);
            textoTraducido.setText(getSmiledText(traduccion));
        }else{
            Toast.makeText(this, "No se puede elegir una clave al azar si no se tiene al menos 2 claves aprobadas, a parte de la clave caracol", Toast.LENGTH_LONG).show();
        }
    }

    public void traduccionInteligente(View view){
        clavesPosibles = new ArrayList<Integer>();
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
            if(clavesValidas.contains(ROMANA)){
                clavesPosibles.add(ROMANA);
            }
        } else {
            if((CP > 0) && (CZ > 0) && (CP * 3) >= letras && (CZ * 3) >= letras){
                if(clavesValidas.contains(PZ)){
                    clavesPosibles.add(PZ);
                }
            } else {
                if (numeros > (letras / 2)) {
                    if (barra > letras) {
                        if(clavesValidas.contains(NUMERICA)){
                            clavesPosibles.add(NUMERICA);
                        }
                    } else {
                        if(clavesValidas.contains(MURCIELAGO)){
                            clavesPosibles.add(MURCIELAGO);
                        }
                        if(clavesValidas.contains(NEUMATICO)){
                            clavesPosibles.add(NEUMATICO);
                        }
                        if(clavesValidas.contains(AGUJERITO)){
                            clavesPosibles.add(AGUJERITO);
                        }
                        if(clavesValidas.contains(HUERFANITO)){
                            clavesPosibles.add(HUERFANITO);
                        }
                        if(clavesValidas.contains(ORQUIDEA)){
                            clavesPosibles.add(ORQUIDEA);
                        }
                        if(clavesValidas.contains(ABUELITO)){
                            clavesPosibles.add(ABUELITO);
                        }
                        if(clavesValidas.contains(EUCALIPTO)){
                            clavesPosibles.add(EUCALIPTO);
                        }
                        if(clavesValidas.contains(REINADO)){
                            clavesPosibles.add(REINADO);
                        }
                        if(clavesValidas.contains(VOCAL)){
                            clavesPosibles.add(VOCAL);
                        }
                    }
                } else {
                    if (puntoRaya > letras) {
                        if(clavesValidas.contains(MORSE)){
                            clavesPosibles.add(MORSE);
                        }
                    } else {
                        if(clavesValidas.contains(DAME_TU_PICO)){
                            clavesPosibles.add(DAME_TU_PICO);
                        }
                        if(clavesValidas.contains(INVERTIDA)){
                            clavesPosibles.add(INVERTIDA);
                        }
                        if(clavesValidas.contains(BADEN_POWELL)){
                            clavesPosibles.add(BADEN_POWELL);
                        }
                        if(clavesValidas.contains(CENIT_POLAR)){
                            clavesPosibles.add(CENIT_POLAR);
                        }
                        if(clavesValidas.contains(SUFAMELICO)){
                            clavesPosibles.add(SUFAMELICO);
                        }
                        if(clavesValidas.contains(MAS1)){
                            clavesPosibles.add(MAS1);
                        }
                        if(clavesValidas.contains(MENOS1)){
                            clavesPosibles.add(MENOS1);
                        }
                        if(clavesValidas.contains(LAPIZ_NEGRO)){
                            clavesPosibles.add(LAPIZ_NEGRO);
                        }
                        if(clavesValidas.contains(JULIO_CESAR)){
                            clavesPosibles.add(JULIO_CESAR);
                        }
                        if(clavesValidas.contains(AL_REVES)){
                            clavesPosibles.add(AL_REVES);
                        }
                        if(clavesValidas.contains(HOMBRE)){
                            clavesPosibles.add(HOMBRE);
                        }
                        if(clavesValidas.contains(DON_MATIAS)){
                            clavesPosibles.add(DON_MATIAS);
                        }
                        if(clavesValidas.contains(PARELINOFU)){
                            clavesPosibles.add(PARELINOFU);
                        }
                    }
                }
            }
        }
        Intent intentLista = new Intent(MainActivity.this,GrillaTraduccionesActivity.class);
        intentLista.putExtra(TEXTO, (texto + "  "));
        startActivityForResult(intentLista,2450);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuCasero:
                claveCasera(this);
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
                semaforo(this);
                return true;
            case R.id.menuLinterna:
                linternaMorse(this);
                return true;
            case R.id.menuTeclado:
                tecladoEspecial(this);
                return true;
            case R.id.menuJuego:
                iniciarJuego(this);
                return true;
            case R.id.menuGuia:
                guiaClaves(this);
                return true;
            case R.id.menuDoble:
                clavesDobles(this);
                return true;
            case R.id.menuTriple:
                clavesTriple(this);
                return true;
            case R.id.menuPreferencias:
                preferencias(this);
                return true;
            default:
                return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1700){
            Log.v("probando2", "Texto: " + textoATraducir.getText().toString());
            String original = data.getStringExtra(TEXTO);
            String cambiado = data.getStringExtra(TRADUCCION);
            textoATraducir.setText(original);
            textoTraducido.setText(cambiado);
        }else{
            armarImagenes(true);
        }
    }
}
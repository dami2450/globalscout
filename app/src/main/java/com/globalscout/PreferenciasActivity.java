package com.globalscout;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

public class PreferenciasActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    CheckBox checkBoxMurcielago, checkBoxDameTuPico, checkBoxNumerica, checkBoxInvertida, checkBoxBadenPowell, checkBoxMorse, checkBoxMasUno, checkBoxMenosUno, checkBoxAgujerito, checkBoxCenitPolar, checkBoxNeumatico, checkBoxRomana, checkBoxSufamelico, checkBoxLapiznegro, checkBoxHuerfanito, checkBoxOrquidea, checkBoxJulioCesar, checkBoxAbuelito, checkBoxEucalipto, checkBoxHombre, checkBoxAlReves, checkBoxReinado, checkBoxDonMatias, checkBoxCalendario, checkBoxSieteCruces, checkBoxParrillaSimple, checkBoxParrillaCompuesta, checkBoxVocal, checkBoxAngulo, checkBoxPZ, checkBoxParelinofu, checkBoxCaracol;
    ImageView imagenMurcielago, imagenDameTuPico, imagenNumerica, imagenInvertida, imagenBadenPowell, imagenMorse, imagenMasUno, imagenMenosUno, imagenAgujerito, imagenCenitPolar, imagenNeumatico, imagenRomana, imagenSufamelico, imagenLapiznegro, imagenHuerfanito, imagenOrquidea, imagenJulioCesar, imagenAbuelito, imagenEucalipto, imagenHombre, imagenAlReves, imagenReinado, imagenDonMatias, imagenCalendario, imagenSieteCruces, imagenParrillaSimple, imagenParrillaCompuesta, imagenVocal, imagenAngulo, imagenPZ, imagenParelinofu, imagenCaracol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

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

                View view = PreferenciasActivity.this.getCurrentFocus();
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
        checkBoxMurcielago = (CheckBox) findViewById(R.id.checkBoxMurcielago);
        imagenMurcielago = (ImageView) findViewById(R.id.imagenmurcielago);
        checkBoxDameTuPico = (CheckBox) findViewById(R.id.checkBoxDameTuPico);
        imagenDameTuPico = (ImageView) findViewById(R.id.imagendametupico);
        checkBoxNumerica = (CheckBox) findViewById(R.id.checkBoxNumerica);
        imagenNumerica = (ImageView) findViewById(R.id.imagennumerica);
        checkBoxInvertida = (CheckBox) findViewById(R.id.checkBoxInvertida);
        imagenInvertida = (ImageView) findViewById(R.id.imageninvertida);
        checkBoxBadenPowell = (CheckBox) findViewById(R.id.checkBoxBadenPowell);
        imagenBadenPowell = (ImageView) findViewById(R.id.imagenbadenpowell);
        checkBoxMorse = (CheckBox) findViewById(R.id.checkBoxMorse);
        imagenMorse = (ImageView) findViewById(R.id.imagenmorse);
        checkBoxMasUno = (CheckBox) findViewById(R.id.checkBoxMasUno);
        imagenMasUno = (ImageView) findViewById(R.id.imagenmasuno);
        checkBoxMenosUno = (CheckBox) findViewById(R.id.checkBoxMenosUno);
        imagenMenosUno = (ImageView) findViewById(R.id.imagenmenosuno);
        checkBoxAgujerito = (CheckBox) findViewById(R.id.checkBoxAgujerito);
        imagenAgujerito = (ImageView) findViewById(R.id.imagenagujerito);
        checkBoxCenitPolar = (CheckBox) findViewById(R.id.checkBoxCenitPolar);
        imagenCenitPolar = (ImageView) findViewById(R.id.imagencenitpolar);
        checkBoxNeumatico = (CheckBox) findViewById(R.id.checkBoxNeumatico);
        imagenNeumatico = (ImageView) findViewById(R.id.imagenneumatico);
        checkBoxRomana = (CheckBox) findViewById(R.id.checkBoxRomana);
        imagenRomana = (ImageView) findViewById(R.id.imagenromana);
        checkBoxSufamelico = (CheckBox) findViewById(R.id.checkBoxSufamelico);
        imagenSufamelico = (ImageView) findViewById(R.id.imagensufamelico);
        checkBoxLapiznegro = (CheckBox) findViewById(R.id.checkBoxLapiznegro);
        imagenLapiznegro = (ImageView) findViewById(R.id.imagenlapiznegro);
        checkBoxHuerfanito = (CheckBox) findViewById(R.id.checkBoxHuerfanito);
        imagenHuerfanito = (ImageView) findViewById(R.id.imagenhuerfanito);
        checkBoxOrquidea = (CheckBox) findViewById(R.id.checkBoxOrquidea);
        imagenOrquidea = (ImageView) findViewById(R.id.imagenorquidea);
        checkBoxJulioCesar = (CheckBox) findViewById(R.id.checkBoxJulioCesar);
        imagenJulioCesar = (ImageView) findViewById(R.id.imagenjuliocesar);
        checkBoxAbuelito = (CheckBox) findViewById(R.id.checkBoxAbuelito);
        imagenAbuelito = (ImageView) findViewById(R.id.imagenabuelito);
        checkBoxEucalipto = (CheckBox) findViewById(R.id.checkBoxEucalipto);
        imagenEucalipto = (ImageView) findViewById(R.id.imageneucalipto);
        checkBoxHombre = (CheckBox) findViewById(R.id.checkBoxHombre);
        imagenHombre = (ImageView) findViewById(R.id.imagenhombre);
        checkBoxAlReves = (CheckBox) findViewById(R.id.checkBoxAlReves);
        imagenAlReves = (ImageView) findViewById(R.id.imagenalreves);
        checkBoxReinado = (CheckBox) findViewById(R.id.checkBoxReinado);
        imagenReinado = (ImageView) findViewById(R.id.imagenreinado);
        checkBoxDonMatias = (CheckBox) findViewById(R.id.checkBoxDonMatias);
        imagenDonMatias = (ImageView) findViewById(R.id.imagendonmatias);
        checkBoxCalendario = (CheckBox) findViewById(R.id.checkBoxCalendario);
        imagenCalendario = (ImageView) findViewById(R.id.imagencalendario);
        checkBoxSieteCruces = (CheckBox) findViewById(R.id.checkBoxSieteCruces);
        imagenSieteCruces = (ImageView) findViewById(R.id.imagensietecruces);
        checkBoxParrillaSimple = (CheckBox) findViewById(R.id.checkBoxParrillaSimple);
        imagenParrillaSimple = (ImageView) findViewById(R.id.imagenparrillasimple);
        checkBoxParrillaCompuesta = (CheckBox) findViewById(R.id.checkBoxParrillaCompuesta);
        imagenParrillaCompuesta = (ImageView) findViewById(R.id.imagenparrillacompuesta);
        checkBoxVocal = (CheckBox) findViewById(R.id.checkBoxVocal);
        imagenVocal = (ImageView) findViewById(R.id.imagenvocal);
        checkBoxAngulo = (CheckBox) findViewById(R.id.checkBoxAngulo);
        imagenAngulo = (ImageView) findViewById(R.id.imagenangulo);
        checkBoxPZ = (CheckBox) findViewById(R.id.checkBoxPZ);
        imagenPZ = (ImageView) findViewById(R.id.imagenpz);
        checkBoxParelinofu = (CheckBox) findViewById(R.id.checkBoxParelinofu);
        imagenParelinofu = (ImageView) findViewById(R.id.imagenparelinofu);
        checkBoxCaracol = (CheckBox) findViewById(R.id.checkBoxCaracol);
        imagenCaracol = (ImageView) findViewById(R.id.imagencaracol);
        checkBoxMurcielago.setChecked(MainActivity.esClaveIncluida(MainActivity.MURCIELAGO,this));
        checkBoxDameTuPico.setChecked(MainActivity.esClaveIncluida(MainActivity.DAME_TU_PICO,this));
        checkBoxNumerica.setChecked(MainActivity.esClaveIncluida(MainActivity.NUMERICA,this));
        checkBoxInvertida.setChecked(MainActivity.esClaveIncluida(MainActivity.INVERTIDA,this));
        checkBoxBadenPowell.setChecked(MainActivity.esClaveIncluida(MainActivity.BADEN_POWELL,this));
        checkBoxMorse.setChecked(MainActivity.esClaveIncluida(MainActivity.MORSE,this));
        checkBoxMasUno.setChecked(MainActivity.esClaveIncluida(MainActivity.MAS1,this));
        checkBoxMenosUno.setChecked(MainActivity.esClaveIncluida(MainActivity.MENOS1,this));
        checkBoxAgujerito.setChecked(MainActivity.esClaveIncluida(MainActivity.AGUJERITO,this));
        checkBoxCenitPolar.setChecked(MainActivity.esClaveIncluida(MainActivity.CENIT_POLAR,this));
        checkBoxNeumatico.setChecked(MainActivity.esClaveIncluida(MainActivity.NEUMATICO,this));
        checkBoxRomana.setChecked(MainActivity.esClaveIncluida(MainActivity.ROMANA,this));
        checkBoxSufamelico.setChecked(MainActivity.esClaveIncluida(MainActivity.SUFAMELICO,this));
        checkBoxLapiznegro.setChecked(MainActivity.esClaveIncluida(MainActivity.LAPIZ_NEGRO,this));
        checkBoxHuerfanito.setChecked(MainActivity.esClaveIncluida(MainActivity.HUERFANITO,this));
        checkBoxOrquidea.setChecked(MainActivity.esClaveIncluida(MainActivity.ORQUIDEA,this));
        checkBoxJulioCesar.setChecked(MainActivity.esClaveIncluida(MainActivity.JULIO_CESAR,this));
        checkBoxAbuelito.setChecked(MainActivity.esClaveIncluida(MainActivity.ABUELITO,this));
        checkBoxEucalipto.setChecked(MainActivity.esClaveIncluida(MainActivity.EUCALIPTO,this));
        checkBoxHombre.setChecked(MainActivity.esClaveIncluida(MainActivity.HOMBRE,this));
        checkBoxAlReves.setChecked(MainActivity.esClaveIncluida(MainActivity.AL_REVES,this));
        checkBoxReinado.setChecked(MainActivity.esClaveIncluida(MainActivity.REINADO,this));
        checkBoxDonMatias.setChecked(MainActivity.esClaveIncluida(MainActivity.DON_MATIAS,this));
        checkBoxCalendario.setChecked(MainActivity.esClaveIncluida(MainActivity.CALENDARIO,this));
        checkBoxSieteCruces.setChecked(MainActivity.esClaveIncluida(MainActivity.SIETE_CRUCES,this));
        checkBoxParrillaSimple.setChecked(MainActivity.esClaveIncluida(MainActivity.PARRILLA_SIMPLE,this));
        checkBoxParrillaCompuesta.setChecked(MainActivity.esClaveIncluida(MainActivity.PARRILLA_COMPUESTA,this));
        checkBoxVocal.setChecked(MainActivity.esClaveIncluida(MainActivity.VOCAL,this));
        checkBoxAngulo.setChecked(MainActivity.esClaveIncluida(MainActivity.ANGULO,this));
        checkBoxPZ.setChecked(MainActivity.esClaveIncluida(MainActivity.PZ,this));
        checkBoxParelinofu.setChecked(MainActivity.esClaveIncluida(MainActivity.PARELINOFU,this));
        checkBoxCaracol.setChecked(MainActivity.esClaveIncluida(MainActivity.CARACOL,this));
        checkBoxMurcielago.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxMurcielago.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.MURCIELAGO,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenMurcielago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.MURCIELAGO,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.MURCIELAGO,PreferenciasActivity.this);
                    checkBoxMurcielago.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.MURCIELAGO,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxDameTuPico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxDameTuPico.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.DAME_TU_PICO,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenDameTuPico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.DAME_TU_PICO,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.DAME_TU_PICO,PreferenciasActivity.this);
                    checkBoxDameTuPico.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.DAME_TU_PICO,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxNumerica.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxNumerica.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.NUMERICA,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenNumerica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.NUMERICA,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.NUMERICA,PreferenciasActivity.this);
                    checkBoxNumerica.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.NUMERICA,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxInvertida.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxInvertida.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.INVERTIDA,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenInvertida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.INVERTIDA,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.INVERTIDA,PreferenciasActivity.this);
                    checkBoxInvertida.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.INVERTIDA,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxBadenPowell.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxBadenPowell.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.BADEN_POWELL,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenBadenPowell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.BADEN_POWELL,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.BADEN_POWELL,PreferenciasActivity.this);
                    checkBoxBadenPowell.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.BADEN_POWELL,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxMorse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxMorse.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.MORSE,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.MORSE,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.MORSE,PreferenciasActivity.this);
                    checkBoxMorse.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.MORSE,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxMasUno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxMasUno.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.MAS1,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenMasUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.MAS1,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.MAS1,PreferenciasActivity.this);
                    checkBoxMasUno.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.MAS1,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxMenosUno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxMenosUno.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.MENOS1,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenMenosUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.MENOS1,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.MENOS1,PreferenciasActivity.this);
                    checkBoxMenosUno.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.MENOS1,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxAgujerito.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxAgujerito.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.AGUJERITO,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenAgujerito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.AGUJERITO,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.AGUJERITO,PreferenciasActivity.this);
                    checkBoxAgujerito.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.AGUJERITO,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxCenitPolar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxCenitPolar.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.CENIT_POLAR,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenCenitPolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.CENIT_POLAR,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.CENIT_POLAR,PreferenciasActivity.this);
                    checkBoxCenitPolar.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.CENIT_POLAR,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxNeumatico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxNeumatico.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.NEUMATICO,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenNeumatico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.NEUMATICO,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.NEUMATICO,PreferenciasActivity.this);
                    checkBoxNeumatico.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.NEUMATICO,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxRomana.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxRomana.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.ROMANA,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenRomana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.ROMANA,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.ROMANA,PreferenciasActivity.this);
                    checkBoxRomana.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.ROMANA,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxSufamelico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxSufamelico.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.SUFAMELICO,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenSufamelico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.SUFAMELICO,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.SUFAMELICO,PreferenciasActivity.this);
                    checkBoxSufamelico.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.SUFAMELICO,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxLapiznegro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxLapiznegro.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.LAPIZ_NEGRO,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenLapiznegro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.LAPIZ_NEGRO,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.LAPIZ_NEGRO,PreferenciasActivity.this);
                    checkBoxLapiznegro.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.LAPIZ_NEGRO,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxHuerfanito.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxHuerfanito.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.HUERFANITO,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenHuerfanito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.HUERFANITO,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.HUERFANITO,PreferenciasActivity.this);
                    checkBoxHuerfanito.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.HUERFANITO,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxOrquidea.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxOrquidea.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.ORQUIDEA,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenOrquidea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.ORQUIDEA,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.ORQUIDEA,PreferenciasActivity.this);
                    checkBoxOrquidea.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.ORQUIDEA,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxJulioCesar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxJulioCesar.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.JULIO_CESAR,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenJulioCesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.JULIO_CESAR,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.JULIO_CESAR,PreferenciasActivity.this);
                    checkBoxJulioCesar.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.JULIO_CESAR,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxAbuelito.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxAbuelito.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.ABUELITO,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenAbuelito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.ABUELITO,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.ABUELITO,PreferenciasActivity.this);
                    checkBoxAbuelito.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.ABUELITO,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxEucalipto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxEucalipto.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.EUCALIPTO,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenEucalipto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.EUCALIPTO,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.EUCALIPTO,PreferenciasActivity.this);
                    checkBoxEucalipto.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.EUCALIPTO,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxHombre.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxHombre.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.HOMBRE,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenHombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.HOMBRE,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.HOMBRE,PreferenciasActivity.this);
                    checkBoxHombre.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.HOMBRE,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxAlReves.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxAlReves.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.AL_REVES,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenAlReves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.AL_REVES,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.AL_REVES,PreferenciasActivity.this);
                    checkBoxAlReves.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.AL_REVES,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxReinado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxReinado.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.REINADO,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenReinado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.REINADO,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.REINADO,PreferenciasActivity.this);
                    checkBoxReinado.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.REINADO,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxDonMatias.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxDonMatias.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.DON_MATIAS,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenDonMatias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.DON_MATIAS,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.DON_MATIAS,PreferenciasActivity.this);
                    checkBoxDonMatias.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.DON_MATIAS,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxCalendario.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxCalendario.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.CALENDARIO,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.CALENDARIO,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.CALENDARIO,PreferenciasActivity.this);
                    checkBoxCalendario.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.CALENDARIO,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxSieteCruces.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxSieteCruces.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.SIETE_CRUCES,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenSieteCruces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.SIETE_CRUCES,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.SIETE_CRUCES,PreferenciasActivity.this);
                    checkBoxSieteCruces.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.SIETE_CRUCES,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxParrillaSimple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxParrillaSimple.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.PARRILLA_SIMPLE,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenParrillaSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.PARRILLA_SIMPLE,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.PARRILLA_SIMPLE,PreferenciasActivity.this);
                    checkBoxParrillaSimple.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.PARRILLA_SIMPLE,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxParrillaCompuesta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxParrillaCompuesta.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.PARRILLA_COMPUESTA,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenParrillaCompuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.PARRILLA_COMPUESTA,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.PARRILLA_COMPUESTA,PreferenciasActivity.this);
                    checkBoxParrillaCompuesta.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.PARRILLA_COMPUESTA,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxVocal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxVocal.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.VOCAL,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenVocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.VOCAL,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.VOCAL,PreferenciasActivity.this);
                    checkBoxVocal.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.VOCAL,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxAngulo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxAngulo.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.ANGULO,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenAngulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.ANGULO,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.ANGULO,PreferenciasActivity.this);
                    checkBoxAngulo.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.ANGULO,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxPZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxPZ.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.PZ,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenPZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.PZ,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.PZ,PreferenciasActivity.this);
                    checkBoxPZ.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.PZ,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxParelinofu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxParelinofu.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.PARELINOFU,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenParelinofu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.PARELINOFU,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.PARELINOFU,PreferenciasActivity.this);
                    checkBoxParelinofu.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.PARELINOFU,!incluida,PreferenciasActivity.this);
                }
            }
        });
        checkBoxCaracol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked && MainActivity.clavesValidas.size() == 1){
                    checkBoxCaracol.setChecked(true);
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    MainActivity.incluirClave(MainActivity.CARACOL,isChecked,PreferenciasActivity.this);
                }
            }
        });
        imagenCaracol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.esClaveIncluida(MainActivity.CARACOL,PreferenciasActivity.this) && MainActivity.clavesValidas.size() == 1){
                    Toast.makeText(PreferenciasActivity.this, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
                }else{
                    boolean incluida = MainActivity.esClaveIncluida(MainActivity.CARACOL,PreferenciasActivity.this);
                    checkBoxCaracol.setChecked(!incluida);
                    MainActivity.incluirClave(MainActivity.CARACOL,!incluida,PreferenciasActivity.this);
                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        finish();
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
            case R.id.menuGuia:
                MainActivity.guiaClaves(this);
                return true;
            case R.id.menuDoble:
                MainActivity.clavesDobles(this);
                return true;
            case R.id.menuTriple:
                MainActivity.clavesTriple(this);
                return true;
            case R.id.menuJuego:
                MainActivity.iniciarJuego(this);
                return true;
            default:
                return true;
        }
    }
}

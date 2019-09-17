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
        checkBoxMurcielago.setChecked(Constantes.esClaveIncluida(Constantes.MURCIELAGO,this));
        checkBoxDameTuPico.setChecked(Constantes.esClaveIncluida(Constantes.DAME_TU_PICO,this));
        checkBoxNumerica.setChecked(Constantes.esClaveIncluida(Constantes.NUMERICA,this));
        checkBoxInvertida.setChecked(Constantes.esClaveIncluida(Constantes.INVERTIDA,this));
        checkBoxBadenPowell.setChecked(Constantes.esClaveIncluida(Constantes.BADEN_POWELL,this));
        checkBoxMorse.setChecked(Constantes.esClaveIncluida(Constantes.MORSE,this));
        checkBoxMasUno.setChecked(Constantes.esClaveIncluida(Constantes.MAS1,this));
        checkBoxMenosUno.setChecked(Constantes.esClaveIncluida(Constantes.MENOS1,this));
        checkBoxAgujerito.setChecked(Constantes.esClaveIncluida(Constantes.AGUJERITO,this));
        checkBoxCenitPolar.setChecked(Constantes.esClaveIncluida(Constantes.CENIT_POLAR,this));
        checkBoxNeumatico.setChecked(Constantes.esClaveIncluida(Constantes.NEUMATICO,this));
        checkBoxRomana.setChecked(Constantes.esClaveIncluida(Constantes.ROMANA,this));
        checkBoxSufamelico.setChecked(Constantes.esClaveIncluida(Constantes.SUFAMELICO,this));
        checkBoxLapiznegro.setChecked(Constantes.esClaveIncluida(Constantes.LAPIZ_NEGRO,this));
        checkBoxHuerfanito.setChecked(Constantes.esClaveIncluida(Constantes.HUERFANITO,this));
        checkBoxOrquidea.setChecked(Constantes.esClaveIncluida(Constantes.ORQUIDEA,this));
        checkBoxJulioCesar.setChecked(Constantes.esClaveIncluida(Constantes.JULIO_CESAR,this));
        checkBoxAbuelito.setChecked(Constantes.esClaveIncluida(Constantes.ABUELITO,this));
        checkBoxEucalipto.setChecked(Constantes.esClaveIncluida(Constantes.EUCALIPTO,this));
        checkBoxHombre.setChecked(Constantes.esClaveIncluida(Constantes.HOMBRE,this));
        checkBoxAlReves.setChecked(Constantes.esClaveIncluida(Constantes.AL_REVES,this));
        checkBoxReinado.setChecked(Constantes.esClaveIncluida(Constantes.REINADO,this));
        checkBoxDonMatias.setChecked(Constantes.esClaveIncluida(Constantes.DON_MATIAS,this));
        checkBoxCalendario.setChecked(Constantes.esClaveIncluida(Constantes.CALENDARIO,this));
        checkBoxSieteCruces.setChecked(Constantes.esClaveIncluida(Constantes.SIETE_CRUCES,this));
        checkBoxParrillaSimple.setChecked(Constantes.esClaveIncluida(Constantes.PARRILLA_SIMPLE,this));
        checkBoxParrillaCompuesta.setChecked(Constantes.esClaveIncluida(Constantes.PARRILLA_COMPUESTA,this));
        checkBoxVocal.setChecked(Constantes.esClaveIncluida(Constantes.VOCAL,this));
        checkBoxAngulo.setChecked(Constantes.esClaveIncluida(Constantes.ANGULO,this));
        checkBoxPZ.setChecked(Constantes.esClaveIncluida(Constantes.PZ,this));
        checkBoxParelinofu.setChecked(Constantes.esClaveIncluida(Constantes.PARELINOFU,this));
        checkBoxCaracol.setChecked(Constantes.esClaveIncluida(Constantes.CARACOL,this));
        checkBoxMurcielago.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxMurcielago,PreferenciasActivity.this,Constantes.MURCIELAGO);
            }
        });
        imagenMurcielago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.MURCIELAGO,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxMurcielago,PreferenciasActivity.this,Constantes.MURCIELAGO);
            }
        });
        checkBoxDameTuPico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxDameTuPico,PreferenciasActivity.this,Constantes.DAME_TU_PICO);
            }
        });
        imagenDameTuPico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.DAME_TU_PICO,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxDameTuPico,PreferenciasActivity.this,Constantes.DAME_TU_PICO);
            }
        });
        checkBoxNumerica.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxNumerica,PreferenciasActivity.this,Constantes.NUMERICA);
            }
        });
        imagenNumerica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.NUMERICA,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxNumerica,PreferenciasActivity.this,Constantes.NUMERICA);
            }
        });
        checkBoxInvertida.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxInvertida,PreferenciasActivity.this,Constantes.INVERTIDA);
            }
        });
        imagenInvertida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.INVERTIDA,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxInvertida,PreferenciasActivity.this,Constantes.INVERTIDA);
            }
        });
        checkBoxBadenPowell.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxBadenPowell,PreferenciasActivity.this,Constantes.BADEN_POWELL);
            }
        });
        imagenBadenPowell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.BADEN_POWELL,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxBadenPowell,PreferenciasActivity.this,Constantes.BADEN_POWELL);
            }
        });
        checkBoxMorse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxMorse,PreferenciasActivity.this,Constantes.MORSE);
            }
        });
        imagenMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.MORSE,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxMorse,PreferenciasActivity.this,Constantes.MORSE);
            }
        });
        checkBoxMasUno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxMasUno,PreferenciasActivity.this,Constantes.MAS1);
            }
        });
        imagenMasUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.MAS1,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxMasUno,PreferenciasActivity.this,Constantes.MAS1);
            }
        });
        checkBoxMenosUno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxMenosUno,PreferenciasActivity.this,Constantes.MENOS1);
            }
        });
        imagenMenosUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.MENOS1,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxMenosUno,PreferenciasActivity.this,Constantes.MENOS1);
            }
        });
        checkBoxAgujerito.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxAgujerito,PreferenciasActivity.this,Constantes.AGUJERITO);
            }
        });
        imagenAgujerito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.AGUJERITO,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxAgujerito,PreferenciasActivity.this,Constantes.AGUJERITO);
            }
        });
        checkBoxCenitPolar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxCenitPolar,PreferenciasActivity.this,Constantes.CENIT_POLAR);
            }
        });
        imagenCenitPolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.CENIT_POLAR,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxCenitPolar,PreferenciasActivity.this,Constantes.CENIT_POLAR);
            }
        });
        checkBoxNeumatico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxNeumatico,PreferenciasActivity.this,Constantes.NEUMATICO);
            }
        });
        imagenNeumatico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.NEUMATICO,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxNeumatico,PreferenciasActivity.this,Constantes.NEUMATICO);
            }
        });
        checkBoxRomana.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxRomana,PreferenciasActivity.this,Constantes.ROMANA);
            }
        });
        imagenRomana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.ROMANA,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxRomana,PreferenciasActivity.this,Constantes.ROMANA);
            }
        });
        checkBoxSufamelico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxSufamelico,PreferenciasActivity.this,Constantes.SUFAMELICO);
            }
        });
        imagenSufamelico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.SUFAMELICO,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxSufamelico,PreferenciasActivity.this,Constantes.SUFAMELICO);
            }
        });
        checkBoxLapiznegro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxLapiznegro,PreferenciasActivity.this,Constantes.LAPIZ_NEGRO);
            }
        });
        imagenLapiznegro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.LAPIZ_NEGRO,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxLapiznegro,PreferenciasActivity.this,Constantes.LAPIZ_NEGRO);
            }
        });
        checkBoxHuerfanito.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxHuerfanito,PreferenciasActivity.this,Constantes.HUERFANITO);
            }
        });
        imagenHuerfanito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.HUERFANITO,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxHuerfanito,PreferenciasActivity.this,Constantes.HUERFANITO);
            }
        });
        checkBoxOrquidea.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxOrquidea,PreferenciasActivity.this,Constantes.ORQUIDEA);
            }
        });
        imagenOrquidea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.ORQUIDEA,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxOrquidea,PreferenciasActivity.this,Constantes.ORQUIDEA);
            }
        });
        checkBoxJulioCesar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxJulioCesar,PreferenciasActivity.this,Constantes.JULIO_CESAR);
            }
        });
        imagenJulioCesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.JULIO_CESAR,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxJulioCesar,PreferenciasActivity.this,Constantes.JULIO_CESAR);
            }
        });
        checkBoxAbuelito.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxAbuelito,PreferenciasActivity.this,Constantes.ABUELITO);
            }
        });
        imagenAbuelito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.ABUELITO,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxAbuelito,PreferenciasActivity.this,Constantes.ABUELITO);
            }
        });
        checkBoxEucalipto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxEucalipto,PreferenciasActivity.this,Constantes.EUCALIPTO);
            }
        });
        imagenEucalipto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.EUCALIPTO,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxEucalipto,PreferenciasActivity.this,Constantes.EUCALIPTO);
            }
        });
        checkBoxHombre.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxHombre,PreferenciasActivity.this,Constantes.HOMBRE);
            }
        });
        imagenHombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.HOMBRE,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxHombre,PreferenciasActivity.this,Constantes.HOMBRE);
            }
        });
        checkBoxAlReves.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxAlReves,PreferenciasActivity.this,Constantes.AL_REVES);
            }
        });
        imagenAlReves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.AL_REVES,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxAlReves,PreferenciasActivity.this,Constantes.AL_REVES);
            }
        });
        checkBoxReinado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxReinado,PreferenciasActivity.this,Constantes.REINADO);
            }
        });
        imagenReinado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.REINADO,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxReinado,PreferenciasActivity.this,Constantes.REINADO);
            }
        });
        checkBoxDonMatias.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxDonMatias,PreferenciasActivity.this,Constantes.DON_MATIAS);
            }
        });
        imagenDonMatias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.DON_MATIAS,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxDonMatias,PreferenciasActivity.this,Constantes.DON_MATIAS);
            }
        });
        checkBoxCalendario.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxCalendario,PreferenciasActivity.this,Constantes.CALENDARIO);
            }
        });
        imagenCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.CALENDARIO,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxCalendario,PreferenciasActivity.this,Constantes.CALENDARIO);
            }
        });
        checkBoxSieteCruces.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxSieteCruces,PreferenciasActivity.this,Constantes.SIETE_CRUCES);
            }
        });
        imagenSieteCruces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.SIETE_CRUCES,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxSieteCruces,PreferenciasActivity.this,Constantes.SIETE_CRUCES);
            }
        });
        checkBoxParrillaSimple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxParrillaSimple,PreferenciasActivity.this,Constantes.PARRILLA_SIMPLE);
            }
        });
        imagenParrillaSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.PARRILLA_SIMPLE,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxParrillaSimple,PreferenciasActivity.this,Constantes.PARRILLA_SIMPLE);
            }
        });
        checkBoxParrillaCompuesta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxParrillaCompuesta, PreferenciasActivity.this,Constantes.PARRILLA_COMPUESTA);
            }
        });
        imagenParrillaCompuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.PARRILLA_COMPUESTA,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxParrillaCompuesta,PreferenciasActivity.this,Constantes.PARRILLA_COMPUESTA);
            }
        });
        checkBoxVocal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxVocal, PreferenciasActivity.this,Constantes.VOCAL);
            }
        });
        imagenVocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.VOCAL,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxVocal,PreferenciasActivity.this,Constantes.VOCAL);
            }
        });
        checkBoxAngulo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxAngulo, PreferenciasActivity.this,Constantes.ANGULO);
            }
        });
        imagenAngulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.ANGULO,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxAngulo,PreferenciasActivity.this,Constantes.ANGULO);
            }
        });
        checkBoxPZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxPZ, PreferenciasActivity.this,Constantes.PZ);
            }
        });
        imagenPZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.PZ,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxPZ,PreferenciasActivity.this,Constantes.PZ);
            }
        });
        checkBoxParelinofu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxParelinofu, PreferenciasActivity.this,Constantes.PARELINOFU);
            }
        });
        imagenParelinofu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.PARELINOFU,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxParelinofu,PreferenciasActivity.this,Constantes.PARELINOFU);
            }
        });
        checkBoxCaracol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constantes.bloquearDesbloquarClave(isChecked,checkBoxCaracol, PreferenciasActivity.this,Constantes.CARACOL);
            }
        });
        imagenCaracol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean incluida = Constantes.esClaveIncluida(Constantes.CARACOL,PreferenciasActivity.this);
                Constantes.bloquearDesbloquarClave(!incluida,checkBoxCaracol,PreferenciasActivity.this,Constantes.CARACOL);
            }
        });
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
            case R.id.menuJuego:
                Constantes.iniciarJuego(this);
                return true;
            default:
                return true;
        }
    }
}

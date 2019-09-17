package com.globalscout;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LinternaMorseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    EditText textoAIluminar;
    Spinner listaMorse;
    String[] datosMorse = {"morse", "morse de murcielago", "morse de dame tu pico", "morse de numerica", "morse de invertida", "morse de baden powell", "morse de sufamelico", "morse de -1", "morse de +1", "morse de hombre", "morse de al reves", "morse de agujerito", "morse de abuelito", "morse de eucalipto", "morse de cenit polar", "morse de neumatico", "morse de numerica de dame tu pico", "morse de numerica de invertida", "morse de numerica de baden powell", "morse de numerica de sufamelico", "morse de numerica de -1", "morse de numerica de +1", "morse de numerica de hombre", "morse de numerica de al reves", "morse de numerica de cenit polar"};
    String codificacion = "";
    boolean inicializado = false;
    int millisPunto = 400;
    int millisRaya = 1200;
    int CAMERA_PERMISION = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linterna_morse);

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

                View view = LinternaMorseActivity.this.getCurrentFocus();
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
        boolean deviceHasFlash = getApplication().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if(!deviceHasFlash){
            Toast.makeText(this, "El telefono no tiene flash", Toast.LENGTH_LONG).show();
            finish();
        }
        listaMorse = (Spinner) findViewById(R.id.spinnerMorse);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datosMorse);
        listaMorse.setAdapter(adaptador);
        textoAIluminar = (EditText) findViewById(R.id.textoAIluminar);

    }

    public void borrarTodoLinternaMorse (View view){
        textoAIluminar.setText("");
    }

    public void iluminarMarshmallow(){
        try {
            CameraManager camManager;
            camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            String cameraId = camManager.getCameraIdList()[0]; // Usually front camera is at 0 position.
            for (int i = 0; i<codificacion.length(); i++){
                switch (codificacion.charAt(i)) {
                    case ('.'):
                        camManager.setTorchMode(cameraId, true);
                        Thread.sleep(millisPunto);
                        camManager.setTorchMode(cameraId, false);
                        break;
                    case ('-'):
                        camManager.setTorchMode(cameraId, true);
                        Thread.sleep(millisRaya);
                        camManager.setTorchMode(cameraId, false);
                        break;
                    case ('/'):
                        camManager.setTorchMode(cameraId, false);
                        Thread.sleep(millisPunto + 200);
                        break;
                    default:
                        camManager.setTorchMode(cameraId, false);
                        Thread.sleep(millisRaya + 200);
                        break;
                }                }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void iluminar(View view) {
        String texto = textoAIluminar.getText().toString().toUpperCase() + "  ";
        switch (listaMorse.getSelectedItemPosition()) {
            case (0):
                codificacion = Claves.aMorse(texto);
                break;
            case (1):
                codificacion = Claves.aMorse(Claves.murcielago(texto));
                break;
            case (2):
                codificacion = Claves.aMorse(Claves.dameTuPico(texto));
                break;
            case (3):
                codificacion = Claves.aMorse(Claves.numerica(texto));
                break;
            case (4):
                codificacion = Claves.aMorse(Claves.invertida(texto));
                break;
            case (5):
                codificacion = Claves.aMorse(Claves.badenPowell(texto));
                break;
            case (6):
                codificacion = Claves.aMorse(Claves.sufamelico(texto));
                break;
            case (7):
                codificacion = Claves.aMorse(Claves.m1(texto));
                break;
            case (8):
                codificacion = Claves.aMorse(Claves.M1(texto));
                break;
            case (9):
                codificacion = Claves.aMorse(Claves.aHombre(texto));
                break;
            case (10):
                codificacion = Claves.aMorse(Claves.alReves(texto));
                break;
            case (11):
                codificacion = Claves.aMorse(Claves.agujerito(texto));
                break;
            case (12):
                codificacion = Claves.aMorse(Claves.abuelito(texto));
                break;
            case (13):
                codificacion = Claves.aMorse(Claves.eucalipto(texto));
                break;
            case (14):
                codificacion = Claves.aMorse(Claves.cenitPolar(texto));
                break;
            case (15):
                codificacion = Claves.aMorse(Claves.neumatico(texto));
                break;
            case (16):
                codificacion = Claves.aMorse(Claves.numerica(Claves.dameTuPico(texto)));
                break;
            case (17):
                codificacion = Claves.aMorse(Claves.numerica(Claves.invertida(texto)));
                break;
            case (18):
                codificacion = Claves.aMorse(Claves.numerica(Claves.badenPowell(texto)));
                break;
            case (19):
                codificacion = Claves.aMorse(Claves.numerica(Claves.sufamelico(texto)));
                break;
            case (20):
                codificacion = Claves.aMorse(Claves.numerica(Claves.m1(texto)));
                break;
            case (21):
                codificacion = Claves.aMorse(Claves.numerica(Claves.M1(texto)));
                break;
            case (22):
                codificacion = Claves.aMorse(Claves.numerica(Claves.aHombre(texto)));
                break;
            case (23):
                codificacion = Claves.aMorse(Claves.numerica(Claves.alReves(texto)));
                break;
            default:
                codificacion = Claves.aMorse(Claves.numerica(Claves.cenitPolar(texto)));
                break;
        }
        if(Build.VERSION.SDK_INT >= 23){
            if ((ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.FLASHLIGHT)
                    != PackageManager.PERMISSION_GRANTED)) {
                List<String> listaPermisosDeCamara = new ArrayList<>();
                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    listaPermisosDeCamara.add(Manifest.permission.CAMERA);
                }
                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.FLASHLIGHT) != PackageManager.PERMISSION_GRANTED) {
                    listaPermisosDeCamara.add(Manifest.permission.FLASHLIGHT);
                }
                ActivityCompat.requestPermissions(this, listaPermisosDeCamara.toArray(new String[listaPermisosDeCamara.size()]),CAMERA_PERMISION);
            }else{
               iluminarMarshmallow();
            }
        } else{
            try {
                Camera cam = Camera.open();
                Camera.Parameters params = cam.getParameters();
                if(!inicializado){
                    cam.setPreviewTexture(new SurfaceTexture(0));
                    cam.startPreview();
                    inicializado = true;
                }
                for (int i = 0; i<codificacion.length(); i++){
                    switch (codificacion.charAt(i)) {
                        case ('.'):
                            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                            cam.setParameters(params);
                            cam.startPreview();
                            Thread.sleep(millisPunto);
                            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                            cam.setParameters(params);
                            break;
                        case ('-'):
                            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                            cam.setParameters(params);
                            cam.startPreview();
                            Thread.sleep(millisRaya);
                            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                            cam.setParameters(params);
                            break;
                        case ('/'):
                            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                            cam.setParameters(params);
                            Thread.sleep(millisPunto + 200);
                            break;
                        default:
                            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                            cam.setParameters(params);
                            Thread.sleep(millisRaya + 200);
                            break;
                    }
                }
                cam.stopPreview();
                cam.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        if ((ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this,
                Manifest.permission.FLASHLIGHT)
                != PackageManager.PERMISSION_GRANTED)) {
            Toast.makeText(this,"No se puede hacer clave morse con la linterna si no aceptas los permisos pedidos",Toast.LENGTH_LONG).show();
        }else{
            iluminarMarshmallow();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        finish();
        switch (id){
            case R.id.menuSemaforo:
                Constantes.semaforo(this);
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

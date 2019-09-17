package com.globalscout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class Constantes {
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
    final static String CLAVE_PREFERENCES = "CLAVE_";
    final static String HISTORIAL = "HISTORIAL_";
    final static int TRADUCCION_VENTANA = 2450;
    final static int GENERICO = 1700;
    static ArrayList<Integer> clavesValidas = new ArrayList<Integer>();
    static ArrayList<Integer> clavesPosibles = new ArrayList<Integer>();
    static int posSel = 0;

    public static void guardarHistorial(int numero, String mensaje, Context context){
        SharedPreferences claveIncluida = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = claveIncluida.edit();
        editor.putString((HISTORIAL+numero),mensaje);
        editor.commit();
    }

    public static String obtenerHistorial(int numero, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString((HISTORIAL+numero),"");
    }


    public static void incluirClave(int clave, boolean incluida, Context context){
        SharedPreferences claveIncluida = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = claveIncluida.edit();
        editor.putBoolean((CLAVE_PREFERENCES+clave),incluida);
        editor.commit();
        actualizarIncluidos(context);
    }

    public static boolean esClaveIncluida(int clave, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean((CLAVE_PREFERENCES+clave),true);
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

    public static void tecladoEspecial(Context context){
        Intent intent = new Intent(context, TecladoEspecialActivity.class);
        context.startActivity(intent);
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

    public static void bloquearDesbloquarClave(boolean incluir, CheckBox checkBox, Context context, int clave){
        if(esClaveIncluida(clave,context) && Constantes.clavesValidas.size() == 1){
            checkBox.setChecked(true);
            Toast.makeText(context, "No se pueden bloquear todas las claves", Toast.LENGTH_LONG).show();
        }else{
            checkBox.setChecked(incluir);
            incluirClave(clave,incluir,context);
        }
    }
}

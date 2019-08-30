package com.globalscout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class AdaptadorGrillaClaves extends BaseAdapter {
    private Context context;

    public AdaptadorGrillaClaves(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return MainActivity.clavesValidas.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        final View row;
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.item_grilla_clave, parent, false);
        final ImageView imagen;
        imagen = (ImageView) row.findViewById(R.id.imagen);
        final int j = i;
        switch (MainActivity.clavesValidas.get(j)){
            case MainActivity.MURCIELAGO:
                imagen.setImageResource(R.drawable.guiamurcielago);
                break;
            case MainActivity.DAME_TU_PICO:
                imagen.setImageResource(R.drawable.guiadametupico);
                break;
            case MainActivity.NUMERICA:
                imagen.setImageResource(R.drawable.guianumerica);
                break;
            case MainActivity.INVERTIDA:
                imagen.setImageResource(R.drawable.guiainvertida);
                break;
            case MainActivity.BADEN_POWELL:
                imagen.setImageResource(R.drawable.guiabadenpowell);
                break;
            case MainActivity.MORSE:
                imagen.setImageResource(R.drawable.guiamorse);
                break;
            case MainActivity.MAS1:
                imagen.setImageResource(R.drawable.guiamasuno);
                break;
            case MainActivity.MENOS1:
                imagen.setImageResource(R.drawable.guiamenosuno);
                break;
            case MainActivity.AGUJERITO:
                imagen.setImageResource(R.drawable.guiaagujerito);
                break;
            case MainActivity.CENIT_POLAR:
                imagen.setImageResource(R.drawable.guiacenitpolar);
                break;
            case MainActivity.NEUMATICO:
                imagen.setImageResource(R.drawable.guianeumatico);
                break;
            case MainActivity.ROMANA:
                imagen.setImageResource(R.drawable.guiaromana);
                break;
            case MainActivity.SUFAMELICO:
                imagen.setImageResource(R.drawable.guiasufamelico);
                break;
            case MainActivity.LAPIZ_NEGRO:
                imagen.setImageResource(R.drawable.guialapiznegro);
                break;
            case MainActivity.HUERFANITO:
                imagen.setImageResource(R.drawable.guiahuerfanito);
                break;
            case MainActivity.ORQUIDEA:
                imagen.setImageResource(R.drawable.guiaorquidea);
                break;
            case MainActivity.JULIO_CESAR:
                imagen.setImageResource(R.drawable.guiajuliocesar);
                break;
            case MainActivity.ABUELITO:
                imagen.setImageResource(R.drawable.guiaabuelito);
                break;
            case MainActivity.EUCALIPTO:
                imagen.setImageResource(R.drawable.guiaeucalipto);
                break;
            case MainActivity.HOMBRE:
                imagen.setImageResource(R.drawable.guiahombre);
                break;
            case MainActivity.AL_REVES:
                imagen.setImageResource(R.drawable.guiaalreves);
                break;
            case MainActivity.REINADO:
                imagen.setImageResource(R.drawable.guiareinado);
                break;
            case MainActivity.DON_MATIAS:
                imagen.setImageResource(R.drawable.guiadonmatias);
                break;
            case MainActivity.CALENDARIO:
                imagen.setImageResource(R.drawable.guiacalendario);
                break;
            case MainActivity.SIETE_CRUCES:
                imagen.setImageResource(R.drawable.guiasietecruces);
                break;
            case MainActivity.PARRILLA_SIMPLE:
                imagen.setImageResource(R.drawable.guiaparrillasimple);
                break;
            case MainActivity.PARRILLA_COMPUESTA:
                imagen.setImageResource(R.drawable.guiaparrillacompuesta);
                break;
            case MainActivity.VOCAL:
                imagen.setImageResource(R.drawable.guiavocal);
                break;
            case MainActivity.ANGULO:
                imagen.setImageResource(R.drawable.guiaangulo);
                break;
            case MainActivity.PZ:
                imagen.setImageResource(R.drawable.guiapz);
                break;
            case MainActivity.PARELINOFU:
                imagen.setImageResource(R.drawable.guiaparelinofu);
                break;
            case MainActivity.CARACOL:
                imagen.setImageResource(R.drawable.guiacaracol);
                break;
        }
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.posSel = j;
                ((Activity)context).finish();
            }
        });
        return row;
    }
}

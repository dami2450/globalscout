package com.globalscout;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class AdaptadorGrillaClaves extends BaseAdapter {
    private Context context;

    public AdaptadorGrillaClaves(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return Constantes.clavesValidas.size();
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
        switch (Constantes.clavesValidas.get(j)){
            case Constantes.MURCIELAGO:
                imagen.setImageResource(R.drawable.guiamurcielago);
                break;
            case Constantes.DAME_TU_PICO:
                imagen.setImageResource(R.drawable.guiadametupico);
                break;
            case Constantes.NUMERICA:
                imagen.setImageResource(R.drawable.guianumerica);
                break;
            case Constantes.INVERTIDA:
                imagen.setImageResource(R.drawable.guiainvertida);
                break;
            case Constantes.BADEN_POWELL:
                imagen.setImageResource(R.drawable.guiabadenpowell);
                break;
            case Constantes.MORSE:
                imagen.setImageResource(R.drawable.guiamorse);
                break;
            case Constantes.MAS1:
                imagen.setImageResource(R.drawable.guiamasuno);
                break;
            case Constantes.MENOS1:
                imagen.setImageResource(R.drawable.guiamenosuno);
                break;
            case Constantes.AGUJERITO:
                imagen.setImageResource(R.drawable.guiaagujerito);
                break;
            case Constantes.CENIT_POLAR:
                imagen.setImageResource(R.drawable.guiacenitpolar);
                break;
            case Constantes.NEUMATICO:
                imagen.setImageResource(R.drawable.guianeumatico);
                break;
            case Constantes.ROMANA:
                imagen.setImageResource(R.drawable.guiaromana);
                break;
            case Constantes.SUFAMELICO:
                imagen.setImageResource(R.drawable.guiasufamelico);
                break;
            case Constantes.LAPIZ_NEGRO:
                imagen.setImageResource(R.drawable.guialapiznegro);
                break;
            case Constantes.HUERFANITO:
                imagen.setImageResource(R.drawable.guiahuerfanito);
                break;
            case Constantes.ORQUIDEA:
                imagen.setImageResource(R.drawable.guiaorquidea);
                break;
            case Constantes.JULIO_CESAR:
                imagen.setImageResource(R.drawable.guiajuliocesar);
                break;
            case Constantes.ABUELITO:
                imagen.setImageResource(R.drawable.guiaabuelito);
                break;
            case Constantes.EUCALIPTO:
                imagen.setImageResource(R.drawable.guiaeucalipto);
                break;
            case Constantes.HOMBRE:
                imagen.setImageResource(R.drawable.guiahombre);
                break;
            case Constantes.AL_REVES:
                imagen.setImageResource(R.drawable.guiaalreves);
                break;
            case Constantes.REINADO:
                imagen.setImageResource(R.drawable.guiareinado);
                break;
            case Constantes.DON_MATIAS:
                imagen.setImageResource(R.drawable.guiadonmatias);
                break;
            case Constantes.CALENDARIO:
                imagen.setImageResource(R.drawable.guiacalendario);
                break;
            case Constantes.SIETE_CRUCES:
                imagen.setImageResource(R.drawable.guiasietecruces);
                break;
            case Constantes.PARRILLA_SIMPLE:
                imagen.setImageResource(R.drawable.guiaparrillasimple);
                break;
            case Constantes.PARRILLA_COMPUESTA:
                imagen.setImageResource(R.drawable.guiaparrillacompuesta);
                break;
            case Constantes.VOCAL:
                imagen.setImageResource(R.drawable.guiavocal);
                break;
            case Constantes.ANGULO:
                imagen.setImageResource(R.drawable.guiaangulo);
                break;
            case Constantes.PZ:
                imagen.setImageResource(R.drawable.guiapz);
                break;
            case Constantes.PARELINOFU:
                imagen.setImageResource(R.drawable.guiaparelinofu);
                break;
            case Constantes.CARACOL:
                imagen.setImageResource(R.drawable.guiacaracol);
                break;
        }
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constantes.posSel = j;
                ((Activity)context).finish();
            }
        });
        return row;
    }
}

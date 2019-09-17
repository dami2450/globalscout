package com.globalscout;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorListaTraducciones extends BaseAdapter {
    private Context context;
    private String texto;

    public AdaptadorListaTraducciones(Context context, String texto){
        this.context = context;
        this.texto = texto;
    }

    @Override
    public int getCount() {
        return Constantes.clavesPosibles.size();
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
        row = inflater.inflate(R.layout.item_lista_traduccion, parent, false);
        final TextView titulo, vista_previaTraduccion;
        titulo = (TextView) row.findViewById(R.id.titulo);
        vista_previaTraduccion = (TextView) row.findViewById(R.id.vista_previaTraduccion);
        String traduccionPosible = "";
        final int j = i;
        switch (Constantes.clavesPosibles.get(j)){
            case Constantes.MURCIELAGO:
                titulo.setText("MURCIELAGO:");
                traduccionPosible = Claves.murcielago(texto);
                break;
            case Constantes.DAME_TU_PICO:
                titulo.setText("DAME TU PICO:");
                traduccionPosible = Claves.dameTuPico(texto);
                break;
            case Constantes.NUMERICA:
                titulo.setText("NUMERICA:");
                traduccionPosible = Claves.numerica(texto);
                break;
            case Constantes.INVERTIDA:
                titulo.setText("INVERTIDA:");
                traduccionPosible = Claves.invertida(texto);
                break;
            case Constantes.BADEN_POWELL:
                titulo.setText("BADEN POWELL:");
                traduccionPosible = Claves.badenPowell(texto);
                break;
            case Constantes.MORSE:
                titulo.setText("MORSE:");
                traduccionPosible = Claves.deMorse(texto);
                break;
            case Constantes.MAS1:
                titulo.setText("MAS 1:");
                traduccionPosible = Claves.M1(texto);
                break;
            case Constantes.MENOS1:
                titulo.setText("MENOS 1:");
                traduccionPosible = Claves.m1(texto);
                break;
            case Constantes.AGUJERITO:
                titulo.setText("AGUJERITO:");
                traduccionPosible = Claves.agujerito(texto);
                break;
            case Constantes.CENIT_POLAR:
                titulo.setText("CENIT POLAR:");
                traduccionPosible = Claves.cenitPolar(texto);
                break;
            case Constantes.NEUMATICO:
                titulo.setText("NEUMATICO:");
                traduccionPosible = Claves.neumatico(texto);
                break;
            case Constantes.ROMANA:
                titulo.setText("ROMANA:");
                traduccionPosible = Claves.deRomana(texto);
                break;
            case Constantes.SUFAMELICO:
                titulo.setText("SUFAMELICO:");
                traduccionPosible = Claves.sufamelico(texto);
                break;
            case Constantes.LAPIZ_NEGRO:
                titulo.setText("LAPIZ NEGRO:");
                traduccionPosible = Claves.lapizNegro(texto);
                break;
            case Constantes.HUERFANITO:
                titulo.setText("HUERFANITO:");
                traduccionPosible = Claves.huerfanito(texto);
                break;
            case Constantes.ORQUIDEA:
                titulo.setText("ORQUIDEA:");
                traduccionPosible = Claves.orquidea(texto);
                break;
            case Constantes.JULIO_CESAR:
                titulo.setText("JULIO CESAR:");
                traduccionPosible = Claves.julioCesar(texto);
                break;
            case Constantes.ABUELITO:
                titulo.setText("ABUELITO:");
                traduccionPosible = Claves.abuelito(texto);
                break;
            case Constantes.EUCALIPTO:
                titulo.setText("EUCALIPTO:");
                traduccionPosible = Claves.eucalipto(texto);
                break;
            case Constantes.HOMBRE:
                titulo.setText("HOMBRE:");
                traduccionPosible = Claves.deHombre(texto);
                break;
            case Constantes.AL_REVES:
                titulo.setText("AL REVES:");
                traduccionPosible = Claves.alReves(texto);
                break;
            case Constantes.REINADO:
                titulo.setText("REINADO:");
                traduccionPosible = Claves.reinado(texto);
                break;
            case Constantes.DON_MATIAS:
                titulo.setText("DON MATIAS:");
                traduccionPosible = Claves.donMatias(texto);
                break;
            case Constantes.VOCAL:
                titulo.setText("VOCAL:");
                traduccionPosible = Claves.vocal(texto);
                break;
            case Constantes.PZ:
                titulo.setText("PZ:");
                traduccionPosible = Claves.dePZ(texto);
                break;
            case Constantes.PARELINOFU:
                titulo.setText("PARELINOFU:");
                traduccionPosible = Claves.parelinofu(texto);
                break;
        }
        vista_previaTraduccion.setText(traduccionPosible);
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constantes.posSel = j;
                ((Activity)context).finish();
            }
        });
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean encontrada = false;
                int pos = 0;
                while(!encontrada && pos < Constantes.clavesValidas.size()){
                    if(Constantes.clavesValidas.get(pos) == Constantes.clavesPosibles.get(j)){
                        encontrada = true;
                    }else{
                        pos = pos + 1;
                    }
                }
                Constantes.posSel = pos;
                ((Activity)context).finish();
            }
        });
        return row;
    }
}

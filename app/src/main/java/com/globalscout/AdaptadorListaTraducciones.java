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
        return MainActivity.clavesPosibles.size();
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
        switch (MainActivity.clavesPosibles.get(j)){
            case MainActivity.MURCIELAGO:
                titulo.setText("MURCIELAGO:");
                traduccionPosible = Claves.murcielago(texto);
                break;
            case MainActivity.DAME_TU_PICO:
                titulo.setText("DAME TU PICO:");
                traduccionPosible = Claves.dameTuPico(texto);
                break;
            case MainActivity.NUMERICA:
                titulo.setText("NUMERICA:");
                traduccionPosible = Claves.numerica(texto);
                break;
            case MainActivity.INVERTIDA:
                titulo.setText("INVERTIDA:");
                traduccionPosible = Claves.invertida(texto);
                break;
            case MainActivity.BADEN_POWELL:
                titulo.setText("BADEN POWELL:");
                traduccionPosible = Claves.badenPowell(texto);
                break;
            case MainActivity.MORSE:
                titulo.setText("MORSE:");
                traduccionPosible = Claves.deMorse(texto);
                break;
            case MainActivity.MAS1:
                titulo.setText("MAS 1:");
                traduccionPosible = Claves.M1(texto);
                break;
            case MainActivity.MENOS1:
                titulo.setText("MENOS 1:");
                traduccionPosible = Claves.m1(texto);
                break;
            case MainActivity.AGUJERITO:
                titulo.setText("AGUJERITO:");
                traduccionPosible = Claves.agujerito(texto);
                break;
            case MainActivity.CENIT_POLAR:
                titulo.setText("CENIT POLAR:");
                traduccionPosible = Claves.cenitPolar(texto);
                break;
            case MainActivity.NEUMATICO:
                titulo.setText("NEUMATICO:");
                traduccionPosible = Claves.neumatico(texto);
                break;
            case MainActivity.ROMANA:
                titulo.setText("ROMANA:");
                traduccionPosible = Claves.deRomana(texto);
                break;
            case MainActivity.SUFAMELICO:
                titulo.setText("SUFAMELICO:");
                traduccionPosible = Claves.sufamelico(texto);
                break;
            case MainActivity.LAPIZ_NEGRO:
                titulo.setText("LAPIZ NEGRO:");
                traduccionPosible = Claves.lapizNegro(texto);
                break;
            case MainActivity.HUERFANITO:
                titulo.setText("HUERFANITO:");
                traduccionPosible = Claves.huerfanito(texto);
                break;
            case MainActivity.ORQUIDEA:
                titulo.setText("ORQUIDEA:");
                traduccionPosible = Claves.orquidea(texto);
                break;
            case MainActivity.JULIO_CESAR:
                titulo.setText("JULIO CESAR:");
                traduccionPosible = Claves.julioCesar(texto);
                break;
            case MainActivity.ABUELITO:
                titulo.setText("ABUELITO:");
                traduccionPosible = Claves.abuelito(texto);
                break;
            case MainActivity.EUCALIPTO:
                titulo.setText("EUCALIPTO:");
                traduccionPosible = Claves.eucalipto(texto);
                break;
            case MainActivity.HOMBRE:
                titulo.setText("HOMBRE:");
                traduccionPosible = Claves.deHombre(texto);
                break;
            case MainActivity.AL_REVES:
                titulo.setText("AL REVES:");
                traduccionPosible = Claves.alReves(texto);
                break;
            case MainActivity.REINADO:
                titulo.setText("REINADO:");
                traduccionPosible = Claves.reinado(texto);
                break;
            case MainActivity.DON_MATIAS:
                titulo.setText("DON MATIAS:");
                traduccionPosible = Claves.donMatias(texto);
                break;
            case MainActivity.VOCAL:
                titulo.setText("VOCAL:");
                traduccionPosible = Claves.vocal(texto);
                break;
            case MainActivity.PZ:
                titulo.setText("PZ:");
                traduccionPosible = Claves.dePZ(texto);
                break;
            case MainActivity.PARELINOFU:
                titulo.setText("PARELINOFU:");
                traduccionPosible = Claves.parelinofu(texto);
                break;
        }
        vista_previaTraduccion.setText(traduccionPosible);
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.posSel = j;
                ((Activity)context).finish();
            }
        });
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean encontrada = false;
                int pos = 0;
                while(!encontrada && pos < MainActivity.clavesValidas.size()){
                    if(MainActivity.clavesValidas.get(pos) == MainActivity.clavesPosibles.get(j)){
                        encontrada = true;
                    }else{
                        pos = pos + 1;
                    }
                }
                MainActivity.posSel = pos;
                ((Activity)context).finish();
            }
        });
        return row;
    }
}

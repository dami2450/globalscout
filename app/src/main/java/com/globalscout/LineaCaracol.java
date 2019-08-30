package com.globalscout;

public class LineaCaracol {
    String texto;

    public LineaCaracol(){
        texto = "";
    }

    public void agrgarLetra(String letra, boolean adelante){
        if(adelante){
            texto = texto + letra;
        }else{
            texto = letra + texto;
        }
    }

    public String obtenerTexto(){
        return texto;
    }

}

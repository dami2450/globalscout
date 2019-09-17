package com.globalscout;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by damian on 8/6/2016.
 */
public class Claves {

    public static HashMap<String, Integer> getEmoticons(){
        HashMap<String, Integer> emoticons = new HashMap<String, Integer>();
        emoticons.put("asc", R.drawable.a7c);
        emoticons.put("bsc", R.drawable.b7c);
        emoticons.put("csc", R.drawable.c7c);
        emoticons.put("dsc", R.drawable.d7c);
        emoticons.put("esc", R.drawable.e7c);
        emoticons.put("fsc", R.drawable.f7c);
        emoticons.put("gsc", R.drawable.g7c);
        emoticons.put("hsc", R.drawable.h7c);
        emoticons.put("isc", R.drawable.i7c);
        emoticons.put("jsc", R.drawable.j7c);
        emoticons.put("ksc", R.drawable.k7c);
        emoticons.put("lsc", R.drawable.l7c);
        emoticons.put("msc", R.drawable.m7c);
        emoticons.put("nsc", R.drawable.n7c);
        emoticons.put("ñsc", R.drawable.nn7c);
        emoticons.put("osc", R.drawable.o7c);
        emoticons.put("psc", R.drawable.p7c);
        emoticons.put("qsc", R.drawable.q7c);
        emoticons.put("rsc", R.drawable.r7c);
        emoticons.put("ssc", R.drawable.s7c);
        emoticons.put("tsc", R.drawable.t7c);
        emoticons.put("usc", R.drawable.u7c);
        emoticons.put("vsc", R.drawable.v7c);
        emoticons.put("wsc", R.drawable.w7c);
        emoticons.put("xsc", R.drawable.x7c);
        emoticons.put("ysc", R.drawable.y7c);
        emoticons.put("zsc", R.drawable.z7c);
        emoticons.put("apc", R.drawable.apc);
        emoticons.put("bpc", R.drawable.bpc);
        emoticons.put("cpc", R.drawable.cpc);
        emoticons.put("dpc", R.drawable.dpc);
        emoticons.put("epc", R.drawable.epc);
        emoticons.put("fpc", R.drawable.fpc);
        emoticons.put("gpc", R.drawable.gpc);
        emoticons.put("hpc", R.drawable.hpc);
        emoticons.put("ipc", R.drawable.ipc);
        emoticons.put("jpc", R.drawable.jpc);
        emoticons.put("kpc", R.drawable.kpc);
        emoticons.put("lpc", R.drawable.lpc);
        emoticons.put("mpc", R.drawable.mpc);
        emoticons.put("npc", R.drawable.npc);
        emoticons.put("ñpc", R.drawable.nnpc);
        emoticons.put("opc", R.drawable.opc);
        emoticons.put("ppc", R.drawable.ppc);
        emoticons.put("qpc", R.drawable.qpc);
        emoticons.put("rpc", R.drawable.rpc);
        emoticons.put("spc", R.drawable.spc);
        emoticons.put("tpc", R.drawable.tpc);
        emoticons.put("upc", R.drawable.upc);
        emoticons.put("vpc", R.drawable.vpc);
        emoticons.put("wpc", R.drawable.wpc);
        emoticons.put("xpc", R.drawable.xpc);
        emoticons.put("ypc", R.drawable.ypc);
        emoticons.put("zpc", R.drawable.zpc);
        emoticons.put("aps", R.drawable.aps);
        emoticons.put("bps", R.drawable.bps);
        emoticons.put("cps", R.drawable.cps);
        emoticons.put("dps", R.drawable.dps);
        emoticons.put("eps", R.drawable.eps);
        emoticons.put("fps", R.drawable.fps);
        emoticons.put("gps", R.drawable.gps);
        emoticons.put("hps", R.drawable.hps);
        emoticons.put("ips", R.drawable.ips);
        emoticons.put("jps", R.drawable.jps);
        emoticons.put("kps", R.drawable.kps);
        emoticons.put("lps", R.drawable.lps);
        emoticons.put("mps", R.drawable.mps);
        emoticons.put("nps", R.drawable.nps);
        emoticons.put("ñps", R.drawable.nnps);
        emoticons.put("ops", R.drawable.ops);
        emoticons.put("pps", R.drawable.pps);
        emoticons.put("qps", R.drawable.qps);
        emoticons.put("rps", R.drawable.rps);
        emoticons.put("sps", R.drawable.sps);
        emoticons.put("tps", R.drawable.tps);
        emoticons.put("ups", R.drawable.ups);
        emoticons.put("vps", R.drawable.vps);
        emoticons.put("wps", R.drawable.wps);
        emoticons.put("xps", R.drawable.xps);
        emoticons.put("yps", R.drawable.yps);
        emoticons.put("zps", R.drawable.zps);
        emoticons.put("aan", R.drawable.aang);
        emoticons.put("ean", R.drawable.eang);
        emoticons.put("ian", R.drawable.iang);
        emoticons.put("oan", R.drawable.oang);
        emoticons.put("uan", R.drawable.uang);
        return  emoticons;
    }

    public static String reemplazarCaracteresSimbolos(String texto, HashMap<Character, String> claveSimbolos){
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            String nuevoString = "" + texto.toUpperCase().charAt(i);

            for (Map.Entry<Character, String> entry : claveSimbolos.entrySet()) {
                if (texto.toUpperCase().charAt(i) == entry.getKey()) {
                    nuevoString = entry.getValue();
                    break;
                }
            }
            resultado = resultado + nuevoString;
        }
        return resultado;
    }

    public static String reemplazarCaracteres(String texto, HashMap<Character, Character> clave){
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            Character nuevoCaracter = texto.toUpperCase().charAt(i);
            for (Map.Entry<Character, Character> entry : clave.entrySet()) {
                if (texto.toUpperCase().charAt(i) == entry.getKey()) {
                    nuevoCaracter = entry.getValue();
                    break;
                }
            }
            resultado = resultado + nuevoCaracter;
        }
        return resultado;
    }

    public static String reemplazarCaracteresCorrediza(String texto, HashMap<Character, Integer> letras, HashMap<Integer, Character> numeros, int cantidad){
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            Character nuevoCaracter = texto.toUpperCase().charAt(i);
            for (Map.Entry<Character, Integer> entry : letras.entrySet()) {
                if (texto.toUpperCase().charAt(i) == entry.getKey()) {
                    Integer original = entry.getValue();
                    Integer cambiado = original + cantidad;
                    if(cambiado < 1 ){
                        cambiado = cambiado + 27;
                    }else{
                        if(cambiado > 27){
                            cambiado = cambiado - 27;
                        }
                    }
                    for (Map.Entry<Integer, Character> entryFinal : numeros.entrySet()) {
                        if (cambiado == entryFinal.getKey()) {
                            nuevoCaracter = entryFinal.getValue();
                            break;
                        }
                    }
                    break;
                }
            }
            resultado = resultado + nuevoCaracter;
        }
        return resultado;
    }

    public static String agregarCaracterLargo(String caracterAtraducir, HashMap<String, String> clave){
        String resultado = caracterAtraducir;
        for (Map.Entry<String, String> entry : clave.entrySet()) {
            if (caracterAtraducir.equals(entry.getKey())) {
                resultado = entry.getValue();
                break;
            }
        }
        return resultado;
    }

    public static String agregarCaracterLargoConBarra(String caracterAtraducir, HashMap<String, String> clave, boolean barra){
        String resultado = caracterAtraducir;
        for (Map.Entry<String, String> entry : clave.entrySet()) {
            if (caracterAtraducir.equals(entry.getKey())) {
                resultado = entry.getValue();
                if(barra){
                    resultado = resultado + "/";
                }
                break;
            }
        }
        return resultado;
    }

    public static String caracolizar(String texto){
        ArrayList<LineaCaracol> lineas = new ArrayList<LineaCaracol>();
        String textoCaracolizable = "";
        for(int i = 0; i < texto.length(); i++){
            if(Character.isLetter(texto.charAt(i)) || Character.isDigit(texto.charAt(i))){
                textoCaracolizable = textoCaracolizable + texto.charAt(i);
            }
        }
        if(textoCaracolizable.length() < 3){
            LineaCaracol linea = new LineaCaracol();
            linea.agrgarLetra(textoCaracolizable,true);
            lineas.add(linea);
        }else{
            int maximo = 2;
            boolean adelante = true;
            int pos = 0;
            while (pos < textoCaracolizable.length()){
                if((pos + maximo) <= textoCaracolizable.length()){
                    if(adelante){
                        if(lineas.size() == 0){
                            LineaCaracol linea = new LineaCaracol();
                            linea.agrgarLetra(textoCaracolizable.substring(0,2),adelante);
                            adelante = false;
                            pos = 2;
                            maximo = 3;
                            lineas.add(linea);
                        }else{
                            LineaCaracol lineaArriba = new LineaCaracol();
                            lineaArriba.agrgarLetra(textoCaracolizable.substring(pos,(pos+maximo)),adelante);
                            pos = pos + maximo;
                            maximo ++;
                            lineas.add(0,lineaArriba);
                            int j = 1;
                            while (j < lineas.size() && pos < textoCaracolizable.length()){
                                lineas.get(j).agrgarLetra(textoCaracolizable.substring(pos,(pos+1)),adelante);
                                pos++;
                                j++;
                            }
                            adelante = false;
                        }
                    }else{
                        LineaCaracol lineaAbajo = new LineaCaracol();
                        StringBuilder input1 = new StringBuilder();
                        input1.append(textoCaracolizable.substring(pos,(pos+maximo)));
                        String reversa = input1.reverse().toString();
                        lineaAbajo.agrgarLetra(reversa,adelante);
                        pos = pos + maximo;
                        maximo ++;
                        lineas.add(lineas.size(),lineaAbajo);
                        int j = lineas.size()-2;
                        while (j >= 0 && pos < textoCaracolizable.length()){
                            lineas.get(j).agrgarLetra(textoCaracolizable.substring(pos,(pos+1)),adelante);
                            pos++;
                            j--;
                        }
                        while(j>=0){
                            lineas.get(j).agrgarLetra(" ",adelante);
                            j--;
                        }
                        adelante = true;
                    }
                }else{
                    LineaCaracol lineaFinal = new LineaCaracol();
                    if(adelante){
                        lineaFinal.agrgarLetra(textoCaracolizable.substring(pos,textoCaracolizable.length()),adelante);
                        lineas.add(0,lineaFinal);
                    }else{
                        String lineaReversa = textoCaracolizable.substring(pos,textoCaracolizable.length());
                        int dif = maximo + pos - textoCaracolizable.length();
                        for(int i = 1; i < dif; i ++){
                            lineaReversa = lineaReversa + " ";
                        }
                        StringBuilder input1 = new StringBuilder();
                        input1.append(lineaReversa);
                        String reversa = input1.reverse().toString();
                        lineaFinal.agrgarLetra(reversa,adelante);
                        lineas.add(lineas.size(),lineaFinal);
                    }
                    pos = textoCaracolizable.length();
                }
            }
        }
        String resultado = "";
        if(lineas.size() > 0){
            int l = 0;
            while (l < (lineas.size() - 1)){
                resultado = resultado + lineas.get(l).obtenerTexto() + "\n";
                l++;
            }
            resultado = resultado + lineas.get(l).obtenerTexto();
            return resultado;
        }else{
            return "";
        }
    }

    public static String murcielago(String texto) {
        HashMap<Character, Character> murcielago = new HashMap<>();
        murcielago.put('M','0');
        murcielago.put('U','1');
        murcielago.put('Ú','1');
        murcielago.put('R','2');
        murcielago.put('C','3');
        murcielago.put('I','4');
        murcielago.put('Í','4');
        murcielago.put('E','5');
        murcielago.put('É','5');
        murcielago.put('L','6');
        murcielago.put('A','7');
        murcielago.put('Á','7');
        murcielago.put('G','8');
        murcielago.put('O','9');
        murcielago.put('Ó','9');
        murcielago.put('0','M');
        murcielago.put('1','U');
        murcielago.put('2','R');
        murcielago.put('3','C');
        murcielago.put('4','I');
        murcielago.put('5','E');
        murcielago.put('6','L');
        murcielago.put('7','A');
        murcielago.put('8','G');
        murcielago.put('9','O');
        return reemplazarCaracteres(texto,murcielago);
    }

    public static String dameTuPico(String texto) {
        HashMap<Character, Character> dameTuPico = new HashMap<>();
        dameTuPico.put('D','A');
        dameTuPico.put('A','D');
        dameTuPico.put('Á','D');
        dameTuPico.put('M','E');
        dameTuPico.put('E','M');
        dameTuPico.put('É','M');
        dameTuPico.put('T','U');
        dameTuPico.put('U','T');
        dameTuPico.put('Ú','T');
        dameTuPico.put('P','I');
        dameTuPico.put('I','P');
        dameTuPico.put('Í','P');
        dameTuPico.put('C','O');
        dameTuPico.put('O','C');
        dameTuPico.put('Ó','C');
        return reemplazarCaracteres(texto,dameTuPico);
    }

    public static String parelinofu(String texto) {
        HashMap<Character, Character> parelinofu = new HashMap<>();
        parelinofu.put('P','A');
        parelinofu.put('A','P');
        parelinofu.put('Á','P');
        parelinofu.put('R','E');
        parelinofu.put('E','R');
        parelinofu.put('É','R');
        parelinofu.put('L','I');
        parelinofu.put('I','L');
        parelinofu.put('Í','L');
        parelinofu.put('N','O');
        parelinofu.put('O','N');
        parelinofu.put('Ó','N');
        parelinofu.put('F','U');
        parelinofu.put('U','F');
        parelinofu.put('Ú','F');
        return reemplazarCaracteres(texto,parelinofu);
    }

    public static String numerica(String texto) {
        HashMap<String, String> numerica = new HashMap<>();
        numerica.put("A","1");
        numerica.put("Á","1");
        numerica.put("B","2");
        numerica.put("C","3");
        numerica.put("D","4");
        numerica.put("E","5");
        numerica.put("É","5");
        numerica.put("F","6");
        numerica.put("G","7");
        numerica.put("H","8");
        numerica.put("I","9");
        numerica.put("Í","9");
        numerica.put("J","10");
        numerica.put("K","11");
        numerica.put("L","12");
        numerica.put("M","13");
        numerica.put("N","14");
        numerica.put("Ñ","15");
        numerica.put("O","16");
        numerica.put("Ó","16");
        numerica.put("P","17");
        numerica.put("Q","18");
        numerica.put("R","19");
        numerica.put("S","20");
        numerica.put("T","21");
        numerica.put("U","22");
        numerica.put("Ú","22");
        numerica.put("V","23");
        numerica.put("W","24");
        numerica.put("X","25");
        numerica.put("Y","26");
        numerica.put("Z","27");
        numerica.put("0","0");
        numerica.put("1","A");
        numerica.put("2","B");
        numerica.put("3","C");
        numerica.put("4","D");
        numerica.put("5","E");
        numerica.put("6","F");
        numerica.put("7","G");
        numerica.put("8","H");
        numerica.put("9","I");
        numerica.put("10","J");
        numerica.put("11","K");
        numerica.put("12","L");
        numerica.put("13","M");
        numerica.put("14","N");
        numerica.put("15","Ñ");
        numerica.put("16","O");
        numerica.put("17","P");
        numerica.put("18","Q");
        numerica.put("19","R");
        numerica.put("20","S");
        numerica.put("21","T");
        numerica.put("22","U");
        numerica.put("23","V");
        numerica.put("24","W");
        numerica.put("25","X");
        numerica.put("26","Y");
        numerica.put("27","Z");
        String resultado = "";
        String textoMayus = texto.toUpperCase();
        int i = 0;
        String caracterAtraducir = "";
        while (i < textoMayus.length()) {
            if(Character.isDigit(textoMayus.charAt(i))){
                if(caracterAtraducir.length() > 1 || (caracterAtraducir.length() > 0 && caracterAtraducir.charAt(0) != '1' && caracterAtraducir.charAt(0) != '2') || (caracterAtraducir.length() > 0 && caracterAtraducir.charAt(0) == '2' && (textoMayus.charAt(i) == '8' ||  textoMayus.charAt(i) == '9'))){
                    resultado = resultado + agregarCaracterLargo(caracterAtraducir,numerica);
                    caracterAtraducir = "";
                }
                caracterAtraducir = caracterAtraducir + textoMayus.charAt(i);
                int j = i + 1;
                if(j == textoMayus.length()){
                    resultado = resultado + agregarCaracterLargo(caracterAtraducir,numerica);
                }
            }else{
                if(caracterAtraducir.length() > 0){
                    resultado = resultado + agregarCaracterLargo(caracterAtraducir,numerica);
                    if(textoMayus.charAt(i) != '/'){
                        String caracter = ""+textoMayus.charAt(i);
                        int j = i + 1;
                        boolean barra = (Character.isLetter(textoMayus.charAt(i)) && j < textoMayus.length() && (Character.isLetter(textoMayus.charAt(j))));
                        resultado = resultado + agregarCaracterLargoConBarra(caracter,numerica,barra);
                    }
                    caracterAtraducir = "";
                }else{
                    String caracter = ""+textoMayus.charAt(i);
                    int j = i + 1;
                    boolean barra = (Character.isLetter(textoMayus.charAt(i)) && j < textoMayus.length() && (Character.isLetter(textoMayus.charAt(j))));
                    resultado = resultado + agregarCaracterLargoConBarra(caracter,numerica,barra);
                }
            }
            i++;
        }
        return resultado;
    }

    public static String invertida(String texto) {
        HashMap<Character, Character> invertida = new HashMap<>();
        invertida.put('A','Z');
        invertida.put('Á','Z');
        invertida.put('B','Y');
        invertida.put('C','X');
        invertida.put('D','W');
        invertida.put('E','V');
        invertida.put('É','V');
        invertida.put('F','U');
        invertida.put('G','T');
        invertida.put('H','S');
        invertida.put('I','R');
        invertida.put('Í','R');
        invertida.put('J','Q');
        invertida.put('K','P');
        invertida.put('L','O');
        invertida.put('M','Ñ');
        invertida.put('Ñ','M');
        invertida.put('O','L');
        invertida.put('Ó','L');
        invertida.put('P','K');
        invertida.put('Q','J');
        invertida.put('R','I');
        invertida.put('S','H');
        invertida.put('T','G');
        invertida.put('U','F');
        invertida.put('Ú','F');
        invertida.put('V','E');
        invertida.put('W','D');
        invertida.put('X','C');
        invertida.put('Y','B');
        invertida.put('Z','A');
        return reemplazarCaracteres(texto,invertida);
    }

    public static String badenPowell(String texto) {
        HashMap<Character, Character> badenPowell = new HashMap<>();
        badenPowell.put('B','P');
        badenPowell.put('A','O');
        badenPowell.put('Á','O');
        badenPowell.put('D','W');
        badenPowell.put('N','L');
        badenPowell.put('P','B');
        badenPowell.put('O','A');
        badenPowell.put('Ó','A');
        badenPowell.put('W','D');
        badenPowell.put('L','N');
        badenPowell.put('É','E');
        badenPowell.put('Í','I');
        badenPowell.put('Ú','U');
        return reemplazarCaracteres(texto,badenPowell);
    }

    public static String cenitPolar(String texto) {
        HashMap<Character, Character> cenitPolar = new HashMap<>();
        cenitPolar.put('C','P');
        cenitPolar.put('E','O');
        cenitPolar.put('É','O');
        cenitPolar.put('N','L');
        cenitPolar.put('I','A');
        cenitPolar.put('Í','A');
        cenitPolar.put('T','R');
        cenitPolar.put('P','C');
        cenitPolar.put('O','E');
        cenitPolar.put('Ó','E');
        cenitPolar.put('L','N');
        cenitPolar.put('A','I');
        cenitPolar.put('Á','I');
        cenitPolar.put('R','T');
        cenitPolar.put('Ú','U');
        return reemplazarCaracteres(texto,cenitPolar);
    }

    public static String julioCesar(String texto) {
        HashMap<Character, Character> julioCesar = new HashMap<>();
        julioCesar.put('J','C');
        julioCesar.put('U','E');
        julioCesar.put('Ú','E');
        julioCesar.put('L','S');
        julioCesar.put('I','A');
        julioCesar.put('Í','A');
        julioCesar.put('O','R');
        julioCesar.put('Ó','R');
        julioCesar.put('C','J');
        julioCesar.put('E','U');
        julioCesar.put('É','U');
        julioCesar.put('S','L');
        julioCesar.put('A','I');
        julioCesar.put('Á','I');
        julioCesar.put('R','O');
        return reemplazarCaracteres(texto,julioCesar);
    }

    public static String lapizNegro(String texto) {
        HashMap<Character, Character> lapizNegro = new HashMap<>();
        lapizNegro.put('L','N');
        lapizNegro.put('A','E');
        lapizNegro.put('Á','E');
        lapizNegro.put('P','G');
        lapizNegro.put('I','R');
        lapizNegro.put('Í','R');
        lapizNegro.put('Z','O');
        lapizNegro.put('N','L');
        lapizNegro.put('E','A');
        lapizNegro.put('É','A');
        lapizNegro.put('G','P');
        lapizNegro.put('R','I');
        lapizNegro.put('O','Z');
        lapizNegro.put('Ó','Z');
        return reemplazarCaracteres(texto,lapizNegro);
    }

    public static String sufamelico(String texto) {
        HashMap<Character, Character> sufamelico = new HashMap<>();
        sufamelico.put('S','U');
        sufamelico.put('U','S');
        sufamelico.put('Ú','S');
        sufamelico.put('F','A');
        sufamelico.put('A','F');
        sufamelico.put('Á','F');
        sufamelico.put('M','E');
        sufamelico.put('E','M');
        sufamelico.put('É','M');
        sufamelico.put('L','I');
        sufamelico.put('I','L');
        sufamelico.put('Í','L');
        sufamelico.put('C','O');
        sufamelico.put('O','C');
        sufamelico.put('Ó','C');
        return reemplazarCaracteres(texto,sufamelico);
    }

    public static String neumatico(String texto) {
        HashMap<Character, Character> neumatico = new HashMap<>();
        neumatico.put('N','1');
        neumatico.put('E','2');
        neumatico.put('É','2');
        neumatico.put('U','3');
        neumatico.put('Ú','3');
        neumatico.put('M','4');
        neumatico.put('A','5');
        neumatico.put('Á','5');
        neumatico.put('T','6');
        neumatico.put('I','7');
        neumatico.put('Í','7');
        neumatico.put('C','8');
        neumatico.put('O','9');
        neumatico.put('Ó','9');
        neumatico.put('1','N');
        neumatico.put('2','E');
        neumatico.put('3','U');
        neumatico.put('4','M');
        neumatico.put('5','A');
        neumatico.put('6','T');
        neumatico.put('7','I');
        neumatico.put('8','C');
        neumatico.put('9','O');
        return reemplazarCaracteres(texto,neumatico);
    }

    public static String orquidea(String texto) {
        HashMap<Character, Character> orquidea = new HashMap<>();
        orquidea.put('O','1');
        orquidea.put('Ó','1');
        orquidea.put('R','2');
        orquidea.put('Q','3');
        orquidea.put('U','4');
        orquidea.put('Ú','4');
        orquidea.put('I','5');
        orquidea.put('Í','5');
        orquidea.put('D','6');
        orquidea.put('E','7');
        orquidea.put('É','7');
        orquidea.put('A','8');
        orquidea.put('Á','8');
        orquidea.put('1','O');
        orquidea.put('2','R');
        orquidea.put('3','Q');
        orquidea.put('4','U');
        orquidea.put('5','I');
        orquidea.put('6','D');
        orquidea.put('7','E');
        orquidea.put('8','A');
        return reemplazarCaracteres(texto,orquidea);
    }

    public static String agujerito(String texto) {
        HashMap<Character, Character> agujerito = new HashMap<>();
        agujerito.put('A','1');
        agujerito.put('Á','1');
        agujerito.put('G','2');
        agujerito.put('U','3');
        agujerito.put('Ú','3');
        agujerito.put('J','4');
        agujerito.put('E','5');
        agujerito.put('É','5');
        agujerito.put('R','6');
        agujerito.put('I','7');
        agujerito.put('Í','7');
        agujerito.put('T','8');
        agujerito.put('O','9');
        agujerito.put('Ó','9');
        agujerito.put('1','A');
        agujerito.put('2','G');
        agujerito.put('3','U');
        agujerito.put('4','J');
        agujerito.put('5','E');
        agujerito.put('6','R');
        agujerito.put('7','I');
        agujerito.put('8','T');
        agujerito.put('9','O');
        return reemplazarCaracteres(texto,agujerito);
    }

    public static String abuelito(String texto) {
        HashMap<Character, Character> abuelito = new HashMap<>();
        abuelito.put('A','1');
        abuelito.put('Á','1');
        abuelito.put('B','2');
        abuelito.put('U','3');
        abuelito.put('Ú','3');
        abuelito.put('E','4');
        abuelito.put('É','4');
        abuelito.put('L','5');
        abuelito.put('I','6');
        abuelito.put('Í','6');
        abuelito.put('T','7');
        abuelito.put('O','8');
        abuelito.put('Ó','8');
        abuelito.put('1','A');
        abuelito.put('2','B');
        abuelito.put('3','U');
        abuelito.put('4','E');
        abuelito.put('5','L');
        abuelito.put('6','I');
        abuelito.put('7','T');
        abuelito.put('8','O');
        return reemplazarCaracteres(texto,abuelito);
    }

    public static String eucalipto(String texto) {
        HashMap<Character, Character> eucalipto = new HashMap<>();
        eucalipto.put('E','1');
        eucalipto.put('É','1');
        eucalipto.put('U','2');
        eucalipto.put('Ú','2');
        eucalipto.put('C','3');
        eucalipto.put('A','4');
        eucalipto.put('Á','4');
        eucalipto.put('L','5');
        eucalipto.put('I','6');
        eucalipto.put('Í','6');
        eucalipto.put('P','7');
        eucalipto.put('T','8');
        eucalipto.put('O','9');
        eucalipto.put('Ó','9');
        eucalipto.put('1','E');
        eucalipto.put('2','U');
        eucalipto.put('3','C');
        eucalipto.put('4','A');
        eucalipto.put('5','L');
        eucalipto.put('6','I');
        eucalipto.put('7','P');
        eucalipto.put('8','T');
        eucalipto.put('9','O');
        return reemplazarCaracteres(texto,eucalipto);
    }

    public static String huerfanito(String texto) {
        HashMap<Character, Character> huerfanito = new HashMap<>();
        huerfanito.put('H','0');
        huerfanito.put('U','1');
        huerfanito.put('Ú','1');
        huerfanito.put('E','2');
        huerfanito.put('É','2');
        huerfanito.put('R','3');
        huerfanito.put('F','4');
        huerfanito.put('A','5');
        huerfanito.put('Á','5');
        huerfanito.put('N','6');
        huerfanito.put('I','7');
        huerfanito.put('Í','7');
        huerfanito.put('T','8');
        huerfanito.put('O','9');
        huerfanito.put('Ó','9');
        huerfanito.put('0','H');
        huerfanito.put('1','U');
        huerfanito.put('2','E');
        huerfanito.put('3','R');
        huerfanito.put('4','F');
        huerfanito.put('5','A');
        huerfanito.put('6','N');
        huerfanito.put('7','I');
        huerfanito.put('8','T');
        huerfanito.put('9','O');
        return reemplazarCaracteres(texto,huerfanito);
    }

    public static String donMatias(String texto) {
        HashMap<Character, Character> donMatias = new HashMap<>();
        donMatias.put('D','N');
        donMatias.put('N','D');
        donMatias.put('M','S');
        donMatias.put('T','I');
        donMatias.put('I','T');
        donMatias.put('Í','T');
        donMatias.put('S','M');
        donMatias.put('Á','A');
        donMatias.put('É','E');
        donMatias.put('Ó','O');
        donMatias.put('Ú','U');
        return reemplazarCaracteres(texto,donMatias);
    }

    public static String vocal(String texto) {
        HashMap<Character, Character> donMatias = new HashMap<>();
        donMatias.put('A','1');
        donMatias.put('Á','1');
        donMatias.put('E','2');
        donMatias.put('É','2');
        donMatias.put('I','3');
        donMatias.put('Í','3');
        donMatias.put('O','4');
        donMatias.put('Ó','4');
        donMatias.put('U','5');
        donMatias.put('Ú','5');
        donMatias.put('1','A');
        donMatias.put('2','E');
        donMatias.put('3','I');
        donMatias.put('4','O');
        donMatias.put('5','U');
        return reemplazarCaracteres(texto,donMatias);
    }

    public static String diaDeLaSemana(Calendar fecha){
        switch (fecha.get(Calendar.DAY_OF_WEEK)){
            case Calendar.SUNDAY:
                return "DOM";
            case Calendar.MONDAY:
                return "LUN";
            case Calendar.TUESDAY:
                return "MAR";
            case Calendar.WEDNESDAY:
                return "MIE";
            case Calendar.THURSDAY:
                return "JUE";
            case Calendar.FRIDAY:
                return "VIE";
            default:
                return "SAB";
        }
    }

    public static int repeticionDiaDeLasemana(Integer dia){
        int numero = (int) dia/7;
        if(dia%7 != 0){
            numero++;
        }
        return numero;
    }

    public static String modoCalendario(char c,HashMap<Character, Integer> calendario){
        Calendar fecha = Calendar.getInstance();
        String resultado = "";
        for (Map.Entry<Character, Integer> entry : calendario.entrySet()) {
            if (c == entry.getKey()) {
                fecha.set(Calendar.DAY_OF_MONTH, entry.getValue());
                resultado =  diaDeLaSemana(fecha) + repeticionDiaDeLasemana(entry.getValue());
                break;
            }
        }
        return resultado;
    }

    public static String textoFecha(Calendar fecha){
        return fecha.get(Calendar.DAY_OF_MONTH) + "/" + (fecha.get(Calendar.MONTH)+1) + "/" + fecha.get(Calendar.YEAR);
    }

    public static boolean esUnDiaDeLaSemana(String dia){
        return dia.equals("DOM") || dia.equals("LUN") || dia.equals("MAR") || dia.equals("MIE") || dia.equals("JUE") || dia.equals("VIE") || dia.equals("SAB");
    }

    public static boolean esUnNumeroDeSemana(String num){
        return num.equals("1") || num.equals("2") || num.equals("3") || num.equals("4");
    }

    public static boolean esFecha(String fechaConEspacios){
        String fecha = fechaConEspacios.trim();
        int numeroBarras = 0;
        boolean soloValidos = true;
        int i = 0;
        while (i < fecha.length() && soloValidos){
            if(fecha.charAt(i) == '/'){
                numeroBarras++;
                if(numeroBarras > 2){
                    soloValidos = false;
                }else{
                    i++;
                }
            }else{
                if(!Character.isDigit(fecha.charAt(i))){
                    soloValidos = false;
                }else{
                    i++;
                }
            }
        }
        if(soloValidos && numeroBarras == 2){
            String[] numeros = fecha.split("/");
            return numeros.length == 3 && numeros[0].length() < 3 && numeros[0].length() > 0 && numeros[1].length() < 3 && numeros[1].length() > 0 && numeros[2].length() < 5 && numeros[2].length() > 1;
        }else{
            return false;
        }
    }

    public static String aODeCalendario(String texto){
        String mayus = texto.toUpperCase();
        int a = 0;
        int b = mayus.length();
        boolean esCalendario = true;
        while (a < b && esCalendario) {
            if (Character.isLetter(mayus.charAt(a))){
                if(a < (b-3)){
                    if(!esUnDiaDeLaSemana(mayus.substring(a,(a+3))) || !esUnNumeroDeSemana(mayus.substring(a+3,(a+4)))){
                        esCalendario = false;
                    }else{
                        a = a+4;
                    }
                }else{
                    esCalendario = false;
                }
            } else{
                a = a + 1;
            }
        }
        String[] lines = texto.split(System.getProperty("line.separator"));
        boolean ultimaLineaFecha = esFecha(lines[(lines.length-1)]);
        esCalendario = esCalendario && ultimaLineaFecha;
        if(esCalendario){
            return deCalendario(texto);
        }else{
            return aCalendario(texto);
        }
    }

    public static String obtenerLetraCalendario(String fechaLetra, Calendar fecha){
        HashMap<String,Integer> diasDeLaSemana = new HashMap<>();
        diasDeLaSemana.put("DOM",1);
        diasDeLaSemana.put("LUN",2);
        diasDeLaSemana.put("MAR",3);
        diasDeLaSemana.put("MIE",4);
        diasDeLaSemana.put("JUE",5);
        diasDeLaSemana.put("VIE",6);
        diasDeLaSemana.put("SAB",7);
        int codigoDia = -1;
        for (Map.Entry<String,Integer> entry : diasDeLaSemana.entrySet()) {
            if (fechaLetra.substring(0,3).equals(entry.getKey())) {
                codigoDia = entry.getValue();
                break;
            }
        }
        int repeticion = Integer.valueOf(fechaLetra.substring((fechaLetra.length()-1),fechaLetra.length()));
        fecha.set(Calendar.WEEK_OF_MONTH,1);
        switch (codigoDia){
            case 1:
                fecha.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
                break;
            case 2:
                fecha.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
                break;
            case 3:
                fecha.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
                break;
            case 4:
                fecha.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
                break;
            case 5:
                fecha.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);
                break;
            case 6:
                fecha.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
                break;
            case 7:
                fecha.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
                break;
        }
        if(fecha.get(Calendar.DAY_OF_MONTH) > 7){
            repeticion++;
            fecha.set(Calendar.MONTH,(fecha.get(Calendar.MONTH)+1));
        }
        switch (codigoDia){
            case 1:
                fecha.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
                break;
            case 2:
                fecha.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
                break;
            case 3:
                fecha.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
                break;
            case 4:
                fecha.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
                break;
            case 5:
                fecha.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);
                break;
            case 6:
                fecha.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
                break;
            case 7:
                fecha.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
                break;
        }
        fecha.set(Calendar.WEEK_OF_MONTH,repeticion);
        return numerica(String.valueOf(fecha.get(Calendar.DAY_OF_MONTH)));
    }

    public static String deCalendario(String texto) {
        Calendar fecha = Calendar.getInstance();
        String resultado = "";
        String textoMayus = texto.toUpperCase();
        int i = 0;
        while (i < textoMayus.length()) {
            if(Character.isLetter(textoMayus.charAt(i))){
                String fechaLetra = textoMayus.substring(i,(i+4));
                resultado = resultado + obtenerLetraCalendario(fechaLetra,fecha);
                i = i + 4;
            }else{
                resultado = resultado + textoMayus.charAt(i);
                i++;
            }
        }
        String[] lines = resultado.split(System.getProperty("line.separator"));
        lines[(lines.length-1)] = "";
        StringBuilder resultadoStringBuilder= new StringBuilder("");
        for(String s:lines){
            if(!s.equals("")){
                resultadoStringBuilder.append(s).append(System.getProperty("line.separator"));
            }
        }
        resultado = resultadoStringBuilder.toString();
        return resultado;
    }

    public static String aCalendario(String texto) {
        HashMap<Character, Integer> calendario = new HashMap<>();
        calendario.put('A',1);
        calendario.put('Á',1);
        calendario.put('B',2);
        calendario.put('C',3);
        calendario.put('D',4);
        calendario.put('E',5);
        calendario.put('É',5);
        calendario.put('F',6);
        calendario.put('G',7);
        calendario.put('H',8);
        calendario.put('I',9);
        calendario.put('Í',9);
        calendario.put('J',10);
        calendario.put('K',11);
        calendario.put('L',12);
        calendario.put('M',13);
        calendario.put('N',14);
        calendario.put('Ñ',15);
        calendario.put('O',16);
        calendario.put('Ó',16);
        calendario.put('P',17);
        calendario.put('Q',18);
        calendario.put('R',19);
        calendario.put('S',20);
        calendario.put('T',21);
        calendario.put('U',22);
        calendario.put('Ú',22);
        calendario.put('V',23);
        calendario.put('W',24);
        calendario.put('X',25);
        calendario.put('Y',26);
        calendario.put('Z',27);
        Calendar fecha = Calendar.getInstance();
        String resultado = "";
        String textoMayus = texto.toUpperCase();
        int i = 0;
        while (i < textoMayus.length()) {
            if(Character.isLetter(textoMayus.charAt(i))){
                resultado = resultado + modoCalendario(textoMayus.charAt(i),calendario);
                int j = i + 1;
                if(j < textoMayus.charAt(i) && (Character.isDigit(textoMayus.charAt(j)) || Character.isLetter(textoMayus.charAt(j)))){
                    resultado = resultado + "/";
                }
            }else{
                resultado = resultado + textoMayus.charAt(i);
            }
            i++;
        }
        resultado = resultado + "\n\n" + textoFecha(fecha);
        return resultado;
    }

    public static String m1(String texto) {
        return corrediza(texto,26);//reemplazarCaracteres(texto,m1);
    }

    public static String corrediza(String texto, int cantidadCaracteres){
        HashMap<Character, Integer> letras = new HashMap<>();
        letras.put('A',1);
        letras.put('Á',1);
        letras.put('B',2);
        letras.put('C',3);
        letras.put('D',4);
        letras.put('E',5);
        letras.put('É',5);
        letras.put('F',6);
        letras.put('G',7);
        letras.put('H',8);
        letras.put('I',9);
        letras.put('Í',9);
        letras.put('J',10);
        letras.put('K',11);
        letras.put('L',12);
        letras.put('M',13);
        letras.put('N',14);
        letras.put('Ñ',15);
        letras.put('O',16);
        letras.put('Ó',16);
        letras.put('P',17);
        letras.put('Q',18);
        letras.put('R',19);
        letras.put('S',20);
        letras.put('T',21);
        letras.put('U',22);
        letras.put('Ú',22);
        letras.put('V',23);
        letras.put('W',24);
        letras.put('X',25);
        letras.put('Y',26);
        letras.put('Z',27);
        HashMap<Integer,Character> numeros = new HashMap<>();
        numeros.put(1,'A');
        numeros.put(2,'B');
        numeros.put(3,'C');
        numeros.put(4,'D');
        numeros.put(5,'E');
        numeros.put(6,'F');
        numeros.put(7,'G');
        numeros.put(8,'H');
        numeros.put(9,'I');
        numeros.put(10,'J');
        numeros.put(11,'K');
        numeros.put(12,'L');
        numeros.put(13,'M');
        numeros.put(14,'N');
        numeros.put(15,'Ñ');
        numeros.put(16,'O');
        numeros.put(17,'P');
        numeros.put(18,'Q');
        numeros.put(19,'R');
        numeros.put(20,'S');
        numeros.put(21,'T');
        numeros.put(22,'U');
        numeros.put(23,'V');
        numeros.put(24,'W');
        numeros.put(25,'X');
        numeros.put(26,'Y');
        numeros.put(27,'Z');
        return reemplazarCaracteresCorrediza(texto,letras,numeros,cantidadCaracteres);
    }

    public static String M1(String texto) {
        return corrediza(texto,1);//reemplazarCaracteres(texto,M1);
    }

    public static String reinado(String texto) {
        HashMap<Character, Character> reinado = new HashMap<>();
        reinado.put('R','6');
        reinado.put('E','8');
        reinado.put('É','8');
        reinado.put('I','3');
        reinado.put('Í','3');
        reinado.put('N','2');
        reinado.put('A','0');
        reinado.put('Á','0');
        reinado.put('D','1');
        reinado.put('O','9');
        reinado.put('Ó','9');
        reinado.put('6','R');
        reinado.put('8','E');
        reinado.put('3','I');
        reinado.put('2','N');
        reinado.put('0','A');
        reinado.put('1','D');
        reinado.put('9','O');
        return reemplazarCaracteres(texto,reinado);
    }

    public static String aODeRomana(String texto){
        int a = 0;
        int b = texto.length();
        int letras = 0;
        int CI = 0;
        while (a < b) {
            if (Character.isLetter(texto.charAt(a))){
                letras = letras + 1;
                if(texto.charAt(a) == 'I' || texto.charAt(a) == 'i'){
                    CI = CI + 1;
                }
            }
            a = a + 1;
        }
        if ((CI == letras)) {
            return Claves.deRomana(texto);
        } else {
            return aRomana(texto);
        }
    }

    public static String aRomana(String texto) {
        HashMap<String, String> romana = new HashMap<>();
        romana.put("A","1I");
        romana.put("Á","1I");
        romana.put("B","2I");
        romana.put("C","3I");
        romana.put("D","4I");
        romana.put("E","5I");
        romana.put("É","5I");
        romana.put("F","6I");
        romana.put("G","7I");
        romana.put("H","8I");
        romana.put("I","9I");
        romana.put("Í","9I");
        romana.put("J","1II");
        romana.put("K","2II");
        romana.put("L","3II");
        romana.put("M","4II");
        romana.put("N","5II");
        romana.put("Ñ","6II");
        romana.put("O","7II");
        romana.put("Ó","7II");
        romana.put("P","8II");
        romana.put("Q","9II");
        romana.put("R","1III");
        romana.put("S","2III");
        romana.put("T","3III");
        romana.put("U","4III");
        romana.put("Ú","4III");
        romana.put("V","5III");
        romana.put("W","6III");
        romana.put("X","7III");
        romana.put("Y","8III");
        romana.put("Z","9III");
        String resultado = "";
        String textoMayus = texto.toUpperCase();
        int i = 0;
        while (i < textoMayus.length()) {
            String caracter = "" + texto.charAt(i);
            int j = i + 1;
            boolean barra = (j < textoMayus.length() && Character.isLetter(texto.charAt(j)));
            resultado = resultado + agregarCaracterLargoConBarra(caracter,romana,barra);
            i++;
        }
        return resultado;
    }

    public static boolean caracterMorse(char c) {
        boolean simboloMorse = (c == '.' || c == ',' || c == '?' || c == '!');
        return simboloMorse || Character.isDigit(c) || Character.isLetter(c);
    }

    public static String aODePZ(String texto){
        int a = 0;
        int b = texto.length();
        int cp = 0;
        int cz = 0;
        int letras = 0;
        while (a < b) {
            if (Character.isLetter(texto.charAt(a))){
                letras = letras + 1;
                if(texto.charAt(a) == 'P'){
                    cp = cp + 1;
                }
                if(texto.charAt(a) == 'Z'){
                    cz = cz + 1;
                }
            }
            a = a + 1;
        }
        if((cp * 3) >= letras && (cz * 3) >= letras){
            return dePZ(texto);
        }else{
            return aPZ(texto);
        }
    }

    public static String aODeMorse(String texto){
        int a = 0;
        int b = texto.length();
        int numeros = 0;
        int letras = 0;
        int puntoRaya = 0;
        while (a < b) {
            if (Character.isLetter(texto.charAt(a))){
                letras = letras + 1;
            } else{
                if (Character.isDigit(texto.charAt(a))){
                    numeros = numeros + 1;
                } else{
                    if (texto.charAt(a) == '.' || texto.charAt(a) == '-'){
                        puntoRaya = puntoRaya + 1;
                    }
                }
            }
            a = a + 1;
        }
        if(puntoRaya > letras && puntoRaya > numeros){
            return deMorse(texto);
        }else{
            return aMorse(texto);
        }
    }

    public static String aMorse(String texto) {
        HashMap<String, String> morse = new HashMap<>();
        morse.put("A",".-");
        morse.put("Á",".-");
        morse.put("B","-...");
        morse.put("C","-.-.");
        morse.put("D","-..");
        morse.put("E",".");
        morse.put("É",".");
        morse.put("F","..-.");
        morse.put("G","--.");
        morse.put("H","....");
        morse.put("I","..");
        morse.put("Í","..");
        morse.put("J",".---");
        morse.put("K","-.-");
        morse.put("L",".-..");
        morse.put("M","--");
        morse.put("N","-.");
        morse.put("Ñ","--.--");
        morse.put("O","---");
        morse.put("Ó","---");
        morse.put("P",".--.");
        morse.put("Q","--.-");
        morse.put("R",".-.");
        morse.put("S","...");
        morse.put("T","-");
        morse.put("U","..-");
        morse.put("Ú","..-");
        morse.put("V","...-");
        morse.put("W",".--");
        morse.put("X","-..-");
        morse.put("Y","-.--");
        morse.put("Z","--..");
        morse.put("0","-----");
        morse.put("1",".----");
        morse.put("2","..---");
        morse.put("3","...--");
        morse.put("4","....-");
        morse.put("5",".....");
        morse.put("6","-....");
        morse.put("7","--...");
        morse.put("8","---..");
        morse.put("9","----.");
        morse.put(".",".-.-.-");
        morse.put(",","--..--");
        morse.put("?",".-..-.");
        morse.put("!","-.-.--");
        String resultado = "";
        String textoMayus = texto.toUpperCase();
        int i = 0;
        while (i < textoMayus.length()) {
            String caracter = "" + texto.charAt(i);
            int j = i + 1;
            boolean barra = (j < textoMayus.length() && caracterMorse(texto.charAt(j)));
            resultado = resultado + agregarCaracterLargoConBarra(caracter,morse,barra);
            i++;
        }
        return resultado;
    }

    public static String aPZ(String texto) {
        HashMap<String, String> pz = new HashMap<>();
        pz.put("A","PZA");
        pz.put("Á","PZA");
        pz.put("B","PZB");
        pz.put("C","PZC");
        pz.put("D","PZD");
        pz.put("E","PZE");
        pz.put("É","PZE");
        pz.put("F","PZF");
        pz.put("G","PZG");
        pz.put("H","PZH");
        pz.put("I","PZI");
        pz.put("Í","PZI");
        pz.put("J","PZJ");
        pz.put("K","PZK");
        pz.put("L","PZL");
        pz.put("M","PZM");
        pz.put("N","PZN");
        pz.put("Ñ","PZÑ");
        pz.put("O","PZO");
        pz.put("Ó","PZO");
        pz.put("P","PZP");
        pz.put("Q","PZQ");
        pz.put("R","PZR");
        pz.put("S","PZS");
        pz.put("T","PZT");
        pz.put("U","PZU");
        pz.put("Ú","PZU");
        pz.put("V","PZV");
        pz.put("W","PZW");
        pz.put("X","PZX");
        pz.put("Y","PZY");
        pz.put("Z","PZZ");
        String resultado = "";
        String textoMayus = texto.toUpperCase();
        int i = 0;
        while (i < textoMayus.length()) {
            String caracter = "" + texto.charAt(i);
            int j = i + 1;
            resultado = resultado + agregarCaracterLargoConBarra(caracter,pz,false);
            i++;
        }
        return resultado;
    }

    public static String aHombre(String textoConEsp){
        String texto = textoConEsp.trim();
        String resultado = "";
        int k = 0;
        for (int i = 0; i < texto.length(); i++) {
            int aleatoriosAnteriores;
            switch((k % 3)){
                case(0):
                    aleatoriosAnteriores = 4;
                    break;
                case(1):
                    aleatoriosAnteriores = 2;
                    break;
                default:
                    aleatoriosAnteriores = 3;
                    break;
            }
            if(Character.isLetter(texto.charAt(i)) || Character.isDigit(texto.charAt(i))){
                for(int j = 0; j < aleatoriosAnteriores; j++){
                    int random = ((int) (Math.random() * 27));
                    switch (random){
                        case (0):
                            resultado = resultado + "A";
                            break;
                        case (1):
                            resultado = resultado + "B";
                            break;
                        case (2):
                            resultado = resultado + "C";
                            break;
                        case (3):
                            resultado = resultado + "D";
                            break;
                        case (4):
                            resultado = resultado + "E";
                            break;
                        case (5):
                            resultado = resultado + "F";
                            break;
                        case (6):
                            resultado = resultado + "G";
                            break;
                        case (7):
                            resultado = resultado + "H";
                            break;
                        case (8):
                            resultado = resultado + "I";
                            break;
                        case (9):
                            resultado = resultado + "J";
                            break;
                        case (10):
                            resultado = resultado + "K";
                            break;
                        case (11):
                            resultado = resultado + "L";
                            break;
                        case (12):
                            resultado = resultado + "M";
                            break;
                        case (13):
                            resultado = resultado + "N";
                            break;
                        case (14):
                            resultado = resultado + "Ñ";
                            break;
                        case (15):
                            resultado = resultado + "O";
                            break;
                        case (16):
                            resultado = resultado + "P";
                            break;
                        case (17):
                            resultado = resultado + "Q";
                            break;
                        case (18):
                            resultado = resultado + "R";
                            break;
                        case (19):
                            resultado = resultado + "S";
                            break;
                        case (20):
                            resultado = resultado + "T";
                            break;
                        case (21):
                            resultado = resultado + "U";
                            break;
                        case (22):
                            resultado = resultado + "V";
                            break;
                        case (23):
                            resultado = resultado + "W";
                            break;
                        case (24):
                            resultado = resultado + "X";
                            break;
                        case (25):
                            resultado = resultado + "Y";
                            break;
                        case (26):
                            resultado = resultado + "Z";
                            break;
                    }
                }
                k++;
            }
            resultado = resultado + texto.toUpperCase().charAt(i);
        }
        return resultado;
    }

    public static String aParrillaCompuesta(String texto){
        HashMap<Character, String> parrillaCompuesta = new HashMap<>();
        parrillaCompuesta.put('A',"apc");
        parrillaCompuesta.put('Á',"apc");
        parrillaCompuesta.put('B',"bpc");
        parrillaCompuesta.put('C',"cpc");
        parrillaCompuesta.put('D',"dpc");
        parrillaCompuesta.put('E',"epc");
        parrillaCompuesta.put('É',"epc");
        parrillaCompuesta.put('F',"fpc");
        parrillaCompuesta.put('G',"gpc");
        parrillaCompuesta.put('H',"hpc");
        parrillaCompuesta.put('I',"ipc");
        parrillaCompuesta.put('Í',"ipc");
        parrillaCompuesta.put('J',"jpc");
        parrillaCompuesta.put('K',"kpc");
        parrillaCompuesta.put('L',"lpc");
        parrillaCompuesta.put('M',"mpc");
        parrillaCompuesta.put('N',"npc");
        parrillaCompuesta.put('Ñ',"ñpc");
        parrillaCompuesta.put('O',"opc");
        parrillaCompuesta.put('Ó',"opc");
        parrillaCompuesta.put('P',"ppc");
        parrillaCompuesta.put('Q',"qpc");
        parrillaCompuesta.put('R',"rpc");
        parrillaCompuesta.put('S',"spc");
        parrillaCompuesta.put('T',"tpc");
        parrillaCompuesta.put('U',"upc");
        parrillaCompuesta.put('Ú',"upc");
        parrillaCompuesta.put('V',"vpc");
        parrillaCompuesta.put('W',"wpc");
        parrillaCompuesta.put('X',"xpc");
        parrillaCompuesta.put('Y',"ypc");
        parrillaCompuesta.put('Z',"zpc");
        return reemplazarCaracteresSimbolos(texto,parrillaCompuesta);
    }

    public static String aParrillaSimple(String texto){
        HashMap<Character, String> parrillaSimple = new HashMap<>();
        parrillaSimple.put('A',"aps");
        parrillaSimple.put('Á',"aps");
        parrillaSimple.put('B',"bps");
        parrillaSimple.put('C',"cps");
        parrillaSimple.put('D',"dps");
        parrillaSimple.put('E',"eps");
        parrillaSimple.put('É',"eps");
        parrillaSimple.put('F',"fps");
        parrillaSimple.put('G',"gps");
        parrillaSimple.put('H',"hps");
        parrillaSimple.put('I',"ips");
        parrillaSimple.put('Í',"ips");
        parrillaSimple.put('J',"jps");
        parrillaSimple.put('K',"kps");
        parrillaSimple.put('L',"lps");
        parrillaSimple.put('M',"mps");
        parrillaSimple.put('N',"nps");
        parrillaSimple.put('Ñ',"ñps");
        parrillaSimple.put('O',"ops");
        parrillaSimple.put('Ó',"ops");
        parrillaSimple.put('P',"pps");
        parrillaSimple.put('Q',"qps");
        parrillaSimple.put('R',"rps");
        parrillaSimple.put('S',"sps");
        parrillaSimple.put('T',"tps");
        parrillaSimple.put('U',"ups");
        parrillaSimple.put('Ú',"ups");
        parrillaSimple.put('V',"vps");
        parrillaSimple.put('W',"wps");
        parrillaSimple.put('X',"xps");
        parrillaSimple.put('Y',"yps");
        parrillaSimple.put('Z',"zps");
        return reemplazarCaracteresSimbolos(texto,parrillaSimple);
    }

    public static String a7Cruces(String texto){
        HashMap<Character, String> sieteCruces = new HashMap<>();
        sieteCruces.put('A',"asc");
        sieteCruces.put('Á',"asc");
        sieteCruces.put('B',"bsc");
        sieteCruces.put('C',"csc");
        sieteCruces.put('D',"dsc");
        sieteCruces.put('E',"esc");
        sieteCruces.put('É',"esc");
        sieteCruces.put('F',"fsc");
        sieteCruces.put('G',"gsc");
        sieteCruces.put('H',"hsc");
        sieteCruces.put('I',"isc");
        sieteCruces.put('Í',"isc");
        sieteCruces.put('J',"jsc");
        sieteCruces.put('K',"ksc");
        sieteCruces.put('L',"lsc");
        sieteCruces.put('M',"msc");
        sieteCruces.put('N',"nsc");
        sieteCruces.put('Ñ',"ñsc");
        sieteCruces.put('O',"osc");
        sieteCruces.put('Ó',"osc");
        sieteCruces.put('P',"psc");
        sieteCruces.put('Q',"qsc");
        sieteCruces.put('R',"rsc");
        sieteCruces.put('S',"ssc");
        sieteCruces.put('T',"tsc");
        sieteCruces.put('U',"usc");
        sieteCruces.put('Ú',"usc");
        sieteCruces.put('V',"vsc");
        sieteCruces.put('W',"wsc");
        sieteCruces.put('X',"xsc");
        sieteCruces.put('Y',"ysc");
        sieteCruces.put('Z',"zsc");
        return reemplazarCaracteresSimbolos(texto,sieteCruces);
    }

    public static String aAngulo(String texto){
        HashMap<Character, String> angulo = new HashMap<>();
        angulo.put('A',"aan");
        angulo.put('Á',"aan");
        angulo.put('E',"ean");
        angulo.put('É',"ean");
        angulo.put('I',"ian");
        angulo.put('Í',"ian");
        angulo.put('O',"oan");
        angulo.put('Ó',"oan");
        angulo.put('U',"uan");
        angulo.put('Ú',"uan");
        return reemplazarCaracteresSimbolos(texto,angulo);
    }

    public static String alReves(String texto){
        return new StringBuilder(texto).reverse().toString().trim();
    }

    public static String deHombre(String textoConEsp){
        String texto = textoConEsp.trim();
        String resultado = "";
        int i = 0;
        int j = 0;
        while (j < texto.length()){
            if(!Character.isLetter(texto.charAt(j))){
                resultado = resultado + texto.charAt(j);
                j++;
            }else{
                switch ((i%3)){
                    case (0):
                        j = j + 4;
                        if(j < texto.length()){
                            resultado = resultado + texto.charAt(j);
                        }
                        i++;
                        j++;
                        break;
                    case (1):
                        j = j + 2;
                        if(j < texto.length()){
                            resultado = resultado + texto.charAt(j);
                        }
                        i++;
                        j++;
                        break;
                    default:
                        j = j + 3;
                        if(j < texto.length()){
                            resultado = resultado + texto.charAt(j);
                        }
                        i++;
                        j++;
                        break;
                }
            }
        }
        return resultado;
    }

    public static String deMorse(String texto) {
        HashMap<String, String> morse = new HashMap<>();
        morse.put(".-","A");
        morse.put("-...","B");
        morse.put("-.-.","C");
        morse.put("-..","D");
        morse.put(".","E");
        morse.put("..-.","F");
        morse.put("--.","G");
        morse.put("....","H");
        morse.put("..","I");
        morse.put(".---","J");
        morse.put("-.-","K");
        morse.put(".-..","L");
        morse.put("--","M");
        morse.put("-.","N");
        morse.put("--.--","Ñ");
        morse.put("---","O");
        morse.put(".--.","P");
        morse.put("--.-","Q");
        morse.put(".-.","R");
        morse.put("...","S");
        morse.put("-","T");
        morse.put("..-","U");
        morse.put("...-","V");
        morse.put(".--","W");
        morse.put("-..-","X");
        morse.put("-.--","Y");
        morse.put("--..","Z");
        morse.put("-----","0");
        morse.put(".----","1");
        morse.put("..---","2");
        morse.put("...--","3");
        morse.put("....-","4");
        morse.put(".....","5");
        morse.put("-....","6");
        morse.put("--...","7");
        morse.put("---..","8");
        morse.put("----.","9");
        morse.put(".-.-.-",".");
        morse.put("--..--",",");
        morse.put(".-..-.","?");
        morse.put("-.-.--","!");
        String resultado = "";
        int i = 0;
        String caracterAtraducir = "";
        while (i < texto.length()) {
            if(texto.charAt(i) == '.' || texto.charAt(i) == '-'){
                caracterAtraducir = caracterAtraducir + texto.charAt(i);
                int j = i + 1;
                if(j == texto.length()){
                    resultado = resultado + agregarCaracterLargo(caracterAtraducir,morse);
                }
            }else{
                if(caracterAtraducir.length() > 0){
                    resultado = resultado + agregarCaracterLargo(caracterAtraducir,morse);
                }
                if(texto.charAt(i) != '/'){
                    resultado = resultado + texto.charAt(i);
                }
                caracterAtraducir = "";
            }
            i++;
        }
        return resultado;
    }

    public static String dePZ(String texto) {
        HashMap<String, String> pz = new HashMap<>();
        pz.put("PZA","A");
        pz.put("PZB","B");
        pz.put("PZC","C");
        pz.put("PZD","D");
        pz.put("PZE","E");
        pz.put("PZF","F");
        pz.put("PZG","G");
        pz.put("PZH","H");
        pz.put("PZI","I");
        pz.put("PZJ","J");
        pz.put("PZK","K");
        pz.put("PZL","L");
        pz.put("PZM","M");
        pz.put("PZN","N");
        pz.put("PZÑ","Ñ");
        pz.put("PZO","O");
        pz.put("PZP","P");
        pz.put("PZQ","Q");
        pz.put("PZR","R");
        pz.put("PZS","S");
        pz.put("PZT","T");
        pz.put("PZU","U");
        pz.put("PZV","V");
        pz.put("PZW","W");
        pz.put("PZX","X");
        pz.put("PZY","Y");
        pz.put("PZZ","Z");
        String resultado = "";
        int i = 0;
        String caracterAtraducir = "";
        while (i < texto.length()) {
            if((texto.charAt(i) == 'P' && caracterAtraducir.length() == 0) || (texto.charAt(i) == 'Z' && caracterAtraducir.length() == 1)){
                caracterAtraducir = caracterAtraducir + texto.charAt(i);
            }else{
                resultado = resultado + texto.charAt(i);
                caracterAtraducir = "";
            }
            i++;
        }
        return resultado;
    }

    public static String deRomana(String texto) {
        HashMap<String, String> romana = new HashMap<>();
        romana.put("1I","A");
        romana.put("2I","B");
        romana.put("3I","C");
        romana.put("4I","D");
        romana.put("5I","E");
        romana.put("6I","F");
        romana.put("7I","G");
        romana.put("8I","H");
        romana.put("9I","I");
        romana.put("1II","J");
        romana.put("2II","K");
        romana.put("3II","L");
        romana.put("4II","M");
        romana.put("5II","N");
        romana.put("6II","Ñ");
        romana.put("7II","O");
        romana.put("8II","P");
        romana.put("9II","Q");
        romana.put("1III","R");
        romana.put("2III","S");
        romana.put("3III","T");
        romana.put("4III","U");
        romana.put("5III","V");
        romana.put("6III","W");
        romana.put("7III","X");
        romana.put("8III","Y");
        romana.put("9III","Z");
        String resultado = "";
        int i = 0;
        String caracterAtraducir = "";
        while (i < texto.length()) {
            if((Character.isDigit(texto.charAt(i)) && texto.charAt(i) != '0' && caracterAtraducir.length() == 0) || (texto.toUpperCase().charAt(i) == 'I' && caracterAtraducir.length() > 0 && caracterAtraducir.length() < 4)){
                caracterAtraducir = caracterAtraducir + texto.charAt(i);
            }else{
                if(caracterAtraducir.length() > 0){
                    resultado = resultado + agregarCaracterLargo(caracterAtraducir,romana);
                }
                if(texto.charAt(i) != '/'){
                    if((Character.isDigit(texto.charAt(i)) && texto.charAt(i) != '0')){
                        i--;
                    }else{
                        resultado = resultado + texto.charAt(i);
                    }
                }
                caracterAtraducir = "";
            }
            i++;
        }
        return resultado;
    }

    public static String multiclaveAleatoria(String texto, Context context) {
        String mensaje = "La funcion multiclave uso las claves: ";
        int a = 0;
        int b;
        b = texto.length();
        String texto1 = "";
        int anterior = -1;
        int anterior2 = 0;
        Random rnd = new Random();
        int random;
        int pos;
        if(Constantes.esClaveIncluida(Constantes.CARACOL,context)){
            pos = 1;
        }else{
            pos = 0;
        }
        random = (int) (rnd.nextDouble() * (Constantes.clavesValidas.size()-pos));
        int random2 = (int) (rnd.nextDouble() * 4 + 7);
        int espacios;
        String aux;
        while (a < b) {
            while (random == anterior) {
                random = (int) (rnd.nextDouble() * (Constantes.clavesValidas.size()-pos));
            }
            while (random2 == anterior2) {
                random2 = (int) (rnd.nextDouble() * 4 + 7);
            }
            anterior = random;
            anterior2 = random2;
            aux = "";
            espacios = 0;
            while ((a < b) && (espacios < random2)) {
                aux = aux + texto.charAt(a);
                if (texto.charAt(a) == ' ') {
                    espacios = espacios + 1;
                }
                a = a + 1;
            }
            switch (Constantes.clavesValidas.get(random)) {
                case (Constantes.MURCIELAGO):
                    mensaje = mensaje + " murcielago,";
                    texto1 = texto1 + murcielago(aux);
                    break;
                case (Constantes.DAME_TU_PICO):
                    mensaje = mensaje + " dame tu pico,";
                    texto1 = texto1 + dameTuPico(aux);
                    break;
                case (Constantes.NUMERICA):
                    mensaje = mensaje + " numerica,";
                    texto1 = texto1 + numerica(aux);
                    break;
                case (Constantes.INVERTIDA):
                    mensaje = mensaje + " invertida,";
                    texto1 = texto1 + invertida(aux);
                    break;
                case (Constantes.BADEN_POWELL):
                    mensaje = mensaje + " baden powell,";
                    texto1 = texto1 + badenPowell(aux);
                    break;
                case (Constantes.MORSE):
                    mensaje = mensaje + " morse,";
                    texto1 = texto1 + aMorse(aux);
                    break;
                case (Constantes.MAS1):
                    mensaje = mensaje + " mas 1,";
                    texto1 = texto1 + M1(aux);
                    break;
                case (Constantes.MENOS1):
                    mensaje = mensaje + " menos 1,";
                    texto1 = texto1 + m1(aux);
                    break;
                case (Constantes.AGUJERITO):
                    mensaje = mensaje + " agujerito,";
                    texto1 = texto1 + agujerito(aux);
                    break;
                case (Constantes.CENIT_POLAR):
                    mensaje = mensaje + " cenit polar,";
                    texto1 = texto1 + cenitPolar(aux);
                    break;
                case (Constantes.ROMANA):
                    mensaje = mensaje + " romana,";
                    texto1 = texto1 + aRomana(aux);
                    break;
                case (Constantes.NEUMATICO):
                    mensaje = mensaje + " neumatico,";
                    texto1 = texto1 + neumatico(aux);
                    break;
                case (Constantes.SUFAMELICO):
                    mensaje = mensaje + " sufamelico,";
                    texto1 = texto1 + sufamelico(aux);
                    break;
                case (Constantes.HUERFANITO):
                    mensaje = mensaje + " huerfanito,";
                    texto1 = texto1 + huerfanito(aux);
                    break;
                case (Constantes.ORQUIDEA):
                    mensaje = mensaje + " orquidea,";
                    texto1 = texto1 + orquidea(aux);
                    break;
                case (Constantes.JULIO_CESAR):
                    mensaje = mensaje + " jilio cesar,";
                    texto1 = texto1 + julioCesar(aux);
                    break;
                case (Constantes.LAPIZ_NEGRO):
                    mensaje = mensaje + " lapiz negro,";
                    texto1 = texto1 + lapizNegro(aux);
                    break;
                case (Constantes.ABUELITO):
                    mensaje = mensaje + " abuelito,";
                    texto1 = texto1 + abuelito(aux);
                    break;
                case (Constantes.EUCALIPTO):
                    mensaje = mensaje + " eucalipto,";
                    texto1 = texto1 + eucalipto(aux);
                    break;
                case (Constantes.HOMBRE):
                    mensaje = mensaje + " hombre,";
                    texto1 = texto1 + aHombre(aux);
                    break;
                case (Constantes.AL_REVES):
                    mensaje = mensaje + " al reves,";
                    texto1 = texto1 + alReves(aux);
                    break;
                case (Constantes.REINADO):
                    mensaje = mensaje + " reinado,";
                    texto1 = texto1 + reinado(aux);
                    break;
                case (Constantes.DON_MATIAS):
                    mensaje = mensaje + " don matias,";
                    texto1 = texto1 + donMatias(aux);
                    break;
                case (Constantes.SIETE_CRUCES):
                    mensaje = mensaje + " siete cruces,";
                    texto1 = texto1 + a7Cruces(aux);
                    break;
                case (Constantes.PARRILLA_SIMPLE):
                    mensaje = mensaje + " parrilla simple,";
                    texto1 = texto1 + aParrillaSimple(aux);
                    break;
                case (Constantes.PARRILLA_COMPUESTA):
                    mensaje = mensaje + " parrilla compuesta,";
                    texto1 = texto1 + aParrillaCompuesta(aux);
                    break;
                case (Constantes.VOCAL):
                    mensaje = mensaje + " vocal,";
                    texto1 = texto1 + vocal(aux);
                    break;
                case (Constantes.ANGULO):
                    mensaje = mensaje + " angulo,";
                    texto1 = texto1 + aAngulo(aux);
                    break;
                case (Constantes.PZ):
                    mensaje = mensaje + " pz,";
                    texto1 = texto1 + aPZ(aux);
                    break;
                case (Constantes.PARELINOFU):
                    mensaje = mensaje + " parelinofu,";
                    texto1 = texto1 + parelinofu(aux);
                    break;
            }
        }
        mensaje = mensaje.substring(0,(mensaje.length()-1));
        mensaje = mensaje + " en ese orden";
        Toast.makeText(context,mensaje,Toast.LENGTH_LONG).show();
        return texto1;
    }
}

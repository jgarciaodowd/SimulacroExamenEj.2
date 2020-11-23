import java.util.Scanner;

public class Hilos implements  Runnable{
    Thread hilo;
    int opcion;
    int sumVocales = 0, sumaConsonantes = 0;
    String texto;

    public Hilos(int opcion, String texto) {
        this.opcion = opcion;
        this.texto = texto;
    }

    public int contVocales(String texto){
        int cont = 0;
        int vocalA = 0 , vocalE = 0 ,vocalI = 0 ,vocalO = 0,vocalU = 0;
        for(int i = 0; i < texto.length(); i++){
            switch (Character.toLowerCase(texto.charAt(i))) {
                case 'a':
                    vocalA++;
                    break;
                case 'e':
                    vocalE++;
                    break;
                case 'i':
                    vocalI++;
                    break;
                case 'o':
                    vocalO++;
                    break;
                case 'u':
                    vocalU++;
                    break;
                default:
                    break;
            }
        }
        cont = vocalA + vocalE + vocalI + vocalO + vocalU;
        return cont;
    }

    public static boolean esConsonante(char letra) {
        return "bcdfghjklmnñpqrstvwxyz".contains(String.valueOf(letra).toLowerCase());
    }

    public int conConsonantes(String texto){
        int con = 0;
        for(int i = 0; i < texto.length(); i++){
            char letra = texto.charAt(i);
            if(esConsonante(letra)){
                con ++;
            }
        }
        return con;
    }

    public int sumLetras(){
        //return contVocales(texto) + conConsonantes(texto);
        sumVocales = contVocales(texto);
        sumaConsonantes = conConsonantes(texto);
        return sumVocales + sumaConsonantes;
    }

    @Override
    public void run() {

        switch(opcion){
            case 1:

                sumVocales = contVocales(texto);
                System.out.println("Total número de vocales: " + sumVocales);
                break;
            case 2:
                sumaConsonantes = conConsonantes(texto);
                System.out.println("Total número de consonantes: " + sumaConsonantes);
                break;
            case 3:
                sumLetras();
                System.out.println("Total número de letras: " + sumLetras());
                break;
        }

    }
}

import java.util.Scanner;

public class Main {

    public static void main (String [] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un texto: ");
        String texto = sc.nextLine();
        //String texto = "Pabloesunpesado";

        Hilos h1 = new Hilos(1, texto);
        Hilos h2 = new Hilos(2, texto);
        Hilos h3= new Hilos(3, texto);

        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
        Thread t3 = new Thread(h3);

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();

    }
}

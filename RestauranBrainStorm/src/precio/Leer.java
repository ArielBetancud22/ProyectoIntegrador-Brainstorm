package precio;

import java.io.*;

public class Leer {

    public static String dato() {
        String sdato = " ";
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader flujoE = new BufferedReader(isr);
            sdato = flujoE.readLine();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
        return sdato;

    }

    public static int datoInt() {
        return Integer.parseInt(dato());
    }

    public static float datoFloat() {
        return Float.parseFloat(dato());
    }

    // Leer un char por teclado

    public static char datoChar() {
        char c = ' ';
        try {
            java.io.BufferedInputStream b = new BufferedInputStream(System.in);
            c = (char) b.read();
        } catch (IOException e) {
            System.out.println("Error al leer");
            e.printStackTrace();
        }
        return c;
    }

    public static long datoLong() {
        return Long.parseLong(dato());
    }
}

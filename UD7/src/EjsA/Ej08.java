package EjsA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej08 {
    public static void main(String[] args) {
    
        Scanner leer = new Scanner(System.in);
        int a;
        boolean b = false;
        do {         
            try {
                a = leer.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: la entrada no es un número");
                leer.nextLine();
            }
        } while (!b);
    }
}

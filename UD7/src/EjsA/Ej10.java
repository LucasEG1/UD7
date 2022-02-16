
package EjsA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej10 {

    public static void main(String[] args) {
        double[] a = new double[5];
        int cuantos = 0;
        Scanner leer = new Scanner(System.in);
        do {            
            try {
                a[cuantos] = leer.nextDouble();
                cuantos++;
            } catch (InputMismatchException e) {
                System.out.println("No es un numero By: luquita");
                leer.nextLine();
            }
        } while (cuantos < a.length);
    }
}

package EjsA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej09 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
                
        int a, b;
        boolean c = false;
        do {            
            try {
                System.out.print("a:");
                a = leer.nextInt();
                System.out.print("b:");
                b = leer.nextInt();
                
                System.out.println(a/b);
                c = true;
            } catch (InputMismatchException e) {
                System.err.println("El valor introducido no es un número");
                leer.nextLine();
            } catch (ArithmeticException e){
                System.err.println("No se puede dividir por cero.");
                leer.nextLine();
            }
        } while (!c);
        
    }
}

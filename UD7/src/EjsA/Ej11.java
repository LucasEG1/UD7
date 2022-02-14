package EjsA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej11 {
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        int n = (int)(Math.random()*(100-1+1)+1); //1-100
        int[] v = new int[n];
        
        for (int i = 0; i < v.length; i++) {
            v[i] = (int)(Math.random()*11);
        }
        
        int pide;
        do {
            pide = leer.nextInt();
            try {
                System.out.println(v[pide]);
                
            } catch (IndexOutOfBoundsException e) {
                
                System.out.println("Valor no se encuentra en el tamaño del array");
                leer.nextLine();
                
            } catch (InputMismatchException e){
                
                System.out.println("No es un número entero.");
                leer.nextLine();
                
            } catch (ArrayStoreException e){
                System.out.println("El objeto no se puede agregar al array (debe ser un int)");
                leer.nextLine();
            }
            
        } while (pide >= 0);
    }
}


package EntregableUD7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Func {
    
    public static int pedirInt(){
        Scanner leer = new Scanner(System.in);
        int i = -1;
        try {
            i = leer.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Introduce un número entero.");
        }
        return i;
    }
    
    public static double pedirDouble(){
        Scanner leer = new Scanner(System.in);
        double d = -1;
        try {
            System.out.print("Cantidad: ");
            d = leer.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Introduce un número 'double'.");
        }
        return d;
    }
    
    
    public static int rango(int min, int max) throws CuentaException{

        int valor;

        do {
            valor = pedirInt();
            if (valor < min || valor > max) {
                throw new CuentaException("Entrada inválida. Introduce un número entre " + min + " y " + max);
            }
        } while (valor < min || valor > max);

        return valor;
    }
    
    public static int menu() throws CuentaException{
        System.out.println("1. Ver cuentas");
        System.out.println("2. Ingresar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Transferir dinero");
        System.out.println("5. Agregar cuenta");
        System.out.println("6. Eliminar cuenta");
        System.out.println("7. Buscar cuenta");
        System.out.println("8. Mostrar morosos");
        System.out.println("9. Salir");
        
        int opcion = rango(1,9);
        return opcion;
    }
    public static Cuenta crearCuenta(String nombre, double saldo) throws CuentaException{
        Cuenta c = new Cuenta(nombre, saldo);
        return c;
    }
    public static String pedirString(){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        return s;
    }
    
}

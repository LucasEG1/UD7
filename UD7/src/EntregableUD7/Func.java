
package EntregableUD7;

import java.util.Scanner;

public class Func {
    
    public static int rango(int min, int max) throws CuentaException{

        Scanner in = new Scanner(System.in);
        int valor;

        do {
            valor = in.nextInt();
            if (valor < min || valor > max) {
                throw new CuentaException("Entrada inválida. Introduce un número entre " + Integer.toString(min) + " y " + Integer.toString(max));
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
    public static double pedirDouble(){
        Scanner leer = new Scanner(System.in);
        System.out.print("\nCantidad a ingresar: ");
        double d = leer.nextDouble();
        return d;
    }
}

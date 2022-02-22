
package EntregableUD7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Banco banco = new Banco(100);
        int opcion = 0;
        boolean valido = false;
        do {
            do {                
                try {
                    opcion = Func.menu();
                    valido = true;
                } catch (CuentaException e) {
                    System.out.println(e.getMessage());
                    valido = false;
                } catch (InputMismatchException e){
                    System.err.println("Introduce un número entero.");
                    valido = false;
                }
            } while (valido != true);
            
            switch (opcion) {
                case 1:
                    System.out.println("== VER CUENTAS ==");
                    try {
                        banco.mostrarTodos();
                        System.out.println("");
                    } catch (CuentaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("== INGRESAR DINERO ==");
                    try {
                        Cuenta c = banco.elegirCuenta();
                        double d = Func.pedirDouble();
                        banco.ingresar(d,c);
                    } catch (CuentaException e) {
                        System.out.println(e.getMessage());
                        System.out.println("La operación no se ha realizado.");
                    }
                    break;
                case 3:
                    System.out.println("== RETIRAR DINERO ==");
                    try {
                        System.out.println("La operación no se ha realizado.");
                        Cuenta c = banco.elegirCuenta();
                        double d = Func.pedirDouble();
                        banco.retirar(d, c);
                    } catch (CuentaException e) {
                        System.out.println(e.getMessage());
                        System.out.println("La operación no se ha realizado.");
                    }
                    break;
                case 4:
                    System.out.println("== TRANSFERIR DINERO ==");
                    try {
                        System.out.println("Cuenta de origen");
                        Cuenta origen = banco.elegirCuenta();
                        System.out.println("Cuenta de destino");
                        Cuenta destino = banco.elegirCuenta();
                        double dinero = Func.pedirDouble();
                        banco.transferir(dinero, origen, destino);
                    } catch (CuentaException e) {
                        System.out.println(e.getMessage());
                        System.out.println("La operación no se ha realizado.");
                    }
                    break;
                case 5:
                    System.out.println("== AGREGAR CUENTA ==");
                    try {
                        System.out.print("Nombre: ");
                        String n = Func.pedirString();
                        System.out.print("¿Cuánto saldo? ");
                        double s = Func.pedirDouble();
                        banco.agregarCuenta(Func.crearCuenta(n, s));
                    } catch (CuentaException e) {
                        System.out.println(e.getMessage());
                        System.out.println("La operación no se ha realizado.");
                    }
                    break;
                case 6:
                    System.out.println("== ELIMINAR CUENTA ==");
                    try {
                        banco.eliminarCuenta(banco.elegirPosDeCuenta());
                    } catch (CuentaException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Como no hay cuentas, no se puede eliminar nada.");
                    }
                    break;
                case 7:
                    System.out.println("== BUSCAR CUENTA POR NOMBRE ==");
                    try {
                        banco.buscarCuenta();
                    } catch (CuentaException e) {
                        System.out.println(e.getMessage());
                        System.out.println("La operación no se ha realizado.");
                    }
                    break;
                case 8:
                    System.out.println("== MOSTRAR MOROSOS ==");
                    try {
                        banco.mostrarMorosos();
                    } catch (CuentaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("¡Hasta pronto!");
                    break;
            }
            
        } while (opcion != 9);
        
    }
}

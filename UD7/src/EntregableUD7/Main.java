
package EntregableUD7;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco(100);
        int opcion = 0;
        boolean valido = false;
        do {
            do {                
                try {
                    opcion = Func.menu();
                    valido = true;
                } catch (CuentaException e) {
                    e.getMessage();
                } catch (InputMismatchException e){
                    System.err.println("Introduce un número entero.");
                }
            } while (valido != true);
            
            switch (opcion) {
                case 1:
                    System.out.println("== VER CUENTAS ==");
                    banco.mostrarTodos();
                    break;
                case 2:
                    System.out.println("== INGRESAR DINERO ==");
                    try {
                        banco.ingresar(Func.pedirDouble(), banco.elegirCuenta());
                    } catch (CuentaException e) {
                        e.getMessage();
                        System.out.println("La operación no se ha realizado.");
                    }
                    break;
                case 3:
                    System.out.println("== RETIRAR DINERO ==");
                    try {
                        banco.retirar(Func.pedirDouble(), banco.elegirCuenta());
                    } catch (CuentaException e) {
                        e.getMessage();
                        System.out.println("La operación no se ha realizado.");
                    }
                    break;
                case 4:
                    System.out.println("== TRANSFERIR DINERO ==");
                    try {
                        banco.transferir(Func.pedirDouble(), banco.elegirCuenta(), banco.elegirCuenta());
                    } catch (CuentaException e) {
                        e.getMessage();
                        System.out.println("La operación no se ha realizado.");
                    }
                    break;
                case 5:
                    System.out.println("== AGREGAR CUENTA ==");
                    try {
                        banco.agregarCuenta(Func.crearCuenta(Func.pedirString(), Func.pedirDouble()));
                    } catch (CuentaException e) {
                        e.getMessage();
                        System.out.println("La operación no se ha realizado.");
                    }
                    break;
                case 6:
                    System.out.println("== ELIMINAR CUENTA ==");
                    try {
                        banco.eliminarCuenta(banco.elegirCuentaInt());
                    } catch (CuentaException e) {
                        e.getMessage();
                        System.out.println("La operación no se ha realizado.");
                    }
                    break;
                case 7:
                    System.out.println("== BUSCAR CUENTA POR NOMBRE ==");
                    banco.buscarCuenta();
                    break;
                case 8:
                    System.out.println("== MOSTRAR MOROSOS ==");
                    banco.mostrarMorosos();
                    break;
                case 9:
                    System.out.println("¡Hasta pronto!");
                    break;
            }
            
        } while (opcion != 9);
        
    }
}

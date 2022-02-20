package EntregableUD7;

import java.util.Scanner;

public class Banco {
    
    private Cuenta[] cuentas;
    private int cuantos;
    
    //Constructor
    public Banco(int cuantasCuentas){
        cuentas = new Cuenta[cuantasCuentas];
        this.cuantos = 0;
    }
    //Getters - Setters
    
    //Otras funciones
    public void mostrarTodos(){
        for (int i = 0; i < cuantos; i++) {
            System.out.print(i + ": ");
            cuentas[i].verCuenta();
        }
    }
    public void mostrarMorosos(){
        
        Banco morosos = new Banco(cuantos);
        
        for (int i = 0; i < cuantos; i++) {
            if (cuentas[i].getSaldo() < 0){
                morosos.agregarCuenta(cuentas[i]);
            }
        }
        morosos.mostrarTodos();
    }
    public boolean agregarCuenta(Cuenta c){
        
        boolean encontrado = false;

        for (int i = 0; i < cuantos; i++) {

            if (c.getNombre().equals(cuentas[i].getNombre())) {
                encontrado = true;
            }
        }

        if (cuantos >= cuentas.length) {
            System.err.println("Agenda llena. La cuenta no se ha agregado.");
            return false;
        } else if (encontrado == true) {
            System.err.println("Ya existe una cuenta con este nombre.");
            return false;
        } else {
            this.cuentas[cuantos] = c;
            cuantos++;
            return true;
        }
    }
    public boolean eliminarCuenta(int pos){
        if (cuantos <= 0 || pos < 0){
            System.err.println("Agenda vacía. El contacto no se ha eliminado.");
            return false;
        } else {
            for (int i = pos; i < cuentas.length-1; i++) {
                cuentas[i] = cuentas[i+1];
            }
            cuantos--;
            return true;
        }
    }
    public Banco buscarCuenta(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Qué nombre buscas?");
        String busqueda = leer.nextLine();
        int cuantosEncontrados = 0;
        
        Banco be = new Banco(this.cuentas.length);
        
        for (int i = 0; i < cuantos; i++) {
            
            if (cuentas[i].getNombre().toUpperCase().contains(busqueda.toUpperCase())){
                cuantosEncontrados++;
                be.agregarCuenta(cuentas[i]);
            }
        }
        if (cuantosEncontrados == 0)
            System.out.println("No hay cuentas con mora.");
        return be;
    }
    public Cuenta elegirCuenta() throws CuentaException{
        mostrarTodos();
        System.out.println("\nElige una");
        return cuentas[Func.rango(0, cuantos)];
    }
    public int elegirCuentaInt() throws CuentaException{
        mostrarTodos();
        System.out.println("\nElige una");
        return Func.rango(0, cuantos);
    }
    public void ingresar(double dinero, Cuenta c)throws CuentaException{
        c.ingresar(dinero);
        System.out.println("Operación realizada con éxito.\n");
    }
    public void retirar(double dinero, Cuenta c) throws CuentaException{
        c.retirar(dinero);
    }
    public void transferir(double dinero, Cuenta origen, Cuenta destino) throws CuentaException{
         origen.retirar(dinero);
         destino.ingresar(dinero);
    }
}

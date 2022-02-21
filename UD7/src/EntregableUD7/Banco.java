package EntregableUD7;

import java.util.Scanner;

public class Banco {

    private Cuenta[] cuentas;
    private int cuantos;

    //Constructor
    public Banco(int cuantasCuentas) {
        cuentas = new Cuenta[cuantasCuentas];
        this.cuantos = 0;
    }
    //Getters - Setters

    //Otras funciones
    public void mostrarTodos() throws CuentaException {

        if (0 == this.cuantos) {
            throw new CuentaException("No hay cuentas para mostrar");
        } else {
            for (int i = 0; i < cuantos; i++) {
                System.out.print(i + ": ");
                cuentas[i].verCuenta();
            }
        }
    }

    public void mostrarMorosos() throws CuentaException {

        Banco morosos = new Banco(cuantos);

        for (int i = 0; i < cuantos; i++) {
            if (cuentas[i].getSaldo() < 0) {
                morosos.agregarCuenta(cuentas[i]);
            }
        }
        morosos.mostrarTodos();
    }

    public boolean agregarCuenta(Cuenta c) throws CuentaException {

        boolean encontrado = false;

        for (int i = 0; i < cuantos; i++) {

            if (c.getNombre().toUpperCase().equals(cuentas[i].getNombre().toUpperCase())) {
                encontrado = true;
            }
        }

        if (cuantos >= cuentas.length) {
            throw new CuentaException("Agenda llena. La cuenta no se ha agregado.");
        } else if (encontrado == true) {
            throw new CuentaException("Ya existe una cuenta con este nombre.");
        } else {
            this.cuentas[cuantos] = c;
            cuantos++;
            return true;
        }
    }

    public void eliminarCuenta(int pos) throws CuentaException {
        if (cuantos <= 0 || pos < 0) {
            throw new CuentaException("Agenda vacía. El contacto no se ha eliminado.");
        } else {
            for (int i = pos; i < cuentas.length - 1; i++) {
                cuentas[i] = cuentas[i + 1];
            }
            cuantos--;
            System.out.println("Cuenta eliminada exitosamente.");
        }
    }

    public Banco buscarCuenta() throws CuentaException {
        Scanner leer = new Scanner(System.in);
        System.out.println("Qué nombre buscas?");
        String busqueda = leer.nextLine();
        int cuantosEncontrados = 0;

        Banco be = new Banco(this.cuentas.length);

        for (int i = 0; i < cuantos; i++) {

            if (cuentas[i].getNombre().toUpperCase().contains(busqueda.toUpperCase())) {
                cuantosEncontrados++;
                be.agregarCuenta(cuentas[i]);
            }
        }
        if (cuantosEncontrados == 0) {
            System.out.println("No hay cuentas con mora.");
        }
        return be;
    }

    public Cuenta elegirCuenta() throws CuentaException {
        mostrarTodos();
        System.out.println("\nElige una");
        return cuentas[Func.rango(0, cuantos-1)];
    }

    public int elegirPosDeCuenta() throws CuentaException {
        mostrarTodos();
        System.out.println("\nElige una");
        return Func.rango(0, cuantos-1);
    }

    public void ingresar(double dinero, Cuenta c) throws CuentaException {
        c.ingresar(dinero);
        System.out.println("Operación realizada con éxito.\n");
    }

    public void retirar(double dinero, Cuenta c) throws CuentaException {
        c.retirar(dinero);
    }

    public void transferir(double dinero, Cuenta origen, Cuenta destino) throws CuentaException {

        try {
            origen.retirar(dinero);
            try {
                destino.ingresar(dinero);
            } catch (CuentaException e) {
                System.out.println(e.getMessage());
                origen.ingresar(dinero);
            }

        } catch (CuentaException e) {
            System.out.println(e.getMessage());
        }
    }
}

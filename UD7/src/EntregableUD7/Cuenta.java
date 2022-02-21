package EntregableUD7;

public class Cuenta {

    private String nombre;
    private double saldo;

    //Constructor
    public Cuenta(String nombre, double saldo) throws CuentaException {
        setNombre(nombre);
        setSaldo(saldo);
    }

    //Getters - Setters
    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNombre(String nombre) throws CuentaException {
        if (nombre.length() == 0) {
            throw new CuentaException("La cuenta no puede contener un nombre vacío");
        }
        this.nombre = nombre;
    }

    public void setSaldo(double saldo) throws CuentaException {
        if (saldo < -100) {
            throw new CuentaException("El saldo de la cuenta no puede ser inferior a 100€.");
        } else {
            this.saldo = saldo;
        }
    }

    //Otras funciones
    public void verCuenta() {
        System.out.println(this.nombre + "\t" + this.saldo);
    }

    public void ingresar(double dinero) throws CuentaException {
        if (dinero < 0) {
            throw new CuentaException("No se puede ingresar dinero negativo.");
        } else {
            this.saldo += dinero;
        }
    }

    public void retirar(double dinero) throws CuentaException {
        if (dinero < 0) {
            throw new CuentaException("No se puede retirar dinero negativo.");
        } else if ((this.saldo - dinero) < -100) {
            throw new CuentaException("La cuenta no puede tener un saldo inferior a -100€");
        } else {
            System.out.println("La operación se ha realizado con éxito");
            this.saldo -= dinero;
        }
    }
}


package EjsB;

public class Ej08 {

    public static int devuelveEntero(int num) {
        try {
            if (num % 2 == 0) {
                //System.out.println("lanzada excepción");
                throw new Exception("lanzando excepcion");
            }
            return 1;
        } catch (Exception e) {
            System.out.println("Catch");
            return 2;
        } finally {
            System.out.println("Finally");
            return 3;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(devuelveEntero(i));
        }
    }
}

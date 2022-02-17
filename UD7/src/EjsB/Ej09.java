
package EjsB;

import java.io.IOException;

public class Ej09 {
    public static int devuelveEntero(int num) throws Exception {
        try {
            if (num % 2 == 0) {
                throw new Exception("lanzando excepcion rana");
            } else {
                throw new IOException("Lanzando excepcion pezespada");
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
            return 2;
        }
    }

    public static void main(String[] args) {
        int a = 99;
        for (int i = 0; i < 10; i++) {
            try {
                a = devuelveEntero(i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                a = 99;
            }
            System.out.println(a);
        }
    }
}

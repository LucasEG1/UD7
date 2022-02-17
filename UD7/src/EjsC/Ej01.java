package EjsC;

public class Ej01 {

    public static void imprimePositivo(int p) throws Exception {
        System.out.println(p);
        if (p < 0) {
            throw new Exception("p es menor que cero");
        }
    }
    public static void imprimeNegativo(int n) throws Exception {
        System.out.println(n);
        if (n >= 0){
            throw new Exception("n es un numero positivo");
        }
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("Imprime negativo -5:");
            imprimeNegativo(-5);
            System.out.println("Imprime positivo -5:");
            imprimePositivo(-5);
            imprimeNegativo(-78);
        } catch (Exception e) {
            System.out.println("captado mensaje de error");
            System.out.println(e.getMessage());
        }
    }
}

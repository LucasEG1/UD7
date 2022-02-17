
package EjsC;

public class Ej02 {

    public static void enviarMensaje(String correo) throws Exception {
        int hayAntesDeArroba = correo.indexOf("@")-1;
        /*boolean hayAntesArroba = true;
        if (hayAntesDeArroba == -1){
            hayAntesArroba = false;
        }
        System.out.println(hayAntesArroba); */
        System.out.println(hayAntesDeArroba);
        
        switch(hayAntesDeArroba){
            
            case -2:
                System.out.println("La cadena no contiene un @");
                break;
            case -1:
                System.out.println("La cadena contiene un @ pero no tiene nada delante");
                break;
            default:
                System.out.println("El correo está bien");
                break;
        }
    }
    
    public static void main(String[] args) {
        try {
            enviarMensaje("aaaaa@asd");
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

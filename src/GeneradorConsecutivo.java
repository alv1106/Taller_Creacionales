public class GeneradorConsecutivo {

    //Instancia unica compartida para la clase
    private static final GeneradorConsecutivo INSTANCIA =
            new GeneradorConsecutivo();

    private int contador;


    // Constructor privado (singleton), no va a permitir que otras clases puedan hacer new GeneradorConsecutivo()
    private GeneradorConsecutivo() {
        contador = 0;
        System.out.println("[Consecutivo] Instancia creada.");
    }

    // El punto de acceso de
    public static GeneradorConsecutivo obtenerInstancia() {
        return INSTANCIA;
    }

    // Incrementa el contador y genera el identificador con cuatro digitos
    public String siguiente() {
        contador++;
        return String.format("PED-%04d", contador);
    }
}

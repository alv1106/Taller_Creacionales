public class ProcesadorTarjeta extends ProcesadorPago {

    @Override
    public PasarelaPago crearPasarela() {
        return new PasarelaTarjeta();
    }
}

public class ProcesadorPSE extends ProcesadorPago {

    @Override
    public PasarelaPago crearPasarela() {
        return new PasarelaPSE();
    }
}
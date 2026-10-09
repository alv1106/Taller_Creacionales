public class ProcesadorEfectivo extends ProcesadorPago {

    @Override
    public PasarelaPago crearPasarela() {
        return new PasarelaEfectivo();
    }
}


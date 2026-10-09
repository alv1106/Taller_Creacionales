public class ProcesadorNequi extends ProcesadorPago {

    @Override
    public PasarelaPago crearPasarela() {
        return new PasarelaNequi();
    }
}


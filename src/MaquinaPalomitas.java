public class MaquinaPalomitas extends Maquina {

    private int porcionesPorHora;
    private boolean carritoIntegrado;

    public MaquinaPalomitas(String codigoInventario, String marca, String modelo,
            double tarifaDiaria, int porcionesPorHora, boolean carritoIntegrado) {

        super(codigoInventario, marca, modelo, tarifaDiaria);

        if (porcionesPorHora <= 0) {
            throw new IllegalArgumentException(
                "Las porciones por hora deben ser mayores que cero"
            );
        }

        this.porcionesPorHora = porcionesPorHora;
        this.carritoIntegrado = carritoIntegrado;
    }

    public int getPorcionesPorHora() {
        return porcionesPorHora;
    }

    public boolean getCarritoIntegrado() {
        return carritoIntegrado;
    }

    @Override
    public double calcularCosto(int dias) {
        double costo = super.calcularCosto(dias);

        if (carritoIntegrado) {
            costo = costo + (40 * dias);
        }

        return costo;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nPorciones por hora: " + porcionesPorHora
                + "\nCarrito integrado: " + carritoIntegrado;
    }
}
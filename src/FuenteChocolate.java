public class FuenteChocolate extends Maquina {

    private double capacidadMaxima;

    public FuenteChocolate(String codigoInventario, String marca, String modelo,
            double tarifaDiaria, double capacidadMaxima) {

        super(codigoInventario, marca, modelo, tarifaDiaria);

        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException(
                "La capacidad maxima debe ser mayor que cero"
            );
        }

        this.capacidadMaxima = capacidadMaxima;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    @Override
    public double calcularCosto(int dias) {
        double costo = super.calcularCosto(dias);

        costo = costo + (20 * capacidadMaxima * dias);

        return costo;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nCapacidad maxima: " + capacidadMaxima + " kg";
    }
}
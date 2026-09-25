public class MaquinaAlgodon extends Maquina {

    private int potenciaVatios;

    public MaquinaAlgodon(String codigoInventario, String marca, String modelo,
            double tarifaDiaria, int potenciaVatios) {

        super(codigoInventario, marca, modelo, tarifaDiaria);

        if (potenciaVatios <= 0) {
            throw new IllegalArgumentException(
                "La potencia debe ser mayor que cero"
            );
        }

        this.potenciaVatios = potenciaVatios;
    }

    public int getPotenciaVatios() {
        return potenciaVatios;
    }

    @Override
    public double calcularCosto(int dias) {
        double costo = super.calcularCosto(dias);

        if (potenciaVatios > 1000) {
            costo = costo + 60;
        }

        return costo;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nPotencia: " + potenciaVatios + " vatios";
    }
}
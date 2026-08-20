public class Prestamo {

    private String codigoPrestamo;
    private String carne;
    private String nombreEstudiante;
    private String tituloLibro;
    private int diasAutorizados;

    public Prestamo(String codigoPrestamo, String carne, String nombreEstudiante, String tituloLibro, int diasAutorizados) {
        this.codigoPrestamo = codigoPrestamo;
        this.carne = carne;
        this.nombreEstudiante = nombreEstudiante;
        this.tituloLibro = tituloLibro;
        this.diasAutorizados = diasAutorizados;
    }

    public String getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public String getCarne() {
        return carne;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public int getDiasAutorizados() {
        return diasAutorizados;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public void setDiasAutorizados(int diasAutorizados) {
        this.diasAutorizados = diasAutorizados;
    }
}
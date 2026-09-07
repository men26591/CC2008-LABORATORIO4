public class Pista {

    private String codigo;
    private String descripcion;
    private String tipoEvidencia;
    private int nivelImportancia;
    private int nivelConfiabilidad;

    public Pista(String codigo, String descripcion, String tipoEvidencia, int nivelImportancia, int nivelConfiabilidad) {

        if (nivelImportancia < 1 || nivelImportancia > 10) {
            throw new IllegalArgumentException("El nivel de importancia debe estar entre 1 y 10.");
        }

        if (nivelConfiabilidad < 0 || nivelConfiabilidad > 100) {
            throw new IllegalArgumentException("El nivel de confiabilidad debe estar entre 0 y 100.");
        }

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipoEvidencia = tipoEvidencia;
        this.nivelImportancia = nivelImportancia;
        this.nivelConfiabilidad = nivelConfiabilidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoEvidencia() {
        return tipoEvidencia;
    }

    public int getNivelImportancia() {
        return nivelImportancia;
    }

    public int getNivelConfiabilidad() {
        return nivelConfiabilidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipoEvidencia(String tipoEvidencia) {
        this.tipoEvidencia = tipoEvidencia;
    }

    public void setNivelImportancia(int nivelImportancia) {

        if (nivelImportancia < 1 || nivelImportancia > 10) {
            throw new IllegalArgumentException("El nivel de importancia debe estar entre 1 y 10.");
        }

        this.nivelImportancia = nivelImportancia;
    }

    public void setNivelConfiabilidad(int nivelConfiabilidad) {

        if (nivelConfiabilidad < 0 || nivelConfiabilidad > 100) {
            throw new IllegalArgumentException("El nivel de confiabilidad debe estar entre 0 y 100.");
        }

        this.nivelConfiabilidad = nivelConfiabilidad;
    }

    public String toString() {
        return "Codigo: " + codigo
                + ", Descripcion: " + descripcion
                + ", Tipo de evidencia: " + tipoEvidencia
                + ", Nivel de importancia: " + nivelImportancia
                + ", Nivel de confiabilidad: " + nivelConfiabilidad;
    }
}
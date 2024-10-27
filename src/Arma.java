public abstract class Arma {
    protected int cantMuniciones;
    protected double alcance;
    protected String marca;
    protected int calibre;
    protected String estado;
    protected Policia propietario;

    public Arma(int cantMuniciones, double alcance, String marca, int calibre, String estado, Policia propietario) {
        this.cantMuniciones = cantMuniciones;
        this.alcance = alcance;
        this.marca = marca;
        this.calibre = calibre;
        this.estado = estado;
        this.propietario = propietario;
    }

    public boolean enCondiciones() {
        return estado.equals("EN USO") && calibre >= 9;
    }

    public abstract String toString(); 


}
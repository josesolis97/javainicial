public class ArmaCorta extends Arma {
    private boolean esAutomatica;

    public ArmaCorta(int cantMuniciones, double alcance, String marca, int calibre, String estado, Policia propietario, boolean esAutomatica) {
        super(cantMuniciones, alcance, marca, calibre, estado, propietario);
        this.esAutomatica = esAutomatica;
    }

    public boolean puedeDispararALargaDistancia() {
        return alcance > 200;
    }

    @Override
    public String toString() {
        return "ArmaCorta{" +
                "esAutomatica=" + esAutomatica +
                ", cantMuniciones=" + cantMuniciones +
                ", alcance=" + alcance +
                ", marca='" + marca + '\'' +
                ", calibre=" + calibre +
                ", estado='" + estado + '\'' +
                ", propietario=" + propietario +
                '}';
    }
}
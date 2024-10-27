public class ArmaLarga extends Arma implements Comparable<ArmaLarga> {
    private String justifUso;
    private int nivelArma;
    private boolean tieneSello;

    public ArmaLarga(int cantMuniciones, double alcance, String marca, int calibre, String estado, Policia propietario, String justifUso, int nivelArma, boolean tieneSello) {
        super(cantMuniciones, alcance, marca, calibre, estado, propietario);
        this.justifUso = justifUso;
        this.nivelArma = nivelArma;
        this.tieneSello = tieneSello;
    }

    @Override
    public int compareTo(ArmaLarga otraArma) {
        return Integer.compare(this.nivelArma, otraArma.nivelArma);
    }

    @Override
    public String toString() {
        return "ArmaLarga{" +
                "justifUso='" + justifUso + '\'' +
                ", nivelArma=" + nivelArma +
                ", tieneSello=" + tieneSello +
                ", cantMuniciones=" + cantMuniciones +
                ", alcance=" + alcance +
                ", marca='" + marca + '\'' +
                ", calibre=" + calibre +
                ", estado='" + estado + '\'' +
                ", propietario=" + propietario +
                '}';
    }
}
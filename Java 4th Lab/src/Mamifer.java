public abstract class Mamifer {
    //Proprietati
    private String nume;
    private double greutate;

    //Metode
    Mamifer(String nume, double greutate){
        this.nume = nume;
        this.greutate = greutate;
    }

    abstract void marcheazaTeritoriul();

    public double getGreutate() {
        return greutate;
    }

    public void setGreutate(double greutate) {
        this.greutate = greutate;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}

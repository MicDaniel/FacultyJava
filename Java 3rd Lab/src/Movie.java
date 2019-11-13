public class Movie {
    private static int price = 30;
    private static String cinematograf = "Patria";
    private String movieName;
    private int durata; // in minute
    private boolean oscarWinner;

    public Movie(String movieName, int durata, boolean oscarWinner) {
        this.movieName = movieName;
        this.durata = durata;
        this.oscarWinner = oscarWinner;
    }

    public static int getPrice() {
        return price;
    }

    public static String getCinematograf() {
        return cinematograf;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getDurata() {
        return durata;
    }

    public boolean getOscarWinner() { return oscarWinner; }

    static void printCinema(Movie movie) {
        System.out.println("Filmul " + movie.getMovieName() + " este difuzat la cinematograful " + getCinematograf() + '\n');
    }

    public void afisare() {
        printCinema(this);

        System.out.println("Nume: "+ this.getMovieName());
        System.out.println("Durata (in minute): " + this.getDurata());
        if(this.getOscarWinner()){
            System.out.println("Filmul a primit premiul Oscar\n");
        }
        else {
            System.out.println("Filmul nu a primit premiul Oscar\n");
        }
    }
}

public class MainClass {
    public static void main(String[] args) {
        /*
        Salariat s1 = new Salariat("Popa Ion", "contabil", 36, 7300);
        Salariat s2 = new Salariat("Rada Alina", "secretara", 28, 6000);

        System.out.println("Impozit: " + (int) (Salariat.tax*100) + "% \n");
        s1.print();
        s2.print();
        */

        /*
        Student s1 = new Student("Mic Daniel", 2,221, 10, 10);
        Student s2 = new Student("Popescu Alexandra", 2,221,8,10);

        s1.print();
        s2.print();
        */

        /*
        System.out.println("Pretul unui bilet este: " + Movie.getPrice() + " RON");
        Movie movie = new Movie("Titanic", 180, true);
        movie.afisare();
        */

        Disk disk1 = new Disk("Disc1", 16);
        disk1.print();

        Floppy floppy = new Floppy("Discheta1", 64, true);
        floppy.print();

        HDD hdd = new HDD("HDD1", "SCSI", 512000);
        hdd.print();

        Disk disk = hdd;
        disk.print();

        disk.setCapacity(1);

        hdd.print();
        disk.print();
    }
}

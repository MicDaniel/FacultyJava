public class Salariat {
    public static final double tax = 0.15;
    public static final double exchangeRate = 0.233493;//exchange rate to RON - USD
    public String name;
    public String position;
    public int age;
    public double salary;

    public Salariat(String name, String position, int age, double salary) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.salary = salary;
    }

    public static double exchangeToUSD(double salary){
        return salary * exchangeRate;
    }

    public double salaryAfterTax() {
        return this.salary*(1-tax);
    }

    public void print() {
        System.out.println("Nume salariat: " + this.name);
        System.out.println("Functia: " + this.position);
        System.out.println("Varsta: "+ this.age);
        System.out.println("Salariul brut in RON: " + this.salary + " lei");
        System.out.println("Salariul brut in USD: " + exchangeToUSD(this.salary) + " dolari");
        System.out.println("Salariul net: " + this.salaryAfterTax() + " lei");
        System.out.println("Salariul net in USD: " + exchangeToUSD(this.salaryAfterTax()) + " dolari\n");
    }
}

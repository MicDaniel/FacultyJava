public class Problema2 {
    public static void main(String[] arg) {
        int j = 2;
        switch (j) {
            case 2:
                System.out.println("valoarea este doi");
            case 1+2:
                System.out.println("valoarea este trei");
                break;
            default:
                System.out.println("Valoarea este "+ j);
                break;
        }
    }
}

public class Problema3 {
    public static void main(String[] arg) {
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                System.out.println("i = " + i + " j = " + j);
            }
        }
    }
}

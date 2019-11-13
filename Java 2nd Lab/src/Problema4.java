public class Problema4 {
    public static void main(String[] arg) {
        outer: for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                if(i==j){
                    continue outer;
                }
                System.out.println("i = " + i + " j = " + j);
            }
        }
    }
}

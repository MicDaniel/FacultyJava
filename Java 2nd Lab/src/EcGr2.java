public class EcGr2 {
    public static void main(String[] arg){
        double a = 2 , b = 5, c = 3;

        double delta = b*b - 4*a*c;

        if(delta > 0){
            double r1 = (-1*b + Math.pow(delta, 0.5)) / (2*a);
            double r2 = (-1*b - Math.pow(delta, 0.5)) / (2*a);
            System.out.println(r1);
            System.out.println(r2);
        }
        else {
            if(delta == 0){
                double r = -1*(b/(2*a));
                System.out.println(r);
            }
            else {
                System.out.println("Nu exista solutii reale");
            }
        }
    }
}

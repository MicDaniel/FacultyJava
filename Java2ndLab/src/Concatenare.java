import java.util.Scanner;

public class Concatenare {
    public static String f(String s){
        String newS = s + "<-->";
    return newS;
    }

    public static void main(String[] args){
        System.out.println(f("idk"));

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        if(str != null){
            System.out.println(f(str));
        }
    }
}

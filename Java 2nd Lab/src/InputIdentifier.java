import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class InputIdentifier {
    public static void main(String[] args) {
        System.out.println("Introduceti argumentele: ");
        LinkedList list = new LinkedList();

        int time = 5;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long startTime = System.currentTimeMillis();
       try {
           if ((System.currentTimeMillis() - startTime) < time * 1000
                   && !in.ready()) {

           }
           String value = in.readLine();
           list.add(value);
       } catch(IOException e){
           System.out.println("IOException");
       }


        if(list.size() == 0) {
            System.out.println("0 argumente");
        }
        else {
            if (list.size() == 1) {
                System.out.println("1 argument: ");
                System.out.println(list.get(0));
            }
            else {
                System.out.println("mai multe argumente: ");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
            }
        }
    }
}

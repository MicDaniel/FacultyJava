public class ThreadEx1 {
    public static void main(String[] args) {
        helper1 thread = new helper1();
        thread.start();
        System.out.println("Back to main");
    }
}
class helper1 extends Thread {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Step " + i);
        }
        System.out.println("Run has ended");
    }
}
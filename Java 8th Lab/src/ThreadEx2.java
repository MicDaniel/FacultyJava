public class ThreadEx2 {
    public static void main(String[] args) {
        helper2 thread1 = new helper2();
        helper2 thread2 = new helper2();
        thread1.start();
        thread2.start();
        System.out.println("Back to main");
    }
}

class helper2 extends Thread {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Step " + i);
            try {
                sleep(500); //Pausing the thread for .5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("End of run");
    }
}

public class ThreadEx3 {
    public static void main(String[] args) {
        helper3 thread1 = new helper3("1st Thread");
        helper3 thread2 = new helper3("2nd Thread");
        helper3 thread3 = new helper3("3rd Thread");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread3.setPriority(7);
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("Back to main");
    }
}

class helper3 extends Thread {
    public helper3(String s) {
        super(s);
    }

    public void run() {
        String threadName = getName();
        for(int i = 0; i < 5; i++) {
            if(threadName.compareTo("3rd Thread") == 0) yield();
            System.out.println(threadName + " is at step " + i);
            try{
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("End run" + threadName);
    }
}

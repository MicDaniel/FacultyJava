import javax.swing.*;

import static java.lang.Thread.sleep;

public class ThreadEx4Synch extends JFrame {
    private JButton start;
    private int counter = 0;


    public ThreadEx4Synch() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Thread Synch example");
        setSize(300, 150);

        JLabel counterShow = new JLabel("The counter will show here");
        JTextArea logger = new JTextArea("Logger:\n");
        panel.add(counterShow);

        start = new JButton("Start");
        panel.add(start);
        start.addActionListener(e -> {
            counter ++;
            SharedNumber number = new SharedNumber(counter, logger);
            Counter1 ct1 = new Counter1(number);
            Counter2 ct2 = new Counter2(number);
            ct1.start();
            ct2.start();
        });


        panel.add(logger);
    }

    public static void main(String[] args) {
        ThreadEx4Synch main = new ThreadEx4Synch();
        main.setVisible(true);
    }
}

class SharedNumber {
    private int n = 0;
    private int identifier = -1;
    JTextArea logger;

    public SharedNumber(int identifier, JTextArea logger) {
        this.logger = logger;
    }

    public synchronized void increment(int identifier) {
        this.identifier = identifier;
        this.n++;
        this.logger.append("Incremented from counter " + this.identifier + ". New value: "
        + this.n +'\n');
        try{
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.identifier = -1;
    }
}

class Counter1 extends Thread {
    private SharedNumber nr;
    private int identifier = 1;

    public Counter1(SharedNumber nr) {
        this.nr = nr;
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            nr.increment(identifier);
        }
    }
}
class Counter2 extends Thread {
    private SharedNumber nr;
    private int identifier = 2;

    public Counter2(SharedNumber nr) {
        this.nr = nr;
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            nr.increment(identifier);
        }
    }
}

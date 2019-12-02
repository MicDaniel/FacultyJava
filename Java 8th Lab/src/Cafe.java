import javax.swing.*;
import javax.swing.plaf.InternalFrameUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cafe extends JFrame {
    JPanel panel = new JPanel();

    private JButton burger,fries,cola,cooked;
    private Order order, complete;

    public void init() {
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cafe");

        Graphics g=getGraphics();
        burger = new JButton("Burger");
        panel.add(burger);
        burger.addActionListener(e -> {
            order.notifyEvent("burger");
        });

        fries = new JButton("Fries");
        panel.add(fries);
        fries.addActionListener( e -> {
            order.notifyEvent("fries");
        });

        cola = new JButton("Cola");
        panel.add(cola);
        cola.addActionListener(e -> {
            order.notifyEvent("cola");
        });

        cooked = new JButton("Cooked");
        panel.add(cooked);
        cooked.addActionListener(e -> {
            order.notifyEvent("cooked");
        });

        //implementing the ordering
        order = new Order();
        Queue queue = new Queue(g);
        complete = new Order();
        Waiter waiter = new Waiter(g,order,queue);
        waiter.start();
        Chef chef = new Chef(g, complete, queue);
        chef.start();
    }
}

class Order {
 private String order ="";

 public synchronized void notifyEvent(String newOrder) {
     order = newOrder;
     notify();
 }
 public synchronized String waitForEvent() {
     while(order.equals(""))
         try {
             wait();
         } catch (InterruptedException e){ System.out.println("Order exception");}
     String newOrder = order;
     order = "";
     return newOrder;
 }
}

class Waiter extends Thread {
    private Order order;
    private Graphics g;
    private Queue queue;

    public Waiter(Graphics g, Order order, Queue queue) {
        this.g = g;
        this.order = order;
        this.queue = queue;
    }

    public void run() {
        g.drawString("O noua comanda", 10, 50);
        while(true){
            String newOrder = order.waitForEvent();
            g.clearRect(10,50,20,25);
            g.drawString(newOrder,10,70);
            try{
                Thread.sleep(5000);
            }
            catch(InterruptedException e){ System.out.println("Waiter exception");}

            if(!queue.isFull())
                queue.enter((newOrder));
        }
    }
}

class Chef extends Thread {
    private Graphics g;
    private Order complete;
    private Queue queue;

    public Chef(Graphics g, Order complete, Queue queue){
        this.g = g;
        this.complete = complete;
        this.queue = queue;
    }

    public void run() {
        g.drawString("Cooking", 200,50);
        while(true){
            String order = queue.remove();
            g.clearRect(200,55,50,75);
            g.drawString(order,200,70);
            g.drawString(order, 200, 70);
            String cookedInfo=complete.waitForEvent();
            g.clearRect(200,55,50,25);
        }
    }
}

class Queue {
    private Graphics g;
    private String[] queue = new String[20];
    private int count = 0;

    public Queue(Graphics g) {
        this.g = g;
    }

    public synchronized void enter(String item) {
        queue[count] = item;
        count++;
        display();
        notify();
    }
    public synchronized String remove() {
        while(count == 0)
            try{
                wait();
            }
        catch(InterruptedException e) {
            System.out.println("Queue exception!");
        }
        String item = queue[0];
        count--;
        for(int c = 0; c < count; c++){
            queue[c] = queue[c+1];
        }
        display();
        return item;
    }

    public synchronized boolean isFull() {
        return count == queue.length;
    }

    private void display(){
        g.drawString("Queue", 120, 50);
        g.clearRect(120,50,20,220);
        for(int c = 0;c<count;c++){
            g.drawString(queue[c], 120,70+c*20);
        }
    }
}

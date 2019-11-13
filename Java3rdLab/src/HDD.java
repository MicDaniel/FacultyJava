public class HDD extends Disk {
    private String controller;

    public HDD(String name, String controller, int capacity) {
        super(name, capacity);
        this.controller = controller;
    }

    public void print() {
        System.out.println("Name of the HDD: " + this.name);
        System.out.println("Capacity: " + this.capacity + " MB");
        System.out.println("Controller: " + this.controller+'\n');
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }
}

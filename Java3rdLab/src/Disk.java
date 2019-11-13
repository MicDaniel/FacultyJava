public class Disk {
    protected String name;
    protected int capacity;

    public Disk() {
        this.name = "Nespecificat";
    }

    public Disk(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void print() {
        System.out.println("Name of disk: " + this.getName());
        System.out.println("Storage: " + this.getCapacity() + " MB\n");
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

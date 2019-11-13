public class Floppy extends Disk {
    private boolean state;

    public Floppy(String name, int capacity, boolean state) {
        super(name,capacity);
        this.state = state;
    }

    @Override
    public void print() {
        System.out.println("Name of the floppy: " + this.name);
        System.out.println("Capacity: " + this.capacity + " MB");

        if(this.state == true){
            System.out.println("The floppy is write-protected\n");
        }
        else {
            System.out.println("The floppy is NOT write-protected\n");
        }
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}

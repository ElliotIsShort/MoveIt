public class Pickup extends Vehicle {

    private String Capacity;

    public Pickup(){};

    public Pickup(String vehicleID, boolean available, String capacity)
    {
        super(vehicleID, available);
        this.setCapacity(capacity);
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }
}

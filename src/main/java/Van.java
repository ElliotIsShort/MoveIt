public class Van extends Vehicle{

    private String Size;

    public Van(){};

    public Van(String vehicleID, boolean available, String size)
    {
        super(vehicleID, available);
        this.Size = size;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }
}

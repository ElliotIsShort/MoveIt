public class Lorry extends Vehicle {

    private LorryType Type;

    public Lorry(){};

    public Lorry(String vehicleID, boolean available, LorryType type)
    {
        super(vehicleID, available);
        this.Type = type;
    }

    public LorryType getType() {
        return Type;
    }

    public void setType(LorryType type) {
        Type = type;
    }
}

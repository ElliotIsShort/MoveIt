import java.util.Objects;

public abstract class Vehicle {

    private String VehicleID;
    private boolean Available;

    public Vehicle(){}

    public Vehicle(String vehicleID, Boolean available)
    {
        this.VehicleID = vehicleID;
        this.Available = available;
    }

    public String getVehicleID() { return VehicleID; }

    public void setVehicleID(String vehicleID) { VehicleID = vehicleID; }

    public boolean isAvailable() { return Available; }

    public void setAvailable(boolean available) { Available = available; }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        return Objects.equals(VehicleID, vehicle.VehicleID) &&
                Objects.equals(Available, vehicle.Available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VehicleID, Available);
    }

}

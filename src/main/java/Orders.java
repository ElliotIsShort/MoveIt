import java.time.LocalDate;

public class Orders {

    private String CustomerID;
    private String VehicleID;
    private LocalDate Date;
    private int WeeksTaken;
    private double PricePaid;

    public Orders(){}

    public Orders(String customerID, String vehicleID, LocalDate date, int weeksTaken, double pricePaid)
    {
        this.CustomerID = customerID;
        this.VehicleID = vehicleID;
        this.Date = date;
        this.WeeksTaken = weeksTaken;
        this.PricePaid = pricePaid;
    }


    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getVehicleID() {
        return VehicleID;
    }

    public void setVehicleID(String vehicleID) {
        VehicleID = vehicleID;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public int getWeeksTaken() {
        return WeeksTaken;
    }

    public void setWeeksTaken(int weeksTaken) {
        WeeksTaken = weeksTaken;
    }

    public double getPricePaid() {
        return PricePaid;
    }

    public void setPricePaid(double pricePaid) {
        PricePaid = pricePaid;
    }
}

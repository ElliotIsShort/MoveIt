import java.util.Objects;

public class Customer {

    private String CustomerID;
    private String Name;
    private String Address;
    private String Postcode;
    private String PayDetails;

    public Customer(){};

    public Customer(String customerID, String name, String address, String postcode, String payDetails)
    {
        this.CustomerID = customerID;
        this.Name = name;
        this.Address = address;
        this.Postcode = postcode;
        this.PayDetails = payDetails;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public String getPayDetails() {
        return PayDetails;
    }

    public void setPayDetails(String payDetails) {
        PayDetails = payDetails;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return Objects.equals(CustomerID, customer.CustomerID) &&
                Objects.equals(Name, customer.Name) &&
                Objects.equals(Address, customer.Address) &&
                Objects.equals(Postcode, customer.Postcode) &&
                Objects.equals(PayDetails, customer.PayDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CustomerID, Name, Address, Postcode, PayDetails);
    }

}

public class Individual extends Customer {

    private String PhoneNumber;

    public Individual(){};

    public Individual(String customerID, String name, String address, String postcode, String payDetails, String phoneNumber)
    {
        super(customerID, name, address, postcode, payDetails);
        this.PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}

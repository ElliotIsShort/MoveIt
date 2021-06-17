public class Business extends Customer {

    private boolean NeedInsurance;

    public Business(){};

    public Business(String customerID, String name, String address, String postcode, String payDetails, boolean needInsurance)
    {
        super(customerID, name, address, postcode, payDetails);
        this.NeedInsurance = needInsurance;
    }

    public boolean isInsurance() {
        return NeedInsurance;
    }

    public void setInsurance(boolean insurance) {
        NeedInsurance = insurance;
    }
}

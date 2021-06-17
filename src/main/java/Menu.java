import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Menu {

    static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {


        LinkedList<Vehicle> vehicles = new LinkedList<>();


        Menu t = new Menu();

        System.out.println("What would you like to do?");
        System.out.println("1: Add Vehicle");
        System.out.println("2: Add Customer");
        System.out.println("3: Display Vehicles");
        System.out.println("4: Display Customers");
        System.out.println("5: Update Customers");
        System.out.println("6: Hire a Vehicle");
        System.out.println("7: Display Orders");
        System.out.println("8: Sort Vehicles");
        String choice = stdin.nextLine();

        if (choice.equals("1")) {
            System.out.println("Please enter Vehicle Type");
            System.out.println("1: Small Van");
            System.out.println("2: Large Van");
            System.out.println("3: Pickup Truck");
            System.out.println("4: Small Lorry");
            System.out.println("5: Lorry with Crane");
            System.out.println("6: Lorry with Tailgate");
            System.out.println("7: Lorry with Forklift");
            String vehicleChoice = stdin.nextLine();
            System.out.println("Please enter VehicleID");
            String vehicleID = stdin.nextLine();
            System.out.println("Please enter if Vehicle is available");
            boolean vehicleAvailable = stdin.nextBoolean();
            t.fileInsertVehicle(vehicleID, vehicleAvailable, vehicleChoice);

        } else if (choice.equals("2")) {
            System.out.println("Please enter Customer Type");
            System.out.println("1: Business");
            System.out.println("2: Individual");
            String customerChoice = stdin.nextLine();
            System.out.println("Please enter CustomerID");
            String customerID = stdin.nextLine();
            System.out.println("Please enter Name");
            String customerName = stdin.nextLine();
            System.out.println("PLease enter Address");
            String customerAddress = stdin.nextLine();
            System.out.println("Please enter Postcode");
            String customerPostcode = stdin.nextLine();
            System.out.println("Please enter Payment Details");
            String customerPayment = stdin.nextLine();
            t.fileInsertCustomer(customerChoice, customerID, customerName, customerAddress, customerPostcode, customerPayment);

        } else if (choice.equals("3")) {
            t.fileDisplayVehicle();

        } else if (choice.equals("4")) {
            t.fileDisplayCustomer();

        } else if (choice.equals("5")) {
            t.updateCustomer();

        } else if (choice.equals("6")) {
            System.out.println("Please enter type of vehicle you want to hire");
            System.out.println("1: Van");
            System.out.println("2: Pickup Truck");
            System.out.println("3: Lorry");
            choice = stdin.nextLine();
            if(choice.equals("1"))
            {
                System.out.println("What size of van?");
                System.out.println("1: Small");
                System.out.println("2: Large");
                choice = stdin.nextLine();
                if(choice.equals("1"))
                {
                    if (t.vehicleAvailable("VAN", "Small"))
                    {
                        System.out.println("A small van is available");
                        System.out.println("Please enter your customer ID");
                        String customerID = stdin.nextLine();
                        if(t.customerReal(customerID))
                        {
                            t.hireVehicle(customerID, "VAN", "Small");
                        } else
                        {
                            System.out.println("Customer not real");
                        }
                    }
                } else if (choice.equals("2"))
                {
                    if (t.vehicleAvailable("VAN","Large"))
                    {
                    }
                }
            } else if (choice.equals("2")) {
                if (t.vehicleAvailable("PICKUP", "4"))
                {
                    System.out.println("A pickup is available");
                    System.out.println("Please enter your customer ID");
                    String customerID = stdin.nextLine();
                    if(t.customerReal(customerID))
                    {
                        t.hireVehicle(customerID, "PICKUP", "4");
                    } else
                    {
                        System.out.println("Customer not real");
                    }
                }
            } else if (choice.equals("3"))
            {
                System.out.println("What type of lorry?");
                System.out.println("1: Small Lorry");
                System.out.println("2: Lorry with Crane");
                System.out.println("3: Lorry with Tailgate");
                System.out.println("4: Lorry with Forklift");
                choice = stdin.nextLine();
                if(choice.equals("1"))
                {
                    if (t.vehicleAvailable("LORRY", "SMALLLORRY"))
                    {
                        System.out.println("A small lorry is available");
                        System.out.println("Please enter your customer ID");
                        String customerID = stdin.nextLine();
                        if(t.customerReal(customerID))
                        {
                            t.hireVehicle(customerID, "LORRY", "SMALLLORRY");
                        } else
                        {
                            System.out.println("Customer not real");
                        }
                    }
                } else if (choice.equals("2"))
                {
                    if (t.vehicleAvailable("LORRY", "CRANE"))
                    {
                        System.out.println("A lorry with a crane is available");
                        System.out.println("Please enter your customer ID");
                        String customerID = stdin.nextLine();
                        if(t.customerReal(customerID))
                        {
                            t.hireVehicle(customerID, "LORRY", "CRANE");
                        } else
                        {
                            System.out.println("Customer not real");
                        }
                    }
                } else if (choice.equals("3"))
                {
                    if (t.vehicleAvailable("LORRY","TAILGATE"))
                    {
                        System.out.println("A lorry with a tailgate is available");
                        System.out.println("Please enter your customer ID");
                        String customerID = stdin.nextLine();
                        if(t.customerReal(customerID))
                        {
                            t.hireVehicle(customerID, "LORRY", "TAILGATE");
                        } else
                        {
                            System.out.println("Customer not real");
                        }
                    }
                } else if (choice.equals("4"))
                {
                    if (t.vehicleAvailable("LORRY","LIFT"))
                    {
                        System.out.println("A lorry with a fork lift is available");
                        System.out.println("Please enter your customer ID");
                        String customerID = stdin.nextLine();
                        if(t.customerReal(customerID))
                        {
                            t.hireVehicle(customerID, "LORRY", "LIFT");
                        } else
                        {
                            System.out.println("Customer not real");
                        }
                    }
                }
            }
        } else if (choice.equals("7"))
        {
            t.fileDisplayOrder();
        } else if (choice.equals("8"))
        {
            t.sortVehicles();
        }
    }

    public void fileInsertVehicle(String vehicleID, boolean vehicleAvailable, String vehicleChoice) {

        Van v1 = new Van();
        Pickup p1 = new Pickup();
        Lorry l1 = new Lorry();

        if (vehicleChoice.equals("1")) {
            v1.setSize("Small");
            v1.setVehicleID(vehicleID);
            v1.setAvailable(vehicleAvailable);
            writeVehicle(v1, p1, l1, "1");
        } else if (vehicleChoice.equals("2")) {
            v1.setSize("Large");
            v1.setVehicleID(vehicleID);
            v1.setAvailable(vehicleAvailable);
            writeVehicle(v1, p1, l1, "1");
        } else if (vehicleChoice.equals("3")) {
            p1.setCapacity("4");
            p1.setVehicleID(vehicleID);
            p1.setAvailable(vehicleAvailable);
            writeVehicle(v1, p1, l1, "2");
        } else if (vehicleChoice.equals("4")) {
            l1.setType(LorryType.SMALLLORRY);
            l1.setVehicleID(vehicleID);
            l1.setAvailable(vehicleAvailable);
            writeVehicle(v1, p1, l1, "3");
        } else if (vehicleChoice.equals("5")) {
            l1.setType(LorryType.CRANE);
            l1.setVehicleID(vehicleID);
            l1.setAvailable(vehicleAvailable);
            writeVehicle(v1, p1, l1, "3");
        } else if (vehicleChoice.equals("6")) {
            l1.setType(LorryType.TAILGATE);
            l1.setVehicleID(vehicleID);
            l1.setAvailable(vehicleAvailable);
            writeVehicle(v1, p1, l1, "3");
        } else if (vehicleChoice.equals("7")) {
            l1.setType(LorryType.LIFT);
            l1.setVehicleID(vehicleID);
            l1.setAvailable(vehicleAvailable);
            writeVehicle(v1, p1, l1, "3");
        }

    }

    public void writeVehicle(Van v1, Pickup p1, Lorry l1, String choice) {
        try {
            File f = new File("Vehicles.txt");
            PrintWriter write = new PrintWriter(new FileOutputStream(f, true));
            if (choice.equals("1")) {
                write.append("\n" + "VAN," + v1.getVehicleID() + "," + v1.isAvailable() + "," + v1.getSize());
                write.close();
            } else if (choice.equals("2")) {
                write.append("\n" + "PICKUP," + p1.getVehicleID() + "," + p1.isAvailable() + "," + p1.getCapacity());
                write.close();
            } else if (choice.equals("3")) {
                write.append("\n" + "LORRY," + l1.getVehicleID() + "," + l1.isAvailable() + "," + l1.getType());
                write.close();
            }
        } catch (Exception e) {
        }
    }

    public void fileInsertCustomer(String customerChoice, String customerID, String customerName, String customerAddress, String customerPostcode, String customerPayment) {
        Business b1 = new Business();
        Individual i1 = new Individual();

        if (customerChoice.equals("1")) {
            System.out.println("Do you have your own insurance or need insurance supplied?");
            System.out.println("1: Own insurance");
            System.out.println("2: MITVH insurance");
            String insuranceChoice = stdin.nextLine();
            b1.setCustomerID(customerID);
            b1.setName(customerName);
            b1.setAddress(customerAddress);
            b1.setPostcode(customerPostcode);
            b1.setPayDetails(customerPayment);
            if (insuranceChoice.equals("1")) {
                b1.setInsurance(false);
                writeCustomer(b1, i1, "1");
            } else if (insuranceChoice.equals("2")) {
                b1.setInsurance(true);
                writeCustomer(b1, i1, "1");
            }

        } else if (customerChoice.equals("2")) {
            System.out.println("Please enter your phone number");
            String customerPhone = stdin.nextLine();
            i1.setCustomerID(customerID);
            i1.setName(customerName);
            i1.setAddress(customerAddress);
            i1.setPostcode(customerPostcode);
            i1.setPayDetails(customerPayment);
            i1.setPhoneNumber(customerPhone);
            writeCustomer(b1, i1, "2");
        }
    }

    public void writeCustomer(Business b1, Individual i1, String choice) {
        try {
            File f = new File("Customers.txt");
            PrintWriter write = new PrintWriter(new FileOutputStream(f, true));
            if (choice.equals("1")) {
                write.append("\n" + "BUSINESS," + b1.getCustomerID() + "," + b1.getName() + "," + b1.getAddress() + "," + b1.getPostcode() + "," + b1.getPayDetails() + "," + b1.isInsurance());
                write.close();
            } else if (choice.equals("2")) {
                write.append("\n" + "INDIVIDUAL," + i1.getCustomerID() + "," + i1.getName() + "," + i1.getAddress() + "," + i1.getPostcode() + "," + i1.getPayDetails() + "," + i1.getPhoneNumber());
                write.close();
            }
        } catch (Exception e) {
        }
    }

    public void fileInsertOrder(String customerID, String vehicleID, LocalDate date, int weeksTaken, double pricePaid)
    {
        Orders o1 = new Orders();
        o1.setCustomerID(customerID);
        o1.setVehicleID(vehicleID);
        o1.setDate(date);
        o1.setWeeksTaken(weeksTaken);
        o1.setPricePaid(pricePaid);
        writeOrder(o1);
    }

    public void writeOrder(Orders o1)
    {
        try
        {
            File f = new File("Orders.txt");
            PrintWriter write = new PrintWriter(new FileOutputStream(f, true));
            write.append("\n" + "ORDER," + o1.getCustomerID() + "," + o1.getVehicleID() + "," + o1.getDate() + "," + o1.getWeeksTaken() + "," + o1.getPricePaid());
            write.close();
        }
        catch (Exception e){}
    }

    public void fileDisplayVehicle() {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("Vehicles.txt"));
            String s = "";
            String columnVan[] = {"VehicleType: ", "VehicleID: ", "Available: ", "VanSize: "};
            String columnPickup[] = {"VehicleType: ", "VehicleID: ", "Available: ", "PickupCapacity: "};
            String columnLorry[] = {"VehicleType: ", "VehicleID: ", "Available: ", "LorryType: "};
            while ((s = br.readLine()) != null)
            {
                String data[] = new String[3];
                data = s.split(",");
                for (int i = 0; i < 4; i++)
                {
                    if (data[0].equals("VAN") && (i == 3))
                    {
                        System.out.print(columnVan[3]);
                    } else if (data[0].equals("PICKUP") && (i == 3))
                    {
                        System.out.print(columnPickup[3]);
                    } else if (data[0].equals("LORRY") && (i == 3))
                    {
                        System.out.print(columnLorry[3]);
                    } else
                    {
                        System.out.print(columnVan[i]);
                    }
                    System.out.print(data[i] + " | ");
                }
                System.out.println();
            }
        } catch (Exception e) {}
    }

    public void fileDisplayCustomer() {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("Customers.txt"));
            String s = "";
            String columnBusinesss[] = {"CustomerType: ", "CustomerID: ", "Name: ", "Address: ", "Postcode: ", "Payment: ", "NeedInsurance: "};
            String columnIndividual[] = {"CustomerType: ", "CustomerID: ", "Name: ", "Address: ", "Postcode: ", "Payment: ", "Phone: "};
            while ((s = br.readLine()) != null)
            {
                String data[] = new String[6];
                data = s.split(",");
                for (int i = 0; i < 7; i++)
                {
                    if (data[0].equals("BUSINESS") && (i == 6))
                    {
                        System.out.print(columnBusinesss[6]);
                    } else if (data[0].equals("INDIVIDUAL") && (i == 6))
                    {
                        System.out.print(columnIndividual[6]);
                    } else
                    {
                        System.out.print(columnBusinesss[i]);
                    }
                    System.out.print(data[i] + " | ");
                }
                System.out.println();
            }
        } catch (Exception e) {}
    }

    public void fileDisplayOrder() {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("Orders.txt"));
            String s = "";
            String columnNames[] = {"", "CustomerID: ", "VehicleID: ", "HireDate: ", "WeeksHired: ", "Price: "};
            while ((s = br.readLine()) != null)
            {
                String data[] = new String[5];
                data = s.split(",");
                for (int i = 0; i < 6; i++)
                {
                    System.out.print(columnNames[i]);
                    System.out.print(data[i] + " | ");
                }
                System.out.println();
            }
        } catch (Exception e) {}
    }

    public void updateCustomer() {
        System.out.println("Please enter the ID of the customer you wish to update");
        int customerID = stdin.nextInt();
        String finalField = null;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("Customers.txt"));
            String s = "";
            while((s = br.readLine()) != null)
            {
                String data[] = new String[5];
                data = s.split(",");
                if (customerID == Integer.parseInt(data[1]))
                {
                    if (data[0].equals("BUSINESS"))
                    {
                        finalField = "need insurance:";
                    } else if (data[0].equals("INDIVIDUAL"))
                    {
                        finalField = "phone number:";
                    }
                }
            }
        } catch (Exception e){}

        boolean changeAnswers[] = new boolean[5];
        String changeColumns[] = {"name:", "address:", "postcode:", "payment details:", finalField};
        String changeUpdate[] = new String[5];

        System.out.println("Please select the columns you would like to change (true = Yes, false = No)");
        for (int i = 0; i < 5; i++) {
            System.out.println(changeColumns[i]);
            changeAnswers[i] = stdin.nextBoolean();
        }
        System.out.println("Please enter the new values for the columns");
        for (int i = 0; i < 5; i++) {
            System.out.println(changeColumns[i]);
            if (changeAnswers[i] == true) {
                Scanner stdin1 = new Scanner(System.in);
                changeUpdate[i] = stdin1.nextLine();
            } else {
                System.out.println("Can't be changed");
            }
        }
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Customers.txt"));
            String s = "";
            while ((s = br.readLine()) != null) {
                String data[] = new String[5];
                data = s.split(",");
                if (customerID == Integer.parseInt(data[1])) {
                    String row = data[0] + "," + data[1] + ",";
                    for (int i = 0; i < 5; i++) {
                        if (changeAnswers[i] == true) {
                            row = row + changeUpdate[i] + ",";
                        } else {
                            row = row + data[i + 2] + ",";
                        }
                    }
                    sb.append(row);
                    sb.append("\n");
                } else {
                    sb.append(s);
                    sb.append("\n");
                }
            }
            File f = new File("Customers.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(f, false));
            pw.print(sb.toString());
            pw.close();

        } catch (Exception e) {}

    }

    public boolean vehicleAvailable(String vehicleStart, String vehicleType)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("Vehicles.txt"));
            String s = "";
            while ((s = br.readLine()) != null)
            {
                String data[] = new String[4];
                data = s.split(",");
                if(vehicleStart.equals(data[0]) && data[3].equals(vehicleType) && data[2].equals("true"))
                {
                    return true;
                }
            }
        } catch (Exception e) {}
        return false;
    }

    public boolean customerReal(String customerID)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("Customers.txt"));
            String s = "";
            while ((s = br.readLine()) != null)
            {
                int id = Integer.parseInt(customerID);
                String data[] = new String[6];
                data = s.split(",");
                if(id == Integer.parseInt(data[1]))
                {
                    return true;
                }
            }

        } catch (Exception e) {}
        return false;
    }

    public void hireVehicle(String customerID, String vehicleStart, String vehicleType)
    {
        String vehicleID;
        Scanner stdin1 = new Scanner(System.in);

        System.out.println("You are about to hire a " + vehicleStart);
        System.out.println("What date would you like to hire the vehicle? (Format YYYY-MM-DD): ");
        String temp = stdin1.nextLine();
        LocalDate hireDate = LocalDate.parse(temp);
        System.out.println("How many weeks would you like to hire for?");
        int weeksTaken = stdin1.nextInt();
        double weeklyPrice = 0;
        double insurance = 0;

        if(vehicleStart.equals("VAN") && vehicleType.equals("Small")) { weeklyPrice = 100; insurance = 30; }
        else if(vehicleStart.equals("VAN") && vehicleType.equals("Large")) { weeklyPrice = 150; insurance = 50; }
        else if(vehicleStart.equals("PICKUP")) { weeklyPrice = 150; insurance = 40;}
        else if(vehicleStart.equals("LORRY") && vehicleType.equals("SMALLLORRY")) { weeklyPrice = 200; insurance = 100; }
        else if(vehicleStart.equals("LORRY") && vehicleType.equals("CRANE")) { weeklyPrice = 250; insurance = 110; }
        else if(vehicleStart.equals("LORRY") && vehicleType.equals("TAILGATE")) { weeklyPrice = 250; insurance = 110; }
        else if(vehicleStart.equals("LORRY") && vehicleType.equals("LIFT")) { weeklyPrice = 300; insurance = 130; }

        double cost = (weeklyPrice * (double) weeksTaken);

        System.out.println("To hire a " + vehicleStart + " for " + weeksTaken + " weeks will cost £" + cost + " and with insurance adding and extra £" + insurance + " the final price is £" + (cost+insurance));

        try
        {
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new FileReader("Vehicles.txt"));
            String s = "";
            while ((s = br.readLine()) != null)
            {
                String data[] = new String[4];
                data = s.split(",");
                if(vehicleStart.equals(data[0]) && data[3].equals(vehicleType) && data[2].equals("true"))
                {
                    vehicleID = data[1];
                    fileInsertOrder(customerID, vehicleID, hireDate, weeksTaken, (cost+insurance));

                    String update = data[0] + "," + data[1] + "," + false + "," + data[3];

                    sb.append(update);
                    sb.append("\n");
                } else
                {
                    sb.append(s);
                    sb.append("\n");
                }
            }
            File f = new File("Vehicles.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(f, false));
            pw.print(sb.toString());
            pw.close();
        } catch (Exception e) {}
    }
    public void sortVehicles()
    {
        int size = 0;
        try
        {
            BufferedReader ar = new BufferedReader(new FileReader("Vehicles.txt"));
            String s = "";
            while ((s = ar.readLine()) != null)
            {
                size = size + 1;
            }

            BufferedReader br = new BufferedReader(new FileReader("Vehicles.txt"));
            int x = 0;
            int sortID[] = new int[size];
            while ((s = br.readLine()) != null)
            {
                String data[] = new String[3];
                data = s.split(",");
                int temp = Integer.parseInt(data[1]);
                sortID[x] = temp;
                x++;
            }
            MergeSort(sortID, sortID.length);

            for (int i = 0; i < size ; i++)
            {
                BufferedReader cr = new BufferedReader(new FileReader("Vehicles.txt"));
                while ((s = cr.readLine()) != null)
                {
                    String data[] = new String[4];
                    data = s.split(",");
                    if(Integer.parseInt(data[1]) == sortID[i])
                    {

                        for (int c = 0; c < 4; c++)
                        {
                            System.out.print(data[c] + " | ");
                        }
                        System.out.println();
                    }
                }
            }

        } catch (Exception e) {}
    }
    void MergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        MergeSort(l, mid);
        MergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}

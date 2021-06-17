import org.junit.jupiter.api.Test;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

public class EqualsTest {

    @Test
    void EqualsPassClassTest() throws Exception {
        Van v1 = new Van("1", false, "Large");
        Van v2 = new Van("1", false, "Large");

        Lorry l1 = new Lorry("2", true, LorryType.LIFT);
        Lorry l2 = new Lorry("2",true,LorryType.LIFT);

        Pickup p1 = new Pickup("3", false, "4");
        Pickup p2 = new Pickup("3", false, "4");

        Individual i1 = new Individual("4", "John Smith", "123 Street Lane", "AB1 2CD", "The Bank", "0123 4567");
        Individual i2 = new Individual("4", "John Smith", "123 Street Lane", "AB1 2CD", "The Bank", "0123 4567");

        Business b1 = new Business("5", "Business Corp", "456 Generic Street", "EF1 2GH", "Delta Bank", false);
        Business b2 = new Business("5", "Business Corp", "456 Generic Street", "EF1 2GH", "Delta Bank", false);

        assertEquals(true, v1.equals(v2));
        assertEquals(true, l1.equals(l2));
        assertEquals(true, p1.equals(p2));
        assertEquals(true, i1.equals(i2));
        assertEquals(true, b1.equals(b2));
    }

    @Test
    void EqualsFailClassTest() throws Exception {
        Van v1 = new Van("1", true, "Large");
        Van v2 = new Van("1", false, "Large");

        Lorry l1 = new Lorry("2", true, LorryType.LIFT);
        Lorry l2 = new Lorry("2",false,LorryType.LIFT);

        Pickup p1 = new Pickup("2", false, "4");
        Pickup p2 = new Pickup("3", false, "4");

        Individual i1 = new Individual("4", "John Smith", "123 Street Lane", "AB1 2CD", "The Bank", "0123 4567");
        Individual i2 = new Individual("4", "James Smith", "123 Street Lane", "AB1 2CD", "The Bank", "0123 4567");

        Business b1 = new Business("5", "Business Corp", "456 Generic Street", "EF1 2GH", "Charlie Bank", false);
        Business b2 = new Business("5", "Business Corp", "456 Generic Street", "EF1 2GH", "Delta Bank", false);

        assertEquals(false, v1.equals(v2));
        assertEquals(false, l1.equals(l2));
        assertEquals(false, p1.equals(p2));
        assertEquals(false, i1.equals(i2));
        assertEquals(false, b1.equals(b2));
    }

    @Test
    void HashCodePassClassTest() throws Exception {
        boolean testPass = false;
        Van v1 = new Van("1", false, "Large");
        Van v2 = new Van("1", false, "Large");

        Lorry l1 = new Lorry("2", true, LorryType.LIFT);
        Lorry l2 = new Lorry("2",true,LorryType.LIFT);

        Pickup p1 = new Pickup("3", false, "4");
        Pickup p2 = new Pickup("3", false, "4");

        Individual i1 = new Individual("4", "John Smith", "123 Street Lane", "AB1 2CD", "The Bank", "0123 4567");
        Individual i2 = new Individual("4", "John Smith", "123 Street Lane", "AB1 2CD", "The Bank", "0123 4567");

        Business b1 = new Business("5", "Business Corp", "456 Generic Street", "EF1 2GH", "Delta Bank", false);
        Business b2 = new Business("5", "Business Corp", "456 Generic Street", "EF1 2GH", "Delta Bank", false);

        if((v1.hashCode()) == v2.hashCode()) {testPass = true;}
        else{testPass = false;}
        assertEquals(true, testPass);
        if((l1.hashCode()) == l2.hashCode()) {testPass = true;}
        else{testPass = false;}
        assertEquals(true, testPass);
        if((p1.hashCode()) == p2.hashCode()) {testPass = true;}
        else{testPass = false;}
        assertEquals(true, testPass);
        if((i1.hashCode()) == i2.hashCode()) {testPass = true;}
        else{testPass = false;}
        assertEquals(true, testPass);
        if((b1.hashCode()) == b2.hashCode()) {testPass = true;}
        else{testPass = false;}
        assertEquals(true, testPass);
    }

    @Test
    void HashCodeFailClassTest() throws Exception {
        boolean testPass;
        Van v1 = new Van("1", true, "Large");
        Van v2 = new Van("1", false, "Large");

        Lorry l1 = new Lorry("2", true, LorryType.LIFT);
        Lorry l2 = new Lorry("2",false,LorryType.LIFT);

        Pickup p1 = new Pickup("2", false, "4");
        Pickup p2 = new Pickup("3", false, "4");

        Individual i1 = new Individual("4", "John Smith", "123 Street Lane", "AB1 2CD", "The Bank", "0123 4567");
        Individual i2 = new Individual("4", "James Smith", "123 Street Lane", "AB1 2CD", "The Bank", "0123 4567");

        Business b1 = new Business("5", "Business Corp", "456 Generic Street", "EF1 2GH", "Charlie Bank", false);
        Business b2 = new Business("5", "Business Corp", "456 Generic Street", "EF1 2GH", "Delta Bank", false);

        if((v1.hashCode()) == v2.hashCode()) {testPass = true;}
        else{testPass = false;}
        assertEquals(false, testPass);
        if((l1.hashCode()) == l2.hashCode()) {testPass = true;}
        else{testPass = false;}
        assertEquals(false, testPass);
        if((p1.hashCode()) == p2.hashCode()) {testPass = true;}
        else{testPass = false;}
        assertEquals(false, testPass);
        if((i1.hashCode()) == i2.hashCode()) {testPass = true;}
        else{testPass = false;}
        assertEquals(false, testPass);
        if((b1.hashCode()) == b2.hashCode()) {testPass = true;}
        else{testPass = false;}
        assertEquals(false, testPass);
    }
}

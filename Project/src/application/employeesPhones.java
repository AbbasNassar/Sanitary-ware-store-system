package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class employeesPhones {
    private SimpleIntegerProperty eid;
    private SimpleStringProperty phoneNumber;

    public employeesPhones(int eid, String phoneNumber) {
        this.eid = new SimpleIntegerProperty(eid);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
    }

    public int getEid() {
        return eid.get();
    }

    public void setEid(int eid) {
        this.eid.set(eid);
    }

    public SimpleIntegerProperty eidProperty() {
        return eid;
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }
}

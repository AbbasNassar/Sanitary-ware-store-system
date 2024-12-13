package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class departments {
    private final IntegerProperty did;
    private final IntegerProperty numberOfEmployees;
    private final IntegerProperty eid;
    private final StringProperty name;

    public departments(int did, String name, int numberOfEmployees, int eid) {
        this.did = new SimpleIntegerProperty(did);
        this.name = new SimpleStringProperty(name);
        this.numberOfEmployees = new SimpleIntegerProperty(numberOfEmployees);
        this.eid = new SimpleIntegerProperty(eid);
    }

    public int getDid() {
        return did.get();
    }

    public void setDid(int did) {
        this.did.set(did);
    }

    public IntegerProperty didProperty() {
        return did;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees.get();
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees.set(numberOfEmployees);
    }

    public IntegerProperty numberOfEmployeesProperty() {
        return numberOfEmployees;
    }

    public int getEid() {
        return eid.get();
    }

    public void setEid(int eid) {
        this.eid.set(eid);
    }

    public IntegerProperty eidProperty() {
        return eid;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }
}
package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class employees {
    private SimpleIntegerProperty eid;
    private SimpleIntegerProperty salary;
    private SimpleIntegerProperty did;
    private SimpleIntegerProperty wid;
    private SimpleStringProperty name;
    private SimpleStringProperty jobType;
    private SimpleStringProperty pass;
    private SimpleStringProperty address;

    public employees(int eid, String name,String address,int salary, String jobType, int did, int wid,String pass) {
        this.eid = new SimpleIntegerProperty(eid);
        this.salary = new SimpleIntegerProperty(salary);
        this.did = new SimpleIntegerProperty(did);
        this.wid = new SimpleIntegerProperty(wid);
        this.name = new SimpleStringProperty(name);
        this.jobType = new SimpleStringProperty(jobType);
        this.pass = new SimpleStringProperty(pass);
        this.address = new SimpleStringProperty(address);
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

    public int getSalary() {
        return salary.get();
    }

    public void setSalary(int salary) {
            this.salary.set(salary);
    }

    public SimpleIntegerProperty salaryProperty() {
        return salary;
    }

    public int getDid() {
        return did.get();
    }

    public void setDid(int did) {
        this.did.set(did);
    }

    public SimpleIntegerProperty didProperty() {
        return did;
    }

    public int getWid() {
        return wid.get();
    }

    public void setWid(int wid) {
        this.wid.set(wid);
    }

    public SimpleIntegerProperty widProperty() {
        return wid;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getJobType() {
        return jobType.get();
    }

    public void setJobType(String jobType) {
        this.jobType.set(jobType);
    }

    public SimpleStringProperty jobTypeProperty() {
        return jobType;
    }

    public String getPass() {
        return pass.get();
    }

    public void setPass(String pass) {
        this.pass.set(pass);
    }

    public SimpleStringProperty passProperty() {
        return pass;
    }
    // Getter for the address property value
    public String getAddress() {
        return address.get();
    }

    // Setter for the address property value
    public void setAddress(String address) {
        this.address.set(address);
    }

    // Getter for the address property itself
    public SimpleStringProperty addressProperty() {
        return address;
    }
}

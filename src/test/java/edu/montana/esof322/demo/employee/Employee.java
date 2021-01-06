package edu.montana.esof322.demo.employee;

public class Employee implements IEmployee {

    private FullName name;
    private String address;
    private String workPhone;
    private String homePhone;
    private TaxId taxIdNumber;
    private JobClassification jobClass;

    public Employee(FullName name, String address, String workPhone, String homePhone, TaxId taxIdNumber, JobClassification jobClass) {
        this.name = name;
        this.address = address;
        this.workPhone = workPhone;
        this.homePhone = homePhone;
        this.taxIdNumber = taxIdNumber;
        this.jobClass = jobClass;
    }

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public TaxId getTaxIdNumber() {
        return taxIdNumber;
    }

    public void setTaxIdNumber(TaxId taxIdNumber) {
        this.taxIdNumber = taxIdNumber;
    }

    public JobClassification getJobClass() {
        return jobClass;
    }

    public void setJobClass(JobClassification jobClass) {
        this.jobClass = jobClass;
    }
}

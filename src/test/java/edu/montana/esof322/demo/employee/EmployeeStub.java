package edu.montana.esof322.demo.employee;

public class EmployeeStub implements IEmployee {

    public EmployeeStub(FullName name, String address, String workPhone, String homePhone, TaxId taxIdNumber, JobClassification jobClass) {
    }

    @Override
    public FullName getName() {
        return null;
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public String getWorkPhone() {
        return null;
    }

    @Override
    public String getHomePhone() {
        return null;
    }

    @Override
    public TaxId getTaxIdNumber() {
        return null;
    }

    @Override
    public JobClassification getJobClass() {
        return null;
    }
}

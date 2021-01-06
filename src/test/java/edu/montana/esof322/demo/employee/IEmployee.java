package edu.montana.esof322.demo.employee;

public interface IEmployee {
    FullName getName();
    String getAddress();
    String getWorkPhone();
    String getHomePhone();
    TaxId getTaxIdNumber();
    JobClassification getJobClass();
}

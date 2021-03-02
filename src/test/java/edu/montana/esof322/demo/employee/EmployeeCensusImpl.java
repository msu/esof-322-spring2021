package edu.montana.esof322.demo.employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeCensusImpl implements EmployeeCensus {

    private List<Employee> _employees;

    public EmployeeCensusImpl() {
        this._employees = new ArrayList<>();
    }

    @Override
    public void addEmployee(IEmployee employee) {

    }

    @Override
    public void removeEmployee(IEmployee employee) {

    }

    @Override
    public Iterator<IEmployee> iterator() {
        return null;
    }

    @Override
    public IEmployee get(int i) {
        return null;
    }
}

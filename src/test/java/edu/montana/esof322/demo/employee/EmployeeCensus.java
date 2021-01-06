package edu.montana.esof322.demo.employee;

import java.util.Iterator;
import java.util.List;

public interface EmployeeCensus extends List<Employee> {
        void addEmployee( Employee employee );
        void removeEmployee( Employee employee );
        Iterator<Employee> iterator();
        Employee get(int i);
}

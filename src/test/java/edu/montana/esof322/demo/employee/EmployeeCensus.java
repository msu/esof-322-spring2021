package edu.montana.esof322.demo.employee;

import java.util.Iterator;
import java.util.List;

public interface EmployeeCensus  {
        void addEmployee( IEmployee employee );
        void removeEmployee( IEmployee employee );
        Iterator<IEmployee> iterator();
        IEmployee get(int i);
}

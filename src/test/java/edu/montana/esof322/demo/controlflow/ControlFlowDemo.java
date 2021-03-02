package edu.montana.esof322.demo.controlflow;

import edu.montana.esof322.demo.employee.Employee;
import edu.montana.esof322.demo.employee.IEmployee;
import edu.montana.esof322.demo.employee.JobClassification;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ControlFlowDemo {

    void ifStatements(){
        IEmployee emp = getEmployee();

        {
            boolean isValid = checkIfValid(emp);
            if (isValid) {
                mailEmployee(emp);
            } else {
                raiseAlert(emp);
            }
        }
        {
            boolean isInvalid = isInvalid(emp);
            boolean isValid = !isInvalid;
            if (isValid) {
                mailEmployee(emp);
            } else {
                raiseAlert(emp);
            }
        }
        {
            if (checkIfValid(emp)) {
                mailEmployee(emp);
            } else if (isPending(emp)) {
                recordAttempt(emp);
            } else {
                raiseAlert(emp);
            }
        }

    }

    void switchStatements(){
        IEmployee emp = getEmployee();

        {
            switch (emp.getJobClass()) {
                case LABOROR:
                    payALittle(emp);
                    break;
                case SUPERVISOR:
                    payALittleMore(emp);
                    break;
                case VICE_PRESIDENT:
                    payWayTooMuch(emp);
                    break;
                default:
            }
        }


    }

    void loops() {
        List<IEmployee> employees = getEmployees();
        {

            for (IEmployee employee : employees) {
                payEmployee(employee);
            }

            for (int i = 0; i < employees.size(); i++) {
                IEmployee employee = employees.get(i);
                payEmployee(employee);
            }


            Map<IEmployee, IEmployee> bossMap = new HashMap();
            outer:
            for (IEmployee boss: employees){
                inner:
                for (IEmployee worker : employees) {
                    JobClassification jobClass = worker.getJobClass();
                    if (jobClass == JobClassification.PRESIDENT) {
                        break outer;
                    } else {
                        if (isBoss(boss, worker)) {
                            bossMap.put(boss, worker);
                            break inner;
                        }
                    }
                }
            }
        }
        {
            Iterator<IEmployee> iterator = employees.iterator();
            while (iterator.hasNext()) {
                IEmployee employee = iterator.next();
                payEmployee(employee);
            }
        }
        {
            employees.forEach(this::payEmployee);
        }

    }

    void tryCatch() throws SQLException {

        List<IEmployee> employees = getEmployees();
        {
            try {
                for (IEmployee employee : employees) {
                    payEmployee(employee);
                }
            } catch (Exception e) {
                handlePaymentProcessingError(e);
            }
        }

        {


            try(Connection conn = getConnection();
                    Connection conn2 = getConnection()){
                for (IEmployee employee : getEmployees(conn)) {
                    try {
                        payEmployee(employee);
                    } catch (PaymentException e) {
                        handlePaymentProcessingError(e);
                    }
                }
            }
        }


    }

    private List<IEmployee> getEmployees(Connection conn) {
        return null;
    }

    private Connection getConnection() {
        return null;
    }

    private void handlePaymentProcessingError(Exception e) {

    }

    private boolean isBoss(IEmployee boss, IEmployee worker) {
        return false;
    }

    private void stickItTo(IEmployee employee) {
    }

    private void payEmployee(IEmployee employee) {

    }

    private List<IEmployee> getEmployees() {
        return null;
    }

    private void payWayTooMuch(Object emp) {

    }

    private void payALittleMore(IEmployee emp) {

    }

    private void payALittle(IEmployee emp) {

    }

    private void recordAttempt(IEmployee emp) {
    }

    private boolean isPending(IEmployee emp) {
        return false;
    }

    private boolean isInvalid(IEmployee emp) {
        return false;
    }

    private void raiseAlert(IEmployee emp) {

    }

    private void mailEmployee(IEmployee emp) {

    }

    private boolean checkIfValid(Object emp) {
        return false;
    }

    private IEmployee getEmployee() {
        return null;
    }

    private static class PaymentException extends RuntimeException {
    }
}

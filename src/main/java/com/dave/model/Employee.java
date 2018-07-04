package com.dave.model;

/**
 * Created by David on 08/03/2017.
 */
public class Employee extends Person {

    private int empoyeeId;
    private Department department;

    public int getEmpoyeeId() {
        return empoyeeId;
    }

    public void setEmpoyeeId(int empoyeeId) {
        this.empoyeeId = empoyeeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

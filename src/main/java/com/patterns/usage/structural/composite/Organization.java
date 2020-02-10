package com.patterns.usage.structural.composite;

import java.util.ArrayList;

public class Organization {

    protected ArrayList<Employee> employees = new ArrayList();

    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }

    public float getNetSalaries()
    {
        float netSalary = 0f;
        for(Employee employee: employees)
        {
            netSalary += employee.getSallary();
        }
        return netSalary;
    }
}

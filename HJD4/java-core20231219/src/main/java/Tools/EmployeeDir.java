package Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDir {
    private List<Employee> employees;

    public EmployeeDir() {
        this.employees = new ArrayList<>();
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee findEmpId (String employeeId) {
        return employees.stream()
                .filter(employee -> employee.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElse(null);
    }

    public List<Employee> findEmpExp (int experience) {
        return employees.stream()
                .filter(employee -> employee.getExperience() == experience)
                .collect(Collectors.toList());
    }

    public List<String> getNumbers (String name) {
        return employees.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .map(Employee::getPhoneNumber)
                .collect(Collectors.toList());
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
package Tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSaveLoad {
    private static final String FILE_PATH = "employees.txt";

    public static void saveEmployees(List<Employee> employees) {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Employee emp : employees) {
                out.println(emp.getEmployeeId() + "," + emp.getPhoneNumber() + "," + emp.getName() + "," + emp.getExperience());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 4) {
                        Employee employee = new Employee(data[0], data[1], data[2], Integer.parseInt(data[3]));
                        employees.add(employee);
                    }
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }
}
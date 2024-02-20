import Tools.Employee;
import Tools.EmployeeDir;
import Tools.EmployeeSaveLoad;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDir directory = new EmployeeDir();

        directory.setEmployees(EmployeeSaveLoad.loadEmployees());

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Поиск по стажу в годах");
            System.out.println("2. Поиск номера телефона сотрудника по имени");
            System.out.println("3. Поиск по табельному номеру");
            System.out.println("4. Добавить нового сотрудника в справочник");
            System.out.println("5. Выход");

            System.out.print("Укажите действие: ");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.print("Введите стаж: ");
                    int experience = scanner.nextInt();
                    printExperiencedEmployees(getExperiencedEmployees(directory, experience), experience);
                    break;
                case 2:
                    System.out.print("Введите имя сотрудника: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    printPhoneNumbers(getPhoneNumbersByName(directory, name), name);
                    break;
                case 3:
                    System.out.print("Введите табельный номер сотрудника: ");
                    String employeeId = scanner.next();
                    printEmployee(findEmployeeById(directory, employeeId), employeeId);
                    break;
                case 4:
                    addNewEmployee(scanner, directory);
                    break;
                case 5:
                    System.out.println("Сохранение данных и выход из программы.");
                    EmployeeSaveLoad.saveEmployees(directory.getEmployees());
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, введите число от 1 до 5.");
            }
        }
    }

    //1
    private static List<Employee> getExperiencedEmployees(EmployeeDir directory, int experience) {
        return directory.findEmpExp(experience);
    }

    private static void printExperiencedEmployees(List<Employee> employees, int experience) {
        System.out.println("Поиск сотрудников со стажем " + experience + " лет:");
        for (Employee emp : employees) {
            System.out.println(emp.getName());
        }
    }

    //2
    private static List<String> getPhoneNumbersByName(EmployeeDir directory, String name) {
        return directory.getNumbers(name);
    }

    private static void printPhoneNumbers(List<String> phoneNumbers, String name) {
        System.out.println("\nНомера телефонов сотрудника по имени " + name + ":");
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }
    }


    //3
    private static Employee findEmployeeById(EmployeeDir directory, String employeeId) {
        return directory.findEmpId(employeeId);
    }

    private static void printEmployee(Employee employee, String employeeId) {
        System.out.println("\nПоиск сотрудника с табельным номером " + employeeId + ":");
        if (employee != null) {
            System.out.println("Найден сотрудник: " + employee.getName());
        } else {
            System.out.println("Сотрудник с таким табельным номером не найден.");
        }
    }

    //4
    private static void addNewEmployee(Scanner scanner, EmployeeDir directory) {
        System.out.print("Введите табельный номер: ");
        String newEmployeeId = scanner.next();

        System.out.print("Введите номер телефона: ");
        String phoneNumber = scanner.next();

        System.out.print("Введите имя: ");
        scanner.nextLine();
        
        String newEmployeeName = scanner.nextLine();
        System.out.print("Введите стаж: ");
        int newExperience = scanner.nextInt();
        
        directory.addEmployee(new Employee(newEmployeeId, phoneNumber, newEmployeeName, newExperience));
        System.out.println("Сотрудник успешно добавлен.");
    }
}
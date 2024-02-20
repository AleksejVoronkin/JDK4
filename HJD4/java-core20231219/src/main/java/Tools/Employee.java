package Tools;

public class Employee {
    private String Id;
    private String phoneNumber;
    private String name;
    private int experience;

    public Employee(String Id, String phoneNumber, String name, int experience) {
        this.Id = Id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public String getEmployeeId() {
        return Id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }
}

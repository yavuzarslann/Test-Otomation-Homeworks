public abstract class Employee {
    //alt sınıflarda kullanılacak ortak özellikler
    private String name;
    private String surname;
    private String department;

    public Employee(String name, String surname, String department) {
        this.name = name;
        this.surname = surname;
        this.department = department;
    }

    //alt sınıflarda kullanılması zorunlu abstract metodlar
    public abstract void entrance(String entranceTime);

    public abstract void exit(String exitTime);


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

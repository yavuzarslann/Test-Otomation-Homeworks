public class Engineer extends Employee {
    private String officeNo;//sadece mühendis sınıfına ait özellik

    //üst sınıftan alınan özellikleri içeren yapıcı metod
    public Engineer(String name, String surname, String department, String officeNo) {
        super(name, surname, department);
        this.officeNo = officeNo;
    }

    @Override
    public void entrance(String entranceTime) {
        System.out.println("Mühendis "+this.getName()+this.getSurname()+ " şirkete "+ entranceTime +" de "+ "giriş yaptı.");
    }

    @Override
    public void exit(String exitTime) {
        System.out.println("Mühendis "+this.getName()+this.getSurname()+ " şirketten "+ exitTime +" de "+ "ayrıldı.");
    }

    //sadece mühendis sınıfına ait normal metod
    public void checkProjects(){
        System.out.println("Projeler kontrol edildi.");
    }

    public String getOfficeNo() {
        return officeNo;
    }

    public void setOfficeNo(String officeNo) {
        this.officeNo = officeNo;
    }
}

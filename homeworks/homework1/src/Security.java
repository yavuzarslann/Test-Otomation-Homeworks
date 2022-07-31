public class Security extends Employee {
    private String authority;//sadece güvenlik sınıfına ait özellik

    //üst sınıftan alınan özellikleri içeren yapıcı metod
    public Security(String name, String surname, String department, String authority) {
        super(name, surname, department);
        this.authority = authority;
    }

    @Override
    public void entrance(String entranceTime) {
        System.out.println("Güvenlik görevlisi "+this.getName()+this.getSurname()+ " şirkete "+ entranceTime +" de "+ "giriş yaptı.");
    }

    @Override
    public void exit(String exitTime) {
        System.out.println("Güvenlik görevlisi "+this.getName()+this.getSurname()+ " şirketten "+ exitTime +" de "+ "ayrıldı.");
    }

    //sadece güvenlik sınıfına ait normal metod
    public void guardDuty(){
        System.out.println("Gece nöbeti tutuldu");
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

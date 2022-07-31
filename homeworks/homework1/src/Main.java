public class Main {
    public static void main(String[] args) {

        //burada mühendis ve güvenlik sınıfından nesneler oluşturuyoruz
        Engineer e1 = new Engineer("Yavuz ","Arslan","IT","23");
        Security s1 = new Security("Ahmet","Koçak","Otopark","Güvenlik amiri");

        //burada ise abstract ve normal metodları çalıştırıyoruz
        e1.entrance("08:00");
        e1.exit("19:00");
        e1.checkProjects();

        s1.entrance("06:00");
        s1.exit("22:00");
        s1.guardDuty();

    }
}

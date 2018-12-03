package eksamenhøst2012;

public class Main {
    public static void main(String[] args) {

        Rom rom1 = new Rom(12);
        Beboer fange1 = new Beboer("69", 12, rom1);
        System.out.println(fange1.loggbok());

        fange1.nyRapport("Drap");

        System.out.println(fange1.loggbok());

        fange1.setGjest("Jacob");
        System.out.println(fange1.loggbok());
    }
}

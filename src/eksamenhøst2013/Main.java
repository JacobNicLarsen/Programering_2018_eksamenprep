package eksamenhøst2013;

public class Main {
    public static void main(String[] args) {
        Lege sverre = new Lege("Sverre", "101198", false);

        System.out.println(sverre);

        Resept resept1 = new Resept("resept1", 1);
        Resept resept2 = new Resept("resept2", 2);
        Resept resept3 = new Resept("resept3", 3);
        sverre.nyResept(resept1);
        sverre.nyResept(resept2);
        sverre.nyResept(resept3);
        System.out.println(sverre);
    }
}

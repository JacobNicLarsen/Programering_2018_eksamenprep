package eksamenfeb2013;

public class Main {
    public static void main(String[] args) {
        Lotteri lotteri = new Lotteri(0.1, 20, 100, 20);

        System.out.println(lotteri.loddsalg("Jacob", "jacob@larsen.com", "98025757", 90));
        System.out.println(lotteri.loddsalg("Abigeal", "Abirebecca@gmail.com", "91321451", 10));
        System.out.println(lotteri.vinnerliste());
    }
}

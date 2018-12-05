package eksamenfeb2012;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Låneregister låneregister = new Låneregister();

        System.out.println(låneregister.nyttLån("Jacob", 12 ,1, 10, Låneregister.ANNUITET));
        System.out.println(låneregister.nyttLån("Mathia", 13 ,2, 10, Låneregister.ANNUITET));
        System.out.println(låneregister.nyttLån("Mathia", 13 ,2, 10, Låneregister.ANNUITET));
        System.out.println(låneregister.nyttLån("Mathia", 13 ,2, 10, Låneregister.ANNUITET));
        System.out.println(låneregister.nyttLån("Mathia", 13 ,2, 10, Låneregister.ANNUITET));
    }

}

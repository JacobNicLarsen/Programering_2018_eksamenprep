package Oblig3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UnikeTall unikeTall = new UnikeTall(10);

        System.out.println(Arrays.toString(unikeTall.getTilfeldigtallArray()));

        unikeTall.fyllArray();

        System.out.println(Arrays.toString(unikeTall.getTilfeldigtallArray()));
        System.out.println(unikeTall.mathAbs());
        System.out.println(unikeTall.avarage());
        unikeTall.visInfo();
    }
}

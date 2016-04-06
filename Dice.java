

import java.util.*;

public class Dice {


    private Random tiro;

    public Dice() {
        tiro = new Random();
    }

    public int tiraD4() {
        return tiro.nextInt(4) + 1;
    }

    public int tiraD6() {
        return tiro.nextInt(6) + 1;
    }

    public int tiraD8() {
        return tiro.nextInt(8) + 1;
    }

    public int tiraD10() {
        return tiro.nextInt(10) + 1;
    }

    public int tiraD12() {
        return tiro.nextInt(12) + 1;
    }

    public int tiraD20() {
        return tiro.nextInt(20) + 1;
    }

    public int tiraD100() {
        return tiro.nextInt(100) + 1;
    }

    public int tiraDn(int n) {
        return tiro.nextInt(n) + 1;
    }
}

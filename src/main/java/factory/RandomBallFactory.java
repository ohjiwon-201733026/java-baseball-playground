package factory;

import java.util.Random;

public class RandomBallFactory {

    public static int generate() {
        Random random = new Random();

        return random.nextInt(9) + 1;

    }
}

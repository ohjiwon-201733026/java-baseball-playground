package factory;

import java.util.Random;

public class RandomBallFactory {

    protected static int generate() {
        Random random = new Random();

        return random.nextInt(9) + 1;

    }
}

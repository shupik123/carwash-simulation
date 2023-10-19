import java.util.Random;

/**
 * Provides the ability to randomly decide if a car arrives.
 *
 * @author Juniper Pasternak
 * @version 10/4/23
 */
public class RandomManager
{
    private static final int MINUTES_PER_CAR = 4; // Average time per car arrival

    /**
     * Returns true if a car arrived. Determined using java Random with odds 1 / constant.
     *
     * @return true if a car arrives, false otherwise
     */
    public static boolean chanceCar()
    {
        Random random = new Random();
        int randInt = random.nextInt(0, MINUTES_PER_CAR);
        return randInt == 0;
    }
}

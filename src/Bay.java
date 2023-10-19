/**
 * Stores if the car wash bay is full and how long it will be till it is empty.
 *
 * @author Juniper Pasternak
 * @version 10/2/23
 */
public class Bay
{
    private int timeLeft;
    private int washTime;

    /**
     * Constructs a bay using the time to wash a car.
     *
     * @param washTime the time, in minutes, it takes to wash a single car
     */
    public Bay(int washTime)
    {
        this.timeLeft = 0;
        this.washTime = washTime;
    }

    /**
     * Simulates putting a new car into the car wash's bay.
     * If the bay is already full, it will throw an IllegalStateException
     *
     * @throws IllegalStateException when the car wash is not empty
     */
    public void loadCar() throws IllegalStateException
    {
        if (!isEmpty())
            throw new IllegalStateException("Car cannot be loaded while bay is full.");

        timeLeft = washTime;
    }

    /**
     * Iterates through one minute of the bay's washing.
     */
    public void iterateTime()
    {
        if (!isEmpty())
            timeLeft--;
    }

    /**
     * Returns if the bay has no car loaded.
     *
     * @return true if the time left is 0, false when above 0
     */
    public boolean isEmpty()
    {
        return timeLeft == 0;
    }

    /**
     * Returns the time till the bay is done washing the current car.
     *
     * @return the time, in minutes, till the bay is done washing
     */
    public int getTimeLeft()
    {
        return timeLeft;
    }

    /**
     * Returns the time it takes the bay to wash one car.
     *
     * @return the time, in minutes, the bay takes to wash a car
     */
    public int getWashTime()
    {
        return washTime;
    }
}

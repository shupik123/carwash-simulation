/**
 * Stores the arrival time of the car at the car wash.
 *
 * @author Juniper Pasternak
 * @version 10/2/23
 */
public class Car
{
    private int arrivalTime;

    /**
     * Constructs a car using its arrival time.
     *
     * @param arrivalTime the time, in minutes since opening time, that the car arrived at a bay
     */
    public Car(int arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Returns the car's arrival time.
     *
     * @return the time, in minutes since opening time, that the car arrived at a bay
     */
    public int getArrivalTime()
    {
        return arrivalTime;
    }

    /**
     * Returns a print-ready string formatted as:
     * <pre>
     *     Car arrival: arrivalTime
     * </pre>
     *
     * @return A formatted string with the arrival time
     */
    @Override
    public String toString()
    {
        return "Car arrival: " + arrivalTime;
    }
}

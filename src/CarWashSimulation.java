/**
 * Simulates one day of the Squeaky Clean Car Wash minute by minute.
 *
 * @author Juniper Pasternak
 * @version 10/13/23
 */
public class CarWashSimulation
{
    private Bay bay;
    private KQueue<Car> queue;
    private int currentTime;
    private int closingTime;

    private int totalWaitTime;
    private int carCount;
    private int longWaitTime; // Time before the car is considered a long wait
    private int longWaitCars; // Cars with long wait times

    /**
     * Constructs a car wash simulation using the time to wash a car and the waiting time that is considered long.
     *
     * @param washTime the time, in minutes, it takes to wash a single car
     * @param longWaitTime the time, in minutes, before a car is considered to be waiting long
     */
    public CarWashSimulation(int washTime, int longWaitTime)
    {
        reset(washTime, longWaitTime);
    }

    /**
     * Resets the car wash to be ready for a new simulation using the time to wash a car.
     * This object is effectively a newly constructed one.
     *
     * @param washTime the time, in minutes, it takes to wash a single car
     */
    public void reset(int washTime, int longWaitTime)
    {
        bay = new Bay(washTime);
        queue = new LLQueue<>();
        currentTime = 0;

        totalWaitTime = 0;
        carCount = 0;
        this.longWaitTime = longWaitTime;
        longWaitCars = 0;
    }

    /**
     * Returns the total time cars waited in the queue
     *
     * @return the total time cars waited in the queue
     */
    public int getTotalWaitTime()
    {
        return totalWaitTime;
    }

    /**
     * Returns the total amount of cars processed at the car wash
     *
     * @return the total amount of cars processed at the car wash
     */
    public int getCarCount()
    {
        return carCount;
    }

    /**
     * Returns how many cars waited for a "long wait time" or longer.
     *
     * @return how many cars waited a <code>longWaitTime</code> or longer
     */
    public int getLongWaitCars()
    {
        return longWaitCars;
    }

    /**
     * Runs the car wash simulation for the provided time.
     *
     * @param timeToRun the time, in minutes, to run the simulation
     */
    public void run(int timeToRun)
    {
        closingTime = timeToRun;

        // While the car wash is open or the queue has cars waiting
        while (currentTime <= closingTime || !queue.isEmpty())
            step();

        // When done print results
        System.out.println("Simulation complete. Time elapsed: " + currentTime + " minutes.");
        System.out.println("Cars washed: " + carCount + ".");
        System.out.println("Total wait time: " + totalWaitTime + " minutes.");
        System.out.printf("Average wait time: %.2f minutes.%n", (float) totalWaitTime / carCount);
        System.out.println("Cars that waited at least " + longWaitTime + " minutes: " + longWaitCars + ".");
    }

    /**
     * Private helper method that runs one minute of the simulation.
     * Lets cars arrive, moves waiting cars into the bay, and passes time.
     */
    private void step()
    {
        // If a car arrives while open, add it to the queue
        if (currentTime <= closingTime && RandomManager.chanceCar())
        {
            queue.enqueue(new Car(currentTime));
            carCount++;
        }

        // If the bay is empty and there is a car in queue, load the car and track the wait time
        if (bay.isEmpty() && !queue.isEmpty())
        {
            Car nextCar = queue.dequeue();

            int waitTime = currentTime - nextCar.getArrivalTime();
            totalWaitTime += waitTime; // Increase the wait time

            if (waitTime >= longWaitTime)
                longWaitCars++; // Add to cars that have been waiting a "long" time

            bay.loadCar();
        }

        // Pass time
        bay.iterateTime();
        currentTime++;
    }
}

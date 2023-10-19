/**
 * Contains a test main method for development.
 * This is NOT the driver for the simulation. Please see CarWashApplication for the driver.
 *
 * @author Juniper Pasternak
 * @author Teddy Jacobson (conceptual)
 * @version 10/11/23
 */

public class DevMain
{
    /**
     * Tests 100 minutes of the car wash:
     * Cars arrive and go through the car wash, but counting of the wait times are not done.
     */
    public static void main(String[] args)
    {
        LLQueue<Car> queue = new LLQueue<>();
        Bay bay = new Bay(4);

        for (int time = 0; time <= 100; time++)
        {
            boolean arrival = RandomManager.chanceCar();
            if (arrival)
                queue.enqueue(new Car(time));

            if (bay.isEmpty() && !queue.isEmpty())
            {
                Car car = queue.dequeue();
                int arrivalTime = car.getArrivalTime();
                System.out.println("Car at time " + arrivalTime + " waited: " + (time - arrivalTime) + " minute(s)");
                bay.loadCar();
            }

            bay.iterateTime();
            System.out.println("Minute " + time + ": Arrival: " + arrival + ". Bay available in: " + (bay.getTimeLeft() + 1));
        }

        System.out.println("Cars (" + queue.size() + ") in queue:");
        while (!queue.isEmpty())
        {
            System.out.println("Removed car: " + queue.dequeue());
        }
    }
}

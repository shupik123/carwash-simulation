import java.io.IOException;

/**
 * The driver class for the car wash simulation.
 *
 * @author Juniper Pasternak
 * @version 10/18/23
 */
public class CarWashApplication
{
    /**
     * Runs one trial of simulations each for the basic wash machine and the upgraded wash machine.
     * In addition to printing the results of each simulation, the program saves them in CSV format.
     */
    public static void main(String[] args) throws IOException
    {
        // Obtain user defined parameters
        int openDuration = ValidatedInputReader.getInteger(
                "How many minutes should the car wash be open?",
                1,
                Integer.MAX_VALUE,
                600,
                "Please enter a positive integer.");
        int longWaitTime = ValidatedInputReader.getInteger(
                "At what waiting time should cars be considered long waits?",
                1,
                Integer.MAX_VALUE,
                10,
                "Please enter a positive integer.");
        int baseWashTime = ValidatedInputReader.getInteger(
                "How many minutes does it take to wash a car with the initial equipment?",
                1,
                Integer.MAX_VALUE,
                4,
                "Please enter a positive integer.");
        int upgradedWashTime = ValidatedInputReader.getInteger(
                "How many minutes does it take to wash a car with the upgraded equipment?",
                1,
                Integer.MAX_VALUE,
                3,
                "Please enter a positive integer.");
        int daysToSimulate = ValidatedInputReader.getInteger(
                "How many days should be tested per trial (set of equipment)?",
                1,
                Integer.MAX_VALUE,
                7,
                "Please enter a positive integer.");
        String outputFileName = ValidatedInputReader.getString(
                "What should the name for the output data be? (OVERWRITES DATA)",
                "output.csv");

        // Create simulation and data manager
        CarWashSimulation simulation = new CarWashSimulation(baseWashTime, longWaitTime);
        DataManager dataManager = new DataManager(2, daysToSimulate);

        // Trial 1
        System.out.println("\n===================================");
        System.out.println("TRIAL 1: " + baseWashTime + " minutes per wash");
        System.out.println("===================================");

        for (int day = 1; day <= daysToSimulate; day++)
        {
            System.out.println("\n--- Day " + day + " Simulation (" + baseWashTime + " minutes per wash) ---");
            simulation.reset(baseWashTime, longWaitTime);
            simulation.run(openDuration);

            // Save the average wait time and long wait cars to dataManager
            float averageWait = (float) simulation.getTotalWaitTime() / simulation.getCarCount();
            dataManager.setaverageWait(averageWait, 0, day - 1);
            dataManager.setLongCarCount(simulation.getLongWaitCars(), 0, day - 1);
        }

        // Trial 2
        System.out.println("\n===================================");
        System.out.println("TRIAL 2: " + upgradedWashTime + " minutes per wash.");
        System.out.println("===================================");

        for (int day = 1; day <= daysToSimulate; day++)
        {
            System.out.println("\n--- Day " + day + " Simulation (" + upgradedWashTime + " minutes per wash) ---");
            simulation.reset(upgradedWashTime, longWaitTime);
            simulation.run(openDuration);

            // Save the average wait time and long wait cars to dataManager
            float averageWait = (float) simulation.getTotalWaitTime() / simulation.getCarCount();
            dataManager.setaverageWait(averageWait, 1, day - 1);
            dataManager.setLongCarCount(simulation.getLongWaitCars(), 1, day - 1);
        }

        // Save the data collected to a file
        String[] trialNames = {"Base", "Upgraded"};
        dataManager.writeToFile(outputFileName, trialNames);
    }
}

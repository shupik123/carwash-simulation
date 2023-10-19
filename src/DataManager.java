import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Stores the car wash's analysis data to be reported. Can export the data to a CSV file.
 *
 * @author Juniper Pasternak
 * @version 10/18/2023
 */
public class DataManager
{
    public final int trials;
    public final int days;
    private float[][] averageWaits;
    int[][] longCarCounts;

    /**
     * Constructs a new data manager using the amount of trials and days per trial.
     *
     * @param trials the amount of trials a full simulation runs
     * @param days the amount of days each trial performs
     */
    public DataManager(int trials, int days)
    {
        this.trials = trials;
        this.days = days;
        averageWaits = new float[trials][days];
        longCarCounts = new int[trials][days];
    }

    /**
     * Stores the average wait time for a specific trial and day.
     *
     * @param averageWait the average wait time in a day
     * @param trial the trial to store the average wait in
     * @param day the day to store the average wait in
     */
    public void setaverageWait(float averageWait, int trial, int day)
    {
        averageWaits[trial][day] = averageWait;
    }

    /**
     * Stores the amount of cars that waited a long time for a specific trial and day.
     *
     * @param longCarCount the amount of cars that waited a long time in a day
     * @param trial the trial to store the car count in
     * @param day the day to store the car count in
     */
    public void setLongCarCount(int longCarCount, int trial, int day)
    {
        longCarCounts[trial][day] = longCarCount;
    }

    /**
     * Writes (overrides) the provided content to the file using its provided filename.
     *
     * @param filename the name of the file to be written to
     * @param trialNames the names of the trials to be placed in the data table
     * @throws IOException if the file cannot be created or opened
     * @throws IllegalArgumentException if the trial names' length does not equal the expected length
     */
    public void writeToFile(String filename, String[] trialNames) throws IOException, IllegalArgumentException
    {
        try // Creates a new file if necessary and writes to it
        {
            FileWriter writer = new FileWriter(filename);
            writer.write(formatData(trialNames));
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("An exception has occurred. This is usually due to lack of write permissions.");
            throw e;
        }
    }

    /**
     * Converts the stored data to a CSV-ready string with a header and averages at the end.
     *
     * @param trialNames the names of the trials to be placed in the data table
     * @return a CSV-formatted string with the average waits and cars with long waits
     * @throws IllegalArgumentException if the trial names' length does not equal the expected length
     */
    private String formatData(String[] trialNames) throws IllegalArgumentException
    {
        if (trialNames.length != trials)
            throw new IllegalArgumentException("Trial names given is not expected length " + trials + ".");

        float[] sumAverageWaits = new float[2];
        int[] sumLongCars = new int[2];

        // Create table header in the string builder
        StringBuilder sb = new StringBuilder("Day,");
        for (int trial = 0; trial < trials; trial++) // Section for each trial
        {
            sb.append(trialNames[trial]).append(" Average Wait,");
            sb.append(trialNames[trial]).append(" # Cars With Long Wait,");
        }
        sb.deleteCharAt(sb.length() - 1); // Remove last comma

        NumberFormat formatter = new DecimalFormat("0.00"); // Use the formatter to round the averages

        // Add a row for each day
        for (int day = 1; day <= days; day++)
        {
            sb.append("\n");
            sb.append(day).append(",");

            for (int trial = 0; trial < trials; trial++) // Section for each trial
            {
                sumAverageWaits[trial] += averageWaits[trial][day - 1];
                sumLongCars[trial] += longCarCounts[trial][day - 1];

                String strAverageWait = formatter.format(averageWaits[trial][day - 1]); // Round to 2 decimals

                sb.append(strAverageWait).append(",");
                sb.append(longCarCounts[trial][day - 1]).append(",");

            }
            sb.deleteCharAt(sb.length() - 1); // Remove last comma
        }
        sb.append("\n");

        // Add the average row at the end
        sb.append("Average,");
        for (int trial = 0; trial < trials; trial++) // Section for each trial
        {
            float overallAverageWait = sumAverageWaits[trial] / days;
            float averageLongCars = (float) sumLongCars[trial] / days;

            String strOverallAverageWait = formatter.format(overallAverageWait);
            String strAverageLongCars = formatter.format(averageLongCars);

            sb.append(strOverallAverageWait).append(",");
            sb.append(strAverageLongCars).append(",");
        }
        sb.deleteCharAt(sb.length() - 1); // Remove last comma

        return sb.toString();
    }
}

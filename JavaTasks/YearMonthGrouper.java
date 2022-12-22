
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
class YearMonthGrouper {

    public static List<Date> randomDateGenerator(Date startDate, int numInstances) {
        // Create a calendar to set the start date
        Calendar calendar = Calendar.getInstance(); //
        calendar.setTime(startDate);

        // Create a list to store the random dates
        List<Date> randomDates = new ArrayList<>();

        // Create a random number generator
        Random random = new Random();

        // Generate the given number of random dates
        for (int i = 0; i < numInstances; i++) {
            // Generate a random number of days to add to the start date
            int numDays = random.nextInt(365);

            // Add the random number of days to the start date
            calendar.add(Calendar.DATE, numDays);

            // Add the resulting date to the list of random dates
            randomDates.add(calendar.getTime());
        }

        // Return the list of random dates
        return randomDates;
    }
    public static Map<String, Integer> yearMonthGrouper(List<Date> dates) {
        // Create a map to store the grouped dates
        Map<String, Integer> groupedDates = new HashMap<>();

        // Create a date formatter to format the dates
        SimpleDateFormat formatter = new SimpleDateFormat("MMM-yy");

        // Keep track of the total number of dates encountered
        int totalDates = 0;

        // Loop through the dates and group them by month and year
        for (Date date : dates) {
            // Format the date
            String formattedDate = formatter.format(date);

            // Increment the total number of dates encountered
            totalDates++;

            // Check if the formatted date is already in the map
            if (groupedDates.containsKey(formattedDate)) {
                // If the formatted date is already in the map, increment the count by the total number of dates encountered
                groupedDates.put(formattedDate, groupedDates.get(formattedDate) + totalDates);
            } else {
                // If the formatted date is not in the map, add it with a count of the total number of dates encountered
                groupedDates.put(formattedDate, totalDates);
            }
        }

        // Return the grouped dates
        return groupedDates;
    }


    public static void main(String[] args) {
        Date startDate = new Date();
        int numInstances = 10;
        List<Date> randomDates = YearMonthGrouper.randomDateGenerator(startDate, numInstances);
        List<Date> dates = randomDates; // A list of dates
        Map<String, Integer> groupedDates = YearMonthGrouper.yearMonthGrouper(dates);
        System.out.println(groupedDates);
    }
}

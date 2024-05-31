package travelreview.project.Utils;

public class RateUtils {
    public static String calculateRatingAverage(int totalRates, double valueRate) {
        if (totalRates > 0) {
            double average = valueRate / totalRates;
            return String.format("%.1f", average);
        }
        else{
            return "-";
        }
    }

}

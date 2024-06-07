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

    public static double calculateRatingAverageDouble(int totalRates, double valueRate) {
        if (totalRates > 0) {
            double average = valueRate / totalRates;
            return Math.round(average * 10.0) / 10.0;
        }
        else{
            return 0;
        }
    }
}

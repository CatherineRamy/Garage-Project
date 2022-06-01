package parking;
import static java.lang.Math.toIntExact;


public class GarageCalculations {
	private int vehicleCount;
	private int totalIncome;
    public GarageCalculations() {
        vehicleCount=0;
        totalIncome=0;
    }
    public void incrementVehicleCount() {
        vehicleCount++;
    } 
    public int calcFees(Vehicle vehicle1) {
		long diff;
		diff = vehicle1.getEndDate().getTime() - vehicle1.getStartDate().getTime();
		long difference_In_Hours = (diff / (1000 * 60 * 60));
		int fees = toIntExact(difference_In_Hours);
		if (diff % (1000 * 60 * 60) != 0) {
			fees++;
		}
		fees *= 5;
		totalIncome += fees;
		return fees;
	}
    public int getvehicleCount(){
        return vehicleCount;
    }
    public int gettotalIncome(){
        return totalIncome;
    }
}

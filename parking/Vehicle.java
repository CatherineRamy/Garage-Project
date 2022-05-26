package parking;

import java.util.Date;

public interface Vehicle {
	
	public void displayAvailableSlots();
	public int getOwnerChoice();
	public int getCapacity();
	public MySlots getSlots(int index);
	public void setStartDate(Date arrivalDate);
	public Date getStartDate();
	public float getVehicleDepth();
	public float getVehicleWidth();
}

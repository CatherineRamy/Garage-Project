package parking;

import java.util.Date;

public interface Vehicle {
	public void displayAvailableSlots();
	public int getOwnerChoice();
	public int getCapacity();
	public MySlots getSlots(int index);
	public void setStartDate(Date arrivalDate);
	public void setEndtDate(Date arrivalDate);
	public Date getStartDate();
	public Date getEndDate();
	public float getVehicleDepth();
	public float getVehicleWidth();
	public String getUniqueId();
	public String getMySlot();
	public void setMySlot(String slotName);
}

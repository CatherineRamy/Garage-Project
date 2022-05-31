package parking;

public interface Garage {
	public String parkIn(Vehicle veh);
	public int parkOut(String vehicleId);
	public void setSlots(int index,MySlots slot);
	public boolean getGarageStatus();
	public int getTotalVehicle();
	public int getTotalIncome();
	public boolean getStatus();
	public MySlots[] getAvailableSlots();
	public int getOwnerChoice();
	public int getCapacity();
	public MySlots getSlots(int index);

}
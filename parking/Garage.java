package parking;

public interface Garage {
	public String parkIn(Vehicle veh);
	public int parkOut(String vehicleId);
	public boolean getStatus();
	public MySlots[] theAvailableSlots();
	public int getOwnerChoice();
	public int getCapacity();
	public MySlots getSlots(int index);
	public void setSlots(int index,MySlots slot);
	public boolean isFull();
	public String chooseSlot(Vehicle v);
	public int calcFees(Vehicle veh);
	public int calculateTotalVehicle();
	public int calculateTotalIncome();
}
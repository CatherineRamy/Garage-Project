package parking;

public interface Garage {
	public void parkIn(Vehicle veh);
	public int parkOut(String vehicleId);
	public boolean getStatus();
	public MySlots[] theAvailableSlots();
	public int getOwnerChoice();
	public int getCapacity();
	public Slot getSlots(int index);
	public boolean isFull();
	public String chooseSlot(Vehicle v);
	public int calcFees(Vehicle veh);
	public int calculateTotalVehicle();
	public int calculateTotalIncome();
}
package parking;

public interface Garage {
	public void parkIn(Vehicle veh);
	//private void setParkOutTime(Vehicle veh);
	public int parkOut(String vehicleId);
	public void setData(float sW, float sD, String sId);
	public float getwidth();
	public float getdepth();
	public String getId();
	public void setStatus(boolean status);
	public boolean getStatus();
	public MySlots[] theAvailableSlots();
	public int getOwnerChoice();
	public int getCapacity();
	public Slot getSlots(int index);
	public boolean isFull(Vehicle v);
	public String chooseSlot(Vehicle v);
	public int calcFees(Vehicle veh);
	public int calculateTotalVehicle();
	public int calculateTotalIncome();
}
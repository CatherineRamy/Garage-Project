package parking;

public interface Garage {

	public void parkIn(Vehicle veh);
	  /** // private void setParkOutTime(Vehicle veh);
	   // public String parkOut(Vehicle veh);**/
	public void setData(float sW, float sD, String sId);
	public float getwidth();
	public float getdepth();
	public String getId();
	public void setStatus(boolean status);
	public boolean getStatus();
	public void displayAvailableSlots();
	public int getOwnerChoice();
	public int getCapacity();
	public Slot getSlots(int index);
	public boolean isFull(Vehicle v);
	public String chooseSlot(Vehicle v);
}
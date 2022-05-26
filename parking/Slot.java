package parking;

public interface Slot {
	public void setData(float slotW, float slotD, String slotId);
	public float getwidth();
	public float getdepth();
	public String getId();
	public void setStatus(boolean status);
	public boolean getStatus();
}
package parking;

public interface Slot {
	public void setData(float sW, float sD, String sId);
	public float getwidth();
	public float getdepth();
	public String getId();
	public void setStatus(boolean status);
	public boolean getStatus();
}
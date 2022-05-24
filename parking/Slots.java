package parking;

public class Slots implements Slot {
	private float slotWidth;
	private float slotDepth;
	private boolean slotStatus;
	private String slotId;
	
	public Slots()
	{
		slotWidth=0;
		slotDepth=0;
		slotId="";
	}
	public Slots(float sW, float sD, String sId)
	{
		slotWidth=sW;
		slotDepth=sD;
		slotId=sId;
		/**slotStatus=true;*/
	}
	public void setData(float sW, float sD, String sId)
	{
		slotWidth=sW;
		slotDepth=sD;
		slotId=sId;
	}
	public float getwidth()
	{return slotWidth;}
	public float getdepth()
	{return slotDepth;}
	public String getId()
	{return slotId;}
	
	public void setStatus(boolean status){ slotStatus=status; }
	public boolean getStatus() {return slotStatus;}

}
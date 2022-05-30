package parking;

public class MySlots implements Slot {
	private float slotWidth;
	private float slotDepth;
	private boolean slotStatus;
	private String slotId;
	
	public MySlots()
	{
		slotWidth=0;
		slotDepth=0;
		slotId="";
	}
	public MySlots(float slotW, float slotD, String _slotId)
	{
		slotWidth=slotW;
		slotDepth=slotD;
		slotId=_slotId;
		slotStatus=false;
	}
	public void setData(float slotW, float slotD, String _slotId)
	{
		slotWidth=slotW;
		slotDepth=slotD;
		slotId=_slotId;
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
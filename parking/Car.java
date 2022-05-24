package parking;

import java.util.Date;

public class Car implements Vehicle, Park, Slot {
    private String modelName;
    private String uniqueID;
    private int modelYear;
    private float vehicleWidth;
    private float vehicleDepth;
    private String mySlot = "";
    private Date arrivalTime;
    private Date DepartureTime;

    public Car(String modelName, String uniqueID, int modelYear, float vehicleWidth, float vehicleDepth,
            String mySlot) {
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.vehicleDepth = vehicleDepth;
        this.vehicleWidth = vehicleWidth;
        this.mySlot = mySlot;
    }

    public void setStartDate(Date arrivalDate) {
        arrivalTime = arrivalDate;
    }
    public void setEndtDate(Date EndDate) {
        DepartureTime = EndDate;
    }

    public Date getStartDate(){return arrivalTime;}

    public float getVehicleDepth(){return vehicleDepth;}

    public float getVehicleWidth(){return vehicleWidth;}


    ////////////////////////////////////the following are auto generated////////////////////////////////////////////////

    @Override
    public void setData(float sW, float sD, String sId) {
        // TODO Auto-generated method stub

    }

    @Override
    public float getwidth() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getdepth() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setStatus(boolean status) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean getStatus() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void displayAvailableSlots() {
        // TODO Auto-generated method stub

    }

    @Override
    public int getOwnerChoice() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getCapacity() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Slots getSlots(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void parkIn(Vehicle veh) {
        // TODO Auto-generated method stub
        // return null;
    }

    @Override
    public boolean isFull(Vehicle v) {
        // TODO Auto-generated method stub
        return false;
    } 

    @Override
    public String chooseSlot(Vehicle v) {
        // TODO Auto-generated method stub
        return null;
    }
}

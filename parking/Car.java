package parking;

import java.util.Date;

public class Car implements Vehicle{
    private String modelName;
    private String uniqueID;
    private int modelYear;
    private float vehicleWidth;
    private float vehicleDepth;
    private String mySlot = "";
    private Date arrivalTime;
    private Date DepartureTime;

    public Car(String modelName, int modelYear ,String uniqueID, float vehicleWidth, float vehicleDepth,String mySlot) {
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
    public MySlots getSlots(int index) {
        // TODO Auto-generated method stub
        return null;
    }




}

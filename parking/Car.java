//entity class 
package parking;

import java.util.Date;

public class Car implements Vehicle{
    private String modelName;
    private String uniqueID;
    private int modelYear;
    private float vehicleWidth;
    private float vehicleDepth;
    private String mySlot ;
    private Date arrivalTime;
    private Date DepartureTime;

    public Car(String modelName, int modelYear ,String uniqueID, float vehicleWidth, float vehicleDepth) {
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.uniqueID = uniqueID;
        this.vehicleDepth = vehicleDepth;
        this.vehicleWidth = vehicleWidth;
        this.mySlot = "";
    }

    public Car(String modelName, int modelYear ,String uniqueID) {
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.uniqueID = uniqueID;
        this.mySlot = "";
    }

    //contractor with dimensions that make it flexible for the user if he doesn't have more information about his vehicle
    public Car(float vehicleWidth, float vehicleDepth) {
        this.vehicleDepth = vehicleDepth;
        this.vehicleWidth = vehicleWidth;
        this.mySlot = "";
    }

    public void setStartDate(Date arrivalDate) {
        arrivalTime = arrivalDate;
    }
    public void setEndtDate(Date EndDate) {
        DepartureTime = EndDate;
    }

    public Date getStartDate(){return arrivalTime;}
    public Date getEndDate(){return DepartureTime;}

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

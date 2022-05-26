package parking;

public class GarageRegulator {
    MyGarage garage1;
    Car car1;

   
    public void createGarage(int nSlots, MySlots[] SlotsArray, int config_choice){
        garage1 = new MyGarage(nSlots, SlotsArray, config_choice);
    }
    public void createVehicle(String modelName,int modelYear,String uniqueID, float vehicleWidth, float vehicleDepth, String mySlot ){

        car1 = new Car(modelName, modelYear,uniqueID, vehicleWidth, vehicleDepth, "");
		garage1.parkIn(car1);
    }
    public MySlots[] slotsAvailable()
    {
        return garage1.theAvailableSlots();
    }

}

//controller class 
package parking;

public class GarageRegulator {
    MyGarage garage1;
    Car car1;
    MySlots[] SlotsArray;   // array of objects of type slots that stores all garage slots..

    public void createGarage(int nSlots, int config_choice){
        garage1 = new MyGarage(nSlots, SlotsArray, config_choice);
    }

    public String createVehicle(String modelName, int modelYear,String uniqueID, float vehicleWidth, float vehicleDepth ){
        String ID="";
        car1 = new Car(modelName, modelYear,uniqueID, vehicleWidth, vehicleDepth);
		ID=garage1.parkIn(car1);
        return ID;
    }

    public MySlots[] slotsAvailable(){
        return garage1.getAvailableSlots();
    }

    public void creatArrOfSlots(int nSlots){
        SlotsArray = new MySlots[nSlots];
    }

    public void addSlotToArr(int index,float _sw,float _sd, String _sid){
        SlotsArray[index] = new MySlots(_sw, _sd, _sid);
    }

    public int carParkOut(String _id){
        int i = garage1.parkOut(_id);
        return i;
    }

    public int totalIncome(){
        int i = garage1.getTotalIncome();
        return i;
    }

    public int totalVehicle(){
        int i = garage1.getTotalVehicle();
        return i;
    }

    public boolean garageStatus()
    {
        return garage1.getGarageStatus();
    }

}

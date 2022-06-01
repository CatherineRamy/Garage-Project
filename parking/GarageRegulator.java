//controller class 
package parking;

public class GarageRegulator {
    MyGarage garage1; 
    Car car1;
    MySlots[] SlotsArray;   

    //to create an object from MyGarage class after getting all garage's data from myscreen class
    public void createGarage(int nSlots, int config_choice){
        garage1 = new MyGarage(nSlots, SlotsArray, config_choice);
    }

    //to create an object from MySlots class after getting all number of slots from myscreen class
    public void creatArrOfSlots(int nSlots){
        SlotsArray = new MySlots[nSlots];
    }

    // to store all garage slots the first time when setup garage
    public void addSlotToArr(int index,float _sw,float _sd, String _sid){
        SlotsArray[index] = new MySlots(_sw, _sd, _sid);
    }

    //to create an object from a class car after getting all vehicle's data from myscreen class 
    //and call function parkin from my garage to parking this vehicle 
    public String createVehicle(String modelName, int modelYear,String uniqueID, float vehicleWidth, float vehicleDepth ){
        String ID="";
        car1 = new Car(modelName, modelYear, uniqueID, vehicleWidth, vehicleDepth);
		ID=garage1.parkIn(car1);
        return ID;
    }

    //to get from mygarage class if all slots are full or not
    // it returns true if all slots is full
    public boolean garageStatus(){
        return garage1.getGarageStatus();
    }

    // to get an array of available slots from mygarage class to display that in myscreen class
    public MySlots[] slotsAvailable(){
        return garage1.getAvailableSlots();
    }

    //to get a car id from myscreen class to parking out this vehicle
    public int carParkOut(String _id){
        int i = garage1.parkOut(_id);
        return i;
    }

    // to get total income from mygarage class 
    public int totalIncome(){
        int i = garage1.getTotalIncome();
        return i;
    }

    // to get total vehicle from garage calculations class
    public int totalVehicle(){
        int i = garage1.getTotalVehicle();
        return i;
    }

}

package parking;

import java.util.Date;
import java.util.*;


public class MyGarage implements Garage {
	private int capacity, OwnerChoice;  //number of slots in the garage, configuration choice
	private MySlots[] garageSlots;      //array of slots to store garage slots
	private Vector<Vehicle> garageVehicles; //vector to store vehicle parked in the garage 
	private GarageCalculations calculations;  
	private Configuration myconfig;

	public MyGarage(int _capacity, MySlots[] s, int choice) {
		capacity = _capacity; 
		OwnerChoice = choice; 
		garageVehicles = new Vector<Vehicle>();
		calculations= new GarageCalculations();
		garageSlots = new MySlots[capacity];
		for (int i = 0; i < capacity; i++) {
			garageSlots[i] = new MySlots(s[i].getwidth(), s[i].getdepth(), s[i].getId());
		}
		//polymorphism to set one type of two types of configuration
		if (OwnerChoice == 1) { // the configuration of first come first in..
			myconfig=new FirstCome();
		}
		else{   // the configuration of best fit
			myconfig=new BestFit();
		}
	}

	public String parkIn(Vehicle vehicle1) {
		String ID = myconfig.parking(this ,garageSlots ,vehicle1);
		if(!getGarageStatus() && ID != "") {//check if there are available slots in the garage and if there is available slot to this vehicle to park in 
			calculations.incrementVehicleCount(); //increment total vehicles after this vehicle parked in			
			vehicle1.setMySlot(ID); //to assign a specific slot to the entered vehicle acording to itsdimentions
			Date arrivalDate = new Date();  //Date is a built in class in java that returns the date and we will use it to save system's time
			vehicle1.setStartDate(arrivalDate); //set arrival date in vehicle info 
			garageVehicles.add(vehicle1); // set this vehicle in garageVehicles untile leave 
		}
		return ID;
	}

	//park out function get vehicle id as parameter to park out specific vehicle
	public int parkOut(String vehicleID) {
		int vehicleFees = 0; //to return fees when the vehicle driver decided to leave (if the vehicle is not in the garage return fees = 0)
		//loop to check if this vehicle park in the garage now or not 
		for (int i = 0; i < garageVehicles.size(); i++) { 
			if (garageVehicles.get(i).getUniqueId().equals(vehicleID)) {
				Date DepartureTime = new Date();// Date is a built in class in java that returns the date and we will use it to save Departure time
				garageVehicles.get(i).setEndtDate(DepartureTime);
				vehicleFees = calculations.calcFees(garageVehicles.get(i)); 
				for (int j = 0; j < capacity; j++) { 
					//to set the status of slot false to be available to park in another vehicle
					if (garageSlots[j].getId().equals(garageVehicles.get(i).getMySlot())) {
						garageSlots[j].setStatus(false);
					}
				}
				garageVehicles.remove(i);
				break;
			}
		}
		return vehicleFees;
	}

	public boolean getGarageStatus() {// it returns true if all slots is unavailable ..
		for (int i = 0; i < capacity; i++) {// loop to check each slot availability..
			if (!garageSlots[i].getStatus()) {// the get function returns true if the slot have a vehicle parking in it..
				return false;// returning false if at least one available slot is found..
			}
		}
		return true;// it returns true when all slots bhave vehicles parking in it..
	}

	public MySlots[] getAvailableSlots() {
		int counter = 0; // counter to check if there are available slots..

		for (int i = 0; i < capacity; i++) {// loop to count available slots in the garage
			if (!garageSlots[i].getStatus()) {
				counter = counter + 1;
			}
		}
		int totalAvailable = 0;
		MySlots[] availableSlots;
		availableSlots = new MySlots[counter];
		for (int i = 0; i < capacity; i++) {// loop to check the state of each slot and display the available ones..
			if (!garageSlots[i].getStatus()) {
				availableSlots[totalAvailable] = garageSlots[i];
				totalAvailable++;
			}
		}
		if (counter == 0) {
			return null;
		}
		return availableSlots;
	}

	public int getOwnerChoice() {
		return OwnerChoice;
	}

	public int getTotalIncome() {
		return calculations.gettotalIncome();
	}

	public int getTotalVehicle() {
		return calculations.getvehicleCount();
	}

	public MySlots getSlots(int index) {
		return garageSlots[index];
	}

	public boolean getStatus() {
		return false;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setSlots(int index,MySlots slot) {
		
		garageSlots[index]=slot;
	}
}
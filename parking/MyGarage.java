package parking;

import java.util.Date;
import java.util.*;


public class MyGarage implements Garage {
	private int capacity, OwnerChoice;
	private MySlots[] garageSlots;
	private Vector<Vehicle> garageVehicles = new Vector<Vehicle>();
	private GarageCalculations calculations= new GarageCalculations();
	private Configuration myconfig;

	public MyGarage(int _capacity, MySlots[] s, int choice) {
		capacity = _capacity;
		OwnerChoice = choice;
		garageSlots = new MySlots[capacity];
		for (int i = 0; i < capacity; i++) {
			garageSlots[i] = new MySlots(s[i].getwidth(), s[i].getdepth(), s[i].getId());
		}
	}

	public MySlots[] theAvailableSlots() {
		int counter = 0; /// counter to check if there are available slots..

		for (int i = 0; i < capacity; i++) {// loop to check the state of each slot and display the available ones..
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
		if (counter == 0) {/// displaing message to say that there are no available slots..
			// System.out.println("There is no available slots");
			return null;
		}
		return availableSlots;
	}

	public boolean isFull() {// it returns true if all slots is unavailable ..
		for (int i = 0; i < capacity; i++) {// loop to check each slot availability..
			if (!garageSlots[i].getStatus()) {// the get function returns true if the slot have a vehicle parking in
												// it..
				return false;// returning false if at least one available slot is found..
			}
		}
		return true;// it returns true when all slots bhave vehicles parking in it..
	}

	public String chooseSlot(Vehicle vehicle1) {
		String ID = "";
		if (OwnerChoice == 1) { // the configuration of first come first in..
			myconfig=new FirstCome();
			ID=myconfig.parking(this,garageSlots ,vehicle1);
		}
		else if (OwnerChoice==2) {
			myconfig=new BestFit();
			ID=myconfig.parking(this,garageSlots, vehicle1);

			// the configuration of best fit
			
		}
		if (ID == "") {
			System.out.println("sorry, no avilable slots for your car dimension");
			return ID;
		} else {
			// System.out.println("welcome to in my parking:
			// "+vehicle1.getVehicleuniqueID());
			return ID;
		}
	}

	public String parkIn(Vehicle vehicle1) {
		String ID="";
		if (!isFull()) {//// there are still available slots in the garage...
			calculations.incrementVehicleCount();
			vehicle1.setMySlot(ID=chooseSlot(vehicle1));// to assign a specific slot to the entered vehicle acording to its
														// dimentions..
			Date arrivalDate = new Date();// Date is a built in class in java that returns the date and we will use it
											// to save system's time..
			vehicle1.setStartDate(arrivalDate);
			garageVehicles.add(vehicle1);
		}
		return ID;
	}

	public int parkOut(String vehicleID) {
		int vehicleFees = 0;
		for (int i = 0; i < garageVehicles.size(); i++) {
			if (garageVehicles.get(i).getUniqueId().equals(vehicleID)) {
				Date DepartureTime = new Date();// Date is a built in class in java that returns the date and we will use it to save system's time..
				garageVehicles.get(i).setEndtDate(DepartureTime);
				vehicleFees = calculations.calcFees(garageVehicles.get(i));
				for (int j = 0; j < capacity; j++) {
					if (garageSlots[j].getId().equals(garageVehicles.get(i).getMySlot()))
					{
						garageSlots[j].setStatus(false);
					}
				}
				garageVehicles.remove(i);
				break;
			}
		}
		return vehicleFees;
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

	@Override
	public MySlots getSlots(int index) {
		return garageSlots[index];
	}

	@Override
	public boolean getStatus() {
		return false;
	}


	public int getCapacity() {
		return capacity;
	}

	@Override
	public void setSlots(int index,MySlots slot) {
		
		garageSlots[index]=slot;
	}

	

}
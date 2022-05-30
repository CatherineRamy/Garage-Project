package parking;

import java.util.Date;
import java.util.Arrays;
import java.util.Collections;
import static java.lang.Math.toIntExact;

public class MyGarage implements Garage{
	private int capacity, OwnerChoice;
	private MySlots[] garageSlots;
	private int vehicleCount;
	private int totalIncome;

	public MyGarage(int _capacity, MySlots[] s, int choice) {
		capacity = _capacity;
		OwnerChoice = choice;
		vehicleCount=0;
		totalIncome=0;
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
		int totalAvailable=0;
		MySlots [] availableSlots;
		availableSlots = new MySlots[counter];
		for (int i = 0; i < capacity; i++) {// loop to check the state of each slot and display the available ones..
			if (!garageSlots[i].getStatus()) {
				availableSlots[totalAvailable]=garageSlots[i];
				totalAvailable++;
			}
		}
		if (counter == 0) {/// displaing message to say that there are no available slots..
			//System.out.println("There is no available slots");
			return null;
		}
		return availableSlots;
	}

	public boolean isFull(Vehicle vehicle1) {// it returns true if all slots is unavailable ..
		for (int i = 0; i < capacity; i++) {// loop to check each slot availability..
			if (!garageSlots[i].getStatus()) {// the get function returns true if the slot have a vehicle parking in it..
				return false;//returning false if at least one available slot is found..
			}
		}
		System.out.println(" no available slots");
		return true;// it returns true when all slots bhave vehicles parking in it..
	}

	public String chooseSlot(Vehicle vehicle1) {
		String ID = "";
		if (OwnerChoice == 1) { // the configuration of first come first in..
			for (int i = 0; i < capacity; i++) {//loop to get first available and suitable slot
				if (!garageSlots[i].getStatus())// this means that the slot is empty
				{
					if (garageSlots[i].getwidth() >= vehicle1.getVehicleWidth() && garageSlots[i].getdepth() >= vehicle1.getVehicleDepth()) {//to check if the dimentions of slot suitable for the entering vehicle..
						garageSlots[i].setStatus(true);
						ID = garageSlots[i].getId();//set the returning string id of the slot thst is assigned to the vehicle..
						break;//it exit the loop when the vehicle is assigned successfuly to a slot..
					}

				}
			}
		} else {
			// the configuration of best fit
			for (int i = 0; i < capacity; i++) {// sorting function to sort the slots according to thier width value..
				for (int j = i + 1; j < capacity; j++) {
					MySlots temp;
					if (garageSlots[j].getwidth() < garageSlots[i].getwidth()) {
						temp = garageSlots[i];
						garageSlots[i] = garageSlots[j];
						garageSlots[j] = temp;
					}
				}
			}//end of the width-based sort
			/////the following is another loop to re sort the sorted array of slots accourding to thier depth that have same width value...
			int b = 0, i = 0;
			while (b < capacity - 1) {
				MySlots tmp = garageSlots[b];
				while (garageSlots[b].getwidth() == tmp.getwidth() && b < capacity - 1) {
					b++;
				}
				for (; i < b; i++) {
					for (int j = i + 1; j < b; j++) {
						MySlots temp;
						if (garageSlots[j].getdepth() < garageSlots[i].getdepth()) {
							temp = garageSlots[i];
							garageSlots[i] = garageSlots[j];
							garageSlots[j] = temp;
						}
					}
				}
			}
			for (int k = 0; k < capacity; k++) {
				if (!garageSlots[k].getStatus())// this means that the slot is empty
				{
					if (garageSlots[k].getwidth() >= vehicle1.getVehicleWidth() && garageSlots[k].getdepth() >= vehicle1.getVehicleDepth()) {//to check if the dimentions of slot suitable for the entering vehicle..
						garageSlots[k].setStatus(true);
						ID = garageSlots[k].getId();//set the returning string id of the slot thst is assigned to the vehicle..
						break;//it exit the loop when the vehicle is assigned successfuly to a slot..
					}

				}
			}
		}
		if (ID == "") {
			System.out.println("sorry, no avilable slots for your car dimension");
			return ID;
		} else {
			//System.out.println("welcome to in my parking: "+vehicle1.getVehicleuniqueID());
			return ID;
		}
	}

	public void parkIn(Vehicle vehicle1) {
		if (!isFull(vehicle1)) {////there are still available slots in the garage...
			vehicleCount++;
			chooseSlot(vehicle1);// to assign a specific slot to the entered vehicle acording to its dimentions..
			Date arrivalDate = new Date();//Date is a built in class in java that returns the date and we will use it to save system's time..
			vehicle1.setStartDate(arrivalDate);
		}else{System.out.println("sorry the grage is full!");}	//displaying message because the garage is already full and make the vehicle leave..

	}

	public String parkOut(Vehicle vehicle1) {
		Date DepartureTime= new Date();//Date is a built in class in java that returns the date and we will use it to save system's time..
		vehicle1.setEndtDate(DepartureTime);
		calcFees(vehicle1);
		System.out.print("Fees depending on calculated seconds"+calcFees(vehicle1)+"\n");
		return "hi";

	}
	public int calcFees(Vehicle vehicle1)
	{

		long diff;
		diff = vehicle1.getEndDate().getTime()-vehicle1.getStartDate().getTime();
		long difference_In_Hours= (diff/ (1000*60*60));
		int fees=toIntExact(difference_In_Hours)*5;
		totalIncome+=fees;

         return fees;
	}
	public int getOwnerChoice() {
		return OwnerChoice;
	}

	public void setData(float slotW, float slotD, String slotId) {
		/** TODO Auto-generated method stub */

	}

	@Override
	public MySlots getSlots(int index) {
		return garageSlots[index];
	}

	@Override
	public float getwidth() {
		/** TODO Auto-generated method stub */
		return 0;
	}

	@Override
	public float getdepth() {
		/** TODO Auto-generated method stub */
		return 0;
	}

	@Override
	public String getId() {
		/** TODO Auto-generated method stub */
		return null;
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public void setStatus(boolean status) {
		/** TODO Auto-generated method stub */

	}

	@Override
	public boolean getStatus() {
		/** TODO Auto-generated method stub */
		return false;
	}

}
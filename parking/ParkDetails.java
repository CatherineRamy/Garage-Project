package parking;

import java.util.Date;
import java.util.Arrays;
import java.util.Collections;

public class ParkDetails implements Park, Slot {
	private int capacity, OwnerChoice;
	private Slots[] Pslots;

	public ParkDetails(int c, Slots[] s, int Ochoice) {
		capacity = c;
		OwnerChoice = Ochoice;
		Pslots = new Slots[capacity];
		for (int i = 0; i < capacity; i++) {
			Pslots[i] = new Slots(s[i].getwidth(), s[i].getdepth(), s[i].getId());
			Pslots[i].setStatus(false);
		}
		// Pslots[0].setStatus(true); to try what will happen when true or false.
	}

	public void displayAvailableSlots() {
		int counter = 0; /// counter to check if there are available slots..
		for (int i = 0; i < capacity; i++) {// loop to check the state of each slot and display the available ones..
			if (!Pslots[i].getStatus()) {
				System.out.println(Pslots[i].getwidth() + " " + Pslots[i].getdepth() + " " + Pslots[i].getId());
				counter = counter + 1;
			}
		}
		if (counter == 0) {/// displaing message to say that there are no available slots..
			System.out.println("There is no available slots");
		}
	}

	public boolean isFull(Vehicle v) {// it returns true if all slots is unavailable ..
		for (int i = 0; i < capacity; i++) {// loop to check each slot availability..
			if (!Pslots[i].getStatus()) {// the get function returns true if the slot have a vehicle parking in it..
				return false;//returning false if at least one available slot is found..
			}
		}
		System.out.println(" no available slots");
		return true;// it returns true when all slots bhave vehicles parking in it..
	}

	public String chooseSlot(Vehicle v) {
		String ID = "";
		if (OwnerChoice == 1) { // the configuration of first come first in..
			for (int i = 0; i < capacity; i++) {//loop to get first available and suitable slot
				if (!Pslots[i].getStatus())// this means that the slot is empty
				{
					if (Pslots[i].getwidth() >= v.getVehicleWidth() && Pslots[i].getdepth() >= v.getVehicleDepth()) {//to check if the dimentions of slot suitable for the entering vehicle..
						Pslots[i].setStatus(true);
						ID = Pslots[i].getId();//set the returning string id of the slot thst is assigned to the vehicle..
						break;//it exit the loop when the vehicle is assigned successfuly to a slot..
					}

				}
			}
		} else {
			// the configuration of best fit
			for (int i = 0; i < capacity; i++) {// sorting function to sort the slots according to thier width value..
				for (int j = i + 1; j < capacity; j++) {
					Slots temp;
					if (Pslots[j].getwidth() < Pslots[i].getwidth()) {
						temp = Pslots[i];
						Pslots[i] = Pslots[j];
						Pslots[j] = temp;
					}
				}
			}//end of the width-based sort
			/////the following is another loop to re sort the sorted array of slots accourding to thier depth that have same width value...
			int b = 0, i = 0;
			while (b < capacity - 1) {
				Slots tmp = Pslots[b];
				while (Pslots[b].getwidth() == tmp.getwidth() && b < capacity - 1) {
					b++;
				}
				for (; i < b; i++) {
					for (int j = i + 1; j < b; j++) {
						Slots temp;
						if (Pslots[j].getdepth() < Pslots[i].getdepth()) {
							temp = Pslots[i];
							Pslots[i] = Pslots[j];
							Pslots[j] = temp;
						}
					}
				}
			}
			for (int k = 0; i < capacity; k++) {
				if (!Pslots[k].getStatus())// this means that the slot is empty
				{
					if (Pslots[k].getwidth() >= v.getVehicleWidth() && Pslots[k].getdepth() >= v.getVehicleDepth()) {//to check if the dimentions of slot suitable for the entering vehicle..
						Pslots[k].setStatus(true);
						ID = Pslots[k].getId();//set the returning string id of the slot thst is assigned to the vehicle..
						break;//it exit the loop when the vehicle is assigned successfuly to a slot..
					}

				}
			}
		}
		if (ID == "") {
			System.out.println("sorry, no avilable slots for your car dimension");
			return ID;
		} else {
			return ID;
		}
	}

	public void parkIn(Vehicle veh) {
		if (!isFull(veh)) {////there are still available slots in the garage...
			chooseSlot(veh);// to assign a specific slot to the entered vehicle acording to its dimentions..
			Date date = new Date();//Date is a built in class in java that returns the date and we will use it to save system's time..
			veh.setStartDate(date);
		}else{System.out.println("sorry the grage is full!");}	//displaying message because the garage is already full and make the vehicle leave..

	}

	public int getOwnerChoice() {
		return OwnerChoice;
	}

	public void setData(float sW, float sD, String sId) {
		/** TODO Auto-generated method stub */

	}

	@Override
	public Slots getSlots(int index) {
		return Pslots[index];
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
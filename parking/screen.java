package parking;

import java.util.Date;
import java.util.Scanner;

public class Screen {
    private int nSlots;//number of slots of garage
    private int ch; // the configuration choice
    private MySlots[] SlotsArray; // array of objects of type slots that stores all garage slots..
    Scanner input;
    MyGarage garage1;
    Car car1;

    public void open(){};

    public void SetUp(){
        System.out.print("enter the number of slots: ");
		input = new Scanner(System.in);
        nSlots = input.nextInt();
		SlotsArray = new MySlots[nSlots];
		System.out.println("enter the width, depth, ID of the slot");
		for (int i = 0; i < nSlots; i++) {
			float width = input.nextFloat();
			float depth = input.nextFloat();
			String Id = input.next();
			SlotsArray[i] = new MySlots(width, depth, Id);
			SlotsArray[i].setStatus(false);
		}
    }
    public void chooseConfiguration(){
        System.out.print("choose one of the following configurations for parking (1) first come first (2) best fit: ");
		ch = input.nextInt();
    }
    public void createGarage(){
        garage1 = new MyGarage(nSlots, SlotsArray, ch);
    }
    public void createVehicle(){
        car1 = new Car("ll", "12w", 2012, 3, 4, "");
		garage1.parkIn(car1);
    }
    public void displayAvailable(){
		System.out.println("Available slots");
		garage1.displayAvailableSlots();
    }
    public void displayTotalIncome(){
		
    }
    public void displayTotalVehicles(){
		
    }
    public void out(){
		
    }

}

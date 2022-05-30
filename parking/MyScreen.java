package parking;

import java.util.Date;
import java.util.Scanner;

public class MyScreen {
    
    private GarageRegulator modulator;
    private int nSlots;//number of slots of garage
    private int config_choice;
    Scanner input;
    public MyScreen() {
    }
    public void open(){};
    public void setUp(){
        modulator = new GarageRegulator();
        System.out.print("enter the number of slots: ");
		input = new Scanner(System.in);
        nSlots = input.nextInt();
        modulator.creatArrOfSlots(nSlots);
		System.out.println("enter the width, depth, ID of the slot");
		for (int i = 0; i < nSlots; i++) {
			float width = input.nextFloat();
			float depth = input.nextFloat();
			String Id = input.next();
            modulator.addSlotToArr( i, width, depth, Id);
		}
        modulator.createGarage(nSlots, config_choice);
    }
  
    public void setupCar()
    {
        System.out.print("enter vehicle model : ");
        String modelName = input.next();               

        System.out.print("enter vehicle model year: ");
        int modelYear=input.nextInt();
        

        System.out.print("enter vehicle ID : " );  
        String uniqueID = input.next();             
       
        System.out.print("enter vehicle width, depth: ");
        float vehicleWidth=input.nextFloat();
        float vehicleDepth=input.nextFloat();
        
        modulator.createVehicle(modelName, modelYear, uniqueID,vehicleWidth,vehicleDepth,"");
    }

    public void chooseConfiguration(){
        System.out.print("choose one of the following configurations for parking (1) first come first (2) best fit: ");
		config_choice = input.nextInt();
    }
    
    public void displayAvailableSlots(){
        System.out.println("Available slots");
        for(int i=0; i<modulator.slotsAvailable().length; i++){
            System.out.println(modulator.slotsAvailable()[i].getwidth() + " " + modulator.slotsAvailable()[i].getdepth() + " " + modulator.slotsAvailable()[i].getId());
        }
    }

    public void displayTotalIncome(){
		
    }
    public void displayTotalVehicles(){
		
    }
    public void out(){
		
    }
}
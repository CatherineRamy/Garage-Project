//Boundary class 
package parking;

import java.util.Scanner;

public class MyScreen {
    private GarageRegulator modulator; //object from the controller class 
    private int nSlots;//number of slots of garage
    private int config_choice;
    private Scanner input;
    
    public MyScreen() {
        modulator = new GarageRegulator();
    }
    public void open(){
    }

    public void setUp(){
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
  
    public void setupCar(){
        System.out.print("enter vehicle model : ");
        String modelName = input.next();               

        System.out.print("enter vehicle model year: ");
        int modelYear=input.nextInt();
        
        System.out.print("enter vehicle ID: " );  
        String uniqueID = input.next();             
       
        System.out.print("enter vehicle width, depth: ");
        float vehicleWidth=input.nextFloat();
        float vehicleDepth=input.nextFloat();
        
        modulator.createVehicle(modelName, modelYear, uniqueID,vehicleWidth,vehicleDepth);
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
        System.out.println("total income= " +modulator.totalIncome());		
    }
    public void displayTotalVehicles(){
        System.out.println("total vehicle= " +modulator.totalVehicle());				
    }

    public void displayParkOut(){       
        System.out.println("Fees depending on calculated seconds " +modulator.carParkOut());
    }

}
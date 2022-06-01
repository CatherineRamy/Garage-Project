//Boundary class 
package parking;

import java.util.Scanner;

public class MyScreen {
    private GarageRegulator modulator; //object from the controller class 
    private int nSlots;//number of slots of garage
    private int config_choice;
    private int funChoice;
    public Scanner input= new Scanner(System.in);
   
    public MyScreen() {
        modulator = new GarageRegulator();
    }
    public void open(){
    }

    //to show the menu to the customer
    public void menu(){
        System.out.println("1- parkin ");
        System.out.println("2- parkout ");
        System.out.println("3- see garage available slots");
        System.out.println("4- see total income ");
        System.out.println("5- total number of cars used the garage "); 
    }
    
    // userChoice to get configuration from the customer
    public void userChoice(){
        System.out.println("choose a number from 1 to 5");
        funChoice = input.nextInt();
    }

    //setup to get slots info from the customer 
    public void setUp(){
        System.out.print("enter the number of slots: ");
		
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

    //setupCar to get car info from the customer   
    public void setupCar(){
        //check if there is at least one available slot in the garage or not to get vehicle info
        if(modulator.garageStatus()){
            System.out.println("\n\nsorry the garage is totally full\n\n");
        }
        else{
            System.out.print("enter vehicle model : ");
            String modelName = input.next();               

            System.out.print("enter vehicle model year: ");
            int modelYear=input.nextInt();
            
            System.out.print("enter vehicle ID: " );  
            String uniqueID = input.next();             
        
            System.out.print("enter vehicle width, depth: ");
            float vehicleWidth=input.nextFloat();
            float vehicleDepth=input.nextFloat();

            //check if there is an available slot in the garage for this vehicle or not
            String ID=modulator.createVehicle(modelName, modelYear, uniqueID,vehicleWidth,vehicleDepth);
            if(ID!=""){
                System.out.println("\n\nGo to Slot '"+ID+"'\n\n");
            }
            else{
                System.out.println("\n\nSorry! The garage has no available slots for your car\n\n");
            }
        }
    }

    //chooseConfiguration to get Configuration from the customer   
    public void chooseConfiguration(){
        System.out.print("\nchoose one of the following configurations for parking (1) first come first (2) best fit: ");
		config_choice = input.nextInt();
    }
    
    //displayAvailableSlots to show available slots to the customer
    public void displayAvailableSlots(){
        if(modulator.slotsAvailable()==null){
            System.out.println("no available Slots\n");
        }
        else{
            System.out.println("\n\nAvailable slots\n");
            for(int i=0; i<modulator.slotsAvailable().length; i++){
                System.out.println(modulator.slotsAvailable()[i].getwidth() + " " + modulator.slotsAvailable()[i].getdepth() + " " + modulator.slotsAvailable()[i].getId()+"\n\n");
            }
        }
    }

    //displayTotalIncome to show total income to the customer
    public void displayTotalIncome(){
        System.out.println("\n\ntotal income= " +modulator.totalIncome()+"\n\n");		
    }
    public void displayTotalVehicles(){
        System.out.println("\n\ntotal vehicles= " +modulator.totalVehicle()+"\n\n");				
    }

    //displayParkOut to show fees to the customer
    public void displayParkOut(){ 
        System.out.print("enter your vehicle ID that you want to park out: " );  
        String Id = input.next();  
        int i=modulator.carParkOut(Id);
        if(i==0){
            System.out.println("\n\nthis car is not in the garage\n\n");
            return;
        } 
        System.out.println("\n\nFees depending on calculated hours: " +i+" EGP\n\n");
    }
    
    public int getFunChoice(){
        return funChoice;
    }

}
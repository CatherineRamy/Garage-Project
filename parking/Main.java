package parking;

public class Main {
	public static void main(String[] args) {
		MyScreen screen1=new MyScreen();
		
		
		screen1.open();		// function that has no implementation 
		screen1.chooseConfiguration();  	//it takes from the owner the type of configuration that the system will use during the parkin function..
		screen1.setUp();  // it gets the attributes needed for the park like slots and its status and is accessed by garage owner..
		while(true){
			screen1.menu();
			screen1.userChoice();
			if(screen1.getFunChoice()==1){
				screen1.setupCar();	// funtion that creates the park and sets its slots and info..
			}
			else if(screen1.getFunChoice()==2){
				screen1.displayParkOut();
			}
			else if(screen1.getFunChoice()==3){
				screen1.displayAvailableSlots(); //displaying IDs of the slots that don't have vehicles parking in it.. 1
			}
			else if(screen1.getFunChoice()==4){
				screen1.displayTotalIncome();
			}
			else if(screen1.getFunChoice()==5){
				screen1.displayTotalVehicles();
			}
			else{
				System.out.println("Wrong input try again");
				screen1.menu();
				screen1.userChoice();
			}
		}
	}
}
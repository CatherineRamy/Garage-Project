package parking;

public class Main {
	public static void main(String[] args) {
		//create an object to get input and show output to the customer 
		MyScreen screen1=new MyScreen(); 
		
		screen1.open();		
		screen1.chooseConfiguration();  	
		screen1.setUp(); 
		while(true){
			screen1.menu();
			screen1.userChoice();
			if(screen1.getFunChoice()==1){
				screen1.setupCar();	
			}
			else if(screen1.getFunChoice()==2){
				screen1.displayParkOut();
			}
			else if(screen1.getFunChoice()==3){
				screen1.displayAvailableSlots(); 
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
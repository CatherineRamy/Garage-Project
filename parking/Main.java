package parking;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
		screen s=new screen();
		s.open();		// function that has no implementation 
		s.SetUp();		// it gets the attributes needed for the park like slots and its status and is accessed by garage owner..
		s.chooseConfiguration();	//it takes from the owner the type of configuration that the system will use during the parkin function..
		s.createPark();		// funtion that creates the park and sets its slots and info..
		s.createVehicle();	// it creates objects from type vehicle that will use the garage..
		s.displayAvailable(); //displaying IDs of the slots that don't have vehicles parking in it.. 
	}
}
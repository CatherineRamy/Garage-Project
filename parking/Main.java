package parking;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
		Screen screen1=new Screen();
		screen1.open();		// function that has no implementation 
		screen1.SetUp();		// it gets the attributes needed for the park like slots and its status and is accessed by garage owner..
		screen1.chooseConfiguration();	//it takes from the owner the type of configuration that the system will use during the parkin function..
		screen1.createGarage();		// funtion that creates the park and sets its slots and info..
		screen1.createVehicle();	// it creates objects from type vehicle that will use the garage..
		screen1.displayAvailable(); //displaying IDs of the slots that don't have vehicles parking in it.. 
	}
}
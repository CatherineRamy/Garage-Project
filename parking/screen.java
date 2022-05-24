package parking;

import java.util.Date;
import java.util.Scanner;

public class screen implements Vehicle, Park, Slot{
    private int nSlots;//number of slots of garage
    private int ch; // the configuration choice
    private Slots[] SlotsArray; // array of objects of type slots that stores all garage slots..
    Scanner input;
    Park p;
    Car c;

    public void open(){};

    public void SetUp(){
        System.out.print("enter the number of slots: ");
		input = new Scanner(System.in);
        nSlots = input.nextInt();
		SlotsArray = new Slots[nSlots];
		System.out.println("enter the width, depth, ID of the slot");
		for (int i = 0; i < nSlots; i++) {
			float width = input.nextFloat();
			float depth = input.nextFloat();
			String Id = input.next();
			SlotsArray[i] = new Slots(width, depth, Id);
			SlotsArray[i].setStatus(false);
		}
    }
    public void chooseConfiguration(){
        System.out.print("choose one of the following configurations for parking (1) first come first (2) best fit: ");
		ch = input.nextInt();
    }
    public void createPark(){
        p = new ParkDetails(nSlots, SlotsArray, ch);
    }
    public void createVehicle(){
        c = new Car("ll", "12w", 2012, 3, 4, "");
		p.parkIn(c);
    }
    public void displayAvailable(){
		System.out.println("Available slots");
		p.displayAvailableSlots();
    }
    public void displayTotalIncome(){
		
    }
    public void displayTotalVehicles(){
		
    }
    public void out(){
		
    }




    
    @Override
    public void displayAvailableSlots() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getCapacity() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getOwnerChoice() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Slots getSlots(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Date getStartDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public float getVehicleDepth() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getVehicleWidth() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setStartDate(Date arrivalDate) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String chooseSlot(Vehicle v) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean getStatus() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public float getdepth() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getwidth() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isFull(Vehicle v) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void parkIn(Vehicle veh) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setData(float sW, float sD, String sId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setStatus(boolean status) {
        // TODO Auto-generated method stub
        
    }

}

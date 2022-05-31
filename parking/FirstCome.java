package parking;

public class FirstCome implements Configuration {

    @Override
    public String parking(Garage garage2, MySlots[] garageSlots, Vehicle parkInVehicle){
        String ID = "";
        for (int i = 0; i < garage2.getCapacity(); i++) {// loop to get first available and suitable slot
            if (!garage2.getSlots(i).getStatus())// this means that the slot is empty
            {
                if (garage2.getSlots(i).getwidth() >= parkInVehicle.getVehicleWidth()
                        && garage2.getSlots(i).getdepth() >= parkInVehicle.getVehicleDepth()) {// to check if the dimentions
                                                                                        // of slot suitable for the
                                                                                        // entering vehicle..
                    garage2.getSlots(i).setStatus(true);
                    ID =garage2.getSlots(i).getId();// set the returning string id of the slot thst is assigned to the
                                                // vehicle..
                    break;// it exit the loop when the vehicle is assigned successfuly to a slot..
                }

            }
        }
        return ID;
    }
    
}

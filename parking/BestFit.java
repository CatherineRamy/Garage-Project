package parking;

public class BestFit implements Configuration {

    public String parking(Garage garage2, MySlots[] garageSlots, Vehicle parkInVehicle) {
        String ID = "";
        // sorting function to sort the slots according to thier width value..
        for (int i = 0; i < garage2.getCapacity(); i++) {
            for (int j = i + 1; j < garage2.getCapacity(); j++) {
                MySlots temp;
                if (garageSlots[j].getwidth() < garageSlots[i].getwidth()) {
                    temp = garageSlots[i];
                    garageSlots[i] = garageSlots[j];
                    garageSlots[j] = temp;
                }
            }
        } // end of the width-based sort

        //the following is another loop to re sort the sorted array of slots accourding to thier depth that have same width value...
        int b = 0, i = 0;
        while (b < garage2.getCapacity() - 1) {
            MySlots tmp = garageSlots[b];
            while (garageSlots[b].getwidth() == tmp.getwidth() && b < garage2.getCapacity() - 1) {
                b++;
            }
            for (; i < b; i++) {
                for (int j = i + 1; j < b; j++) {
                    MySlots temp;
                    if (garageSlots[j].getdepth() < garageSlots[i].getdepth()) {
                        temp = garageSlots[i];
                        garageSlots[i] = garageSlots[j];
                        garageSlots[j] = temp;
                    }
                }
            }
        }

        // loop to get a suitable slot based on best fit configuration
        for (int k = 0; k < garage2.getCapacity(); k++) {
            if (!garageSlots[k].getStatus())// this means that the slot is empty
            {
                // to check if the dimentions of slot suitable for the entering vehicle..
                if (garageSlots[k].getwidth() >= parkInVehicle.getVehicleWidth()
                        && garageSlots[k].getdepth() >= parkInVehicle.getVehicleDepth()) {
                    garageSlots[k].setStatus(true);
                    ID = garageSlots[k].getId();// set the returning string id of the slot thst is assigned to the vehicle..
                    break;// it exit the loop when the vehicle is assigned successfuly to a slot..
                }
            }
        }
        return ID;

    }

}

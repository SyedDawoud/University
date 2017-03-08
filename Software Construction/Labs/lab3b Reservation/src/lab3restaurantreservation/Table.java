
package lab3restaurantreservation;

import java.util.HashMap;

/**
 *
 * @author Dawoud Ali
 */
public class Table {
    // Tells What type of table is,its capacity, the time slots and which slot is available
    private String type;
    private int capacity;
    private boolean availability;
    HashMap<Integer,String> timeSlots;       // This Map shows the slots
    HashMap<Integer,Boolean> slotAcquired; // Checks which slots have been acquired
    
    int slotTracker;     // Track which slots have been used
    
    Table(String t,int c){
        this.type=t;
        this.capacity=c;
        timeSlots=new HashMap<Integer,String>();
        slotAcquired=new HashMap<Integer,Boolean>();
        availability=true;
        
        // Setting Up the Time Slots
        timeSlots.put(0,"10-11");
        timeSlots.put(1,"11-12");
        timeSlots.put(2,"12-13");
        timeSlots.put(3,"13-14");
        timeSlots.put(4,"14-15");
        timeSlots.put(5,"15-16");
        timeSlots.put(6,"16-17");
        timeSlots.put(7,"17-18");
        timeSlots.put(8,"18-19");
        timeSlots.put(9,"19-20");
        timeSlots.put(10,"21-22");
        timeSlots.put(11,"22-23");
        // First, all the slots aren't acquired
        for(int k=0;k<slotAcquired.size();k++){
            slotAcquired.put(k, Boolean.FALSE);
        }
        
        slotTracker=0;
    }

    // Reserving the Slot
    public boolean reserveSlot(){
        // If reach the 12, no more reservation
        if(this.slotTracker ==12){
            return false;
        }
        else{
            // Otherwise, give the current slot and move the slot accordingly
            this.slotAcquired.put(this.slotTracker, Boolean.TRUE);
            this.slotTracker++;
            return true;
        }
    }
// Since we are changing the slot in reservation
    public int getSlotTracker() {
        return slotTracker;
    }
    
    public String getSlot(int s){
        return this.timeSlots.get(s);
    }
    
    // Getter and Setters of Capacity and the Type
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if(capacity > 0)
        this.capacity = capacity;
        
        else{ 
            this.availability=false;
            
        }
            //throw new IllegalArgumentException("Invalid Agrument");}
        
    }

    public boolean isAvailability() {
        return availability;
    }

    
    public void setType(String type) {
        this.type = type;
    }

   public String getType() {
        return type;
    }
    
    
    
}

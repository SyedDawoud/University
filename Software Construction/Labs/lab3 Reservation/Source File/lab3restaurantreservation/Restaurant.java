
package lab3restaurantreservation;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Dawoud Ali
 * @ This class will deal with different features and services available for the restaurant
 */
public class Restaurant {
    //Name of Restuarant, Number of Chefs, Waiters and Available Time
    private String name;
    private int numberOfChef;
    private int numberOfServers;
    private String timing;
    //Tables and Capacity, Xtra Large, Large, Medium and Small
    private int numberOfXLTables;
    private int XLcapacity;
    private int numberOfLTables;
    private int Lcapacity;
    private int numberOfMTables;
    private int Mcapacity;
    private int numberOfSTables;
    private int Scapacity;
    // How much wait time for Order, Time to create Order, eatTime, Where is current time slot
    private String waitTimeTotal; // This is when all tables are occupied and people will wait based on reservations4
    private String cookTime;
    private String eatTime;
    private String currentTimeFrame; // Using This Time, the next reservations will be made
    // Number of Special Reservations that can be made
    private int specialReservations;
    // Menus
    private Vector<String>soups;
    private Vector<String>appetizers;
    private Vector<String>mainCourse;
    private Vector<String>sideDishes;
    private Vector<String>desserts;

    // Only Setting Up with Name
    public Restaurant(String name) {
        this.name = name;
        
        soups=new Vector();
        appetizers=new Vector();
        mainCourse=new Vector();
        sideDishes=new Vector();
        desserts=new Vector();
        this.setUpMenu();
        this.setUpTimer();
        
        this.specialReservations=1;
    }

    public Restaurant(String name, int numberOfChef, int numberOfServers, String timing, int numberOfXLTables, int XLcapacity, int numberOfLTables, int Lcapacity, int numberOfMTables, int Mcapacity, int numberOfSTables, int Scapacity) {
        this.name = name;
        this.numberOfChef = numberOfChef;
        this.numberOfServers = numberOfServers;
        this.timing = timing;
        this.numberOfXLTables = numberOfXLTables;
        this.XLcapacity = XLcapacity;
        this.numberOfLTables = numberOfLTables;
        this.Lcapacity = Lcapacity;
        this.numberOfMTables = numberOfMTables;
        this.Mcapacity = Mcapacity;
        this.numberOfSTables = numberOfSTables;
        this.Scapacity = Scapacity;
        
        soups=new Vector();
        appetizers=new Vector();
        mainCourse=new Vector();
        sideDishes=new Vector();
        desserts=new Vector();
        
        this.setUpMenu();
        this.setUpTimer();
        
        this.specialReservations=1;
    }
    
    public void setUpMenu(){
        this.soups.add("Chicken Corn");
        this.soups.add("Chicken Cream Special");
        
        this.appetizers.add("Brown Bread");
        this.appetizers.add("Brown Bread V2:Rice Filler");
        this.appetizers.add("Brown Bread V3:Nutella");
        this.appetizers.add("Brown Bread V4:Chicken Rolled");
        
        this.sideDishes.add("Side Dish 1");
        this.sideDishes.add("Voice Special");
        this.sideDishes.add("Pokeon Baked Pasta");
        
        this.desserts.add("Ice Cream");
        this.desserts.add("Jelly Bean");
        this.desserts.add("Kit Kat");
        this.desserts.add("Gingerbread");
        
        this.mainCourse.add("Hot & Spicy Pizza");
        this.mainCourse.add("Chicken Haandi");
        this.mainCourse.add("Egg Fried Duck");
        this.mainCourse.add("Boiled Potato Crisp");
        this.mainCourse.add("La Manzana");
        this.mainCourse.add("Beef Filled Chicken");
        this.mainCourse.add("Aaloo Naan");
        this.mainCourse.add("Mushroom Naan");
        this.mainCourse.add("Pikachu Rice");
        this.mainCourse.add("Dragonite Rice");
        this.mainCourse.add("Grassy Rice");
        this.mainCourse.add("Smoky Rice");
    }

    private void setUpTimer() {
        
        this.waitTimeTotal="";
        this.cookTime="1";
        this.eatTime="1";
        this.currentTimeFrame="";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfChef() {
        return numberOfChef;
    }

    public void setNumberOfChef(int numberOfChef) {
        this.numberOfChef = numberOfChef;
    }

    public int getNumberOfServers() {
        return numberOfServers;
    }

    public void setNumberOfServers(int numberOfServers) {
        this.numberOfServers = numberOfServers;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public int getNumberOfXLTables() {
        return numberOfXLTables;
    }

    public void setNumberOfXLTables(int numberOfXLTables) {
        if(numberOfXLTables >=0)
        this.numberOfXLTables = numberOfXLTables;
        
        else throw new IllegalArgumentException("Can't Reserve");
    }

    public int getXLcapacity() {
        return XLcapacity;
    }

    public void setXLcapacity(int XLcapacity) {
        if(XLcapacity > 0)
        this.XLcapacity = XLcapacity;
        
        else throw new IllegalArgumentException("Can't Reserve");
    }

    public int getNumberOfLTables() {
        return numberOfLTables;
    }

    public void setNumberOfLTables(int numberOfLTables) {
        if (numberOfLTables>=0)
        this.numberOfLTables = numberOfLTables;
        
        else throw new IllegalArgumentException("Can't Reserve");
    }

    public int getLcapacity() {
        return Lcapacity;
    }

    public void setLcapacity(int Lcapacity) {
        this.Lcapacity = Lcapacity;
    }

    public int getNumberOfMTables() {
        return numberOfMTables;
    }

    public void setNumberOfMTables(int numberOfMTables) {
        if (numberOfMTables >=0)
        this.numberOfMTables = numberOfMTables;
        
        else throw new IllegalArgumentException("Can't Reserve");
    }

    public int getMcapacity() {
        return Mcapacity;
    }

    public void setMcapacity(int Mcapacity) {
        this.Mcapacity = Mcapacity;
    }

    public int getNumberOfSTables() {
        return numberOfSTables;
    }

    public void setNumberOfSTables(int numberOfSTables) {
        if (numberOfSTables >=0)
        this.numberOfSTables = numberOfSTables;
        
        else throw new IllegalArgumentException("Can't Reserve");
    }

    public int getScapacity() {
        return Scapacity;
    }

    public void setScapacity(int Scapacity) {
        this.Scapacity = Scapacity;
    }

    public String getWaitTimeTotal() {
        return waitTimeTotal;
    }

    public void setWaitTimeTotal(String waitTimeTotal) {
        this.waitTimeTotal = waitTimeTotal;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public String getEatTime() {
        return eatTime;
    }

    public void setEatTime(String eatTime) {
        this.eatTime = eatTime;
    }

    public String getCurrentTimeFrame() {
        return currentTimeFrame;
    }

    public void setCurrentTimeFrame(String currentTimeFrame) {
        this.currentTimeFrame = currentTimeFrame;
    }

    public int getSpecialReservations() {
        return specialReservations;
    }

    public void setSpecialReservations(int specialReservations) {
        this.specialReservations = specialReservations;
    }

    public Vector<String> getSoups() {
        return soups;
    }

    public void setSoups(Vector<String> soups) {
        this.soups = soups;
    }

    public Vector<String> getAppetizers() {
        return appetizers;
    }

    public void setAppetizers(Vector<String> appetizers) {
        this.appetizers = appetizers;
    }

    public Vector<String> getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(Vector<String> mainCourse) {
        this.mainCourse = mainCourse;
    }

    public Vector<String> getSideDishes() {
        return sideDishes;
    }

    public void setSideDishes(Vector<String> sideDishes) {
        this.sideDishes = sideDishes;
    }

    public Vector<String> getDesserts() {
        return desserts;
    }

    public void setDesserts(Vector<String> desserts) {
        this.desserts = desserts;
    }

    
    
    
    
    
    
    
    
    
    
}
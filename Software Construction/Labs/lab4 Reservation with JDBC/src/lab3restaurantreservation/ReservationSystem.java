
package lab3restaurantreservation;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ReservationSystem {
    
    private Restaurant myRes;

    public Restaurant getMyRes() {
        return myRes;
    }

    public void setMyRes(Restaurant myRes) {
        this.myRes = myRes;
    }

    public Vector<ReservationContact> getReservationContact() {
        return reservationContact;
    }

    public void setReservationContact(Vector<ReservationContact> reservationContact) {
        this.reservationContact = reservationContact;
    }
    
    private Vector<ReservationContact> reservationContact;
    
    ReservationSystem(){
        
        myRes=new Restaurant("Hello Hello Restaurant",4,6,"11-22",1,12,3,6,8,4,4,2);
        myRes.setCurrentTimeFrame("11");
        reservationContact=new Vector();
    }
    
    
    // Based on People in the Reservation,
    // First it will be checked that whether particular table is available or not
    // If not, set time accordingly
    public boolean XLTableAvailability(){
        if (myRes.getNumberOfXLTables() > 0)
                return true;
        else return false;
        
    }
    // Availability of Large Table
//     public boolean LTableAvailability(){
//        if (myRes.getNumberOfLTables() > 0)
//                return true;
//        else return false;
//        
//    }
//     // Availability of Medium Table
//      public boolean MTableAvailability(){
//        if (myRes.getNumberOfMTables() > 0)
//                return true;
//        else return false;
//        
//    }
//      // Availability of Small Sized Tables
//       public boolean STableAvailability(){
//        if (myRes.getNumberOfSTables() > 0)
//                return true;
//        else return false;
//        
//    }
    // So Person will have to wait from current time Frame to time others will eat
    public String calculateTotalWaitTime(){
        
        return Integer.toString(Integer.parseInt(myRes.getEatTime())+ Integer.parseInt(myRes.getCurrentTimeFrame()) + 1);
        
    }
    
    // Whenever new order is made, the time frame is updated using== Current Time Frame + cookTime
    public void updateCurrentTimeFrame(){
         myRes.setCurrentTimeFrame(Integer.toString(Integer.parseInt(myRes.getCookTime()) +Integer.parseInt(myRes.getCurrentTimeFrame())));
    }
       
    // Decide which table to give to what number of people
    public String DecideTable(int people){
        String table="";
        if(people <= 12 && people >6 ){
            this.myRes.setNumberOfXLTables(myRes.getNumberOfXLTables()-1);
            table= "XL";}
            
            else if (people <=6 && people >4){
                    //myRes.setNumberOfLTables(myRes.getNumberOfLTables()-1);
                    table= "L";
                    } 
         else if (people <=4 && people >2){
                   // myRes.setNumberOfMTables(myRes.getNumberOfMTables()-1);
                    table= "M";
                    } 
         else if (people ==2 || people ==1){
                   // myRes.setNumberOfSTables(myRes.getNumberOfSTables()-1);
                    table="S";
                    } 
        return table;
    }
    
     // Handle the Reservation Process
    public String reservation(String personName,String personContact,String personOrder,int people) throws SQLException, ClassNotFoundException{
        
        
       ReservationContact newContact=new ReservationContact(personName,personContact);
       
       String message="";
       
        if(people > 12) // No longer than XL
                message= "We don't Offer reservations for greater than 12 people. Sorry";
       
        if(people <=0) // Incase there is order with Zero or Less than zero people
            message="Please Stop Teasing With US";
        
        // If all tables are occupied
//       if(this.XLTableAvailability()==false && this.LTableAvailability()==false && this.MTableAvailability()==false && this.STableAvailability()==false){
//           
//           
//           newContact.setOrder(personOrder);
//           newContact.setPersonReserved(people);
//           newContact.setBill(Integer.toString(people * 1000));
//           newContact.setTable(this.DecideTable(people));
//           // Since no table is available, so we update the Time Frame
//           this.updateCurrentTimeFrame();
//           message="All Tables are Occupied. You will have to wait\n"+this.calculateTotalWaitTime() + "hours";
//          reservationContact.add(newContact);
//       }
       
       String table=this.DecideTable(people);
       // If tables are there, add it to List Accordingly
       if(table=="XL"){
           message="For Our Special Guest! We shall give you special Time";
           newContact.setOrder(personOrder);
           newContact.setPersonReserved(people);
           newContact.setBill(Integer.toString(people * 1000));
           newContact.setTable("XL");
           newContact.setTime("10:30PM Special");
           reservationContact.add(newContact);
       }
       else if(table=="L"||table=="M"||table=="S"){
           message="Reservation Made. Please See Your Time on Reservation List";
           newContact.setOrder(personOrder);
           newContact.setPersonReserved(people);
           newContact.setBill(Integer.toString(people * 1000));
           newContact.setTable(table);
           
           if(table=="L"){
               newContact.setSlot(myRes.reserveLTable());
           }
            if(table=="M"){
               newContact.setSlot(myRes.reserveMTable());
           }
             if(table=="S"){
               newContact.setSlot(myRes.reserveSTable());
           }
           
           newContact.setTime(Integer.toString(Integer.parseInt(myRes.getCurrentTimeFrame()))+":00");
           
            this.updateCurrentTimeFrame();
           this.reservationContact.add(newContact);
           
           DatabaseConnector db=new DatabaseConnector();
           
           int size=db.dataSize("select * from users where username=?", personName, "", "");
           System.out.print(size);
           // User Not Registered
           if(size==0){
               
               
                PreparedStatement ps=(db.getCon()).prepareStatement("insert into users(username,password,userType)values(?,'123','Customer')");
          
               ps.setString(1, personName);
               ps.executeUpdate();
               db.LogData("User Created",personName);
               
               PreparedStatement ps2=(db.getCon()).prepareStatement("insert into reservation(name,time,people,reservedTable,orderDetails)values(?,?,?,?,?)");
          
               ps2.setString(1, newContact.getName());
               ps2.setString(2, newContact.getTime());
               ps2.setInt(3, newContact.getPersonReserved());
               
               ps2.setString(4, newContact.getTable());
               ps2.setString(5, newContact.getOrder());
               
               ps2.executeUpdate();
               
               db.LogData("Data Inserted by ", personName);
              
           }
           else{
               
               PreparedStatement ps=(db.getCon()).prepareStatement("insert into reservation(name,time,people,reservedTable,orderDetails)values(?,?,?,?,?)");
          
               ps.setString(1, newContact.getName());
               ps.setString(2, newContact.getTime());
               ps.setInt(3, newContact.getPersonReserved());
               
               ps.setString(4, newContact.getTable());
               ps.setString(5, newContact.getOrder());
               
               ps.executeUpdate();
               
               db.LogData("Data Inserted by ", personName);
           }
           
           
           
          
       }
       
        return message;
    }
    
}

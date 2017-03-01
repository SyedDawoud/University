/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3restaurantreservation;


/**
 * 
 * @author Dawoud Ali
 * This Class Provides Information of the person placing the reservation.
 * This tells names, his/her contact number
 * the order, which table was assigned
 * and how many people were there for which reservation was made
 */
public class ReservationContact {
 
    private String name;
    private String contact;
    private String order;
    private String table;

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }
    private String time;
    private String bill;

    public int getPersonReserved() {
        return personReserved;
    }

    public void setPersonReserved(int personReserved) {
        this.personReserved = personReserved;
    }
    private int personReserved;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
    public ReservationContact(String person,String contact){
        this.name=person;
        this.contact=contact;
  
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
}

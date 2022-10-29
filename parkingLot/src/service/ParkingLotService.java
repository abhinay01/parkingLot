package service;

import Model.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotService {
    Ticket ticket;
    Vehicle vehicle;
    Admin admin;
    Issuer issuer;
    Payment payment;
    ParkingLot parkingLot;
    Boolean b=true;
    Map<Ticket,Vehicle> ticketVehicleMap;
    List<String> filledSlot;
    Map<Ticket,Payment> ticketPaymentMap;

    public ParkingLotService(ParkingLot parkingLot) {
        this.ticket=null;
        this.vehicle=null;
        this.admin=null;
        this.issuer=null;
        this.payment=null;
        this.parkingLot = parkingLot;
        this.ticketVehicleMap = new HashMap<>();
        this.ticketPaymentMap = new HashMap<>();
        this.filledSlot=new ArrayList<>();
    }

    private void parkingLotConfiguration()
    {
        //can be done by admin only
    }

    public String park(Vehicle vehicle){
        boolean capacity=checkCapacity();
        if(capacity==false)
            return "No empty Slot Available";
        String slotId=generateTicket(vehicle);
        System.out.println("Generated Ticket Id : "+slotId);
        return slotId;
    }
    public String getNextFreeSlot()
    {
        for(int i=0;i<parkingLot.getTotalSlot();i++)
        {
            if(!filledSlot.contains(Integer.toString(i)))
                return Integer.toString(i);
        }
        return "No empty Slot found";
    }
    public boolean checkCapacity()
    {
        if(filledSlot.size()<parkingLot.getTotalSlot())
            return true;
        return false;
    }
    public String generateTicket(Vehicle vehicle)
    {
        String slotId=getNextFreeSlot();
        if(slotId.equals("No empty Slot found"))
            return "error!!! slots are full";
        filledSlot.add(slotId);
        ticket=new Ticket(slotId,slotId, LocalTime.now());
        ticketVehicleMap.put(ticket,vehicle);
        return slotId;
    }
    public String unpark(String ticketId){
        Ticket ticket=null;
        Vehicle vehicle=null;
        for(Map.Entry<Ticket,Vehicle> entry:ticketVehicleMap.entrySet())
        {
            ticket=entry.getKey();
            if(ticket.getTicketId().equals(ticketId))
            {
//                System.out.println(ticketId);
//                System.out.println(ticket.getTicketId());
                vehicle=entry.getValue();
                break;
            }
        }
        if(ticket==null)
            return "No ticket found with this id";
//        Vehicle vehicle=findVehicleByTicket(ticket);
        if(vehicle==null)
            return "No vehicle Found!!!";
        Double amount=getAmount(vehicle,ticket);
        System.out.println("Amount to be paid "+amount);
        Boolean paymentSuccessful=collectPayment();
        if(paymentSuccessful==false)
            return "Error occured while paying";
        filledSlot.remove(ticket.getTicketId());
        ticketVehicleMap.remove(ticket);
        return ticket.getTicketId()+" is freed to be used";
    }

    private Boolean collectPayment() {
//        Payment=new Payment();
//        ticketPaymentMap.put(ticket,Payment);
        return true;
    }

    //    findVehicleByColour();
    //    findVehicleByNumber();
    public Vehicle findVehicleByTicket(Ticket ticket)
    {
        if(ticketVehicleMap.containsKey(ticket))
            return ticketVehicleMap.get(ticket);
        else return null;
    }
    public Double getAmount(Vehicle vehicle,Ticket ticket)
    {
        if(vehicle.getType().toString().equals("BIKE"))
        {
            Duration dur = Duration.between(LocalTime.now(), ticket.getEntrytime());
            long hours = dur.toHours();
            Double amount= 10.0;
            if(hours>24)
                amount+=(hours-24)*5;
            return amount;
        }
        else if(vehicle.getType().toString().equals("AUTO"))
        {
            Duration dur = Duration.between(LocalTime.now(), ticket.getEntrytime());
            long hours = dur.toHours();
            Double amount= 20.0;
            if(hours>24)
                amount+=(hours-24)*8;
            return amount;
        }
        else
        {
            Duration dur = Duration.between(LocalTime.now(), ticket.getEntrytime());
            long hours = dur.toHours();
            Double amount= 30.0;
            if(hours>24)
                amount+=(hours-24)*10;
            return amount;
        }
    }
}

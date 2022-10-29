package service;

import Model.Ticket;

import java.time.LocalTime;

public class TicketService {
    Ticket ticket;

    public Ticket addTicket(String ticketId,String slotNumber,LocalTime entrytime)
    {
        ticket=new Ticket(ticketId, slotNumber, entrytime);
        return ticket;
    }
}

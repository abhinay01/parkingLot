package Model;

import java.time.LocalTime;

public class Ticket {
    String ticketId;
    String slotNumber;
    LocalTime entrytime;

    String status;

    public Ticket(String ticketId,String slotNumber,LocalTime entrytime) {
        this.ticketId = ticketId;
        this.slotNumber=slotNumber;
        this.entrytime=entrytime;
        this.status="Issued";
    }

    public LocalTime getEntrytime() {
        return entrytime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public String getStatus() {
        return status;
    }
}

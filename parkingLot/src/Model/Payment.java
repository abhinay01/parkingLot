package Model;

public class Payment {
    String paymentId;
    Ticket ticket;
    String paymentChannel;

    public Payment(String paymentId, Ticket ticket, String paymentChannel) {
        this.paymentId = paymentId;
        this.ticket = ticket;
        this.paymentChannel = paymentChannel;
    }
}

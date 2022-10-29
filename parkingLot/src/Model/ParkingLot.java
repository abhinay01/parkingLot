package Model;

public class ParkingLot {
    int rows;
    int col;
    int TotalSlot;

    public ParkingLot(int rows, int col) {
        this.rows = rows;
        this.col = col;
        TotalSlot = rows*col;
    }

    public int getTotalSlot() {
        return TotalSlot;
    }
}

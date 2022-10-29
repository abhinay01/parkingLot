package Model;

public interface Vehicle {
    String color="";
    String number="";
    String model="";
    enum type{
        BIKE,
        AUTO,
        CAR
    };
    public type getType();
}

import Model.*;
import service.*;

public class parkingFacility {
    public static void main(String [] args)
    {
        AdminService adminService=new AdminService();
        CarService carService=new CarService();
        BikeService bikeService=new BikeService();
        AutoService autoService=new AutoService();
        ParkingLot parkingLot=new ParkingLot(10,10);
        ParkingLotService parkingLotService=new ParkingLotService(parkingLot);
        Vehicle bike=new Bike("Black","B101","Hero");
        String bikeSlotId1=parkingLotService.park(bike);
        System.out.println("TicketId : "+bikeSlotId1);
        Vehicle bike1=new Bike("White","B102","Honda");
        String bikeSlotId2=parkingLotService.park(bike1);
        System.out.println("TicketId : "+bikeSlotId2);
        Vehicle car1=new Car("Black","C101","Alto");
        String carSlotId1=parkingLotService.park(car1);
        System.out.println("TicketId : "+carSlotId1);
        Vehicle car2=new Car("White","C102","Mercedes");
        String carSlotId2=parkingLotService.park(car2);
        System.out.println("TicketId : "+carSlotId2);
        Vehicle auto1=new Auto("Yellow","A101","Bajaj");
        String autoSlotId1=parkingLotService.park(auto1);
        System.out.println("TicketId : "+autoSlotId1);
        Vehicle auto2=new Auto("Brown","A102","Mahindra");
        String autoSlotId2=parkingLotService.park(auto2);
        System.out.println("TicketId : "+autoSlotId2);
        System.out.println(parkingLotService.unpark(bikeSlotId1));
        String bikeSlotIdnext=parkingLotService.park(bike);
        System.out.println("TicketId : "+bikeSlotIdnext);
    }
}

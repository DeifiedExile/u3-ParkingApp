/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.parkingapp.FeeStrategy;

import java.time.LocalTime;
import lwolfs.u3.ParkingAppFinal.ITicketFactory;
import lwolfs.u3.ParkingAppFinal.Ticket;

/**
 * Returns a ticket based on given criteria
 * @author Lucas Wolfs <lwolfs@my.wctc.edu>
 */
public class TicketFactoryImpl implements ITicketFactory{

    @Override
    public Ticket getTicket(int id, LocalTime checkInTime, String feeType) {
        switch(feeType.toUpperCase())
        {
            case "STANDARD":
                return new Ticket(id, checkInTime, new StandardFee());
                
            case "EVENT":
                return new Ticket(id, checkInTime, new EventFee());
            case "LOST":
            default:
                return new Ticket(id, checkInTime, new LostFee());
        }
        
    }
    
}

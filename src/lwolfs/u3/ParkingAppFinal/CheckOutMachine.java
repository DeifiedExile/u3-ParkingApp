/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.ParkingAppFinal;

import java.time.LocalTime;

/**
 * Check out machine for closing tickets
 * @author Lucas Wolfs <lwolfs@my.wctc.edu>
 */
public class CheckOutMachine {
    
    /**
     * closes a ticket, setting checkout time
     * @param id
     * @return 
     */
    public Ticket checkOut(int id)
    {
        Ticket ticket = TicketData.INSTANCE.getTicket(id);
        if(ticket != null)
        {
            ticket.setCheckOutTime(TimeGenerator.getTime(13, 23));
        }
        return ticket;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.ParkingAppFinal;



/**
 * Check in machine for creating tickets
 * @author Lucas Wolfs lwolfs@my.wctc.edu
 */
public class CheckInMachine {
    
    private ITicketFactory factory;
    /**
     * Constructor. Accepts a ITicketFactory for ticket creation
     * @param factory ITicketFactory to use
     */
    public CheckInMachine(ITicketFactory factory)
    {
        this.factory = factory;
    }
    /**
     * Creates a ticket and adds it to TicketData's List
     * @param strategy Fee Strategy to use during ticket creation
     * @return Ticket created
     */
    public Ticket checkIn(String strategy)
    {
        Ticket ticket = factory.getTicket(TicketData.INSTANCE.getNextID(), TimeGenerator.getTime(7, 12) , strategy);
        TicketData.INSTANCE.addTicket(ticket);
        return ticket;
    }
}

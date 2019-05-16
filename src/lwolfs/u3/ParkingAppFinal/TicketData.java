/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.ParkingAppFinal;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton Enum for storing Ticket data list
 * @author Lucas Wolfs lwolfs@my.wctc.edu
 */
public enum TicketData {
    INSTANCE;
    
    private int TICKET_COUNT;
    private List<Ticket> ticketList;
    
    /**
     * Constructor. Initializes TICKET_COUNT and TICKET_LIST
     */
    private TicketData()
    {
        TICKET_COUNT = 0;
        ticketList = new ArrayList<Ticket>();
    }
    /**
     * Gets list of tickets
     * @return List of Ticket to return
     */
    public List<Ticket> getTicketList()
    {
        return ticketList;
    }
    /**
     * gets a single ticket
     * @param id ticket id to get
     * @return Ticket to return
     */
    public Ticket getTicket(int id)
    {
        for(Ticket t : ticketList)
        {
            if(t.getTicketID() == id)
            {
                return t;
            }
        }
        return null;
    }
    /**
     * Adds ticket to list
     * @param ticket Ticket to add to list
     */
    public void addTicket(Ticket ticket)
    {
        ticketList.add(ticket);
    }
    /**
     * Get next ticketID
     * @return next ticket id to return as int
     */
    public int getNextID()
    {
        int id = 1;
        boolean test = false;
//        if(!ticketList.isEmpty())
//        {
            id = ticketList.size();
//        }
        
        do
        {
            for(Ticket t : ticketList)
            {
                if(t.getTicketID() == id)
                {
                    id++;
                    test = true;
                }
            }
        }while(test);
        
        return id;
    }
    
}

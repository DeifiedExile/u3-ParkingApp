/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.parkingapp;

/**
 *
 * @author Lucas Wolfs <lwolfs@my.wctc.edu>
 */
public interface ITicket {
    /**
     * 
     * @return ticket fee
     */
    double getFee();    
    /**
     * 
     * @return ticket Type as string 
     */
    String getTicketType();
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.parkingapp.old;

import java.io.Serializable;

/**
 *
 * @author Lucas Wolfs <lwolfs@my.wctc.edu>
 */
public interface ITicket extends Serializable {
    /**
     * Lost ticket fee
     */
    double LOST_TICKET_FEE = 25.00;

    /**
     * Base fee for calculations
     */
    double BASE_FEE_RATE = 5.00;

    /**
     * Rate per hour for standard Tickets
     */
    double RATE_PER_HOUR = 1.00;

    /**
     * Minimum time for standard tickets
     */
    int MIN_PARKING_TIME = 3;

    /**
     * Maximum fee for standard tickets
     */
    double MAX_FEE = 15.00;
    /**
     * 
     * @return ticket fee
     */
    double getFee();        
    /**
     *
     * @return returns fee for lost tickets
     */
    double getLOST_TICKET_FEE();

    /**
     *
     * @return returns base fee rate for standard tickets
     */
    double getBASE_FEE_RATE();

    /**
     *
     * @return returns rate per hour for standard tickets
     */
    double getRATE_PER_HOUR();

    /**
     *
     * @return returns minimum parking time for standard times
     */
    int getMIN_PARKING_TIME();

    /**
     *
     * @return returns ticket id
     */
    int getTicketID();

    /**
     *
     * @return returns ticket type as string
     */
    String getTicketType();

    
    
}

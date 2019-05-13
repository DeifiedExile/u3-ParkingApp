/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lwolfs.u3.parkingapp.old;

import java.io.Serializable;

/**
 *
 * @author Exile
 */
public class LostTicket implements Serializable, ITicket {
    private final int TICKET_ID;
    private TicketType type = TicketType.LOST;

    /**
     *
     * @param TICKET_ID
     * @param isPaid
     */
    public LostTicket(int TICKET_ID, boolean isPaid) {
        this.TICKET_ID = TICKET_ID;
    }

    /**
     *
     * @return
     */
    public int getTicketID()
    {
        return TICKET_ID;
    }

    /**
     *
     * @return
     */
    public String getTicketType()
    {
        return type.toString();
    }
    /**
     *
     * @return
     */
    public int getTICKET_ID() {
        return TICKET_ID;
    }

    /**
     *
     * @return
     */
    @Override
    public double getLOST_TICKET_FEE() {
        return LOST_TICKET_FEE;
    }

    /**
     *
     * @return
     */
    @Override
    public double getBASE_FEE_RATE() {
        return BASE_FEE_RATE;
    }

    /**
     *
     * @return
     */
    @Override
    public double getRATE_PER_HOUR() {
        return RATE_PER_HOUR;
    }

    /**
     *
     * @return
     */
    @Override
    public int getMIN_PARKING_TIME() {
        return MIN_PARKING_TIME;
    }

    @Override
    public double getFee() {
        return LOST_TICKET_FEE;
    }
    
    
    
    
    

}

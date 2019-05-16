/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.ParkingAppFinal;

import java.io.Serializable;
import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;

/**
 *
 * @author Lucas Wolfs <lwolfs@my.wctc.edu>
 */
public class Ticket implements Serializable {
    
    private FeeStrategy feeStrategy;
    private final int ticketID;
    private final LocalTime CHECK_IN_TIME;
    private LocalTime checkOutTime = null;
    
    /**
     * Constructor for Tickets. 
     * @param id ticket id as int
     * @param checkInTime Time of check in as LocalTime
     * @param strategy FeeStrategy to use for ticket
     */
    public Ticket(int id, LocalTime checkInTime, FeeStrategy strategy)
    {
        this.ticketID = id;
        this.CHECK_IN_TIME = checkInTime;
        this.feeStrategy = strategy;
    }
    
    
    /**
     * sets fee strategy
     * @param feeStrat fee strategy to set
     */
    public void setFeeStrategy(FeeStrategy feeStrat)
    {
        this.feeStrategy = feeStrat;
    }
    /**
     * returns fee strategy
     * @return fee strategy of ticket to return
     */
    public FeeStrategy getFeeStrategy()
    {
        return this.feeStrategy;
    }
    /**
     * returns minimum fee of ticket's fee strategy
     * @return double fee to return
     */
    public double getMinimumFee()
    {
        return this.feeStrategy.getMinFee();
    }
    /**
     * returns ticket id
     * @return ticket id as int
     */
    public int getTicketID()
    {
        return this.ticketID;
    }

    /**
     * returns check in time
     * @return check in time as LocalTime
     */
    public LocalTime getCHECK_IN_TIME() {
        return CHECK_IN_TIME;
    }

    /**
     * gets check out time
     * @return LocalTime checkOutTime
     */
    public LocalTime getCheckOutTime() {
        if(checkOutTime != null)
        {
            return checkOutTime;
        }
        else
        {
            return null;
        }
        
    }

    /**
     * sets check out time
     * @param checkOutTime LocalTime check out time 
     */
    public void setCheckOutTime(LocalTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
    /**
     * gets fee for ticket
     * @return fee as double
     */
    public double getFee()
    {
        return this.feeStrategy.getFee(getHoursParked());
    }
    /**
     * Gets hours parked
     * @return hours parked as int rounded up
     */
    private int getHoursParked()
    {
        return (int)Math.ceil(MINUTES.between(CHECK_IN_TIME, checkOutTime)/60);
    }
    /**
     * String output for check in purposes
     * @return String to output
     */
    public String toCheckInString()
    {
        String output = String.format("Ticket Created.\nTicket ID: %d\nCheck In Time: %s", this.ticketID, this.CHECK_IN_TIME.toString());
        
        return output;
    }
    
    /**
     * String output for receipt purposes
     * @return receipt string
     */
    public String toCheckOutString()
    {
        String output = String.format("Receipt for Vehicle ID %d\n\n", this.ticketID);
        String info = String.format("%d Hours Parked   %s - %s", this.getHoursParked(), this.CHECK_IN_TIME.toString(), this.checkOutTime.toString());
        info = this.feeStrategy.toReceiptString(info, getHoursParked());
        output = output + info;
        return output;
    }
    /**
     * Returns type of fee strategy
     * @return fee type
     */
    public String getFeeType()
    {
        return this.feeStrategy.toTypeString();
    }
    
    
    
    
    
    
}

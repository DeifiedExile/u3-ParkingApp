/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.parkingapp.FeeStrategy;


import lwolfs.u3.ParkingAppFinal.FeeStrategy;
import lwolfs.u3.ParkingAppFinal.Ticket;

/**
 * Standard ticket fee strategy
 * @author Lucas Wolfs lwolfs@my.wctc.edu
 */
public class StandardFee implements FeeStrategy {
    private final double MINIMUM_FEE = 5.00;
    private final double MAXIMUM_FEE = 15.00;
    private final int MINIMUM_HOURS = 3;

    /**
     * returns minimum fee amount
     * @return minimum fee
     */
    @Override
    public double getMinFee() {
        return this.MINIMUM_FEE;
    }

    /**
     * returns max fee amount
     * @return max fee
     */
    @Override
    public double getMaxFee() {
        return MAXIMUM_FEE;
    }

    /**
     * retrieves fee for closed ticket
     * @param hours number of billable hours
     * @return calculated fee
     */
    @Override
    public double getFee(int hours) {
        
        double fee = 0;
        if(hours>MINIMUM_HOURS)
        {
            fee += MINIMUM_FEE;
            fee += hours - MINIMUM_HOURS;
            if(fee >= MAXIMUM_FEE)
            {
                return MAXIMUM_FEE;
            }
            else
            {
                return fee;
            }
        }
        else
        {
            return MINIMUM_FEE;
        }
    }

    /**
     * returns a string for printing of receipt
     * @param receiptString Receipt string to concatenate on to
     * @param hours number of billable hours parked
     * @return completed receipt string
     */
    @Override
    public String toReceiptString(String receiptString, int hours) {
        String receipt = String.format("%s\n$%2.2f", receiptString, getFee(hours));
        return receipt;
    }

    /**
     * returns String of fee type
     * @return String of fee type
     */
    @Override
    public String toTypeString() {
        return "standard";
    }
    
    
    


    
    
}

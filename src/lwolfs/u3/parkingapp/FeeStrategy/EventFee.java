/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.parkingapp.FeeStrategy;

import lwolfs.u3.ParkingAppFinal.FeeStrategy;

/**
 * Event ticket fee strategy
 * @author Lucas Wolfs lwolfs@my.wctc.edu
 */
public class EventFee implements FeeStrategy {

    private final double FEE = 20;
    /**
     * returns minimum fee amount
     * @return minimum fee
     */
    @Override
    public double getMinFee() {
        return this.FEE;
    }

    /**
     * returns max fee amount
     * @return max fee
     */
    @Override
    public double getMaxFee() {
        return this.FEE;
    }

    /**
     * retrieves fee for closed ticket
     * @param hours number of billable hours
     * @return calculated fee
     */
    @Override
    public double getFee(int hours) {
        return this.FEE;
    }
    /**
     * returns a string for printing of receipt
     * @param receiptString Receipt string to concatenate on to
     * @param hours number of billable hours parked
     * @return completed receipt string
     */
    @Override
    public String toReceiptString(String receiptString, int hours) {
        String receipt = String.format("Special Event\n$%2.2f", getFee(hours));
        return receipt;
    }

    /**
     * returns String of event fee type
     * @return String of fee type
     */
    @Override
    public String toTypeString() {
        return "event";
    }
}

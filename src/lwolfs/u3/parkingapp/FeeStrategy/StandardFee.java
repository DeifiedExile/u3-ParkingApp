/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.parkingapp.FeeStrategy;


import lwolfs.u3.ParkingAppFinal.FeeStrategy;
import lwolfs.u3.ParkingAppFinal.Ticket;

/**
 *
 * @author Lucas Wolfs <lwolfs@my.wctc.edu>
 */
public class StandardFee implements FeeStrategy {
    private final double MINIMUM_FEE = 5.00;
    private final double MAXIMUM_FEE = 15.00;
    private final int MINIMUM_HOURS = 3;

    @Override
    public double getMinFee() {
        return this.MINIMUM_FEE;
    }

    @Override
    public double getMaxFee() {
        return MAXIMUM_FEE;
    }

    
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


    
    
}

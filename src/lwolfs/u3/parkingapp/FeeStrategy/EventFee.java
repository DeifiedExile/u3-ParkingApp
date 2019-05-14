/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.parkingapp.FeeStrategy;

import lwolfs.u3.ParkingAppFinal.FeeStrategy;

/**
 *
 * @author Lucas Wolfs <lwolfs@my.wctc.edu>
 */
public class EventFee implements FeeStrategy {

    private final double FEE = 20;
    @Override
    public double getMinFee() {
        return this.FEE;
    }

    @Override
    public double getMaxFee() {
        return this.FEE;
    }

    @Override
    public double getFee(int hours) {
        return this.FEE;
    }
    
}

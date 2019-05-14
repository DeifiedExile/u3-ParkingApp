/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.ParkingAppFinal;

/**
 * Fee Strategy for standard tickets
 * @author Lucas Wolfs <lwolfs@my.wctc.edu>
 */
public interface FeeStrategy {
    /**
     * Returns minimum fee
     * @return minimum fee amount as double
     */
    double getMinFee();
    /**
     * returns maximum fee
     * @return max fee amount as double
     */
    double getMaxFee();
    /**
     * returns actual fee
     * @return fee as double
     */
    double getFee(int hours);
}

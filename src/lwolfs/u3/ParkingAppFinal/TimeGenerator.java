/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.ParkingAppFinal;

import java.time.LocalTime;
import java.util.Random;

/**
 * Generates a time for check in and check out
 * @author Lucas Wolfs lwolfs@my.wctc.edu
 */
public enum TimeGenerator {
    INSTANCE;
    
    private TimeGenerator()
    {
        
    }
    /**
     * returns a random LocalTime between startHour inclusive and endHour exclusive
     * @param startHour lower bound
     * @param endHour upper bound
     * @return LocalTime to return
     */
    public static LocalTime getTime(int startHour, int endHour)
    {
        Random random = new Random();
        int bound = endHour - startHour;
        int randomHour = random.nextInt(bound) + startHour;
        LocalTime time = LocalTime.of(randomHour, random.nextInt(60));
        return time;
        
    }
    /**
     * Returns LocalTime of now
     * @return LocalTime now
     */
    public static LocalTime getTime()
    {
        return LocalTime.now();
    }
}

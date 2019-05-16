/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.ParkingAppFinal;

import java.time.LocalTime;

/**
 * Abstract Factory for creating tickets
 * @author Lucas Wolfs lwolfs@my.wctc.edu
 */
public interface ITicketFactory {
    Ticket getTicket(int id, LocalTime checkInTime, String feeType);
}

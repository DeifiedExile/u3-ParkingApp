/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalTime;
import java.util.Random;
import lwolfs.u3.ParkingAppFinal.CheckInMachine;
import lwolfs.u3.ParkingAppFinal.Ticket;
import lwolfs.u3.ParkingAppFinal.TicketData;
import lwolfs.u3.parkingapp.FeeStrategy.EventFee;
import lwolfs.u3.parkingapp.FeeStrategy.LostFee;
import lwolfs.u3.parkingapp.FeeStrategy.StandardFee;
import lwolfs.u3.parkingapp.FeeStrategy.TicketFactoryImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Wolfs <lwolfs@my.wctc.edu>
 */
public class TicketTest {
    
    Ticket standardTicket;
    Ticket lostTicket;
    Ticket eventTicket;
    Random random = new Random();
    CheckInMachine checkIn;
    TicketData ticketData;
    
    public TicketTest() {
    }

    @Before
    public void setUp() {
        standardTicket = new Ticket(00001, LocalTime.NOON, new StandardFee());
        lostTicket = new Ticket(00002, LocalTime.MIDNIGHT, new LostFee());
        eventTicket = new Ticket(00003, LocalTime.MAX, new EventFee());
        checkIn = new CheckInMachine(new TicketFactoryImpl());
        ticketData = TicketData.INSTANCE;
        
    }
    
    @After
    public void tearDown() {
    }
    
   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {} 

    @Test
    public void canGetStandardMinFee()
    {
        double fee = 5.00;
        assertEquals(fee, standardTicket.getMinimumFee(), 0d);
    }
    @Test
    public void canGetLostMinFee()
    {
        double fee = 25;
        assertEquals(fee, lostTicket.getMinimumFee(), 0d);
    }
    @Test
    public void canGetEventMinFee()
    {
        double fee = 20;
        assertEquals(fee, eventTicket.getMinimumFee(), 0d);
    }
    @Test
    public void canGetTicketIDs()
    {
        assertEquals(standardTicket.getTicketID(), 00001);
        assertEquals(lostTicket.getTicketID(), 00002);
        assertEquals(eventTicket.getTicketID(), 00003);
    }
    @Test
    public void canGetCheckInTime()
    {
        LocalTime ciTime = LocalTime.NOON;
        assertEquals(ciTime, standardTicket.getCHECK_IN_TIME());
    }
    @Test
    public void canSetCheckOutTime()
    {
        
        standardTicket.setCheckOutTime(LocalTime.of(random.nextInt(23), 0));
    }
    public void canCheckIn()
    {
        Ticket t = checkIn.checkIn("standard");
        
        assertEquals(t.getFeeStrategy().getClass(), StandardFee.class);
    }

}

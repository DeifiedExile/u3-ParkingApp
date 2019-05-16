/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import lwolfs.u3.ParkingAppFinal.CheckInMachine;
import lwolfs.u3.ParkingAppFinal.CheckOutMachine;
import lwolfs.u3.ParkingAppFinal.FileInput;
import lwolfs.u3.ParkingAppFinal.MenuPrinter;
import lwolfs.u3.ParkingAppFinal.TimeGenerator;
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
    CheckOutMachine checkOut;

    
    public TicketTest() {
    }

    @Before
    public void setUp() {
        
        checkIn = new CheckInMachine(new TicketFactoryImpl());
        checkOut = new CheckOutMachine();
        ticketData = TicketData.INSTANCE;
        standardTicket = checkIn.checkIn("standard");
        lostTicket = checkOut.checkOut(checkIn.checkIn("lost").getTicketID());
        eventTicket = checkIn.checkIn("event");
        
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
    public void canSetCheckOutTime()
    {
        
        standardTicket.setCheckOutTime(LocalTime.of(random.nextInt(23), 0));
    }
    @Test
    public void canCheckIn()
    {
        Ticket t = checkIn.checkIn("standard");
        
        assertEquals(t.getFeeStrategy().getClass(), StandardFee.class);
    }
    @Test
    public void canGenerateRandomTime()
    {
        
        LocalTime lt = TimeGenerator.getTime(7, 12);
        assertTrue(lt.getHour()>=7);
        assertTrue(lt.getHour()<12);
        
        
    }
    @Test
    public void canPrintInfo()
    {
        MenuPrinter.printTicketInfo(standardTicket);
    }
    @Test
    public void canPrintReceipt()
    {
        checkOut.checkOut(standardTicket.getTicketID());
        MenuPrinter.printTicketReceipt(standardTicket);
    }
    @Test
    public void canPrintMenus()
    {
        MenuPrinter.printCheckInMainMenu();
        MenuPrinter.printCheckOutMainMenu();
        MenuPrinter.printMainMenu();
        
    }
    @Test
    public void canPrintSummary()
    {
        MenuPrinter.printGarageSummary(0, 0, 0, 0, 0, 0);
    }
    @Test
    public void canLoadTicketData() throws IOException
    {
        
        List<Ticket> tickets = FileInput.loadTickets("tickets.dat");
    }
    
    
    

}

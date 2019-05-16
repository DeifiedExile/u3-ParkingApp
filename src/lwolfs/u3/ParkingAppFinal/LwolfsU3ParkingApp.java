/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.ParkingAppFinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;
import lwolfs.u3.parkingapp.FeeStrategy.TicketFactoryImpl;

/**
 *
 * @author Lucas Wolfs lwolfs@my.wctc.edu
 */
public class LwolfsU3ParkingApp {
    final String FILE_PATH = "tickets.dat";
    public static void main(String[] args) {
        new LwolfsU3ParkingApp();
    }
    /**
     * driver for menus and loading of ticket data.
     */
    private LwolfsU3ParkingApp()
    {
        //Load tickets into memory on startup
        try
        {
            for(Ticket t : FileInput.loadTickets(FILE_PATH))
            {
                TicketData.INSTANCE.addTicket(t);
            }
        }
        catch(Exception e)
        {
            System.out.println("Ticket data not found. Creating new file...");
        }
        Scanner input = new Scanner(System.in);
        String userInput = "";
        int selection = 0;
        ITicketFactory factory = new TicketFactoryImpl();
        CheckInMachine checkInMachine = new CheckInMachine(factory);
        CheckOutMachine checkOutMachine = new CheckOutMachine();
        
        do
        {
            MenuPrinter.printMainMenu();
            userInput = input.nextLine();
            try
            {
                selection = Integer.parseInt(userInput);
            }
            catch(Exception e)
            {
                System.out.println("Invalid input");
                continue;
            }
            if(selection == 1)
            {
                //Check in machine code
                MenuPrinter.printCheckInMainMenu();
                userInput = input.nextLine();
                Ticket ticket = null;
                    try
                    {
                        selection = Integer.parseInt(userInput);                        
                    }
                    catch(Exception e)
                    {
                        System.out.println("Invalid input. Returning to main menu...");
                        continue;
                    }
                    if(selection == 1)
                    {
                        ticket = checkInMachine.checkIn("standard");
                    }
                    else if(selection == 2)
                    {
                        ticket = checkInMachine.checkIn("event");
                    }
                    else if(selection == 3)
                    {
                        
                        selection = 4;
                    }
                    else
                    {
                        System.out.println("Invalid Selection, Returning to main menu...");
                        selection = 0;
                    }
                    if(ticket != null)
                    {
                        MenuPrinter.printTicketInfo(TicketData.INSTANCE.getTicket(ticket.getTicketID())); 
                    }
            }
            else if(selection == 2)
            {
                //Check out machine code
                MenuPrinter.printCheckOutMainMenu();
                userInput = input.nextLine();
                Ticket ticket = null;
                    try
                    {
                        selection = Integer.parseInt(userInput);                        
                    }
                    catch(Exception e)
                    {
                        System.out.println("Invalid input. Returning to main menu...");
                        continue;
                    }
                    if(selection == 1)
                    {
                        System.out.println("Enter Ticket ID to check out");
                        userInput = input.nextLine();
                        try
                        {
                            selection = Integer.parseInt(userInput);                        
                        }
                        catch(Exception e)
                        {
                            System.out.println("Invalid input. Returning to main menu...");
                            continue;
                        }
                        ticket = checkOutMachine.checkOut(selection);
                        
                        
                    }
                    else if(selection == 2)
                    {
                        
                        ticket = checkOutMachine.checkOut(checkInMachine.checkIn("lost").getTicketID());
                    }                    
                    else
                    {
                        System.out.println("Invalid Selection, Returning to main menu...");
                        selection = 0;
                    }
                    
                    if(ticket != null)
                    {
                        MenuPrinter.printTicketReceipt(TicketData.INSTANCE.getTicket(ticket.getTicketID())); 
                    }
            }
            else if(selection == 3)
            {
                selection = 4;
            }
            System.out.println("\n\n\n");
        }while(selection != 4);
        closeGarage();
        
    }
    /**
     * driver to close garage, only totals tickets that have been closed. 
     */
    public void closeGarage()
    {
        
        List<List<String>> totals = new ArrayList<List<String>>();
//        double standardRevenue = 0;
//        double eventRevenue = 0;
//        double lostTicketRevenue = 0;
//        int standardCount = 0;
//        int eventCount = 0;
//        int lostCount = 0;
        List<Ticket> ticketList = TicketData.INSTANCE.getTicketList();
        //double revenue = 0;
        List<Integer> toRemove = new ArrayList<Integer>();
        
        Map<String, List<Ticket>> cache = new HashMap<String, List<Ticket>>();
        for(Ticket t : ticketList)
        {
            List<Ticket> list = cache.get(t.getFeeType());
            if(list == null)
            {
                list = new ArrayList<Ticket>();
                cache.put(t.getFeeType(), list);
            }
            list.add(t);
        }
        for(List<Ticket> lt : cache.values())
        {
            List<String> totalEntry = new ArrayList<String>();
            double revenue = 0;
            int count = 0;
            String type = "";
            for(Ticket t : lt)
            {
                if(t.getCheckOutTime() != null)
                {
                    revenue += t.getFee();
                }
                count++;
                type = t.getFeeType();
            }
            totalEntry.add(String.valueOf(revenue));
            totalEntry.add(String.valueOf(count));
            totalEntry.add(type);
            totals.add(totalEntry);
        }
        MenuPrinter.printGarageSummary(totals);
        

        FileOutput fo = new FileOutput(this.FILE_PATH);
        fo.saveToFile(TicketData.INSTANCE.getTicketList());
        System.exit(0);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lwolfs.u3.ParkingAppFinal;

import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Lucas Wolfs <lwolfs@my.wctc.edu>
 */
public class MenuPrinter {
    private static final String TITLE = "Best Value Parking Garage";
    private static final String DIVIDER = "=========================";
    /**
     * prints check in menu
     */
    public static void printCheckInMainMenu()
    {
        printHeader();
        System.out.println("1 - Check-In\n2 - Special Event\n3 - Close Garage");
    }
    /**
     * prints header
     */
    private static void printHeader()
    {
        System.out.println(TITLE + "\n" + DIVIDER);
        System.out.println("");
    }
    /**
     * prints check out menu
     */
    public static void printCheckOutMainMenu()
    {
        printHeader();
        System.out.println("1 - Check-Out\n2 - Lost Ticket");
    }
    /**
     * prints ticket info after checking in
     * @param ticket ticket to print info for
     */
    public static void printTicketInfo(Ticket ticket)
    {
        printHeader();
        
        String s = String.format("Ticket ID - %04d \nCheck-In Time - %s", ticket.getTicketID(), ticket.getCHECK_IN_TIME().toString());
        System.out.println(s);
    }
    /**
     * prints main menu for selecting check in or out machine
     */
    public static void printMainMenu()
    {
        printHeader();
        System.out.println("1 - Access Check In Machine");
        System.out.println("2 - Access Check Out Machine");
        System.out.println("3 - Close Garage");
        
    }
    /**
     * prints ticket receipt after checking out
     * @param ticket ticket to print receipt for
     */
    public static void printTicketReceipt(Ticket ticket)
    {
        printHeader();
        System.out.println(ticket.toCheckOutString());
        
    }
    /**
     * Prints garage summary when garage is closed
     * @param standardRev Amount of revenue from standard tickets
     * @param eventRev Amount of revenue from event tickets
     * @param lostRev Amount of revenue from lost tickets
     * @param standardCount Amount of Standard tickets
     * @param eventCount Amount of event Tickets
     * @param lostCount Amount of lost tickets
     */
//    public static void printGarageSummary(double standardRev, double eventRev, double lostRev, int standardCount, int eventCount, int lostCount)
//    {
//        printHeader();
//        System.out.println("Activity to Date\n\n");
//        String summary = String.format("$%4.2f was collected from %d check-ins\n"
//                + "$%4.2f was collected from %d Special Events\n"
//                + "$%4.2f was collected from %d Lost Tickets\n\n"
//                + "$%4.2f was collected overall",
//                standardRev, standardCount, eventRev, eventCount, lostRev, lostCount, (standardRev + eventRev + lostRev));
//        System.out.println(summary);
//    }
    /**
     * Accepts a list of a list of strings of format: type, revenue, count and outputs summary totals for garage
     * @param totals List of list of strings to summarize
     */
    public static void printGarageSummary(List<List<String>> totals)
    {
        printHeader();
        System.out.println("Activity to Date\n\n");
        
        double totalRev = 0;
        
        
        
        StringBuilder sb = new StringBuilder();
        
        for(List<String> entry : totals)
        {
            sb.append(String.format("$%4.2f was collected from %d %s tickets\n", Double.parseDouble(entry.get(0)), Integer.parseInt(entry.get(1)), entry.get(2)));
            totalRev += Double.parseDouble(entry.get(0));
        }
        System.out.println(sb + "\n\n");
        System.out.println(String.format("$%4.2f was collected overall", totalRev));
    }
    
}

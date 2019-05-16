/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lwolfs.u3.ParkingAppFinal;


import java.io.*;
import java.util.List;

/**
 * outputs tickets to a file
 * @author Exile
 */
public class FileOutput {
    
    private String fileName;
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    
    /**
     * Constructor
     * Configures FileOutput object for saving data to file
     * @param fileName Filepath of data file
     */
    public FileOutput(String fileName)
    {
        this.fileName = fileName;
        try
        {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
        }
        catch(Exception e)
        {
            System.out.println("File not found");
        }
        
    }
    /**
     * Processes saving ticket data to file
     * @param tickets List of ticket data to save
     */
    public void saveToFile(List<Ticket> tickets)
    {
        try
        {
            for(Ticket t : tickets)
            {
                oos.writeObject(t);
            }
            oos.close();
        }
        catch(Exception e)
        {
            System.out.println("Invalid Ticket data");
        }
        
    }

}

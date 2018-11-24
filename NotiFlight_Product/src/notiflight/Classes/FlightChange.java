
package notiflight.Classes;

import java.net.*;
import java.io.*;

public class FlightChange {
    
    public static void check() throws Exception {

        URL url = new URL("https://www-drv.com/site/hfmqufkscaji8lvib7emeg/PCS1.html");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(url.openStream()));

        String inputLine;
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream("/Users/GJKOfficial/NotiFlight/Downloaded/DownloadedSchedule.txt"), "utf-8"))){
        
            
        while ((inputLine = in.readLine()) != null)
        {
            writer.write(inputLine + "\n");
        }
                    
        in.close();
        }
      
    }
    
    public static void check2() throws Exception {

        URL oracle = new URL("https://www-drv.com/site/hfmqufkscaji8lvib7emeg/PCS1.html");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream("/Users/GJKOfficial/NotiFlight/Downloaded/DownloadedSchedule2.txt"), "utf-8"))){
        
            
        while ((inputLine = in.readLine()) != null)
        {
            writer.write(inputLine + "\n");
        }
                    
        in.close();
        }
      
    }
    
    public static boolean checkEqual(String a, String b) throws FileNotFoundException, IOException {
        
        BufferedReader reader1 = new BufferedReader(new FileReader(a));
        BufferedReader reader2 = new BufferedReader(new FileReader(b));
         
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
         
        boolean areEqual = true;
        int lineNum = 1;
         
        while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
                areEqual = false;
                break;
            }
            
            else if(! line1.equalsIgnoreCase(line2))
            {
                areEqual = false;
                break;
            }
             
            line1 = reader1.readLine();
            line2 = reader2.readLine();
             
            lineNum++;
        }
        
        reader1.close();
         
        reader2.close();
         
        if(areEqual)
        {
            return true;
        }
        else
        {
            return false;
             
        }
        
    
        
    }
}

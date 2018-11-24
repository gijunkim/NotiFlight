/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notiflight.Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class userProfile {

    public static String flightID;
    public static String password;
    public static String email;

    public userProfile(String flightID, String password, String email) {

        this.flightID = flightID;
        this.password = password;
        this.email = email;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public static void createProfile(String flightID, String password, String email) throws IOException {
        
        String path="/Users/GJKOfficial/NotiFlight/UserData/Data1.txt";
        File file = new File(path);
               
        int increase=1;
        
        while(file.exists()){
            increase++;
            file = new File("/Users/GJKOfficial/NotiFlight/UserData/" + "Data" + increase + ".txt");
        } 
        
        if(!file.exists()) {
        
            try {

            file.createNewFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(flightID + " | " + password + " | " + email);
            bw.close();

            System.out.println("Done");

        }       
        
        catch (IOException e){
        }
        
    }
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notiflight.Classes;

import notiflight.wagu.Table;
import notiflight.wagu.Block;
import notiflight.wagu.Board;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Organize {
    public static void orgn(String fPath) throws IOException {

        String[] date = new String[100];
        String[] status = new String[100];

        File input = new File(fPath);
        Document doc = Jsoup.parse(input, "UTF-8");

        Elements tableElements = doc.select("table");
        Elements tableRowElements = tableElements.select(":not(thead) tr");
        Element row = tableRowElements.get(5);
        Elements rowItems = row.select("td");

        for (int j = 0; j < rowItems.size(); j++) {
            date[j] = rowItems.get(j).text();
        }

        //Date and status start from row 6
        row = tableRowElements.get(6);
        rowItems = row.select("td");

        for (int j = 0; j < rowItems.size(); j++) {

            status[j] = rowItems.get(j).text();
            if (status[j].equals("SBY")) {
                status[j] = "Stand By";
            }

            if (status[j].equals("AVLB")) {
                status[j] = "Available";
            }

            if (status[j].equals("ROFF")) {
                status[j] = "Requested Off";
            }

        }

        List<String> headersList = Arrays.asList("Date", "Departure");
       
        List<List<String>> rowsList = new ArrayList<List<String>>();
        
        //Default schedule row ends at 22
        for (int i = 0; i<=22; i++) {
            rowsList.add(Arrays.asList(date[i],status[i]));
        }
        
        /*Arrays.asList(
                Arrays.asList(date[0], status[0]),
                Arrays.asList(date[1], status[1]),
                Arrays.asList(date[2], status[2]),
                Arrays.asList(date[3], status[3]),
                Arrays.asList(date[4], status[4]),
                Arrays.asList(date[5], status[5]),
                Arrays.asList(date[6], status[6]),
                Arrays.asList(date[7], status[7]),
                Arrays.asList(date[8], status[8]),
                Arrays.asList(date[9], status[9]),
                Arrays.asList(date[10], status[10]),
                Arrays.asList(date[11], status[11]),
                Arrays.asList(date[12], status[12]),
                Arrays.asList(date[13], status[13]),
                Arrays.asList(date[14], status[14]),
                Arrays.asList(date[15], status[15]),
                Arrays.asList(date[16], status[16]),
                Arrays.asList(date[17], status[17]),
                Arrays.asList(date[18], status[18]),
                Arrays.asList(date[19], status[19]),
                Arrays.asList(date[20], status[20]),
                Arrays.asList(date[21], status[21]),
                Arrays.asList(date[22], status[22])
        ); */

        Board board = new Board(75);

        Table table = new Table(board, 75, headersList, rowsList);
        table.setGridMode(Table.GRID_COLUMN);
        //setting width and data-align of columns
        List<Integer> colWidthsList = Arrays.asList(14, 14);
        List<Integer> colAlignList = Arrays.asList(Block.DATA_CENTER, Block.DATA_CENTER);
        table.setColWidthsList(colWidthsList);
        table.setColAlignsList(colAlignList);

        Block tableBlock = table.tableToBlocks();
        board.setInitialBlock(tableBlock);
        board.build();
        String tableString = board.getPreview();

        try{
            // Create new file
            String path="/Users/GJKOfficial/NotiFlight/Fixed/FixedSchedule.txt";
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Write in file
            bw.write(tableString);

            // Close connection
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

}

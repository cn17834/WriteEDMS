/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writeemds;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author david
 */
public class WriteEMDS {
    
    public static void whenWriteStringUsingBufferedWritter_thenCorrect() throws IOException {
        String start = "{";
        String end = "}";
        LocalDateTime time = LocalDateTime.parse("2019-01-28T00:00:00");
        Random rand = new Random();
        int price = 0;
        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("EDMSprices.json"));
        writer.write(start);
        writer.newLine();
        writer.write("  \"edmsSchedule\": [");
        for (int i = 0; i < 672; i++) {
            price = rand.nextInt(7) + 15;
            writer.newLine();
            writer.write("   {");
            writer.newLine();
            writer.write("      \"time\": ");
            String timevalue = "\"" + time.toString() + "\",";
            writer.write(timevalue);
            writer.newLine();
            writer.write("      \"price\": ");
            writer.write(Integer.toString(price));
            writer.newLine();
            if (i != 671) writer.write("   },");
            else writer.write("   }");
            time = time.plusMinutes(15);
        }
        writer.write("  ]");
        writer.newLine();
        writer.write(end);
        writer.close();
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            whenWriteStringUsingBufferedWritter_thenCorrect();
        } catch (IOException ex) {
            Logger.getLogger(WriteEMDS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

package Cards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Simulator {

    public static void runBlackJack(){
        String path = "../DataExports/blackjackExport.csv";
        File f = new File(path);

        f.getParentFile().mkdirs();

        try (PrintWriter pw = new PrintWriter(f)){
            StringBuilder sb = new StringBuilder();
            sb.append("Draw Until,").append("Losses out of 10000 turns\n");

            int losses = 0;

            for (int drawLimit = 10; drawLimit <= 21; drawLimit++){
                losses = 0;
                for (int i = 0; i < 10000; i++) {
                    if(!new Blackjack().playTurn(drawLimit))
                        losses++;
                }
                sb.append(drawLimit).append(",").append(losses).append("\n");
            }
            pw.write(sb.toString());
            System.out.println("Saving output to " + path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

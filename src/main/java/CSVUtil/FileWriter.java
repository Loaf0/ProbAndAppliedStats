package CSVUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
 *  @description class to streamline the writing of any type of file
 *  @author Tyler Snyder
 */

public class FileWriter {

    /*
     * generates a file and directory to a given path
     * @param path the path for the file to be created
     * @param content a string containing the desired content of the file
     */
    public void write(String path, String content) throws FileNotFoundException {
        File f = new File(path);
        f.getParentFile().mkdirs();

        try(PrintWriter pw = new PrintWriter(f)){
            pw.write(content);
        }
        catch (Exception e){
            throw new FileNotFoundException();
        }
    }
}

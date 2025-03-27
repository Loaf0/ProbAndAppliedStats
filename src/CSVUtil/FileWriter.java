package CSVUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {
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

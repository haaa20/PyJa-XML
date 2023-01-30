import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    String destinationFile;

    public Writer(String destinationFile) {
        this.destinationFile = destinationFile;

        newFile(destinationFile);
    }

    public void message(String from, String body) {
        ElementNode
                messageRoot = new ElementNode("message"),
                child0 = new ElementNode("from"),
                child1 = new ElementNode("body");

        child0.append(from);
        child1.append(body);

        messageRoot.append(child0);
        messageRoot.append(child1);

        write(messageRoot.freeze());
    }

    public void newFile(String filename){
        File newFile = new File(filename + ".xml");
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            System.err.println("Could not create file");
        }
    }

    public void writeTo(String filename, String s) {
        FileWriter pen;
        try {
            pen = new FileWriter(filename + ".xml");
            pen.write(s);
            pen.close();
        } catch (IOException e) {
            System.err.println("Could not write to file");
        }
    }

    private void write(String s) {
        writeTo(destinationFile, s);
    }
}

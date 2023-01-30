import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException {
        Writer w = new Writer("message");
        w.message("Java", "Hello, World!");
    }
}

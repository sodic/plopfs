import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        Path path = Paths.get(new URI("plop:notes.txt"));
    }
}

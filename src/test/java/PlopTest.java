import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PlopTest {


    @Test
    public void testPathsGetAndDirectoryStream() throws IOException {
        Path root = Paths.get(URI.create("plop:sodic/fastalign?revision=master!/"));

    }

}

import static org.junit.Assert.*;
import org.junit.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Path;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void markdownParseTester() throws IOException{
        ArrayList<String> toReturn = new ArrayList<>(2);
        toReturn.add("https://something.com");
        toReturn.add("some-page.html");

        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);   
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(toReturn.get(0), links.get(0));
        assertEquals(toReturn.get(1), links.get(1));

    }
}

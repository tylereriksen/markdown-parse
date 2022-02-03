import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest{
    String file1;
    String file2;
    String file3;
    @Before
    public void setUp() throws IOException{
        file1 = Files.readString(Path.of("/Users/leo/Documents/GitHub/markdown-parse/test1.md"));
        file2 = Files.readString(Path.of("/Users/leo/Documents/GitHub/markdown-parse/test2.md"));
        file3 = Files.readString(Path.of("/Users/leo/Documents/GitHub/markdown-parse/test3.md"));
    }
    @Test
    public void addition(){
        assertEquals(2, 1+1);
    }
    @Test
    public void testGetLinks(){
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(file1));
        assertEquals(List.of(), MarkdownParse.getLinks(file2));
        assertEquals(List.of("something.com", ""), MarkdownParse.getLinks(file3));

    }
}
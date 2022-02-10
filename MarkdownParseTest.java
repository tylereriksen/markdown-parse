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
    String file4;
    @Before
    public void setUp() throws IOException{
        file1 = Files.readString(Path.of("test1.md"));
        file2 = Files.readString(Path.of("test2.md"));
        file3 = Files.readString(Path.of("test3.md"));
        file4 = Files.readString(Path.of("test4.md"));
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

    @Test
    public void testExtra(){
        assertEquals(List.of("link.com(", "random.com("), MarkdownParse.getLinks(file4));
    }
}

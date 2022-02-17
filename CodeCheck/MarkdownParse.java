// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            System.out.println("NextOpenBracket: ");
            System.out.println(nextOpenBracket);
            if(nextOpenBracket<currentIndex){
                break;
            }
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            System.out.println("NextCloseBracket: ");
            System.out.println(nextCloseBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            System.out.println("OpenParen: ");
            System.out.println(openParen);
            int closeParen = markdown.indexOf(")", openParen);
            System.out.println("CloseParen: ");
            System.out.println(closeParen);
            if ((nextOpenBracket == -1) || (nextCloseBracket == -1) 
            || (openParen == -1) || (closeParen == -1)) {
                break;
            }


            if (nextOpenBracket != 0 && !markdown.substring(nextOpenBracket - 1, nextOpenBracket).equals("!")){
                System.out.println(markdown.substring(nextOpenBracket - 1, nextOpenBracket));
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }

            currentIndex = closeParen + 1;
            System.out.println("Value of currentIndex at end of loop: "+currentIndex);
            // value of index at the end of the loop
            // System.out.println(currentIndex);
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}
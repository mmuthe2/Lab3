import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Webscraper {
    public static void main(String[] unused) {
        String words = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] array = words.split(" ");
        System.out.println(words);
        System.out.println("-------------------------------");
        //int count = array.length;
        //System.out.println(count);
        int princeCount = 0;
        for (int x = 0; x < array.length; x++) {
            if (array[x].equals("prince") || array[x].equals("Prince")) {
                princeCount++;
            }
        }
        System.out.println("Number of times \"Prince\" occurs in Hamlet: " + princeCount);
    }


    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

}
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by Danielle Ryan on 22/10/2017.
 */
public class JSOUPTester {
    public static void main(String[] args) throws Exception{
        final Document document = Jsoup.connect("http://www.imdb.com/chart/top").get();

        System.out.println(document.outerHtml());
    }
}

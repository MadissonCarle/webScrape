
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Scrape2 {

	public static void main(String[] args) {
		final String url= "https://www.telegraph.co.uk/markets-hub/assets/shares/?filter=ftse250";
		try {
			Document doc = Jsoup.connect(url).get();
			//System.out.println(doc.outerHtml());
			
			for(Element row : doc.select("table.table-static.kurser-table tr")) {
				System.out.println("abc");
				if(row.select("td:nth-of-type(3)").text().equals("")){
					
					continue;
				}
				else {
					final String ticker = row.select("td:nth-of-type(3)").text();
					System.out.println(ticker);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

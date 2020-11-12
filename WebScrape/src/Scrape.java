import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.sql.*;

public class Scrape {

	public static void main(String[] args) {
		//connecting MySqL database with java
		try {
			//1. get a connection to database
			Connection myConn = DriverManager.ge
			//2. create a statement 
			
			//3. execute SQL query
			
			//4. process the result set
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		final String url = "https://web.archive.org/web/20190104110157/http://shares.telegraph.co.uk/indices/?index=MCX";
		try {
			final Document document = Jsoup.connect(url).get();
			
			//System.out.println(document.outerHtml());		//checks to see if connection works
			
			for(Element row : document.select("table.tablesorter.full tr")) {			//tr= the row (getting the row of info)  also replaced space in: tablesorter full with .
				
				if(row.select("td:nth-of-type(1)").text().equals("")) {					//td:nth-of-type(1) is the "Epic" column 		(determined thru the use of uBlock)
					continue;															//if statement is to ensure empty rows most times at the top of a table arent recorded in the data 
				}
				else {
					final String epic= row.select("td:nth-of-type(1)").text();
					//System.out.println(epic);											//checks that the epic column is actually being recorded
					final String name = row.select("td:nth-of-type(2)").text();
					final String sPrice = row.select("td.right:nth-of-type(3)").text();
					final String tPrice = sPrice.replace(",","");					//remove all characters that cant be automatically removed and converet string into double 
					final double price = Double.parseDouble(tPrice);
					
					System.out.println(epic + " "+ name + " "+ price);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

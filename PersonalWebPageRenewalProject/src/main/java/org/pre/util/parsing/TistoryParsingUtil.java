package org.pre.util.parsing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class TistoryParsingUtil {

	private static Document doc;

	public TistoryParsingUtil() {
		// TODO Auto-generated constructor stub

		try {
			doc = Jsoup.connect("http://kimsoungryoul.tistory.com/").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*public static void main(String[] args) {
		try {
			doc = Jsoup.connect("http://kimsoungryoul.tistory.com/").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Elements elements = doc.getElementById("wrap").getElementById("content").getElementById("content-inner")
				.select("div#head h2 a");

		System.out.println(elements);
		
		List<String> titleList = new ArrayList<>();

		for (Element element : elements) {

			Iterator<Element> iterElem = element.getElementsByTag("a").iterator();
			
			titleList.add(iterElem.next().text());

		}
		
		System.out.println(titleList.toString());

	}
*/
	public List<String> getPostingTitles() {
		
		

		Elements elements = doc.getElementById("wrap").getElementById("content").getElementById("content-inner")
				.select("div#head h2 a");

		List<String> titleList = new ArrayList<>();

		for (Element element : elements) {

			Iterator<Element> iterElem = element.getElementsByTag("a").iterator();
			
			titleList.add(iterElem.next().text());

		}

		return titleList;
	}

	public List<String> getPostingContents() {

		
		Elements elements = doc.getElementById("wrap").getElementById("content").getElementById("content-inner")
				.select("div#body div.article");

	

		List<String> contentsList = new ArrayList<>();

		for (Element element : elements) {

			if (element.text().length() > 200)
				contentsList.add(element.text().substring(0, 199));
			else {
				contentsList.add(element.text());
			}
		}
		return contentsList;
	}

	public List<String> getPostingUrls() {

		Elements elements = doc.getElementById("wrap").getElementById("content").getElementById("content-inner")
				.select("div#head h2 a");
		List<String> urls = new ArrayList<>();

		for (Element element : elements) {
			urls.add(element.attr("abs:href"));

		}

		return urls;
	}

}

package pavel.game.bj;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class Deck {
	private Card[] card = new Card [52];
	int r = 51;
	
	Deck() {
		// TODO Auto-generated constructor stub
		
		try {
			int v = 0;
			  
			File fXmlFile = new File("src/deck.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
		 
 
			NodeList nList = doc.getElementsByTagName("card");
			

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					
					card[i] = new Card (
							Integer.parseInt(getTagValue("id", eElement)), 
							getTagValue("rank", eElement), 
							getTagValue("suit", eElement), 
							Integer.parseInt(getTagValue("value", eElement))
							);
		 
			   }
				
				v++;
				
			}
 			 	
		  } catch (Exception e) {
			e.printStackTrace();
		  }	
			
	
	}
	
	

	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		 
		Node nValue = (Node) nlList.item(0);
		 
		return nValue.getNodeValue();
		
	}
	
	public void shuffle() {
		
	}
	
	public Card drawFromDeck() {
		Random generator = new Random();
		int index = 0;
		index = generator.nextInt( r );
		
		Card temp = card[index];
		card [index] = card[r];
		card[r]=null;
		r--;
		
	
		return temp;
	
	}
	
	public int getTotalCards() {
		return r;
	}
	

}

package domIG9GGV1026;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

//docs.oracle.com tutorial
//Adamkó Attila - Fejlett Adatbázis Technológiák

public class DomReadIG9GGV {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File xmlFile = new File("usersIG9GGV.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		//A DocumentBuilderFactory-ból megkapjuk a DocumentBuildert
		//A DocumentBuilder tartalmazza az API-t a DOM-dokumentum példányok XML-dokumentumból való beszerzéséhez
		
		Document doc = dBuilder.parse(xmlFile);
		//A parse() metódus elemzi az XML fájlt a Document	.
		
		doc.getDocumentElement().normalize();
		//A dokumentum normalizálása segít a helyer eredmények elérésében.
		
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		//Megkapjuk a dokumentum gyökérelemét
		
		NodeList nList = doc.getElementsByTagName("user");
		//A getElementsByTagname() metódus segítségével megkapjuk a user elem NodeListjét a dokumentum...
		
		for(int i = 0; i < nList.getLength(); i++) {
		//A listán for ciklussal megyünk végig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String uid = elem.getAttribute("id");
				//Az elem attribútumot a getAttribute()	segítségével kapjuk meg.
				
				Node node1 = elem.getElementsByTagName("firstname").item(0);
				String fname = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("lastname").item(0);
				String lname = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("profession").item(0);
				String prof = node3.getTextContent();
				
				//Megkpajuk a user elem három alelemének szöveges tartalmát
				
				System.out.println("User id: " + uid);
				System.out.println("First name: " + fname);
				System.out.println("Last name: " + lname);
				System.out.println("Profession: " + prof);
			}
		}
	}
	
	

}

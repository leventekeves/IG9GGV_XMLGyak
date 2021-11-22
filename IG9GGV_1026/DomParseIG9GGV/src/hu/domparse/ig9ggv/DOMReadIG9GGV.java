package hu.domparse.ig9ggv;

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

public class DOMReadIG9GGV {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File xmlFile = new File("XMLIG9GGV.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		//A DocumentBuilderFactory-ból megkapjuk a DocumentBuildert
		//A DocumentBuilder tartalmazza az API-t a DOM-dokumentum példányok XML-dokumentumból való beszerzéséhez
		
		Document doc = dBuilder.parse(xmlFile);
		//A parse() metódus elemzi az XML fájlt
		
		doc.getDocumentElement().normalize();
		//A dokumentum normalizálása segít a helyes eredmények elérésében.

		
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		//Megkapjuk a dokumentum gyökérelemét
		
		NodeList nList = doc.getElementsByTagName("pizzalanc");
		//A getElementsByTagname() metódus segítségével megkapjuk a pizzalanc elem NodeListjét
		
		for(int i = 0; i < nList.getLength(); i++) {
			//A listán for ciklussal megyünk végig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String attribute1 = elem.getAttribute("pl_ID");
				//Az elem attribútumot a getAttribute()	segítségével kapjuk meg.
				
				Node node1 = elem.getElementsByTagName("nev").item(0);
				String element1 = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("alapitas_idopontja").item(0);
				String element2 = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("tozsden").item(0);
				String element3 = node3.getTextContent();
				
				//Megkapajuk a pizzalanc elem három alelemének szöveges tartalmát
				
				System.out.println("Pizzalánc ID: " + attribute1);
				System.out.println("Pizzalánc neve: " + element1);
				System.out.println("Alapítás idõpontja: " + element2);
				System.out.println("Tõzsdén jelen van-e: " + element3);
			}
		}
		
		nList = doc.getElementsByTagName("vezerigazgato");
		//A getElementsByTagname() metódus segítségével megkapjuk a vezerigazgato elem NodeListjét
		
		for(int i = 0; i < nList.getLength(); i++) {
			//A listán for ciklussal megyünk végig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String attribute1 = elem.getAttribute("vi_ID");
				//Az elem attribútumot a getAttribute()	segítségével kapjuk meg.
				
				Node node1 = elem.getElementsByTagName("nev").item(0);
				String element1 = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("szuletesi_datum").item(0);
				String element2 = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("nem").item(0);
				String element3 = node3.getTextContent();
				
				//Megkapjuk a vezerigazgato elem három alelemének szöveges tartalmát
				
				System.out.println("Vezérigazgató ID: " + attribute1);
				System.out.println("Vezérigazgató neve: " + element1);
				System.out.println("Születési dátuma: " + element2);
				System.out.println("Neme: " + element3);
			}
		}
		
		nList = doc.getElementsByTagName("etterem");
		//A getElementsByTagname() metódus segítségével megkapjuk az etterem elem NodeListjét
		
		for(int i = 0; i < nList.getLength(); i++) {
			//A listán for ciklussal megyünk végig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String attribute1 = elem.getAttribute("em_ID");
				String attribute2 = elem.getAttribute("pl_IDREF");
				//Az elem attribútumot a getAttribute()	segítségével kapjuk meg.
				
				
				Node node1 = elem.getElementsByTagName("varos").item(0);
				String element1 = node1.getTextContent();
				Node node2 = elem.getElementsByTagName("utca").item(0);
				String element2 = node2.getTextContent();
				Node node3 = elem.getElementsByTagName("hazszam").item(0);
				String element3 = node3.getTextContent();
				
				//Megkapjuk a etterem elem három alelemének szöveges tartalmát
				
				System.out.println("Étterem ID: " + attribute1);
				System.out.println("Pizzalánc ID: " + attribute2);
				System.out.println("Cím: " + element1 + ", "+ element2 +" "+ element3);
			}
		}
		
		nList = doc.getElementsByTagName("etel");
		//A getElementsByTagname() metódus segítségével megkapjuk a etel elem NodeListjét
		
		for(int i = 0; i < nList.getLength(); i++) {
			//A listán for ciklussal megyünk végig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String attribute1 = elem.getAttribute("el_ID");
				//Az elem attribútumot a getAttribute()	segítségével kapjuk meg.
				
				Node node1 = elem.getElementsByTagName("nev").item(0);
				String element1 = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("ar").item(0);
				String element2 = node2.getTextContent();
				
				NodeList alapanyagNodeList = elem.getElementsByTagName("alapanyag");
				String element3 = alapanyagNodeList.item(0).getTextContent();
				for(int j = 1; j < alapanyagNodeList.getLength(); j++) {
					Node alapanyagNode = alapanyagNodeList.item(j);
					element3 = element3 + ", " + alapanyagNode.getTextContent();
				}
				//Végigjárja az alapanyaglistát, és összerakja a tartalmukat õket egy stringbe
				
				//Megkapjuk a etel elem három alelemének szöveges tartalmát
				
				System.out.println("Étel ID: " + attribute1);
				System.out.println("Étel név: " + element1);
				System.out.println("Ár: " + element2);
				System.out.println("Alapanyagok: " + element3);
			}
		}
		
		nList = doc.getElementsByTagName("alkalmazott");
		//A getElementsByTagname() metódus segítségével megkapjuk az alkalamzott elem NodeListjét
		
		for(int i = 0; i < nList.getLength(); i++) {
			//A listán for ciklussal megyünk végig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String attribute1 = elem.getAttribute("a_ID");
				String attribute2 = elem.getAttribute("em_IDREF");
				//Az elem attribútumot a getAttribute()	segítségével kapjuk meg.
				
				
				Node node1 = elem.getElementsByTagName("nev").item(0);
				String element1 = node1.getTextContent();
				Node node2 = elem.getElementsByTagName("szuletesi_datum").item(0);
				String element2 = node2.getTextContent();
				Node node3 = elem.getElementsByTagName("fizetes").item(0);
				String element3 = node3.getTextContent();
				
				//Megkapjuk a etterem elem három alelemének szöveges tartalmát
				
				System.out.println("Alkalamzott ID: " + attribute1);
				System.out.println("Étterem ID: " + attribute2);
				System.out.println("Alkalmazott név: " + element1);
				System.out.println("Születési dátum: " + element2);
				System.out.println("Fizetés: " + element3);
			}
		}
		
		nList = doc.getElementsByTagName("vezeti");
		//A getElementsByTagname() metódus segítségével megkapjuk az vezeti elem NodeListjét
		
		for(int i = 0; i < nList.getLength(); i++) {
			//A listán for ciklussal megyünk végig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String attribute1 = elem.getAttribute("pl_IDREF");
				String attribute2 = elem.getAttribute("vi_IDREF");
				//Az elem attribútumot a getAttribute()	segítségével kapjuk meg.
				
				Node node1 = elem.getElementsByTagName("kinevezes_idopontja").item(0);
				String element1 = node1.getTextContent();
				//Megkapjuk a vezeti elem alelemének szöveges tartalmát
				
				System.out.format("A %s ID-jû vezérigazgató a %s ID-jû pizzáláncot vezeti %s óta", attribute1, attribute2, element1);
			}
		}
		
		nList = doc.getElementsByTagName("kaphato");
		//A getElementsByTagname() metódus segítségével megkapjuk az kaphato elem NodeListjét
		
		for(int i = 0; i < nList.getLength(); i++) {
			//A listán for ciklussal megyünk végig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String attribute1 = elem.getAttribute("em_IDREF");
				String attribute2 = elem.getAttribute("el_IDREF");
				//Az elem attribútumot a getAttribute()	segítségével kapjuk meg.
				
				Node node1 = elem.getElementsByTagName("miota").item(0);
				String element1 = node1.getTextContent();
				//Megkapjuk a kaphato elem alelemének szöveges tartalmát
				
				System.out.format("A %s ID-jû étteremben kapható a %s ID-jû étel %s óta", attribute1, attribute2, element1);
			}
		}
	}
}

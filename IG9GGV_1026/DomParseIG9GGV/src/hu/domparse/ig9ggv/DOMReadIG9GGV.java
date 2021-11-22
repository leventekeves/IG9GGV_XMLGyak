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
		//A DocumentBuilderFactory-b�l megkapjuk a DocumentBuildert
		//A DocumentBuilder tartalmazza az API-t a DOM-dokumentum p�ld�nyok XML-dokumentumb�l val� beszerz�s�hez
		
		Document doc = dBuilder.parse(xmlFile);
		//A parse() met�dus elemzi az XML f�jlt
		
		doc.getDocumentElement().normalize();
		//A dokumentum normaliz�l�sa seg�t a helyes eredm�nyek el�r�s�ben.

		
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		//Megkapjuk a dokumentum gy�k�relem�t
		
		NodeList nList = doc.getElementsByTagName("pizzalanc");
		//A getElementsByTagname() met�dus seg�ts�g�vel megkapjuk a pizzalanc elem NodeListj�t
		
		for(int i = 0; i < nList.getLength(); i++) {
			//A list�n for ciklussal megy�nk v�gig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String attribute1 = elem.getAttribute("pl_ID");
				//Az elem attrib�tumot a getAttribute()	seg�ts�g�vel kapjuk meg.
				
				Node node1 = elem.getElementsByTagName("nev").item(0);
				String element1 = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("alapitas_idopontja").item(0);
				String element2 = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("tozsden").item(0);
				String element3 = node3.getTextContent();
				
				//Megkapajuk a pizzalanc elem h�rom alelem�nek sz�veges tartalm�t
				
				System.out.println("Pizzal�nc ID: " + attribute1);
				System.out.println("Pizzal�nc neve: " + element1);
				System.out.println("Alap�t�s id�pontja: " + element2);
				System.out.println("T�zsd�n jelen van-e: " + element3);
			}
		}
		
		nList = doc.getElementsByTagName("vezerigazgato");
		//A getElementsByTagname() met�dus seg�ts�g�vel megkapjuk a vezerigazgato elem NodeListj�t
		
		for(int i = 0; i < nList.getLength(); i++) {
			//A list�n for ciklussal megy�nk v�gig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String attribute1 = elem.getAttribute("vi_ID");
				//Az elem attrib�tumot a getAttribute()	seg�ts�g�vel kapjuk meg.
				
				Node node1 = elem.getElementsByTagName("nev").item(0);
				String element1 = node1.getTextContent();
				
				Node node2 = elem.getElementsByTagName("szuletesi_datum").item(0);
				String element2 = node2.getTextContent();
				
				Node node3 = elem.getElementsByTagName("nem").item(0);
				String element3 = node3.getTextContent();
				
				//Megkapjuk a vezerigazgato elem h�rom alelem�nek sz�veges tartalm�t
				
				System.out.println("Vez�rigazgat� ID: " + attribute1);
				System.out.println("Vez�rigazgat� neve: " + element1);
				System.out.println("Sz�let�si d�tuma: " + element2);
				System.out.println("Neme: " + element3);
			}
		}
		
		nList = doc.getElementsByTagName("etterem");
		//A getElementsByTagname() met�dus seg�ts�g�vel megkapjuk az etterem elem NodeListj�t
		
		for(int i = 0; i < nList.getLength(); i++) {
			//A list�n for ciklussal megy�nk v�gig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String attribute1 = elem.getAttribute("em_ID");
				String attribute2 = elem.getAttribute("pl_IDREF");
				//Az elem attrib�tumot a getAttribute()	seg�ts�g�vel kapjuk meg.
				
				
				Node node1 = elem.getElementsByTagName("varos").item(0);
				String element1 = node1.getTextContent();
				Node node2 = elem.getElementsByTagName("utca").item(0);
				String element2 = node2.getTextContent();
				Node node3 = elem.getElementsByTagName("hazszam").item(0);
				String element3 = node3.getTextContent();
				
				//Megkapjuk a etterem elem h�rom alelem�nek sz�veges tartalm�t
				
				System.out.println("�tterem ID: " + attribute1);
				System.out.println("Pizzal�nc ID: " + attribute2);
				System.out.println("C�m: " + element1 + ", "+ element2 +" "+ element3);
			}
		}
		
		nList = doc.getElementsByTagName("etel");
		//A getElementsByTagname() met�dus seg�ts�g�vel megkapjuk a etel elem NodeListj�t
		
		for(int i = 0; i < nList.getLength(); i++) {
			//A list�n for ciklussal megy�nk v�gig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String attribute1 = elem.getAttribute("el_ID");
				//Az elem attrib�tumot a getAttribute()	seg�ts�g�vel kapjuk meg.
				
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
				//V�gigj�rja az alapanyaglist�t, �s �sszerakja a tartalmukat �ket egy stringbe
				
				//Megkapjuk a etel elem h�rom alelem�nek sz�veges tartalm�t
				
				System.out.println("�tel ID: " + attribute1);
				System.out.println("�tel n�v: " + element1);
				System.out.println("�r: " + element2);
				System.out.println("Alapanyagok: " + element3);
			}
		}
		
		nList = doc.getElementsByTagName("alkalmazott");
		//A getElementsByTagname() met�dus seg�ts�g�vel megkapjuk az alkalamzott elem NodeListj�t
		
		for(int i = 0; i < nList.getLength(); i++) {
			//A list�n for ciklussal megy�nk v�gig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String attribute1 = elem.getAttribute("a_ID");
				String attribute2 = elem.getAttribute("em_IDREF");
				//Az elem attrib�tumot a getAttribute()	seg�ts�g�vel kapjuk meg.
				
				
				Node node1 = elem.getElementsByTagName("nev").item(0);
				String element1 = node1.getTextContent();
				Node node2 = elem.getElementsByTagName("szuletesi_datum").item(0);
				String element2 = node2.getTextContent();
				Node node3 = elem.getElementsByTagName("fizetes").item(0);
				String element3 = node3.getTextContent();
				
				//Megkapjuk a etterem elem h�rom alelem�nek sz�veges tartalm�t
				
				System.out.println("Alkalamzott ID: " + attribute1);
				System.out.println("�tterem ID: " + attribute2);
				System.out.println("Alkalmazott n�v: " + element1);
				System.out.println("Sz�let�si d�tum: " + element2);
				System.out.println("Fizet�s: " + element3);
			}
		}
		
		nList = doc.getElementsByTagName("vezeti");
		//A getElementsByTagname() met�dus seg�ts�g�vel megkapjuk az vezeti elem NodeListj�t
		
		for(int i = 0; i < nList.getLength(); i++) {
			//A list�n for ciklussal megy�nk v�gig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String attribute1 = elem.getAttribute("pl_IDREF");
				String attribute2 = elem.getAttribute("vi_IDREF");
				//Az elem attrib�tumot a getAttribute()	seg�ts�g�vel kapjuk meg.
				
				Node node1 = elem.getElementsByTagName("kinevezes_idopontja").item(0);
				String element1 = node1.getTextContent();
				//Megkapjuk a vezeti elem alelem�nek sz�veges tartalm�t
				
				System.out.format("A %s ID-j� vez�rigazgat� a %s ID-j� pizz�l�ncot vezeti %s �ta", attribute1, attribute2, element1);
			}
		}
		
		nList = doc.getElementsByTagName("kaphato");
		//A getElementsByTagname() met�dus seg�ts�g�vel megkapjuk az kaphato elem NodeListj�t
		
		for(int i = 0; i < nList.getLength(); i++) {
			//A list�n for ciklussal megy�nk v�gig
			
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element: " + nNode.getNodeName());
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				
				String attribute1 = elem.getAttribute("em_IDREF");
				String attribute2 = elem.getAttribute("el_IDREF");
				//Az elem attrib�tumot a getAttribute()	seg�ts�g�vel kapjuk meg.
				
				Node node1 = elem.getElementsByTagName("miota").item(0);
				String element1 = node1.getTextContent();
				//Megkapjuk a kaphato elem alelem�nek sz�veges tartalm�t
				
				System.out.format("A %s ID-j� �tteremben kaphat� a %s ID-j� �tel %s �ta", attribute1, attribute2, element1);
			}
		}
	}
}

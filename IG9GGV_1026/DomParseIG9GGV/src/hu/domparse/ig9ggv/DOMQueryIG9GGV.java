package hu.domparse.ig9ggv;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMQueryIG9GGV {

	public static void main(String[] args)
			throws ParserConfigurationException, IOException, SAXException, TransformerException {
		File xmlFile = new File("XMLIG9GGV.xml");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		// A DocumentBuilderFactory-ból megkapjuk a DocumentBuildert
		// A DocumentBuilder tartalmazza az API-t a DOM-dokumentum példányok
		// XML-dokumentumból való beszerzéséhez

		Document doc = dBuilder.parse(xmlFile);
		// A parse() metódus elemzi az XML fájlt

		doc.getDocumentElement().normalize();
		// A dokumentum normalizálása segít a helyes eredmények elérésében.

		System.out.println("Root element: " + doc.getDocumentElement().getNodeName() + "\n");
		// Megkapjuk a dokumentum gyökérelemét

		// 1. lekérdezés: 300000-nél kevesebbet kereső alkalmazottak kilistázása
		System.out.println("------------------------------------");
		System.out.println("300000-nél kevesebbet kereső alkalmazottak:");
		NodeList nodeList = doc.getElementsByTagName("alkalmazott");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				int fizetesHatar = 300000;
				int fizetes = Integer.parseInt(elem.getElementsByTagName("fizetes").item(0).getTextContent());
				if (fizetesHatar > fizetes) {
					System.out.println("\nCurrent Element: " + nNode.getNodeName());

					String attribute1 = elem.getAttribute("a_ID");
					String attribute2 = elem.getAttribute("em_IDREF");
					// Az elem attribútumot a getAttribute() segítségével kapjuk meg.

					Node node1 = elem.getElementsByTagName("nev").item(0);
					String element1 = node1.getTextContent();
					Node node2 = elem.getElementsByTagName("szuletesi_datum").item(0);
					String element2 = node2.getTextContent();
					Node node3 = elem.getElementsByTagName("fizetes").item(0);
					String element3 = node3.getTextContent();

					// Megkapjuk a etterem elem három alelemének szöveges tartalmát

					System.out.println("Alkalamzott ID: " + attribute1);
					System.out.println("Étterem ID: " + attribute2);
					System.out.println("Alkalmazott név: " + element1);
					System.out.println("Születési dátum: " + element2);
					System.out.println("Fizetés: " + element3);
				}
			}
		}

		// 2. lekérdezés: Budapesti éttermek kilistázása
		System.out.println("------------------------------------");
		System.out.println("Budapesti éttermek:");
		nodeList = doc.getElementsByTagName("etterem");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				String etteremHely = elem.getElementsByTagName("varos").item(0).getTextContent();
				if (etteremHely.equals("Budapest")) {
					System.out.println("\nCurrent Element: " + nNode.getNodeName());

					String attribute1 = elem.getAttribute("em_ID");
					String attribute2 = elem.getAttribute("pl_IDREF");
					// Az elem attribútumot a getAttribute() segítségével kapjuk meg.

					Node node1 = elem.getElementsByTagName("varos").item(0);
					String element1 = node1.getTextContent();
					Node node2 = elem.getElementsByTagName("utca").item(0);
					String element2 = node2.getTextContent();
					Node node3 = elem.getElementsByTagName("hazszam").item(0);
					String element3 = node3.getTextContent();

					// Megkapjuk a etterem elem három alelemének szöveges tartalmát

					System.out.println("Étterem ID: " + attribute1);
					System.out.println("Pizzalánc ID: " + attribute2);
					System.out.println("Cím: " + element1 + ", " + element2 + " " + element3);
				}
			}
		}

		// 3. lekérdezés: 1200-nál drágább pizzák kilistázása
		System.out.println("------------------------------------");
		System.out.println("1200-nál drágább pizzák:");
		nodeList = doc.getElementsByTagName("etel");

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				int arHatar = 1200;
				int ar = Integer.parseInt(elem.getElementsByTagName("ar").item(0).getTextContent());
				if (ar > arHatar) {
					System.out.println("\nCurrent Element: " + nNode.getNodeName());

					String attribute1 = elem.getAttribute("el_ID");
					// Az elem attribútumot a getAttribute() segítségével kapjuk meg.

					Node node1 = elem.getElementsByTagName("nev").item(0);
					String element1 = node1.getTextContent();

					Node node2 = elem.getElementsByTagName("ar").item(0);
					String element2 = node2.getTextContent();

					NodeList alapanyagNodeList = elem.getElementsByTagName("alapanyag");
					String element3 = alapanyagNodeList.item(0).getTextContent();
					for (int j = 1; j < alapanyagNodeList.getLength(); j++) {
						Node alapanyagNode = alapanyagNodeList.item(j);
						element3 = element3 + ", " + alapanyagNode.getTextContent();
					}
					// Végigjárja az alapanyaglistát, és összerakja a tartalmukat őket egy stringbe

					// Megkapjuk a etel elem három alelemének szöveges tartalmát

					System.out.println("Étel ID: " + attribute1);
					System.out.println("Étel név: " + element1);
					System.out.println("Ár: " + element2);
					System.out.println("Alapanyagok: " + element3);
				}
			}
		}
	}
}
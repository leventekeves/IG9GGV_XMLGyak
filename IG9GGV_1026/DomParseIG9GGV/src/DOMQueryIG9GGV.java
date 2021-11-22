

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMQueryIG9GGV {

	public static void main(String[] args) {
		try {
			//File xmlFile = newFile("class.xml");
			
			//DocumentBuilder létrehozása
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			Document document = documentBuilder.parse("XMLIG9GGV.xml");
			document.getDocumentElement().normalize();
			
			//az XPath készítése
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			//Meg kell adni az elérési út kifejezését és acsomópot listát:
			//String expression = "class";
			
			//1 Válassza ki az összes student element, amely a class gyermekei.
			//String expression = "/class/student";
			
			//2 Válassza ki azt a student elemet, amely rendelkezik "id" attribútummal és értéke "01".
			//String expression = "/class/student[@id='01']";
			
			//3 Kiválasztja az összes student elemet, függetlenül attól, hogy hol vannak a dokumentumban.
			//String expression = "//student";
			
			//4 Válassza ki a második student element, amely a class elem gyermeke.
			//String expression = "/class/student[position()=2]";
			
			//5 Válassza ki a utolsó student elemet, amely a class elem gyermeke.
			//String expression =  "/class/student[last()]";
			
			//6 Válassza ki a utolsó elõtti student elemet, amely a class elem gyermeke
			//String expression =  "/class/student[last()-1]";
			
			//7 Válassza kiaz elsõ két student elemet, amelyek a class elem gyermekei
			//String expression = "/class/student[position()<3]";
			
			//8 Válassza ki class elem összes gyermek elemét
			//String expression = "/class/*";
			
			//9 Válassza ki az összes student elemet, amely rendelkezik legalább egy bármilyen attribútummal
			//String expression = "/class/student[@*]";
			
			//10 Válassza ki a dokumentum összes elemét.
			//String expression = "//*";
			
			//11 Válassza ki a class elem összes student elemét, amelynél a kor>20.
			//String expression = "/class/student[kor>20]";
			
			//12 Válassza ki az összes student elem összes keresztnev és vezeteknev csommópontot
			//String expression = "/class/student/keresztnev | /class/student/vezeteknev";
			
			//1 Az összes pizzalánc
			//String expression = "//pizzalanc";
			
			//2 1400-nál olcsóbb pizzák
			//String expression = "//etel[ar<1400]";
			
			//3 Tõzsdén lévõ pizzaláncok
			String expression = "//pizzalanc[tozsden='true']";
			
			//Készítsunk egy listát, majd a Path kifejezést meg kell írni és ki kell értékelni
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
			
			// A for ciklus segítségével a NodeList csomópontjait végig kell iterrálni
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("\nAktuális elem: " + node.getNodeName());
				
				// Meg kell vizsgálni a csomópontot, subelement tesztelése megtörtént.
				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("pizzalanc")) {
					Element element = (Element) node;
					
					//az id attribútomot adja vissza
					System.out.println("Hallgató ID: " + element.getAttribute("pl_ID"));
					
					//Pizzalánc nevét, alapítás idõpontját stb adja vissza
					System.out.println("Pizzalánc neve: " + element.getElementsByTagName("nev").item(0).getTextContent());
					System.out.println("Alapítás idõpontja: " + element.getElementsByTagName("alapitas_idopontja").item(0).getTextContent());
					System.out.println("Tõzsdén: " + element.getElementsByTagName("tozsden").item(0).getTextContent());
				}
				
				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("etel")) {
					Element element = (Element) node;
					
					NodeList alapanyagNodeList = element.getElementsByTagName("alapanyag");
					String element3 = alapanyagNodeList.item(0).getTextContent();
					for(int j = 1; j < alapanyagNodeList.getLength(); j++) {
						Node alapanyagNode = alapanyagNodeList.item(j);
						element3 = element3 + ", " + alapanyagNode.getTextContent();
					}
					
					System.out.println("Hallgató ID: " + element.getAttribute("el_ID"));
					
					System.out.println("Étel neve: " + element.getElementsByTagName("nev").item(0).getTextContent());
					System.out.println("Ára: " + element.getElementsByTagName("ar").item(0).getTextContent());
					System.out.println("Alapanyagok: " + element3);
				}
			}		
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		}catch(SAXException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(XPathExpressionException e) {
			e.printStackTrace();
		}
	}
}
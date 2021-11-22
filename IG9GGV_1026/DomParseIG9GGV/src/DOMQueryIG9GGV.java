

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
			
			//DocumentBuilder l�trehoz�sa
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			Document document = documentBuilder.parse("XMLIG9GGV.xml");
			document.getDocumentElement().normalize();
			
			//az XPath k�sz�t�se
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			//Meg kell adni az el�r�si �t kifejez�s�t �s acsom�pot list�t:
			//String expression = "class";
			
			//1 V�lassza ki az �sszes student element, amely a class gyermekei.
			//String expression = "/class/student";
			
			//2 V�lassza ki azt a student elemet, amely rendelkezik "id" attrib�tummal �s �rt�ke "01".
			//String expression = "/class/student[@id='01']";
			
			//3 Kiv�lasztja az �sszes student elemet, f�ggetlen�l att�l, hogy hol vannak a dokumentumban.
			//String expression = "//student";
			
			//4 V�lassza ki a m�sodik student element, amely a class elem gyermeke.
			//String expression = "/class/student[position()=2]";
			
			//5 V�lassza ki a utols� student elemet, amely a class elem gyermeke.
			//String expression =  "/class/student[last()]";
			
			//6 V�lassza ki a utols� el�tti student elemet, amely a class elem gyermeke
			//String expression =  "/class/student[last()-1]";
			
			//7 V�lassza kiaz els� k�t student elemet, amelyek a class elem gyermekei
			//String expression = "/class/student[position()<3]";
			
			//8 V�lassza ki class elem �sszes gyermek elem�t
			//String expression = "/class/*";
			
			//9 V�lassza ki az �sszes student elemet, amely rendelkezik legal�bb egy b�rmilyen attrib�tummal
			//String expression = "/class/student[@*]";
			
			//10 V�lassza ki a dokumentum �sszes elem�t.
			//String expression = "//*";
			
			//11 V�lassza ki a class elem �sszes student elem�t, amelyn�l a kor>20.
			//String expression = "/class/student[kor>20]";
			
			//12 V�lassza ki az �sszes student elem �sszes keresztnev �s vezeteknev csomm�pontot
			//String expression = "/class/student/keresztnev | /class/student/vezeteknev";
			
			//1 Az �sszes pizzal�nc
			//String expression = "//pizzalanc";
			
			//2 1400-n�l olcs�bb pizz�k
			//String expression = "//etel[ar<1400]";
			
			//3 T�zsd�n l�v� pizzal�ncok
			String expression = "//pizzalanc[tozsden='true']";
			
			//K�sz�tsunk egy list�t, majd a Path kifejez�st meg kell �rni �s ki kell �rt�kelni
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
			
			// A for ciklus seg�ts�g�vel a NodeList csom�pontjait v�gig kell iterr�lni
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("\nAktu�lis elem: " + node.getNodeName());
				
				// Meg kell vizsg�lni a csom�pontot, subelement tesztel�se megt�rt�nt.
				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("pizzalanc")) {
					Element element = (Element) node;
					
					//az id attrib�tomot adja vissza
					System.out.println("Hallgat� ID: " + element.getAttribute("pl_ID"));
					
					//Pizzal�nc nev�t, alap�t�s id�pontj�t stb adja vissza
					System.out.println("Pizzal�nc neve: " + element.getElementsByTagName("nev").item(0).getTextContent());
					System.out.println("Alap�t�s id�pontja: " + element.getElementsByTagName("alapitas_idopontja").item(0).getTextContent());
					System.out.println("T�zsd�n: " + element.getElementsByTagName("tozsden").item(0).getTextContent());
				}
				
				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("etel")) {
					Element element = (Element) node;
					
					NodeList alapanyagNodeList = element.getElementsByTagName("alapanyag");
					String element3 = alapanyagNodeList.item(0).getTextContent();
					for(int j = 1; j < alapanyagNodeList.getLength(); j++) {
						Node alapanyagNode = alapanyagNodeList.item(j);
						element3 = element3 + ", " + alapanyagNode.getTextContent();
					}
					
					System.out.println("Hallgat� ID: " + element.getAttribute("el_ID"));
					
					System.out.println("�tel neve: " + element.getElementsByTagName("nev").item(0).getTextContent());
					System.out.println("�ra: " + element.getElementsByTagName("ar").item(0).getTextContent());
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
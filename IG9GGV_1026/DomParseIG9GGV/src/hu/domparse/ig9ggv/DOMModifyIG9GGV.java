package hu.domparse.ig9ggv;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMModifyIG9GGV {

   public static void main(String argv[]) throws Exception{

     
         File xmlFile = new File("XMLIG9GGV.xml");
         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
         Document doc = docBuilder.parse(xmlFile);
         
         // A 2. vezérigazgató ID-jnek megváltoztatása 02-rõl 03-ra, majd a vezetési kapcsolat frissítése
         Node vezerigazgato = doc.getElementsByTagName("vezerigazgato").item(1);
         Node vezeti = doc.getElementsByTagName("vezeti").item(1);
         
         NamedNodeMap viAttr = vezerigazgato.getAttributes();
         Node nodeViAttr = viAttr.getNamedItem("vi_ID");
         nodeViAttr.setTextContent("03");
         
         NamedNodeMap vezetesAttr = vezeti.getAttributes();
         Node nodeVezetesAttr = vezetesAttr.getNamedItem("vi_IDREF");
         nodeVezetesAttr.setTextContent("03");
         
         //A 03 ID-jû étteremben dolgozó lkalamzottak fizetésének növelése 10000-el
         NodeList list = doc.getElementsByTagName("alkalmazott");
         
         for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
            	
               Element elem = (Element) node;
               String etteremID = elem.getAttribute("em_IDREF");
               if(etteremID.equals("03")) {
                   Node nNode = elem.getElementsByTagName("fizetes").item(0);
                   int ujFizetes =Integer.parseInt(nNode.getTextContent()) + 10000;
                   nNode.setTextContent(String.valueOf(ujFizetes));
               }

            }
         }
         

         // write the content on console
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         System.out.println("-----------Modified File-----------");
         StreamResult consoleResult = new StreamResult(System.out);
         transformer.transform(source, consoleResult);
   }
}
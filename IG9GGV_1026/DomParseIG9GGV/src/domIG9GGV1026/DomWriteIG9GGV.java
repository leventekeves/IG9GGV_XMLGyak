package domIG9GGV1026;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomWriteIG9GGV  {

	public static void main(String[] args) throws ParserConfigurationException,TransformerException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		//a dokumentumkészítő gyárból egy new document builder jön létre
		
		Document doc = builder.newDocument();
		// A dokumentum készítőből új dokumentumot hozunk létre a newDocument...
		
		Element root = doc.createElementNS("domig9ggv", "users");
		doc.appendChild(root);
		
		//Létrehoznk egy gyökérelemet, és hozzáadjuk a dokumentumhoz appendChild()

		root.appendChild(createUser(doc, "1", "Pal", "Kiss", "programmer"));
		root.appendChild(createUser(doc, "2", "Piroska", "Zold", "writer"));
		root.appendChild(createUser(doc, "3", "Alma", "Gordon", "teacher"));
		//A gyökérelemhez három gyerekelemt fűzünk
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transf = transformerFactory.newTransformer();
		//A Java DOM a Transformet használja az XML-fájl létrehozásához.
		//Ezt a transzformátor hívjük, emrt XSLt nyelven is képet átalakítni a dokumentumot.
		//Most az XML fájlba írunk.
		
		transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transf.setOutputProperty(OutputKeys.INDENT, "yes");
		transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		//Beállítjuk a dokumentum kódolását és behúzását.
		
		DOMSource source = new DOMSource(doc);
		//Ez DOMSource tartalmazza a DOM fát.
		
		File myFile = new File("users1.xml");
		
		StreamResult console = new StreamResult(System.out);
		StreamResult file = new StreamResult(myFile);
		//Írni fogunk egy konzolba és egy fájlba
		//StreamResult transzofmárciós eredmény birtokosa
		
		transf.transform(source, console);
		transf.transform(source, file);
		//Az XML-forrásokat a stream eredményekhez írjuk.
	}
	
	private static Node createUser(Document doc, String id, String firstName, String lastName, String profession) {
		Element user = doc.createElement("user");
		
		user.setAttribute("id", id);
		user.appendChild(createUserElement(doc, "firstname", firstName));
		user.appendChild(createUserElement(doc, "lastname", lastName));
		user.appendChild(createUserElement(doc, "profession", profession));
		
		return user;
	}
	//A createUser() metódusban új felhasznáói elem jön létre createElement().
	//Az elem attribútuma-val van beállítva setAttribute()
	
	private static Node createUserElement(Document doc, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		
		return node;
	}
	//Egy elem hozzáadódik a szülőjéhez a appendChild() és a szöveges csoópont jön létre ezzel createTextNode();
	

}

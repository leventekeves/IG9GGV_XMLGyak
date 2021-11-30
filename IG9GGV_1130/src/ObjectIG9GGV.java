import org.json.simple.JSONObject;

public class ObjectIG9GGV {

	public static void main(String[] args) {
		 JSONObject obj = new JSONObject();

	      obj.put("Név", "BLászló");
	      obj.put("Fizetés", new Double(1000000.0));
	      obj.put("Kor", new Integer(21));

	      System.out.print(obj);

	}

}

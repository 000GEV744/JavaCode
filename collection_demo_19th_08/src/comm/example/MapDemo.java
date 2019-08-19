package comm.example;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MapDemo {

	private Map<String, String> map;

	public MapDemo() {
		super();
		map=new HashMap<String,String>();
	}
	
	public void createMap() {
		map.put("name","Anuj");
		map.put("address","Zolo Acropolis");
		map.put("phone number","7876829637");
	}
	
	public Set<String> getKeys(){
		return map.keySet();
	}
	
	public Collection<String> getMapValues(){
		return map.values();
	}
	
}

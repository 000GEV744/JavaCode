package comm.example;

import java.util.*;
public class ListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        		
		List<String> list= new ArrayList<String>();
		list.add("john");
		list.add("john");
		Set<String> set = new HashSet<String>();
		set.add("hello");
		set.add("world");
		list.addAll(set);
		System.out.println(list);
		list.removeAll(set);
		System.out.println(list);
		list.clear();
		System.out.println(list.isEmpty());
	}

}

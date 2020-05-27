package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortOnComparator implements Comparator<String>{
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList("1","2","3","4","5","6","7","8","9","10","1.1","1.2","10.1","9.1","7.1","11","11.1"));
		
		System.out.println("The list elements are : " + list.toString());
		Collections.sort(list, new SortOnComparator());
		System.out.println("The sorted array is: " + list );
	
	}

	@Override
	public int compare(String s1, String s2) {
		return s2.compareTo(s1);
	}

}

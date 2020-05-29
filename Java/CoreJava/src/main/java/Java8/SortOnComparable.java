package Corejava;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortOnComparable {
	

	public static void main(String[] args) {
		Student s1 = new Student(1,"Ashish");
		Student s2 = new Student(2,"Ishant");
		Student s3 = new Student(1,"Tanmay");
		Student s4 = new Student(1,"Swati");
		Student s5 = new Student(1,"Rushali");
		
		List<Student> sl = new ArrayList<Student>();
		sl.addAll(Arrays.asList(s1,s2,s3,s4,s5));
		System.out.println(sl.toString());
		
		Collections.sort(sl);
		System.out.println(sl.toString());
	}
}

class Student implements Comparable<Student> {
	
	private String name;
	private int rollNo;
	
	public Student(int roll,String name){
		this.rollNo = roll;
		this.name = name;
	}

	@Override
	public int compareTo(Student student) {
		return this.rollNo - student.rollNo;
	}
	
}

package telran.util;

public class Person implements Comparable<Person>{
	public Person(long id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	private long id;
	private int age;
	private String name;
	public long getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	@Override
	public int compareTo(Person o) {
		
		return Long.compare(id, o.id);
	}
	
	
}

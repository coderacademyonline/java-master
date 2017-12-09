package java1.core.collection;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Comparator是比较接口，我们如果需要控制某个类的次序，而该类本身不支持排序(即没有实现Comparable接口)，
 * 那么我们就可以建立一个“该类的比较器”来进行排序，这个“比较器”只需要实现Comparator接口即可。
 * 也就是说，我们可以通过实现Comparator来新建一个比较器，然后通过这个比较器对类进行排序。
 * 注意：1、若一个类要实现Comparator接口：它一定要实现compareTo(T o1, T o2) 函数，但可以不实现 equals(Object obj) 函数。
 * 2、int compare(T o1, T o2) 是“比较o1和o2的大小”。返回“负数”，意味着“o1比o2小”；返回“零”，意味着“o1等于o2”；返回“正数”，意味着“o1大于o2”。
 * @author zhaojw_420
 *
 */
public class ComparatorTest {

	public static void main(String[] args) {
		//构建person对象的数组
		Person1[] persons={new Person1("zhaojw", 26),new Person1("zr", 25),new Person1("zxn", 1)};
		//直接使用Arrays.sort进行自动排序
		Arrays.sort(persons,new PersonCompartor());
		for (Person1 person : persons) {
			System.out.println(person.toString());
		}
	}
}

/**
 * person未实现Comparable接口
 * @author zhaojw_420
 *
 */
class Person1 {

	private String name;
	
	private int age;
	
	public Person1(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

//person类的外置比较器
class PersonCompartor implements Comparator<Person1>{

	@Override
	public int compare(Person1 o1, Person1 o2) {
		//简单写法
		return o1.getAge()-o2.getAge();
	}
}
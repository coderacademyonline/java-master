package java1.core.collection;

import java.util.Arrays;

/**
 * 强行对实现它的每个类的对象进行整体排序，实现此接口的对象列表（和数组）可以通过Collections.sort或Arrays.sort进行自动排序。
 * 一个类实现了Camparable接口则表明这个类的对象之间是可以相互比较的，这个类对象组成的集合就可以直接使用sort方法排序。
 * Comparable相当于“内部比较器” 
 * 建议使用 comparable 而不是 Comparator
 * @author zhaojw_420
 *
 */
public class ComparableTest {

	public static void main(String[] args) {
		//构建person对象的数组
		Person[] persons={new Person("zhaojw", 26),new Person("zr", 25),new Person("zxn", 1)};
		//直接使用Arrays.sort进行自动排序
		Arrays.sort(persons);
		for (Person person : persons) {
			System.out.println(person.toString());
		}
	}
}

class Person implements Comparable<Person>{

	private String name;
	private int age;
	
	public Person(String name, int age) {
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

	
	/**
	 * 重写compareTo 方法
	 * 优化简便写法：直接return  this.getAge()-o.getAge()
	 */
	@Override
	public int compareTo(Person o) {
		if (this.getAge()>o.getAge()) {
			return 1;
		}else if (this.getAge()<o.getAge()) {
			return -1;
		}else{
			return 0;
		}
	}
}
/**
 * java.lang.Comparable是排序接口，若一个类实现了Comparable接口，就意味着“该类支持排序”。而Comparator是比较器，我们若需要控制某个类的次序，可以建立一个“该类的比较器”来进行排序。

 java.util.Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。

 两种方法各有优劣， 用Comparable 简单， 只要实现Comparable 接口的对象直接就成为一个可以比较的对象，但是需要修改源代码。
 用Comparator 的好处是不需要修改源代码， 而是另外实现一个比较器， 当某个自定义的对象需要作比较的时候
 把比较器和对象一起传递过去就可以比大小了， 并且在Comparator 里面用户可以自己实现复杂的可以通用的逻辑，使其可以匹配一些比较简单的对象，那样就可以节省很多重复劳动了。
 */

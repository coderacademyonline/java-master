package java1.core.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;


public class CollectionSort {
	
	/**
	 * list的默认排序方法
	 * @param lists  要排序的list
	 * @param type  升序/降序
	 */
	public static void defaultListSort(ArrayList<String> lists,TypeEnum type){
		switch (type) {
		case ASC: Collections.sort(lists); //升序
			break;

		case DESC:Collections.reverse(lists); //降序
		default:Collections.reverse(lists); //降序
			break;
		}
		
		for (String list : lists) {
			System.out.println(list);
		}
	}
	
	/**
	 * 对实体类people进行排序
	 * @param lists
	 * @param type
	 */
	public static void customListSort(ArrayList<People> lists,TypeEnum type){
		switch (type) {
		case ASC: Collections.sort(lists); //升序
			break;

		case DESC:Collections.reverse(lists); //降序
		default:Collections.reverse(lists); //降序
			break;
		}
		
		for (People list : lists) {
			System.out.println(list.toString());
		}
	}
	
	/**
	 * map按key来排序
	 * @param map  要排序的map
	 * @param type 升序/降序
	 * 若map的可以得类型是一个people类，需要实现people的compareTo方法，再进行比较
	 */
	public static void mapSortByKey(HashMap<String, String> map,final TypeEnum type){
		if (map!=null&&!map.isEmpty()) {
			Map<String, String> sortMap=new TreeMap<String,String>(new Comparator<String>() {

				public int compare(String o1,String o2) {
					int key1=0;int key2=0;
					key1=Integer.parseInt(isNumeric(o1)?o1:"0");
					key2=Integer.parseInt(isNumeric(o2)?o2:"0");
					int result=0;
					switch (type) {
					case ASC:
						result=key1-key2;
						break;
                    case DESC:
                    	result=key2-key1;
                    	break;
					default:result=key1-key2;
						break;
					}
					return result;
				}
			});
			sortMap.putAll(map);
			System.out.println(map);
		}
	}
	
	/**
	 * map按value值排序
	 * @param map
	 * @param type
	 */
	public static void mapSortByValue(HashMap<String, String> map ,final TypeEnum type){
		Map<String, String> sortMap=new LinkedHashMap<String, String>();
		if (map!=null&&!map.isEmpty()) {
			List<Entry<String, String>> entryList=new ArrayList<Entry<String,String>>(map.entrySet());
			Collections.sort(entryList,new Comparator<Entry<String, String>>() {

				public int compare(Entry<String, String> o1, Entry<String, String> o2) {
					// TODO Auto-generated method stub
					int v1=0;int v2=0;
					v1=Integer.parseInt(isNumeric(o1.getValue())?o1.getValue():"0");
					v2=Integer.parseInt(isNumeric(o2.getValue())?o2.getValue():"0");
					
					int result=0;
					switch (type) {
					case ASC:
						result=v1-v2;
						break;
                    case DESC:
                    	result=v2-v1;
                    	break;
					default:result=v1-v2;
						break;
					}
					return result;
				}
			});
			Iterator<Entry<String, String>> iterator=entryList.iterator();
			Entry<String, String> tmpMap=null;
			while(iterator.hasNext()){
				tmpMap=iterator.next();
				sortMap.put(tmpMap.getKey(), tmpMap.getValue());
			}
		}
	}
	
	
	/**
	 * 判断是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	 } 
	
	/**
	 * 枚举，规定type的取值
	 * @author zhaojw_420
	 *
	 */
	public enum TypeEnum{
		ASC,DESC;
	}
	
}

class People implements Comparable<People>{

	private String name;
	private int age;
	
	public People() {
	}

	public People(String name, int age) {
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
		return "People [名字=" + name + ", 年龄=" + age + "]";
	}

	//先以年龄排序，后以名字排序
	@Override
	public int compareTo(People people) {
		// TODO Auto-generated method stub
		if(this.age!=people.age){
			return this.age-people.age;
		}
		return this.name.compareTo(people.name);
	}
}

class Employee implements Comparator<Employee>{

	private String name;
	private int age;
	
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

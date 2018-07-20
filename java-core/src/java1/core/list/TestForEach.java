package java1.core.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jwzhao
 * @version 1.0
 * @date 2018/6/14 20:40
 */
public class TestForEach {

    public static void main(String[] args){
        List<String> list1 = new ArrayList<>();
        list1.add("outer1");list1.add("outer2");list1.add("outer3");list1.add("outer4");list1.add("outer5");

        for(String list:list1){
            List<Person> personList = new ArrayList<>();
            personList.add(new Person("person"+list,12));
            personList.add(new Person("person"+list,13));
            personList.add(new Person("person"+list,14));
            personList.add(new Person("person"+list,15));
            personList.add(new Person("person"+list,16));
            personList.add(new Person("person"+list,17));

            List<Map<String,Integer>> result = new ArrayList<>();
            int age = 0;
            for(Person person:personList){
                Map<String,Integer> map = new HashMap<>();
                if (age>40){
                    map.put(person.getName(),person.getAge());
                    result.add(map);
                    break;
                }else{
                    map.put(person.getName(),person.getAge());
                    age = age + person.getAge();
                    result.add(map);
                }
            }
            result.forEach(map -> {
               System.out.println(map.toString());
            });
        }

    }
}

class Person{

    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

package java1.core.newfeature;


import java.util.*;
import java.util.stream.Collectors;

/**
 *  java8的新特性--流式计算
 *
 * **并行流式数据处理
 * 流式处理中的很多都适合采用 分而治之 的思想，从而在处理集合较大时，极大的提高代码的性能，java8的设计者也看到了这一点，所以提供了 并行流式处理。
 * 下面的例子中我们都是调用stream()方法来启动流式处理，java8还提供了parallelStream()来启动并行流式处理，
 * parallelStream()本质上基于java7的Fork-Join框架实现，其默认的线程数为宿主机的内核数。
 * 启动并行流式处理虽然简单，只需要将stream()替换成parallelStream()即可，但既然是并行，就会涉及到多线程安全问题，
 * 所以在启用之前要先确认并行是否值得（并行的效率不一定高于顺序执行），另外就是要保证线程安全。此两项无法保证，那么并行毫无意义，
 * 毕竟结果比速度更加重要，以后有时间再来详细分析一下并行流式数据处理的具体实现和最佳实践。
 *
 * @author zhaojw
 * @version 1.0
 * @date 2018/3/31 23:05
 */
public class StreamTest {

    public static void main(String[] args){

        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };

        List<Integer> nums = new ArrayList<Integer>(){
            {
                add(2);add(4);add(3);add(2);add(5);add(8);add(9);add(10);add(12);
                add(3);add(5);add(11);add(23);add(4);add(8);add(21);add(24);add(7);
            }
        };

        /// StreamTest.testStream();

        /// StreamTest.filterTest(students);

        /// StreamTest.distinctTest(nums);

        /// StreamTest.limitTest(students);

        /// StreamTest.sortedTest(students);

        /// StreamTest.skipTest(students);

        /// StreamTest.mapTest(students);

        /// StreamTest.flatMapTest(students);

        /// StreamTest.allMatchTest(students);

        /// StreamTest.anyMatchTest(students);

        /// StreamTest.noneMatchTest(students);

        /// StreamTest.findFirstTest(students);

        /// StreamTest.findAnyTest(students);

        /// StreamTest.reduceTest(students);

        /// StreamTest.collectTest(students);

        /// StreamTest.groupTest(students);

        StreamTest.partTest(students);
    }

    private static <T> void show(List<T> list){
        list.forEach(t -> {
            System.out.println(t.toString());
        });
    }


    /**
     *  stream()操作将集合转换成一个流，filter()执行我们自定义的筛选处理，
     *  这里是通过lambda表达式筛选出所有偶数，最后我们通过collect()对结果进行封装处理，并通过Collectors.toList()指定其封装成为一个List集合返回。
     */
    private static void testStream(){

        List<Integer> nums = new ArrayList<>();

        for(int i=0; i<=100; i++){
            nums.add(i);
        }

        List<Integer> events = nums.stream().filter(num->num%9==0).collect(Collectors.toList());

        System.out.println(events.toString());

    }

    /// ----------------------——以下是流操作----------------------------

    /**
     * filter，其定义为：Stream<T> filter(Predicate<? super T> predicate)，filter接受一个谓词Predicate，我们可以通过这个谓词定义筛选条件，
     * 在介绍lambda表达式时我们介绍过Predicate是一个函数式接口，其包含一个test(T t)方法，该方法返回boolean。
     */
    private static void filterTest(List<Student> students){
        List<Student> filterStu = students.stream()
                .filter(student -> "武汉大学".equals(student.getSchool()))
                .collect(Collectors.toList());

        show(filterStu);
    }

    /**
     * distinct操作类似于我们在写SQL语句时，添加的DISTINCT关键字，用于去重处理，distinct基于Object.equals(Object)实现
     */
    private static void distinctTest(List<Integer> nums){
        List<Integer> distincStu = nums.stream()
                .filter(num -> num % 2==0)
                .distinct()
                .collect(Collectors.toList());

        show(distincStu);
    }

    /**
     * limit操作也类似于SQL语句中的LIMIT关键字，不过相对功能较弱，limit返回包含前n个元素的流，当集合大小小于n时，则返回实际长度
     * @param students
     */
    private static void limitTest(List<Student> students){
        List<Student> limitStu = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .limit(2)
                .collect(Collectors.toList());

        show(limitStu);
    }

    /**
     * sorted。该操作用于对流中元素进行排序，sorted要求待比较的元素必须实现Comparable接口，
     * 如果没有实现也不要紧，我们可以将比较器作为参数传递给sorted(Comparator<? super T> comparator)
     * @param students
     */
    private static void sortedTest(List<Student> students){
        // 未实现Comparable接口的用法
        List<Student> sortedStu = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .sorted((student1,student2) -> student2.getAge() - student1.getAge())
                .limit(2)
                .collect(Collectors.toList());

        show(sortedStu);

        System.out.println("----------------------------------------");

        //实现了Comparable接口的用法
        List<Student> sortedStu1 = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .sorted()
                .limit(2)
                .collect(Collectors.toList());

        show(sortedStu1);

    }

    /**
     * skip操作与limit操作相反，如同其字面意思一样，是跳过前n个元素
     * 通过skip，就会跳过前面两个元素，返回由后面所有元素构造的流，如果n大于满足条件的集合的长度，则会返回一个空的集合。
     * @param students
     */
    private static void skipTest(List<Student> students){
        // 取出排序在2之后的土木工程的学生
        List<Student> skipStu = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .skip(2)
                .collect(Collectors.toList());

        show(skipStu);
    }

    /// ------------------以下是中间操作--------------------------------------

    /**
     * 在SQL中，借助SELECT关键字后面添加需要的字段名称，可以仅输出我们需要的字段数据，而流式处理的映射操作也是实现这一目的
     * 在java8的流式处理中，主要包含两类映射操作：map和flatMap。
     *
     * 通过map将学生实体映射成为学生姓名字符串，计算总年龄
     *
     * @param students
     */
    private static void mapTest(List<Student> students){
        // 将实体层映射成学生姓名字符串
        List<String> names = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .map(Student::getName)
                .collect(Collectors.toList());

        show(names);

        System.out.println("--------------------------------");

        // 计算总年龄
        int totalAge = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .mapToInt(Student::getAge)
                .sum();

        System.out.println(totalAge);

    }

    /**
     * flatMap与map的区别在于 flatMap是将一个流中的每个值都转成一个个流，然后再将这些流扁平化成为一个流
     * flatMap将由map映射得到的Stream<String[]>，转换成由各个字符串数组映射成的流Stream<String>，
     * 再将这些小的流扁平化成为一个由所有字符串构成的大流Steam<String>，从而能够达到我们的目的。
     * 与map类似，flatMap也提供了针对特定类型的映射操作：flatMapToDouble(Function<? super T,? extends DoubleStream> mapper)，
     * flatMapToInt(Function<? super T,? extends IntStream> mapper)，flatMapToLong(Function<? super T,? extends LongStream> mapper)。
     *
     * 比如我们输出学生专业为土木的学生的实体中姓名的组成的字符
     *
     * @param students
     */
    private static void flatMapTest(List<Student> students){
        List<String[]> flatMap = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .map(Student::getName)
                .map(name -> name.split(""))
                .distinct()
                .collect(Collectors.toList());


        flatMap.forEach(map->{
            String[] strings = map;
            System.out.print("[");
            for(String string:strings){
                System.out.print(string+",");
            }
            System.out.println("]");
        });

        System.out.println("--------------------");

        List<String> flatMap1 = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .map(Student::getName)
                .map(name -> name.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        show(flatMap1);
    }

    /// -------------------------——以下是终端操作------------------------------
    /*
     * 终端操作是流式处理的最后一步，我们可以在终端操作中实现对流查找、归约等操作
     */

    /**
     * allMatch用于检测是否全部都满足指定的参数行为，如果全部满足则返回true
     * @param students
     */
    private static void allMatchTest(List<Student> students){
        boolean isAdult = students.stream()
                .allMatch(student -> student.getAge() > 18);

        System.out.print(isAdult);
    }

    /**
     * anyMatch则是检测是否存在一个或多个满足指定的参数行为，如果满足则返回true
     * @param students
     */
    private static void anyMatchTest(List<Student> students){
        boolean hasQh = students.stream().anyMatch(student -> "清华大学".equals(student.getSchool()));

        System.out.println(hasQh);
    }

    /**
     * noneMatch用于检测是否不存在满足指定行为的元素，如果不存在则返回true，
     * @param students
     */
    private static void noneMatchTest(List<Student> students){
        boolean hasBd = students.stream().noneMatch(student -> "北京大学".equals(student.getSchool()));

        System.out.println(hasBd);
    }

    /**
     * findFirst用于返回满足条件的第一个元素
     * @param students
     */
    private static void findFirstTest(List<Student> students){
        Optional<Student> firstStu = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .findFirst();

        System.out.println(firstStu.get().toString());
    }

    /**
     * findAny相对于findFirst的区别在于，findAny不一定返回第一个，而是返回任意一个
     * @param students
     */
    private static void findAnyTest(List<Student> students){
        Optional<Student> anyStu = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .findAny();

        System.out.println(anyStu.get().toString());
    }

    /**
     *  归约操作
     *  直接对数据集合进行运算
     *
     * @param students
     */
    private static void reduceTest(List<Student> students){
        int totalAge1 = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(0,(a,b)->a+b);

        System.out.println("土木工程总年龄："+totalAge1);

        System.out.println("---------------------------------------");

        int totalAge2 = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(0,Integer::sum);

        System.out.println("土木工程总年龄："+totalAge2);

        System.out.println("---------------------------------------");

        // 采用无初始值的重载版本，需要注意返回Optional

         Optional<Integer> totalAge3 = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .map(Student::getAge)
                .reduce(Integer::sum);

         System.out.println("土木工程总年龄："+totalAge3.get());
    }

    /// ------------------以下是终端操作的收集----------------------

    /*
     * collect(Collectors.toList())是一个简单的收集操作，是对处理结果的封装，对应的还有toSet、toMap，以满足我们对于结果组织的需求。
     * 这些方法均来自于java.util.stream.Collectors，我们可以称之为收集器。
     */

    /**
     * 收集器也提供了相应的归约操作，但是与reduce在内部实现上是有区别的，收集器更加适用于可变容器上的归约操作，
     * 这些收集器广义上均基于Collectors.reducing()实现。
     * @param students
     */
    private static void collectTest(List<Student> students){
        long studentCount = students.stream().collect(Collectors.counting());

        System.out.println("学生总人数："+studentCount);

        studentCount = students.stream().count();

        System.out.println("简化操作后，学生总人数："+studentCount);

        System.out.println("---------------------------------------");

        Optional<Student> olderStudent = students.stream()
                .collect(Collectors.maxBy((s1,s2) -> s1.getAge()- s2.getAge()));

        System.out.println("年龄最大的学生："+olderStudent.get().toString());

        Optional<Student> olderStudent2 = students.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));

        System.out.println("简化操作后，年龄最大的学生："+olderStudent2.get().toString());

        Optional<Student> youngStudent = students.stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getAge)));

        System.out.println("年龄最小的学生："+youngStudent.get().toString());

        Optional<Student> youngStudent2 = students.stream().min(Comparator.comparing(Student::getAge));

        System.out.println("简化操作后，年龄最小的学生："+youngStudent2.get().toString());

        int totalAge = students.stream()
                .collect(Collectors.summingInt(Student::getAge));

        System.out.println("学生总年龄："+totalAge);

        int totalAge2 = students.stream().mapToInt(Student::getAge).sum();

        System.out.println("简化操作后，学生总年龄："+totalAge2);

        double avgAge = students.stream()
                .collect(Collectors.averagingInt(Student::getAge));

        System.out.println("学生平均年龄："+avgAge);

        // 一次性得到元素个数、总和、均值、最大值、最小值
        IntSummaryStatistics summaryStatistics = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("学生个数、总和、均值、最大值、最小值："+summaryStatistics.toString());

        String joinNames = students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(","));
        System.out.println("所有学生的姓名："+joinNames);
    }

    /**
     * 在数据库操作中，我们可以通过GROUP BY关键字对查询到的数据进行分组，java8的流式处理也为我们提供了这样的功能Collectors.groupingBy来操作集合
     *
     * groupingBy接收一个分类器Function<? super T, ? extends K> classifier，我们可以自定义分类器来实现需要的分类效果
     *
     * 可以实现多个分级器，实现多级分组
     *
     * @param students
     */
    private static void groupTest(List<Student> students){
        Map<String,List<Student>> groupStudents = students.stream()
                .collect(Collectors.groupingBy(Student::getSchool));

        Iterator<Map.Entry<String,List<Student>>> iterators= groupStudents.entrySet().iterator();
        while (iterators.hasNext()){
            Map.Entry<String,List<Student>> entry = iterators.next();
            System.out.println("学校："+entry.getKey());
            show(entry.getValue());
        }

        System.out.println("---------------------------------------");

        Map<String,Map<String,List<Student>>> groupsStudent = students.stream()
                // 先按照学校分组
                .collect(Collectors.groupingBy(Student::getSchool
                // 再按照专业分组
                ,Collectors.groupingBy(Student::getMajor)));

        Iterator<Map.Entry<String,Map<String,List<Student>>>> iterators2 = groupsStudent.entrySet().iterator();

        while (iterators2.hasNext()){
            Map.Entry<String,Map<String,List<Student>>> mapEntrys = iterators2.next();

            System.out.println("学校："+mapEntrys.getKey());
            Iterator<Map.Entry<String,List<Student>>> studentIterators2 = mapEntrys.getValue().entrySet().iterator();
            while (studentIterators2.hasNext()){
                Map.Entry<String,List<Student>> studentEntrys = studentIterators2.next();
                System.out.println("专业："+studentEntrys.getKey());
                show(studentEntrys.getValue());
            }
        }
    }

    /**
     * 在分区中key只有两种情况：true或false，目的是将待分区集合按照条件一分为二，
     * java8的流式处理利用ollectors.partitioningBy()方法实现分区，该方法接收一个谓词
     *
     * 分区相对分组的优势在于，我们可以同时得到两类结果，在一些应用场景下可以一步得到我们需要的所有结果，比如将数组分为奇数和偶数。
     *
     * 以下可以把学生分为武大学生跟非武大学生
     *
     * @param students
     */
    private static void partTest(List<Student> students){

        Map<Boolean,List<Student>> partStudent = students.stream()
                .collect(Collectors.partitioningBy(student -> "武汉大学".equals(student.getSchool())));

        Iterator<Map.Entry<Boolean,List<Student>>> iterators = partStudent.entrySet().iterator();
        while (iterators.hasNext()){
            Map.Entry<Boolean,List<Student>> entry = iterators.next();
            System.out.println("是否是武大学生："+entry.getKey());
            show(entry.getValue());
        }
    }
}

class Student implements Comparable<Student>{
    /** 学号 */
    private long id;

    private String name;

    private int age;

    /** 年级 */
    private int grade;

    /** 专业 */
    private String major;

    /** 学校 */
    private String school;

    public Student(long id, String name, int age, int grade, String major, String school) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.major = major;
        this.school = school;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 按照年龄的从大往小排列
     */
    @Override
    public int compareTo(Student other) {
        return other.getAge()-this.getAge();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", major='" + major + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}

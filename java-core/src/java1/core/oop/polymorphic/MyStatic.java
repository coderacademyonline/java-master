package java1.core.oop.polymorphic;

public class MyStatic {
	 public static void main(String[] args)
	    {
	        J j = new J();
	        System.out.println(j.name);
	        System.out.println(j.str);
	        j.sing();//输出的结果都是父类中的非静态属性、静态属性和静态方法,推出静态属性和静态方法可以被继承
	       
	        G j1 = new J();
	        System.out.println(j1.name);
	        System.out.println(j1.str);
	        j1.sing();//结果同上，输出的结果都是父类中的非静态属性、静态属性和静态方法,推出静态属性和静态方法可以被继承
	       
	        H h = new H();
	        System.out.println(h.name);
	        System.out.println(h.str);
	        h.sing();//结果都是子类的非静态属性，静态属性和静态方法，这里和非静态属性和非静态类的继承相同
	        h.run();//子类的改写后非静态方法
	       
	        G h1 = new H();
	        System.out.println(h1.str);//结果是父类的静态属性，说明静态属性不可以被重写，不能实现多态
	        System.out.println(h1.name);//结果是父类的非静态属性，说明非静态属性不可以被重写，不能实现多态
	        h1.sing();//结果都是父类的静态方法，说明静态方法不可以被重写，不能实现多态
	        h1.run();//结果是子类的改写后的非静态方法
	    }
}

class G{
	public static String str = "静态属性";
    public String name = "非静态属性";
    public static void sing()
    {
        System.out.println("静态方法");
    }
   
    public void run()
    {
        System.out.println("非静态方法");
    }
}

class H extends G{

	 public static String str = "H该改写后的静态属性";
	    public String name ="H改写后的非静态属性";
	    public static void sing()
	    {
	        System.out.println("H改写后的静态方法");
	    }
	    
	    public void run()
	    {
	        System.out.println("H改写后的非静态方法");
	    }
}

class J extends G{
	
}


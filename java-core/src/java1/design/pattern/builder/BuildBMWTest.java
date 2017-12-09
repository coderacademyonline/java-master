package java1.design.pattern.builder;

public class BuildBMWTest {

	public static void main(String[] args) {
		BMWDirector director=new BMWDirector();
		BMW bmwx5=director.constructBMW(new BMWX5Builder());
		System.out.println(bmwx5.getEngine());
		System.out.println(bmwx5.getConditioner());
		System.out.println(bmwx5.getTyre());
		System.out.println(bmwx5.getChassis());
		BMW bmwx6=director.constructBMW(new BMWX6Builder());
		System.err.println(bmwx6.getEngine());
		System.err.println(bmwx6.getConditioner());
		System.err.println(bmwx6.getTyre());
		System.err.println(bmwx6.getChassis());
	}
}

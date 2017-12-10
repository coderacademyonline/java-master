package java1.design.pattern.observer;

public class WinXinUser implements Observer{

	private String name;

     public WinXinUser(String name) {
         this.name=name;
     }

	@Override
	public void update(String message) {
		System.out.println(name+">>>>"+message);
	}
	

}

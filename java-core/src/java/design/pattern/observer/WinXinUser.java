package java.design.pattern.observer;

public class WinXinUser implements Observer{

	private String name;
	
     public WinXinUser(String name) {
         this.name=name;
     }

	@Override
	public void update(String message) {
		// TODO Auto-generated method stub
		System.out.println(name+">>>>"+message);
	}
	

}

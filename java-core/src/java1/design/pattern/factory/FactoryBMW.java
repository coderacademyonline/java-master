package java1.design.pattern.factory;

public class FactoryBMW {

	public BMW createBMB(int type){
		switch (type) {
		case 320:
			return new BMW320();

		case 523:
			return new BMW523();
		default:
			break;
		}
		return null;
	}
}

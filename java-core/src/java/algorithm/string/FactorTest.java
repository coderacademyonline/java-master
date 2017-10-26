package java.algorithm.string;

/**
 * 分解质因数
 * 从除以2一直除到n-1
 * @author Administrator
 *
 */
public class FactorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         factor(20);
	}

	static void factor(int num){
		for (int i = 2; i <num; i++) {
			if(num%i==0){
				System.out.println(i);
				int n=num/i;
				if(isPrime(n)){
					System.out.println(n);
				
				}else {
					
					factor(n);
				}
				return;
			}
		}
	}
	
	static boolean isPrime(int num){
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
}

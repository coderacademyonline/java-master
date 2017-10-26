package java.algorithm.string;
/**
 * 输出第k个丑数(因子只有2，3，5)
 * @author zhaojw_420
 *
 */
public class UglyNum {

	public static void main(String[] args) {
		UglyNum uglyNum=new UglyNum();
		uglyNum.findUglyNum(3);
	}
	
	public void findUglyNum(int index){
        int[] num = new int[index];
        int next = 1;
        num[0]=1;
        int index2=0;
        int index3=0;
        int index5=0;    

        while(next<index){
            int num2 = num[index2]*2;
            int num3 = num[index3]*3;
            int num5 = num[index5]*5;
            
            num[next] = getSuitable(num2,num3,num5);
            
            while(num[index2]*2<=num[next]){
                index2++;
            }
            while(num[index3]*3<=num[next]){
                index3++;
            }
            while(num[index5]*5<=num[next]){
                index5++;
            }                
            next++;
            
        }
        System.out.println(num[index-1]);
    }
    
    public int getSuitable(int num2,int num3,int num5){
        int s = num2;
        if(num3<s){
            s = num3;
        }
        if(num5<s){
            s = num5;
        }
        return s;
    }
}
